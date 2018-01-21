package br.com.IanOliv.teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import br.com.IanOliv.connection.JPAutil;
import br.com.IanOliv.dao.ProdutoPrecoDAO;
import br.com.IanOliv.model.ProdutoPreco;

public class TestePrdPreco {

	public static void main(String[] args) {
		List<ProdutoPreco> prcs = new ArrayList<>();

		EntityManager em = new JPAutil().getEntiyManager();
		em.getTransaction().begin();

		prcs= new ProdutoPrecoDAO(em).listPrdPrco(3);
		
		prcs.forEach(item->System.out.println(item.getPreco()+" "+item.getRegiao()));

		
		em.getTransaction().commit();
		em.close();
		// System.out.println(prdPrc.getPreco()+"\n"+prdPrc.getRegiao()+"\n"+prdPrc.getProduto().getNome());

	}

}
