<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Produto ${produto.nome}</title>

<link rel="stylesheet" type="text/css" href="CSS/Menu.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="CSS/NewStyle.css">

</head>
<body>
	<c:import url="../../Pages/Menu.html"></c:import>

	<br>
	<br>
	<div class="box">
		<div class="card">
			<div class="container">
				<div>
					<h3>Nome do Produto :</h3>
					${produto.nome}
				</div>
				<h3>Codigo do Produto:</h3>
				${produto.codigo}


			</div>
		</div>
	</div>
	<br>
	<br>


	<div class="box">
		<div class="card">
			<div class="container">
				<ul id="preco">
					<h3>Preço do Produto por regiao</h3>

					<c:forEach var="preco" items="${produto.precos}">
						<li><div>
								<h4>${preco.regiao}</h4>
								<h4>${preco.preco}</h4>
							</div></li>


						<br>
						<br>
						<br>
						<br>
						<br>
						<br>

					</c:forEach>
				</ul>

			</div>
		</div>
	</div>

	<div class="box">
		<div class="card">
			<div class="container">
		<a href="/GerenDePedidos/fazTudo?tarefa=AlteraProduto&IdProduto=${produto.id}">	<button> Alterar Produto</button></a>
			</div>
		</div>
	</div>

</body>
</html>