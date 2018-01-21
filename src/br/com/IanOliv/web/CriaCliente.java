package br.com.IanOliv.web;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.IanOliv.connection.JPAutil;
import br.com.IanOliv.dao.ClienteDAO;
import br.com.IanOliv.model.Cliente;
import br.com.IanOliv.model.Contato;
import br.com.IanOliv.model.Endereco;
import br.com.IanOliv.teste.GeraCodigo;

public class CriaCliente implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Endereco endereco = new Endereco();
		endereco.setCep(req.getParameter("cepCliente"));
		endereco.setCidade(req.getParameter("cidadeCliente"));
		endereco.setEstado(req.getParameter("estadoCliente"));
		endereco.setLogradouro(req.getParameter("logCliente"));
		endereco.setRegiao(endereco.veriRegiao(endereco.getEstado()));

		Contato contato = new Contato();
		contato.setCel(req.getParameter("celCliente"));
		contato.setTelefone(req.getParameter("telCliente"));
		contato.setEmail(req.getParameter("emailCliente"));

		Cliente cliente = new Cliente();
		cliente.setNome(req.getParameter("nameCliente"));
		cliente.setCodigo(GeraCodigo.getCodigoCliente(endereco.getEstado()));
		cliente.setContato(contato);
		cliente.setEndereco(endereco);

		EntityManager em = new JPAutil().getEntiyManager();
		em.getTransaction().begin();
		new ClienteDAO(em).createCliente(cliente);

		em.getTransaction().commit();
		em.close();

		req.setAttribute("cliente", cliente);
		req.setAttribute("endereco", endereco);
		req.setAttribute("contado", contato);

		return "WEB-INF/jsps/novoCliente.jsp";
	}

}
