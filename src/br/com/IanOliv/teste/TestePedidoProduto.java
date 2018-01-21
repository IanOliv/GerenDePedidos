package br.com.IanOliv.teste;

import java.util.List;

import javax.persistence.EntityManager;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import br.com.IanOliv.connection.JPAutil;
import br.com.IanOliv.dao.PedidoDAO;
import br.com.IanOliv.dao.PedidoProdutoDAO;
import br.com.IanOliv.dao.ProdutoDAO;
import br.com.IanOliv.model.Pedido;
import br.com.IanOliv.model.PedidoProduto;
import br.com.IanOliv.model.Produto;

public class TestePedidoProduto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PedidoProduto ped = new PedidoProduto();

		List<PedidoProduto> pedPrdByPrduto;
		List<PedidoProduto> pedPrdByPedido;
		List<PedidoProduto> pedPrdByCliente;

		EntityManager em = new JPAutil().getEntiyManager();
		em.getTransaction().begin();

		PedidoProdutoDAO pedidoProdutoDAO = new PedidoProdutoDAO(em);

		ped = pedidoProdutoDAO.searchPedPrd(1);

		Pedido pedido = new Pedido();
		Produto produto = new Produto();

		pedido = em.find(Pedido.class, 1);
		produto = em.find(Produto.class, 1);

		pedPrdByPrduto = pedidoProdutoDAO.listPedPrdByProduto(produto);
		pedPrdByPedido = pedidoProdutoDAO.listPedPrdByPedido(pedido);
		pedPrdByCliente = pedidoProdutoDAO.listPedPrdByCliente(pedido.getCliente());

		em.getTransaction().commit();
		em.close();

		System.out.println(ped);

	}

}
