<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cria Pedido</title>
<link rel="stylesheet" type="text/css" href="CSS/Table.css">
<link rel="stylesheet" type="text/css" href="CSS/Menu.css">
<link rel="stylesheet" type="text/css" href="CSS/NewStyle.css">
</head>
<body>
	<c:import url="/Pages/Menu.html"></c:import>
	<br>
	<br>
	<div class="box">
		<div class="card">
			<div class="container">
				<div class="left">

					<form action="/GerenDePedidos/fazTudo?tarefa=CriaPedido"
						method="Post">
						<h3>Pedido Do cliente :</h3>
						<select required name="idCliente">
							<option value="">--</option>
							<c:forEach var="cliente" items="${clientes}">
								<option value="${cliente.id}">${cliente.nome}</option>
							</c:forEach>
						</select> <button type="submit" name="Criar"></button>
					</form>


				</div>
			</div>
		</div>
	</div>
</body>
</html>