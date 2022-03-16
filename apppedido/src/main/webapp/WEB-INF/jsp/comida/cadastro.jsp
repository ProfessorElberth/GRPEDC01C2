<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8" />
	<title>App.2022 - Java</title>
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
<body>

	<header class="masthead">
    <div class="container px-4 px-lg-5 h-100">
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	</div>
	</header>

	<div class="container">
	
		<form action="/comida/incluir" method="post">
			<h2>Cadastramento de Comidas</h2>
		
			<div class="form-group">
				<label>Descrição:</label>
				<input type="text" class="form-control" name="descricao" value="Pão com ovo"> 
			</div>

			<div class="form-group">
				<label>Valor:</label>
				<input type="text" class="form-control" name="valor" value="15"> 
			</div>

			<div class="form-group">
				<label>Peso:</label>
				<input type="text" class="form-control" name="peso" value="250"> 
			</div>

			<div class="form-group">
				<label>Marca:</label>
				<input type="text" class="form-control" name="marca" value="DaFruta"> 
			</div>

			<div class="form-group">
				<label>Acompanhamento:</label>
				<input type="text" class="form-control" name="acompanhamento" value="pão e ovo"> 
			</div>

			<div class="form-group">
				<label>Qtde Servido:</label>
				<input type="text" class="form-control" name="qtdeServido" value="1"> 
			</div>

			<div class="form-group">
				<label>Características:</label>
				
				<div class="checkbox">
				  <label><input type="checkbox" name="vegana" value="true" checked> Vegana</label>
				</div>				
			</div>

			<button type="submit">Cadastrar</button>
		</form>		
	</div>
</body>
</html>