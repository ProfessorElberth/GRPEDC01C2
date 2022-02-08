package br.edu.infnet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.model.domain.Aluno;
import br.edu.infnet.model.repository.AlunoRepository;

public class AlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AlunoController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.getRequestDispatcher("aluno.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Aluno aluno = new Aluno(request.getParameter("nome"), request.getParameter("email"));
		aluno.setIdade(Integer.valueOf(request.getParameter("idade")));
		aluno.setMensalidade(Float.valueOf(request.getParameter("mensalidade")));
		aluno.setCurso(request.getParameter("curso"));
		aluno.setDisciplinas(request.getParameterValues("disciplinas"));
		aluno.setRegiao(request.getParameter("regiao"));
		
		AlunoRepository.incluir(aluno);
		
		List<Aluno> alunos = AlunoRepository.obterLista();
		
		PrintWriter out = response.getWriter();
		
		out.println(
				"<!DOCTYPE html>" + 
				"<html>" + 
				"<head>" + 
				"	<meta charset=\"ISO-8859-1\">" + 
				"	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">" + 
				"	<title>App.2022 - Java</title>" + 
				"</head>" + 
				"<body>" + 
				"	<div class=\"container\">" + 
				"		<form action=\"aluno\" method=\"get\">" + 
				"			<h2>Cadastramento realizado com sucesso!!!</h2>"
				);
		
		out.println("<h4>" + aluno.toString()+"</h4>");
		
		out.println(
				"			<button type=\"submit\">Voltar</button>" + 
				"		</form>"); 

		out.println("<h3>Quantidade de alunos cadastrados: " + alunos.size()+"</h3>");
		
		for(Aluno a: alunos) {
			out.println("<h4>"+a.getNome()+" | "+a.getEmail()+"</h4>");			
		}
		
		out.println(
				"	</div>" + 
				"</body>" + 
				"</html>"
				);		

		
//		aluno.impressao();
		
//		request.getRequestDispatcher("confirmacao.html").forward(request, response);
	}
}