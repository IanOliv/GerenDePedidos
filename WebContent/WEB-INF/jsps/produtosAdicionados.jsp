<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Produtos adicionados</title>
<link rel="stylesheet" type="text/css" href="CSS/Menu.css">
<link rel="stylesheet" type="text/css" href="CSS/Menu.css">
<link rel="stylesheet" type="text/css" href="CSS/NewStyle.css">
</head>
<body>

	<c:import url="../../Pages/Menu.html"></c:import>
	<br>
	<br>
	<div class="box">
		<div class="card">
			<div class="container">
				<div class="left">
					<h2>Produtos adicionados com sucesso ao Pedido : ${pedido.id}</h2>
					<br> <br>
					<h3>Total: ${pedido.total }</h3>
				</div>
			</div>
		</div>
</body>
</html>