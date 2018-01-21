<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pedido ${pedido.id}</title>
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
					<h3>Pedido nº ${pedido.id}</h3>
					<h4>Dono do Pedido ${pedido.cliente.nome}</h4>
					<h4>Total do Pedio :R$ ${pedido.total}</h4>
				</div>
			</div>
		</div>
	</div>
	<section>
					<h1>Produto</h1>
					<div class="tbl-header">
						<table cellpadding="0" cellspacing="0" border="0">
							<thead>
								<tr>

									<th>Codigo</th>
									<th>Nome</th>
								</tr>
							</thead>
						</table>
					</div>
					<div class="tbl-content">
						<table cellpadding="0" cellspacing="0" border="0">
							<tbody>
								<c:forEach var="pedPrt" items="${pedido.pePr}">
									<tr>
										<td>${pedPrt.produto.codigo}</td>
										<td>${pedPrt.produto.codigo}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</section>



</body>
</html>