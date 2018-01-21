package br.com.IanOliv.web;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.IanOliv.connection.JPAutil;
import br.com.IanOliv.dao.PedidoDAO;
import br.com.IanOliv.dao.PedidoProdutoDAO;
import br.com.IanOliv.dao.ProdutoDAO;
import br.com.IanOliv.model.Pedido;
import br.com.IanOliv.model.PedidoProduto;
import br.com.IanOliv.model.Produto;
import br.com.IanOliv.model.Regioes;
import br.com.IanOliv.model.StatusPedido;

public class CriaPedidoProduto implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String ids[] = req.getParameterValues("Produto");
		Integer idPedio  =Integer.parseInt( req.getParameter("idPedido"));
		List<Produto> produtos  = new ArrayList<>();
		double total =  0 ;
		
		EntityManager em  = new JPAutil().getEntiyManager();
		em.getTransaction().begin();
		for (String string : ids) {
		produtos.add(new ProdutoDAO(em).searchProduto(Integer.parseInt(string)));		
		}
		Pedido pedido  = new PedidoDAO(em).searchPedido(idPedio);
		
		for (Produto produto : produtos) {
		
		new PedidoProdutoDAO(em).criaPedPrd(new PedidoProduto(produto, pedido));	
		total += produto.getPrecos().get(0).getPreco();
		
		}
		
		pedido.setStatus(StatusPedido.FINALIZADO);
		pedido.setTotal(total);
		em.merge(pedido);
		
		
		
		em.getTransaction().commit();
		
		em.close();
		
		
		
		
		req.setAttribute("pedido", pedido);
		
		return "/WEB-INF/jsps/produtosAdicionados.jsp";
	}

}
