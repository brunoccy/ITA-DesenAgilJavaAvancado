
public class PrincipalInsert {

	public static void main(String[] args) {
		Usuario u = new Usuario();
		u.setEmail("teste@gmail.com");
		u.setLogin("login");
		u.setNome("nome");
		UsuarioDAO.insertUsuario(u);

	}

}
