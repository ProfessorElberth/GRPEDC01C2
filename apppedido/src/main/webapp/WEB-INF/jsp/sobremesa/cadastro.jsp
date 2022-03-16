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
	
		<form action="/sobremesa/incluir" method="post">
			<h2>Cadastramento de Sobremesas</h2>
		
			<div class="form-group">
				<label>Descrição:</label>
				<input type="text" class="form-control" name="descricao" value="Pudim"> 
			</div>

			<div class="form-group">
				<label>Valor:</label>
				<input type="text" class="form-control" name="valor" value="20"> 
			</div>

			<div class="form-group">
				<label>Peso:</label>
				<input type="text" class="form-control" name="peso" value="100"> 
			</div>

			<div class="form-group">
				<label>Ingrediente:</label>
				<input type="text" class="form-control" name="ingrediente" value="leite e coco"> 
			</div>

			<div class="form-group">
				<label>Características:</label>
				
				<div class="checkbox">
				  <label><input type="checkbox" name="calda" value="true" checked> Calda</label>
				</div>				
				<div class="checkbox">
				  <label><input type="checkbox" name="diet" value="true" checked> Diet</label>
				</div>				
			</div>

			<button type="submit">Cadastrar</button>
		</form>		
	</div>
</body>
</html>