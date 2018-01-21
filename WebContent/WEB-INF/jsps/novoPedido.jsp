<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>novo Pedido</title>
<link rel="stylesheet" type="text/css" href="CSS/Table.css">
<link rel="stylesheet" type="text/css" href="CSS/Menu.css">
<link rel="stylesheet" type="text/css" href="CSS/NewStyle.css">
</head>
<body>
	<c:import url="../../Pages/Menu.html"></c:import>

	<div class="box">
		<div class="card">
			<div class="container">
				<h3>nº do Pedido :</h3>
				${pedido.id}
				<h3>Pedido do Cliente</h3>
				${pedido.cliente.nome}
				<h3>Status do pedido</h3>
				${pedido.status}
				<h3>Total :</h3>
				${pedido.total}
			</div>
		</div>
	</div>
	<br>
	<div class="box">
		<div class="card">
			<div class="container"></div>
		<form action="/GerenDePedidos/fazTudo?tarefa=ADDPrs" method="POST">
		<input type="hidden" name="regiao" value="${pedido.cliente.endereco.regiao}">
		<input type="hidden" name="idPedido" value="${pedido.id}">
		<input type="Submit" name="Add Produtos">
		
		</form>
		</div>
	</div>

</body>
</html>