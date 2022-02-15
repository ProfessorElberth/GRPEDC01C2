<%@page import="br.edu.infnet.model.domain.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="br.edu.infnet.model.domain.Aluno"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<title>App.2022 - Java</title>
</head>
<body>
	<%
	Usuario userLogado = (Usuario)request.getAttribute("user"); 
	List<Aluno> alunos = (List<Aluno>)request.getAttribute("alunoLista");
	int qtde = alunos.size();
	
	String nome = userLogado != null ? userLogado.getNome() : "Fantasma";
	%>
	 
	<div class="container">	
		<h4><%=nome%>, realize o cadastramento de alunos:</h4>

		<form action="aluno" method="get">
			<button type="submit">Novo aluno</button>
		</form>

	  	<%if(qtde > 0){%>
		  	<p>Quantidade de alunos cadastrados: <%=qtde%></p>            
		  	<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>Nome</th>
			        <th>E-mail</th>
			        <th>Idade</th>
			        <th>Curso</th>
			        <th>Região</th>
			      </tr>
			    </thead>
			    <tbody>
				<%for(Aluno a: alunos) {%>
			      <tr>
			        <td><%=a.getNome()%></td>
			        <td><%=a.getEmail()%></td>
			        <td><%=a.getIdade()%></td>
			        <td><%=a.getCurso()%></td>
			        <td><%=a.getRegiao()%></td>
			      </tr>
				<%}%>
			    </tbody>
			    <tfoot>
			      <tr>
			        <th>Nome</th>
			        <th>E-mail</th>
			        <th>Idade</th>
			        <th>Curso</th>
			        <th>Região</th>
			      </tr>
			    </tfoot>
		  	</table>
	  	<%} else {%>
	  		<p>Não existem alunos cadastrados!!!</p>            
	  	<%}%>
	</div>
</body>
</html>