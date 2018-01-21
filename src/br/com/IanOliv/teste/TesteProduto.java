package br.com.IanOliv.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.IanOliv.connection.JPAutil;
import br.com.IanOliv.dao.ProdutoDAO;
import br.com.IanOliv.model.Produto;
import br.com.IanOliv.model.ProdutoPreco;
import br.com.IanOliv.model.Regioes;

public class TesteProduto {
	public static void main(String[] args) {

		Produto produto = new Produto();
		produto.setNome("cebolitos");
		produto.setCodigo(GeraCodigo.getCodigoCliente("sp"));

		ProdutoPreco produtoPreco = new ProdutoPreco();
		produtoPreco.setDate(Calendar.getInstance());
		produtoPreco.setPreco(3.21);
		produtoPreco.setRegiao(Regioes.SUL);
		produtoPreco.setProduto(produto);

		ProdutoPreco produtoPreco2 = new ProdutoPreco();
		produtoPreco2.setDate(Calendar.getInstance());
		produtoPreco2.setPreco(2.99);
		produtoPreco2.setRegiao(Regioes.SULDESTE);
		produtoPreco2.setProduto(produto);
		
		produto.addPreco(produtoPreco2);
		produto.addPreco(produtoPreco);
		// create banco
		EntityManager em = new JPAutil().getEntiyManager();
		em.getTransaction().begin();

		em.persist(produto);
		em.persist(produtoPreco);
		em.persist(produtoPreco2);
		
		
		
	
		

		em.getTransaction().commit();
		em.close();

	}

}
