package br.edu.infnet.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.infnet.connection.Conexao;
import br.edu.infnet.model.domain.Aluno;

public class AlunoRepository {

	public static void incluir(Aluno aluno){

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(
					"INSERT INTO TAluno "
					+ "(nome, email, idade, mensalidade, disciplinas, curso, regiao) "
					+ "VALUES (?,?,?,?,?,?,?)"
				);
			ps.setString(1, aluno.getNome());
			ps.setString(2, aluno.getEmail());
			ps.setInt(3, aluno.getIdade());
			ps.setFloat(4, aluno.getMensalidade());
			ps.setString(5, Arrays.toString(aluno.getDisciplinas()));
			ps.setString(6, aluno.getCurso());
			ps.setString(7, aluno.getRegiao());
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Aluno> obterLista(){
		
		List<Aluno> lista = new ArrayList<Aluno>();
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(
					"SELECT * FROM TAluno ORDER BY nome"
				);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {

				Aluno aluno = new Aluno(rs.getString("nome"), rs.getString("email"));
				aluno.setId(rs.getInt("id"));
				aluno.setIdade(rs.getInt("idade"));
				aluno.setMensalidade(rs.getFloat("mensalidade"));
				aluno.setCurso(rs.getString("curso"));
				aluno.setDisciplinas(rs.getString("disciplinas").split(","));
				aluno.setRegiao(rs.getString("regiao"));						

				lista.add(aluno);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return lista;
	}
}