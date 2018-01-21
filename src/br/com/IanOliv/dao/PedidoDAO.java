package br.com.IanOliv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.IanOliv.model.Pedido;
import br.com.IanOliv.model.Produto;
import br.com.IanOliv.model.Regioes;
import br.com.IanOliv.model.StatusPedido;

public class PedidoDAO {
	private EntityManager em;

	public PedidoDAO(EntityManager em) {
		super();
		this.em = em;
	}

	public Integer createPedido(Pedido pedido) {
		em.persist(pedido);
		return pedido.getId();
	}

	public void deletePedido(Integer id) {
		Pedido find = em.find(Pedido.class, id);
		em.remove(find);
	}

	public void updatePedido(Pedido pedido) {
		Pedido find = em.find(Pedido.class, pedido.getId());
		find = pedido;
		em.merge(find);
	}

	public Pedido searchPedido(Integer id) {
		return em.find(Pedido.class, id);
	}

	public List<Pedido> listPedidos() {
		TypedQuery<Pedido> query = em.createQuery("Select p from Pedido p", Pedido.class);
		return query.getResultList();
	}



	
}
