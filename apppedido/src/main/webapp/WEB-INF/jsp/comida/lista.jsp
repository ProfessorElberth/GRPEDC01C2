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

		<h4>Cadastramento de comidas:</h4>

		<form action="/comida" method="get">
			<button type="submit">Nova comida</button>
		</form>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
			  <strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${not empty comidaLista}">
		  	<p>Quantidade de comidas cadastradas: ${comidaLista.size()}</p>            
		  	<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>ID</th>
			        <th>Descrição</th>
			        <th>Valor</th>
			        <th>Peso</th>
			        <th>Acompanhamento</th>
			        <th>Vegana</th>
			        <th>Qtde Servido</th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
			    <c:forEach var="c" items="${comidaLista}">
			      <tr>
			        <td>${c.id}</td>
			        <td>${c.descricao}</td>
			        <td>${c.valor}</td>
			        <td>${c.peso}</td>
			        <td>${c.acompanhamento}</td>
			        <td>${c.vegana}</td>
			        <td>${c.qtdeServido}</td>
			        <td><a href="/comida/${c.id}/excluir">Excluir</a></td>
			      </tr>
				</c:forEach>
			    </tbody>
			    <tfoot>
			      <tr>
			        <th>ID</th>
			        <th>Descrição</th>
			        <th>Valor</th>
			        <th>Peso</th>
			        <th>Acompanhamento</th>
			        <th>Vegana</th>
			        <th>Qtde Servido</th>
			        <th></th>
			      </tr>
			    </tfoot>
		  	</table>
		</c:if>
		
		<c:if test="${empty comidaLista}">
	  		<p>Não existem comidas cadastradas!!!</p>            
	  	</c:if>
	</div>
</body>
</html>