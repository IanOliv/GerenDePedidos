package br.com.IanOliv.web;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.IanOliv.connection.JPAutil;
import br.com.IanOliv.dao.PedidoDAO;
import br.com.IanOliv.model.Pedido;

public class ListaPedidos implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		EntityManager em = new JPAutil().getEntiyManager();
		em.getTransaction().begin();
		
		List<Pedido> pedidos = new PedidoDAO(em).listPedidos();
		
		
		em.getTransaction().commit();
		em.close();
		req.setAttribute("pedidos", pedidos);
		
		return "/WEB-INF/jsps/listaPedidos.jsp";
	}

}
