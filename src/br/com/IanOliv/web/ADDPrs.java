package br.com.IanOliv.web;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.IanOliv.connection.JPAutil;
import br.com.IanOliv.dao.ProdutoDAO;
import br.com.IanOliv.model.Produto;
import br.com.IanOliv.model.Regioes;

public class ADDPrs implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		Integer idPedido = Integer.parseInt(req.getParameter("idPedido"));
		Regioes regiao = Regioes.valueOf(req.getParameter("regiao"));

		EntityManager em = new JPAutil().getEntiyManager();
		em.getTransaction().begin();

		List<Produto> produtos = new ProdutoDAO(em).listProdutosByRegia(regiao);

		em.getTransaction().commit();
		em.close();

		req.setAttribute("produtos", produtos);
		req.setAttribute("idPedido", idPedido);
		req.setAttribute("regiao", regiao);

		return "/WEB-INF/jsps/addProdutos.jsp";
	}

}
