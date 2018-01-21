<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Produto</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/Table.css">
<link rel="stylesheet" type="text/css" href="CSS/Menu.css">
</head>
<body>


	<c:import url="../../Pages/Menu.html"></c:import>
	<section>
	<h1>Produtos disponiveis na Regiao ${regiao}</h1>

	<form method="POST"
		action="/GerenDePedidos/fazTudo?tarefa=CriaPedidoProduto">
		<div class="tbl-header">
			<table cellpadding="0" cellspacing="0" border="0">
				<thead>
					<tr>

						<th>Codigo</th>
						<th>Nome</th>
						<th>Preço</th>
						<th>Add</th>

					</tr>
				</thead>
			</table>
		</div>

		<div class="tbl-content">
			<table cellpadding="0" cellspacing="0" border="0">
				<tbody>
					<c:forEach var="produto" items="${produtos}">
						<tr>
							<td>${produto.codigo}</td>
							<td>${produto.nome}</td>
							<td><input placeholder="${produto.precos.get(0).preco}"
								type="number" step="1" min="0.01"></td>
							<td><input type="checkbox" name="Produto"
								value="${produto.id}" class="myCheck" onclick="myFunction()"></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>

			<br>
			<div class="box">
				<div class="card">
					<div class="container">
						<button type="submit" name="idPedido" value="${idPedido}">Finalizar
							Pedido"</button>
					</div>
				</div>
			</div>
		</div>
	</form>
	</section>
	<script src="CSS/Table.js"></script>
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

</body>
</html>