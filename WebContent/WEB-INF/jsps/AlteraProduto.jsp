<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Altera Produto</title>
<link rel="stylesheet" type="text/css" href="CSS/Menu.css">
</head>
<body>

<c:import url="../../Pages/Menu.html"></c:import>

<br>
<br>
<div class="container">

	<form action="/GerenDePedidos/fazTudo?tarefa=CriaProduto" method="POST"
	id="FormCadastro">

		<h3>Cadastro de Produto</h3>
		<br>
		<fieldset>
		<h4>Nome</h4>
		<input placeholder="${produto.nome}" required autofocus type="text" name="nameProduto">
		</fieldset>
		<fieldset>
		<h4>Codigo</h4>
		<input   placeholder="${produto.codigo}" required autofocus type="text" maxlength="12" name="codigoProduto">
		</fieldset>
		<fieldset>
		<fieldset>
		<input placeholder="Preço da Regiao Suldeste" required autofocus type="number" step="any" min="0.01" name="preProdutoSE">
		</fieldset>
		<fieldset>
		<input  placeholder="Preço da Regiao Sul" required autofocus type="number" step="any" min="0.01" name="preProdutoS">
		</fieldset>
		<fieldset>
		<input  placeholder="Preço da Regiao Nordeste" required autofocus type="number" step="any" min="0.01" name="preProdutoNE">
		</fieldset>
		<fieldset>
		<input  placeholder="Preço da Regiao Norte" required autofocus type="number" step="any" min="0.01" name="preProdutoN">
		</fieldset>
		<fieldset>
		<input  placeholder="Preço da Regiao Centro-Oeste" required autofocus type="number" step="any" min="0.01" name="preProdutoCO">
		</fieldset>
		</fieldset>

		<fieldset>
		<button name="submit" type="submit" id="contact-submit" >Submit</button>
		
		</fieldset>
	</form>

</div>

</body>
</html>