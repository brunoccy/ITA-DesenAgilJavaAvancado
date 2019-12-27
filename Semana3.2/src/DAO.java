import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO implements UsuarioDAO{

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void inserir(Usuario u) {

		try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/coursera", "postgres", "284693")){
			String sql = "INSERT INTO usuario(\r\n" + 
					"	login, email, nome, senha, pontos)\r\n" + 
					"	VALUES (?, ?, ?, ?, ?);";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setString(1, u.getLogin());
			stm.setString(2, u.getEmail());
			stm.setString(3, u.getNome());
			stm.setString(4, u.getSenha());
			stm.setInt(5, u.getPontos());

			stm.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException("Nao foi possivel ter acesso");
		}	
	}

	@Override
	public Usuario recuperar(String login) {
		Usuario u = new Usuario();
		try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/coursera", "postgres", "284693")){
			String sql = "SELECT * FROM usuario WHERE login = ?;";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setString(1, login);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				u.setLogin(rs.getString("login"));
				u.setEmail(rs.getString("email"));
				u.setNome(rs.getString("nome"));
				u.setSenha(rs.getString("senha"));
				u.setPontos(rs.getInt("pontos"));
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Nao foi possivel ter acesso");
		}
		return u;
	}

	@Override
	public void adicionarPontos(String login, int pontos) {
		Usuario u = new Usuario();
		try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/coursera", "postgres", "284693")){
			String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?;";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setString(1, login);
			stm.setInt(2, pontos);
			stm.executeUpdate();
			}
		catch (SQLException e) {
			throw new RuntimeException("Nao foi possivel ter acesso");
		}
	}

	@Override
	public List<Usuario> ranking() {
		List<Usuario> listRanking = new ArrayList<Usuario>();
		try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/coursera", "postgres", "284693")){
			String sql = "SELECT * FROM usuario ORDER BY pontos DESC;";
			PreparedStatement stm = c.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Usuario u = new Usuario();
				u.setLogin(rs.getString("login"));
				u.setEmail(rs.getString("email"));
				u.setNome(rs.getString("nome"));
				u.setSenha(rs.getString("senha"));
				u.setPontos(rs.getInt("pontos"));
				listRanking.add(u);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Nao foi possivel ter acesso");
		}
		return listRanking;
	}

}
