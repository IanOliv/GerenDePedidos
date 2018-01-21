package br.com.IanOliv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.mysql.fabric.xmlrpc.Client;

import br.com.IanOliv.model.Cliente;

public class ClienteDAO {
	private EntityManager em;

	public ClienteDAO(EntityManager em) {
		this.em = em;
	}

	public Integer createCliente(Cliente cliente) {
		em.persist(cliente.getEndereco());
		em.persist(cliente.getContato());
		em.persist(cliente);
		return cliente.getId();
	}

	public void deleteCliente(Integer id) {
		Cliente cliente = em.find(Cliente.class, id);
		em.remove(cliente);
	}

	public void updateCliente(Cliente cliente) {
		Cliente oldCliente = em.find(Cliente.class, cliente.getId());
		oldCliente = cliente;
		em.merge(oldCliente);
	}

	public Cliente searchCliente(Integer id) {
		return em.find(Cliente.class, id);

	}

	public List<Cliente> listClientes() {
		TypedQuery<Cliente> query = em.createQuery("Select c from Cliente c",Cliente.class);
		return query.getResultList();

	}

}
