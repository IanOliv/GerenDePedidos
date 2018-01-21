package br.com.IanOliv.web;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.IanOliv.connection.JPAutil;
import br.com.IanOliv.dao.ClienteDAO;
import br.com.IanOliv.dao.PedidoDAO;
import br.com.IanOliv.dao.PedidoProdutoDAO;
import br.com.IanOliv.model.Cliente;
import br.com.IanOliv.model.Pedido;
import br.com.IanOliv.model.PedidoProduto;

public class BuscaCliente implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		Integer idCliente = Integer.parseInt(req.getParameter("idCliente"));
		EntityManager em = new JPAutil().getEntiyManager();
		em.getTransaction().begin();

		Cliente cliente = new ClienteDAO(em).searchCliente(idCliente);
		List<PedidoProduto> pedidosProds = new PedidoProdutoDAO(em).listPedPrdByCliente(cliente);
		
		
		em.getTransaction().commit();
		em.close();

		
		
		req.setAttribute("cliente", cliente);
		req.setAttribute("endereco", cliente.getEndereco());
		req.setAttribute("contado", cliente.getContato());

		return "/WEB-INF/jsps/novoCliente.jsp";
	}

}
