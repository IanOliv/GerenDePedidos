package br.com.IanOliv.web;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.IanOliv.connection.JPAutil;
import br.com.IanOliv.dao.ProdutoDAO;
import br.com.IanOliv.model.Produto;

public class ListaProdutos implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		EntityManager em = new JPAutil().getEntiyManager();
		em.getTransaction().begin();

		List<Produto> produtos = new ProdutoDAO(em).listProdutos();

		em.getTransaction().commit();
		em.close();

		req.setAttribute("produtos", produtos);

		return "/WEB-INF/jsps/listaProdutos.jsp";
	}

}
