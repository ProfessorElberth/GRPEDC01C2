package br.edu.infnet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.model.repository.AcessoRepository;

public class AcessoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AcessoController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario usuario = AcessoRepository.validar(email, senha);
		
		if(usuario != null) {
			request.getRequestDispatcher("aluno.html").forward(request, response);
		} else {

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
					"	<div class='container'>" + 
					"		<form action='login' method='get'>" + 
					"			<h2>Impossível autenticar no sistema:</h2>"
					);
			
			out.println("<h4>" + email +"</h4>");
			
			out.println(
					"			<button type='submit'>Voltar</button>" + 
					"		</form>"); 
			
			out.println(
					"	</div>" + 
					"</body>" + 
					"</html>"
					);		

		}
	}
}