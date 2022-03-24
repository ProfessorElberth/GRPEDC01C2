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

		<h4>Cadastramento de solicitantes:</h4>

		<form action="/solicitante" method="get">
			<button type="submit">Novo solicitante</button>
		</form>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
			  <strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${not empty solicitanteLista}">
		  	<p>Quantidade de solicitantes cadastrados: ${solicitanteLista.size()}</p>            
		  	<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>Nome</th>
			        <th>E-mail</th>
			        <th>CPF</th>
			        <th>Usuário</th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
			    <c:forEach var="s" items="${solicitanteLista}">
			      <tr>
			        <td>${s.nome}</td>
			        <td>${s.email}</td>
			        <td>${s.cpf}</td>
			        <td>${s.usuario.nome}</td>
			        <td><a href="/solicitante/${s.id}/excluir">Excluir</a></td>
			      </tr>
				</c:forEach>
			    </tbody>
			    <tfoot>
			      <tr>
			        <th>Nome</th>
			        <th>E-mail</th>
			        <th>CPF</th>
			        <th>Usuário</th>
			        <th></th>
			      </tr>
			    </tfoot>
		  	</table>
		</c:if>
		
		<c:if test="${empty solicitanteLista}">
	  		<p>Não existem solicitantes cadastrados!!!</p>            
	  	</c:if>
	</div>
</body>
</html>