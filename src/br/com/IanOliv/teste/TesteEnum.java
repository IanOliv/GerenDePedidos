package br.com.IanOliv.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.IanOliv.connection.JPAutil;
import br.com.IanOliv.dao.PedidoProdutoDAO;
import br.com.IanOliv.dao.ProdutoDAO;
import br.com.IanOliv.model.Produto;
import br.com.IanOliv.model.ProdutoPreco;
import br.com.IanOliv.model.Regioes;

public class TesteEnum {

	public static void main(String[] args) {
		Regioes regiao = Regioes.valueOf("SUL");
		EntityManager em = new JPAutil().getEntiyManager();
		em.getTransaction().begin();
		
//		List<Produto> produtos = new ProdutoDAO(em).listProdutosByRegia("SUL");
//		
//		
		em.getTransaction().commit();
		em.close();
				
				
//				
//		for (Produto produto : produtos) {
//			System.out.println("---");
//			
//			System.out.println(produto.getId());
//			System.out.println(produto.getCodigo());
//			System.out.println(produto.getNome());
//			for (ProdutoPreco preco : produto.getPrecos()) {
//				System.out.println("<<<<<<>>>>>>>");
//				System.out.println(preco.getId());
//				System.out.println(preco.getDate());
//				System.out.println(preco.getPreco());
//				System.out.println(preco.getRegiao());
//				System.out.println("<<<<<<>>>>>>>");
//				
//			}
//			
//			
//			System.out.println("---");
//			
//			
			
			
			
			
		}
		

	}

