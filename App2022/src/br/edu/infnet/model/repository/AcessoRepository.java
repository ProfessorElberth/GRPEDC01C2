package br.edu.infnet.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.infnet.connection.Conexao;
import br.edu.infnet.model.domain.Usuario;

public class AcessoRepository {

	public static Usuario validar(String email, String senha){
		
		String sql = "SELECT * FROM TUsuario WHERE email = ? and senha = ?";
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, senha);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(email);//rs.getString("email")
				usuario.setSenha(senha);//rs.getString("senha")
				
				return usuario;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}