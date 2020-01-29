
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutenticarDAO {
    String login;
    String senha;
    static {
	try {
            Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
            e.printStackTrace();
            }
	}
    public AutenticarDAO() {
    }  
    public static boolean verficarUsuario(String login, String senha){
        boolean usuario = false;
        try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/semana4","postgres","284693")) {
            String sql = "SELECT * FROM usuario WHERE login = ? and senha = ?;";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, login);
            stm.setString(2, senha);
            ResultSet rs = stm.executeQuery();
            usuario = rs.next();
          
            } catch (SQLException ex) {
            Logger.getLogger(AutenticarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }
    
}
