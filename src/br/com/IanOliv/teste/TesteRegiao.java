package br.com.IanOliv.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.IanOliv.connection.JPAutil;
import br.com.IanOliv.dao.ClienteDAO;
import br.com.IanOliv.dao.ProdutoDAO;
import br.com.IanOliv.model.Cliente;
import br.com.IanOliv.model.Produto;
import br.com.IanOliv.model.Regioes;
import sun.security.krb5.internal.ccache.CCacheInputStream;

public class TesteRegiao {

	public static void main(String[] args) {

		List<Produto> produtos;
		Cliente cliente ; 
		
		EntityManager manager = new JPAutil().getEntiyManager();
		manager.getTransaction().begin();

		cliente = new ClienteDAO(manager).searchCliente(1);
		ProdutoDAO dao=new ProdutoDAO(manager);
		produtos = dao.listProdutosByRegia(cliente.getEndereco().getRegiao());

		manager.getTransaction().commit();
		manager.close();

		produtos.forEach(item->System.out.println(item.getId()));

		
	}

}
