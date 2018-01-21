package br.com.IanOliv.web;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.IanOliv.connection.JPAutil;
import br.com.IanOliv.dao.ProdutoDAO;
import br.com.IanOliv.dao.ProdutoPrecoDAO;
import br.com.IanOliv.model.Produto;
import br.com.IanOliv.model.ProdutoPreco;

public class BuscaProduto implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		Integer idProduto = Integer.parseInt(req.getParameter("idProduto"));
		List<ProdutoPreco> precos = new ArrayList<>();
		EntityManager em = new JPAutil().getEntiyManager();
		em.getTransaction().begin();

		Produto produto = new ProdutoDAO(em).searchProduto(idProduto);
		 precos = new ProdutoPrecoDAO(em).listPrdPrco(idProduto);

		em.getTransaction().commit();
		em.close();
		produto.setPrecos(precos);
		req.setAttribute("produto", produto);
		return "/WEB-INF/jsps/buscaProduto.jsp";
	}

}
