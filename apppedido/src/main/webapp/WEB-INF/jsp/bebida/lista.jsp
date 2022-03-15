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

		<h4>Cadastramento de bebidas:</h4>

		<form action="/bebida" method="get">
			<button type="submit">Nova bebida</button>
		</form>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
			  <strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${not empty bebidaLista}">
		  	<p>Quantidade de bebidas cadastradas: ${bebidaLista.size()}</p>            
		  	<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>ID</th>
			        <th>Descrição</th>
			        <th>Valor</th>
			        <th>Peso</th>
			        <th>Marca</th>
			        <th>Importada</th>
			        <th>Gelada</th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
			    <c:forEach var="b" items="${bebidaLista}">
			      <tr>
			        <td>${b.id}</td>
			        <td>${b.descricao}</td>
			        <td>${b.valor}</td>
			        <td>${b.peso}</td>
			        <td>${b.marca}</td>
			        <td>${b.importada}</td>
			        <td>${b.gelada}</td>
			        <td><a href="/produto/${b.id}/excluir">Excluir</a></td>
			      </tr>
				</c:forEach>
			    </tbody>
			    <tfoot>
			      <tr>
			        <th>ID</th>
			        <th>Descrição</th>
			        <th>Valor</th>
			        <th>Peso</th>
			        <th>Marca</th>
			        <th>Importada</th>
			        <th>Gelada</th>
			        <th></th>
			      </tr>
			    </tfoot>
		  	</table>
		</c:if>
		
		<c:if test="${empty bebidaLista}">
	  		<p>Não existem bebidas cadastradas!!!</p>            
	  	</c:if>
	</div>
</body>
</html>