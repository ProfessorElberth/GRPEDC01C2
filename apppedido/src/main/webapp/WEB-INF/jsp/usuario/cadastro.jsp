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

		<form action="/cep" class="form-inline" method="post">	
			<div class="form-group">
				<label>Cep:</label>
				<input type="text" class="form-control" name="cep" value="24.123-45"> 
			</div>
			
			<button type="submit" class="btn btn-primary">Buscar</button>
		</form>
	
		<form action="/usuario/incluir" method="post">
			<h2>Cadastramento de Usu�rios</h2>
		
			<div class="form-group">
				<label>Nome:</label>
				<input type="text" class="form-control" name="nome" value="Elberth L C Moraes"> 
			</div>
			
			<div class="form-group">
				<label>E-mail:</label>
				<input type="email" class="form-control" name="email" value="elberth.moraes@prof.infnet.edu.br">
			</div>
			
			<div class="form-group">
				<label>Senha:</label>
				<input type="password" class="form-control" name="senha" value="123"> 
			</div>
			
			<c:import url="/WEB-INF/jsp/endereco.jsp"/>

			<button type="submit">Cadastrar</button>
		</form>	
	
	</div>
</body>
</html>