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

		<h4>Cadastramento de produtos:</h4>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
			  <strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${not empty produtoLista}">
		  	<p>Quantidade de produtos cadastrados: ${produtoLista.size()}</p>            
		  	<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>ID</th>
			        <th>Descrição</th>
			        <th>Valor</th>
			        <th>Peso</th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
			    <c:forEach var="p" items="${produtoLista}">
			      <tr>
			        <td>${p.id}</td>
			        <td>${p.descricao}</td>
			        <td>${p.valor}</td>
			        <td>${p.peso}</td>
			        <td><a href="/produto/${p.id}/excluir">Excluir</a></td>
			      </tr>
				</c:forEach>
			    </tbody>
			    <tfoot>
			      <tr>
			        <th>ID</th>
			        <th>Descrição</th>
			        <th>Valor</th>
			        <th>Peso</th>
			        <th></th>
			      </tr>
			    </tfoot>
		  	</table>
		</c:if>
		
		<c:if test="${empty produtoLista}">
	  		<p>Não existem produtos cadastrados!!!</p>            
	  	</c:if>
	</div>
</body>
</html>