import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//DAO data acess object, classe que acessa os dados.

public class UsuarioDAO {
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static List<Usuario> todosUsuarios(){
		List<Usuario> todos = new ArrayList<Usuario>();
		try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/usuarios", "postgres", "284693")){
	
			String sql = "select login, nome, email from usuario";
			PreparedStatement stm = c.prepareStatement(sql);
			ResultSet rs=stm.executeQuery();
				while(rs.next()) {
					Usuario u = new Usuario();
					u.setLogin(rs.getString("login"));
					u.setNome(rs.getString("nome"));
					u.setEmail(rs.getString("email"));
					todos.add(u);
				}
			
		}catch(SQLException e) {
			throw new RuntimeException("Nao foi possivel executar o acesso", e);
		}
		
		return todos;
		
	}
	public static List<Usuario> insertUsuario(Usuario u){
		List<Usuario> todos = new ArrayList<Usuario>();
		try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/usuarios", "postgres", "284693")){
			
			String sql = "INSERT INTO public.usuario(\r\n" + 
					"	nome, login, email)\r\n" + 
					"	VALUES (?, ?, ?);";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setString(1, u.getNome());
			stm.setString(2, u.getLogin());
			stm.setString(3, u.getEmail());
			stm.executeUpdate();
			
		}catch(SQLException e) {
			throw new RuntimeException("Nao foi possivel executar o acesso", e);
		}
		
		return todos;
	}
}
