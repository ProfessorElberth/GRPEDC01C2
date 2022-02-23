<%@page import="br.edu.infnet.apppedido.model.domain.Aluno"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<title>App.2022 - Java</title>
</head>
<body>

	<div class="container">	
		<h4>Cadastramento de alunos:</h4>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
			  <strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<form action="/aluno" method="get">
			<button type="submit">Novo aluno</button>
		</form>

		<c:if test="${not empty alunoLista}">
		  	<p>Quantidade de alunos cadastrados: ${alunoLista.size()}</p>            
		  	<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>Nome</th>
			        <th>E-mail</th>
			        <th>Idade</th>
			        <th>Curso</th>
			        <th>Região</th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
			    <c:forEach var="a" items="${alunoLista}">
			      <tr>
			        <td>${a.nome}</td>
			        <td>${a.email}</td>
			        <td>${a.idade}</td>
			        <td>${a.curso}</td>
			        <td>${a.regiao}</td>
			        <td><a href="/aluno/${a.id}/excluir">Excluir</a></td>
			      </tr>
				</c:forEach>
			    </tbody>
			    <tfoot>
			      <tr>
			        <th>Nome</th>
			        <th>E-mail</th>
			        <th>Idade</th>
			        <th>Curso</th>
			        <th>Região</th>
			        <th></th>
			      </tr>
			    </tfoot>
		  	</table>
		</c:if>
		
		<c:if test="${empty alunoLista}">
	  		<p>Não existem alunos cadastrados!!!</p>            
	  	</c:if>
	</div>
</body>
</html>