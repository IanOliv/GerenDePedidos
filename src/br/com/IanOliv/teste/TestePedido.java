package br.com.IanOliv.teste;

import java.util.List;

import javax.persistence.EntityManager;

import com.mysql.fabric.xmlrpc.Client;

import br.com.IanOliv.connection.JPAutil;
import br.com.IanOliv.dao.ClienteDAO;
import br.com.IanOliv.dao.PedidoDAO;
import br.com.IanOliv.model.Cliente;
import br.com.IanOliv.model.Contato;
import br.com.IanOliv.model.Endereco;
import br.com.IanOliv.model.Pedido;
import br.com.IanOliv.model.PedidoProduto;
import br.com.IanOliv.model.Produto;
import br.com.IanOliv.model.ProdutoPreco;
import br.com.IanOliv.model.Regioes;

public class TestePedido {
	public static void main(String[] args) {
		Endereco endereco = new Endereco();
		endereco.setCep("231231");
		endereco.setCidade("sp");
		endereco.setEstado("sp");
		endereco.setLogradouro("rua joa");
		endereco.setRegiao(Endereco.veriRegiao("SP"));

		Contato contato = new Contato();
		contato.setCel("23132");
		contato.setEmail("3221312@sd");
		contato.setTelefone("3213");

		Cliente cliente = new Cliente("ian", GeraCodigo.getCodigoCliente(endereco.getCidade()), endereco, contato);

		Pedido pedido = new Pedido();
//		pedido.setCliente(cliente);

		Produto produto = new Produto("doritos", "dasdsa");

		ProdutoPreco produtoPreco = new ProdutoPreco(Regioes.SUL, 2.99, produto);

		PedidoProduto pedidoProduto = new PedidoProduto(produto, pedido);

		EntityManager em = new JPAutil().getEntiyManager();
		em.getTransaction().begin();
		em.persist(contato);
		em.persist(endereco);
		em.persist(cliente);
		pedido.setCliente(cliente);
		em.persist(pedido);

		em.persist(produto);
		em.persist(produtoPreco);

		em.persist(pedidoProduto);

		em.getTransaction().commit();
		em.close();
		
		
		System.out.println(pedido.getCliente().getNome());
		
		
		

	}

}
