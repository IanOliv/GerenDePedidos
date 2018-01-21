package br.com.IanOliv.web;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.IanOliv.connection.JPAutil;
import br.com.IanOliv.dao.PedidoDAO;
import br.com.IanOliv.model.Pedido;

public class BuscaPedido implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Integer idPedido  = Integer.parseInt(req.getParameter("idPedido"));
		Pedido pedido = new Pedido();
		
		EntityManager em = new  JPAutil().getEntiyManager();
		em.getTransaction().begin();
		
		pedido  = new PedidoDAO(em).searchPedido(idPedido);
		
		em.getTransaction().commit();
		em.close();
		
		
		
		
		req.setAttribute("pedido",pedido);
		
		return "WEB-INF/jsps/buscaPedido.jsp";
	}

}
