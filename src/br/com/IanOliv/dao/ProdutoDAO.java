package br.com.IanOliv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.IanOliv.model.Produto;
import br.com.IanOliv.model.Regioes;

public class ProdutoDAO {

	private EntityManager em ;

	public ProdutoDAO(EntityManager em) {
		super();
		this.em = em;
	}
	
	public Integer createProduto(Produto produto) {
		em.persist(produto);
		return produto.getId();		
	}
	
	public  void deleteProduto(Integer id) {
		Produto find = em.find(Produto.class, id);
		em.remove(find);
	}
	
	public void updateProduto(Produto produto) {
		Produto oldProduto = em.find(Produto.class, produto.getId());
		oldProduto = produto;
		em.merge(oldProduto);
	}
	
	public Produto searchProduto(Integer id) {
		return em.find(Produto.class, id);
	}
	
	public List<Produto> listProdutos(){
		TypedQuery<Produto> query = em.createQuery("Select p from Produto p",Produto.class);
		return query.getResultList();
	}
	
	
	public List<Produto> listProdutosByRegia(Regioes regiao){
		TypedQuery<Produto> query = em.createQuery("Select p from Produto p " 
				+ " inner join ProdutoPreco pp "
				+ " on p.id = pp.produto.id "
				+ " where pp.regiao = :pRegiao "
				+ "",Produto.class);
		query.setParameter("pRegiao",regiao);
		
		return query.getResultList();
	}

	
	
	
	
}
