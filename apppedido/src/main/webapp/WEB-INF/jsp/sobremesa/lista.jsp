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
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container fixed-top" >	

		<h4>Cadastramento de sobremesas:</h4>

		<form action="/sobremesa" method="get">
			<button type="submit">Nova sobremesa</button>
		</form>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
			  <strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${not empty sobremesaLista}">
		  	<p>Quantidade de sobremesas cadastradas: ${sobremesaLista.size()}</p>            
		  	<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>ID</th>
			        <th>Descrição</th>
			        <th>Valor</th>
			        <th>Peso</th>
			        <th>Ingrediente</th>
			        <th>Calda</th>
			        <th>Diet</th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
			    <c:forEach var="s" items="${sobremesaLista}">
			      <tr>
			        <td>${s.id}</td>
			        <td>${s.descricao}</td>
			        <td>${s.valor}</td>
			        <td>${s.peso}</td>
			        <td>${s.ingrediente}</td>
			        <td>${s.calda}</td>
			        <td>${s.diet}</td>
			        <td><a href="/sobremesa/${s.id}/excluir">Excluir</a></td>
			      </tr>
				</c:forEach>
			    </tbody>
			    <tfoot>
			      <tr>
			        <th>ID</th>
			        <th>Descrição</th>
			        <th>Valor</th>
			        <th>Peso</th>
			        <th>Ingrediente</th>
			        <th>Calda</th>
			        <th>Diet</th>
			        <th></th>
			      </tr>
			    </tfoot>
		  	</table>
		</c:if>
		
		<c:if test="${empty sobremesaLista}">
	  		<p>Não existem sobremesas cadastradas!!!</p>            
	  	</c:if>
	</div>
</body>
</html>