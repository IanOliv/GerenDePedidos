package br.com.IanOliv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.IanOliv.model.ProdutoPreco;

public class ProdutoPrecoDAO {
	private EntityManager em;

	public ProdutoPrecoDAO(EntityManager em) {
		super();
		this.em = em;
	}

	public void createPrdPreco(ProdutoPreco prdPreco) {
		em.persist(prdPreco);
	}

	public void deletePrdPreco(Integer id) {
		ProdutoPreco find = em.find(ProdutoPreco.class, id);
		em.remove(find);
	}

	public void updatePrdPreco(ProdutoPreco prdPreco) {
		ProdutoPreco find = em.find(ProdutoPreco.class, prdPreco.getId());
		find = prdPreco;
		em.merge(find);
	}

	public ProdutoPreco searchPrdPreco(Integer idPrdPrc) {
		TypedQuery<ProdutoPreco> query = em.createQuery("Select pp from ProdutoPreco pp where pp.id = :pIdPrd", ProdutoPreco.class);
		query.setParameter("pIdPrd", idPrdPrc);
		return query.getSingleResult();
		
		
	}

	public List<ProdutoPreco> listAllPrdPrecos() {
		TypedQuery<ProdutoPreco> query = em.createQuery("Select pp from ProdutoPreco pp", ProdutoPreco.class);
		return query.getResultList();

	}

	public List<ProdutoPreco> listPrdPrco(Integer idPrd){
		TypedQuery<ProdutoPreco> query = em.createQuery("Select pp from ProdutoPreco pp where pp.produto.id = :pIdPrd", ProdutoPreco.class);
		query.setParameter("pIdPrd",idPrd);
		return query.getResultList();
	}
	
}
