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

		<h4>Cadastramento de pedidos:</h4>

		<form action="/pedido" method="get">
			<button type="submit">Novo pedido</button>
		</form>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
			  <strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${not empty pedidoLista}">
		  	<p>Quantidade de pedidos cadastrados: ${pedidoLista.size()}</p>            
		  	<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>Descrição</th>
			        <th>Data</th>
			        <th>Solicitante</th>
			        <th>Produtos</th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
			    <c:forEach var="p" items="${pedidoLista}">
			      <tr>
			        <td>${p.descricao}</td>
			        <td>${p.data}</td>
			        <td>${p.solicitante.nome}</td>
			        <td>${p.produtos.size()}</td>
			        <td><a href="/pedido/${p.id}/excluir">Excluir</a></td>
			      </tr>
				</c:forEach>
			    </tbody>
			    <tfoot>
			      <tr>
			        <th>Descrição</th>
			        <th>Data</th>
			        <th>Solicitante</th>
			        <th>Produtos</th>
			        <th></th>
			      </tr>
			    </tfoot>
		  	</table>
		</c:if>
		
		<c:if test="${empty pedidoLista}">
	  		<p>Não existem pedidos cadastrados!!!</p>            
	  	</c:if>
	</div>
</body>
</html>