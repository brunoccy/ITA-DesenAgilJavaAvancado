
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class UsuarioDAO {
    
    static {
	try {
            Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
            e.printStackTrace();
            }
	}
    
    public Usuario recuperarUm(String login){
        Usuario u = new Usuario();
        try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/semana4","postgres","284693")) {
            String sql = "SELECT * FROM usuario WHERE login = ?;";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, login);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                u.setEmail(rs.getString("email"));
                u.setLogin(rs.getString("login"));
                u.setNome(rs.getString("nome"));
                u.setSenha(rs.getString("senha"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u; 
        
    }
    
    public List<Usuario> recuperarTudo(){
        List<Usuario> listTudo = new ArrayList<Usuario>();
        try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/semana4","postgres","284693")) {
            String sql = "SELECT * FROM usuario";
            PreparedStatement stm = c.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                Usuario u = new Usuario();
                u.setEmail(rs.getString("email"));
                u.setLogin(rs.getString("login"));
                u.setNome(rs.getString("nome"));
                u.setSenha(rs.getString("senha"));
                listTudo.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTudo; 
        
    }

    void inserirUsuario(Usuario newUser) {
        try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/semana4","postgres","284693")) {
            String sql = "INSERT INTO usuario(\r\n" + 
                        " login, email, nome, senha, pontos)\r\n" + 
			" VALUES (?, ?, ?, ?, ?);";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, newUser.getLogin());
            stm.setString(2, newUser.getEmail());
            stm.setString(3, newUser.getNome());
            stm.setString(4, newUser.getSenha());
            stm.setInt(5, newUser.getPontos());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Usuario> ranking(){
        List<Usuario> listRank = new ArrayList<Usuario>();
        try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/semana4","postgres","284693")) {
            String sql = "SELECT * FROM usuario ORDER BY pontos DESC;";
            PreparedStatement stm = c.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                Usuario u = new Usuario();
                u.setEmail(rs.getString("email"));
                u.setLogin(rs.getString("login"));
                u.setNome(rs.getString("nome"));
                u.setSenha(rs.getString("senha"));
                listRank.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRank; 
        
    }
    
}
