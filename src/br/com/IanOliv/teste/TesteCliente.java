package br.com.IanOliv.teste;

import java.util.List;

import javax.persistence.EntityManager;

import com.mysql.fabric.xmlrpc.Client;

import br.com.IanOliv.connection.JPAutil;
import br.com.IanOliv.dao.ClienteDAO;
import br.com.IanOliv.model.Cliente;
import br.com.IanOliv.model.Contato;
import br.com.IanOliv.model.Endereco;

public class TesteCliente {

	public static void main(String[] args) {		
		Endereco endereco = new Endereco();
		endereco.setCep("442342");
		endereco.setCidade("dasdas");
		endereco.setEstado("dsadas");
		endereco.setLogradouro("fasfas");
		
		Contato contato = new Contato();
		contato.setCel("dasda");
		contato.setEmail("dasda");
		
		Cliente cliente = new Cliente();
		cliente.setNome("xarrdsdsa");
		cliente.setEndereco(endereco);
		cliente.setContato(contato);
		
		
		
		EntityManager em = new  JPAutil().getEntiyManager();
		em.getTransaction().begin();
		
	
		ClienteDAO clienteDAO = new ClienteDAO(em);
		 clienteDAO.createCliente(cliente);
		
		
		em.getTransaction().commit();

		em.close();
		
		
		
		
		
	}

}
