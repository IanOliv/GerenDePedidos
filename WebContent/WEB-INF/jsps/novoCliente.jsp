<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cliente Criado</title>
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
					<h3>Cliente:</h3>
					<br>
					${cliente.nome}
				</div>
				<div class="left">
					<h3>email :</h3>
					<br>
					${cliente.contato.email}
				</div>
				<div class="right">
					<h3>Celular :</h3>
					<br>
					${cliente.contato.cel}
				</div>
				<div class="right">
					<h3>Telefone :</h3>
					<br>
					${cliente.contato.telefone}
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<div class="box">
		<div class="card">
			<div class="container">


				<h3>Codigo do Cliente :</h3>${cliente.codigo}
				<h3>Endereco :</h3>
				${cliente.endereco.logradouro}
				<h3>Estado :</h3>${cliente.endereco.estado}
				<h3>cidade :</h3>
				${cliente.endereco.cidade}
				<h3>CEP :</h3>${cliente.endereco.cep}
			</div>
		</div>
	</div>
</body>
</html>