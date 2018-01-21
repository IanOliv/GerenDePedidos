<%@page import="br.com.IanOliv.connection.JPAutil"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="br.com.IanOliv.dao.PedidoProdutoDAO"%>
<%@page import="br.com.IanOliv.model.PedidoProduto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cliente ${cliente.nome}</title>

<link rel="stylesheet" type="text/css" href="CSS/BoxPedido.css">
<link rel="stylesheet" type="text/css" href="CSS/Table.css">
<link rel="stylesheet" type="text/css" href="CSS/Menu.css">
</head>
<body>
<c:import url="../../Pages/Menu.html"></c:import>
	<h3>Cliente:</h3>${cliente.nome}
	<h3>Codigo do Cliente :</h3>${cliente.codigo}
	<h3>Endereco :</h3>
	${cliente.endereco.logradouro}
	<h3>Estado :</h3>${cliente.endereco.estado}
	<h3>cidade :</h3>
	${cliente.endereco.cidade}
	<h3>CEP :</h3>${cliente.endereco.cep}
	<h3>email :</h3>${cliente.contato.email}
	<h3>Celular :</h3>
	${cliente.contato.cel}
	<h3>Telefone :</h3>
	${cliente.contato.telefone}
	
	<br>

	<div class="tab">
		<c:forEach items="${pedidosPrd}" var="pedidoRel">
			<button class="tablinks"onclick="openCity(event,'${pedidoRel.pedido.id}' )"  id="defaultOpen">
			 Pedido ${pedidoRel.pedido.id}
			 </button>
		</c:forEach>

	</div>


	<c:forEach items="${pedidosPrd}" var="pedidoRel">
		<div id="${pedidoRel.pedido.id}" class="tabcontent">
			<h3>Pedido ${pedidoRel.pedido.id}</h3>
			<c:forEach items="${pedidoRel.pedido.pePr}" var="pedi">
			
			<p>${pedi.produto.nome}</p>
			
			</c:forEach>
					

		</div>


	</c:forEach>


<script src="JS/BuscaCliente.js"></script>
</body>
</html>