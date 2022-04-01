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

	<c:set var="statusBotao" value=""/>

	<header class="masthead">
    <div class="container px-4 px-lg-5 h-100">
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	</div>
	</header>

	<div class="container">
	
		<form action="/pedido/incluir" method="post">
			<h2>Cadastramento de Pedidos</h2>
		
			<div class="form-group">
				<label>Descrição:</label>
				<input type="text" class="form-control" name="descricao" value="Primeiro pedido"> 
			</div>

			<div class="form-group">
				<c:if test="${not empty solicitanteLista}">
					<label>Solicitante:</label>
					<select name="solicitante.id" class="form-control">
						<c:forEach var="s" items="${solicitanteLista}">
							<option value="${s.id}">${s.nome}</option>
						</c:forEach>
					</select>
				</c:if>
				
				
				<c:if test="${empty solicitanteLista}">
					<label>Nenhum solicitante cadastrado!!!</label>
					<c:set var="statusBotao" value="disabled"/>
				</c:if>				
			</div>

			<div class="form-group">
				<c:if test="${not empty produtoLista}">
					<label>Produtos:</label>
					
					<c:forEach var="p" items="${produtoLista}">
						<div class="checkbox">
						  <label><input type="checkbox" name="idsProdutos" value="${p.id}" checked> ${p.descricao}</label>
						</div>
					</c:forEach>	
				</c:if>
				
				<c:if test="${empty produtoLista}">
					<label>Nenhum produto cadastrado!!!</label>
					<c:set var="statusBotao" value="disabled"/>
				</c:if>				
			</div>

			<button ${statusBotao} type="submit">Cadastrar</button>
		</form>		
	</div>
</body>
</html>