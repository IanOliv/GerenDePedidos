package br.com.IanOliv.web;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.IanOliv.connection.JPAutil;
import br.com.IanOliv.dao.ClienteDAO;
import br.com.IanOliv.dao.PedidoDAO;
import br.com.IanOliv.dao.ProdutoDAO;
import br.com.IanOliv.model.Cliente;
import br.com.IanOliv.model.Endereco;
import br.com.IanOliv.model.Pedido;
import br.com.IanOliv.model.Produto;
import br.com.IanOliv.model.web.ProdutoWeb;

public class CriaPedido implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		Integer idCliente = Integer.parseInt(req.getParameter("idCliente"));
		Pedido pedido = new Pedido();
		List<Produto> produtos;
		Cliente cliente;
		EntityManager em = new JPAutil().getEntiyManager();
		em.getTransaction().begin();
		cliente = new ClienteDAO(em).searchCliente(idCliente);

		pedido.setCliente(cliente);
		new PedidoDAO(em).createPedido(pedido);
		produtos = new ProdutoDAO(em).listProdutosByRegia(Endereco.veriRegiao(cliente.getEndereco().getEstado()));

		
		em.getTransaction().commit();
		em.close();
		List<ProdutoWeb> prdWb = new ArrayList<>();
		
	
		
		req.setAttribute("pedido", pedido);
		
		return "/WEB-INF/jsps/novoPedido.jsp";
	}

}
