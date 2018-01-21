<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Novo Produto</title>

<link rel="stylesheet" type="text/css" href="CSS/Menu.css">
</head>
<body>
<c:import url="../../Pages/Menu.html"></c:import>
	<h1>Novo Produto Adicionado</h1>
	<h3>Nome do Produto :</h3>
	${produto.nome}
	<h3>Codigo do Produto:</h3>
	${produto.codigo}
	<h3>Preço deo Produto</h3>
	<ul>
		<c:forEach var="preco" items="${produto.precos}">
			<li><div>
					<h3>${preco.regiao}<h3>
							<h3>${preco.preco}<h3>
									
				</div></li>

		</c:forEach>
	</ul>
</body>
</html>