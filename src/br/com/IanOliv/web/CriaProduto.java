package br.com.IanOliv.web;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.IanOliv.connection.JPAutil;
import br.com.IanOliv.dao.ProdutoDAO;
import br.com.IanOliv.dao.ProdutoPrecoDAO;
import br.com.IanOliv.model.Produto;
import br.com.IanOliv.model.ProdutoPreco;
import br.com.IanOliv.model.Regioes;

public class CriaProduto implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		
		Produto produto = new Produto();
		produto.setCodigo(req.getParameter("codigoProduto"));
		produto.setNome(req.getParameter("nameProduto"));

		ProdutoPreco produtoPrecoSE = new ProdutoPreco();
		produtoPrecoSE.setPreco(Double.parseDouble(req.getParameter("preProdutoSE")));
		produtoPrecoSE.setRegiao(Regioes.SULDESTE);
		
		ProdutoPreco produtoPrecoS = new ProdutoPreco();
		produtoPrecoS.setPreco(Double.parseDouble(req.getParameter("preProdutoS")));
		produtoPrecoS.setRegiao(Regioes.SUL);
		
		ProdutoPreco produtoPrecoNE = new ProdutoPreco();
		produtoPrecoNE.setPreco(Double.parseDouble(req.getParameter("preProdutoNE")));
		produtoPrecoNE.setRegiao(Regioes.NORDESTE);
		
		ProdutoPreco produtoPrecoN = new ProdutoPreco();
		produtoPrecoN.setPreco(Double.parseDouble(req.getParameter("preProdutoN")));
		produtoPrecoN.setRegiao(Regioes.NORTE);
		
		ProdutoPreco produtoPrecoCO = new ProdutoPreco();
		produtoPrecoCO.setPreco(Double.parseDouble(req.getParameter("preProdutoCO")));
		produtoPrecoCO.setRegiao(Regioes.CENTRO_OESTE);
		
		EntityManager em = new JPAutil().getEntiyManager();
		em.getTransaction().begin();

		em.persist(produto);
		ProdutoPrecoDAO produtoPrecoDAO = new ProdutoPrecoDAO(em);
		produtoPrecoCO.setProduto(produto);
		produtoPrecoDAO.createPrdPreco(produtoPrecoCO);
		produtoPrecoN.setProduto(produto);
		produtoPrecoDAO.createPrdPreco(produtoPrecoN);
		produtoPrecoNE.setProduto(produto);
		produtoPrecoDAO.createPrdPreco(produtoPrecoNE);
		produtoPrecoS.setProduto(produto);
		produtoPrecoDAO.createPrdPreco(produtoPrecoS);
		produtoPrecoSE.setProduto(produto);
		produtoPrecoDAO.createPrdPreco(produtoPrecoSE);

		em.getTransaction().commit();
		em.close();

		produto.addPreco(produtoPrecoCO);
		produto.addPreco(produtoPrecoN);
		produto.addPreco(produtoPrecoNE);
		produto.addPreco(produtoPrecoS);
		produto.addPreco(produtoPrecoSE);

		req.setAttribute("produto", produto);

		return "/WEB-INF/jsps/buscaProduto.jsp";

	}

}
