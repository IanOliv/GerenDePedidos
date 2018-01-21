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

public class AlteraProduto implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Integer idPedido = Integer.parseInt(req.getParameter("IdProduto"));
		
		
		Produto oldProduto = new Produto();

		EntityManager em = new JPAutil().getEntiyManager();
		em.getTransaction().begin();
		
		oldProduto = new ProdutoDAO(em).searchProduto(idPedido);
		
		em.getTransaction().commit();
		em.close();
		
		
		
		
	
		
		
		req.setAttribute("nome", oldProduto.getNome());
		req.setAttribute("codigo",oldProduto.getCodigo());
		
		return "WEB-INF/jsps/novoAlteraProduto.jsp";
	}

}
