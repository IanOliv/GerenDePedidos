package br.com.IanOliv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.IanOliv.model.Cliente;
import br.com.IanOliv.model.Pedido;
import br.com.IanOliv.model.PedidoProduto;
import br.com.IanOliv.model.Produto;

public class PedidoProdutoDAO {
	private EntityManager em;

	public PedidoProdutoDAO(EntityManager em) {
		super();
		this.em = em;
	}

	public void criaPedPrd(PedidoProduto pedidoProduto) {
		em.persist(pedidoProduto);
	}

	public void deletePedPrd(Integer id) {
		PedidoProduto find = em.find(PedidoProduto.class, id);
		em.remove(find);
	}

	public PedidoProduto searchPedPrd(Integer id) {
		return em.find(PedidoProduto.class, id);
	}

	public List<PedidoProduto> listPedPrd() {
		TypedQuery<PedidoProduto> query = em.createQuery("Select pp from PedidoProduto pp",PedidoProduto.class);
		return query.getResultList();
	}
	
	public List<PedidoProduto> listPedPrdByPedido(Pedido pedido) {
		TypedQuery<PedidoProduto> query = em.createQuery("Select pp from PedidoProduto pp where pp.pedido = :pPedido ",PedidoProduto.class);
		query.setParameter("pPedido",pedido);
		return query.getResultList();
	}
	public List<PedidoProduto> listPedPrdByProduto(Produto produto) {
		TypedQuery<PedidoProduto> query = em.createQuery("Select pp from PedidoProduto pp where pp.produto = :pProduto ",PedidoProduto.class);
		query.setParameter("pProduto", produto);
		return query.getResultList();
	}
	public List<PedidoProduto> listPedPrdByCliente(Cliente cliente) {
		TypedQuery<PedidoProduto> query = em.createQuery("Select pp from PedidoProduto pp "
				+ " inner join Pedido pd "
				+ " on pp.pedido.id =pd.id "
				+ " where pd.cliente = :pCliente",PedidoProduto.class);
		query.setParameter("pCliente", cliente);
		return query.getResultList();
	}
	
	public List<PedidoProduto> infoPedPrdByPedido(Pedido pedido) {
		TypedQuery<PedidoProduto> query = em.createQuery("Select pp from PedidoProduto pp where pp.pedido = :pPedido ",PedidoProduto.class);
		query.setParameter("pPedido",pedido);
		return query.getResultList();
	}
	
	
	

	
	
	
	
	
	
}
