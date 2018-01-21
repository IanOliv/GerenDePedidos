<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/Table.css">
<link rel="stylesheet" type="text/css" href="CSS/Menu.css">

<style type="text/css">
</style>
<title>Lista Pedidos</title>
</head>
<body>

	<c:import url="../../Pages/Menu.html"></c:import>
	<br>
	<br>
	<section>
	<h1>Pedidos</h1>
	<div class="tbl-header">
	<table  cellpadding="0" cellspacing="0" border="0">
		<thead>
			<tr>
				
				<th>Nº</th>
				<th>Dono do Pedido</th>
				<th>Status</th>
				<th>Total</th>
			</tr>
		</thead>
		</table>
		</div>
		<div class="tbl-content">
		<table cellpadding="0" cellspacing="0" border="0">
		<tbody>
			<c:forEach var="pedido" items="${pedidos}">
				<tr>
					<td><a href="fazTudo?tarefa=BuscaPedido&idPedido=${pedido.id}">${pedido.id}</a></td>
					<td><a href="fazTudo?tarefa=BuscaPedido&idPedido=${pedido.id}">${pedido.cliente.nome}</a></td>
					<td><a href="fazTudo?tarefa=BuscaPedido&idPedido=${pedido.id}">${pedido.status}</a></td>
					<td><a href="fazTudo?tarefa=BuscaPedido&idPedido=${pedido.id}">R$ ${pedido.total}</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	</section>

<script src="CSS/Table.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
</body>
</html>