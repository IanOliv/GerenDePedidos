package br.com.IanOliv.web;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.IanOliv.connection.JPAutil;
import br.com.IanOliv.dao.ClienteDAO;
import br.com.IanOliv.model.Cliente;

public class ListaClientes implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String path = req.getParameter("option");
		EntityManager em = new JPAutil().getEntiyManager();
		em.getTransaction().begin();
		List<Cliente> clientes = new ClienteDAO(em).listClientes();
		
		em.getTransaction().commit();
		em.close();
		
		
		req.setAttribute("clientes", clientes);
		
		
		if (path.equals("lc")) {
			return "/WEB-INF/jsps/listaClientes.jsp";
		}else if (path.equals("cp")) {
			return "/WEB-INF/jsps/CriaPedido.jsp";
		}else {
			return null;
		}
	}

}
