
import java.sql.SQLException;

import org.dbunit.JdbcDatabaseTester;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;




class DAOTest {

	JdbcDatabaseTester jdt;
	DAO d;
	@Before
	public void setUp() throws Exception {
	 jdt = new JdbcDatabaseTester("org.postgresql.Driver","jdbc:postgresql://localhost/coursera","postgres", "284693");
	 FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
	 jdt.setDataSet(loader.load("/inicio.xml"));
	 jdt.onSetup();
	}
	
	@Test
	public void inserirUsuario() throws SQLException, Exception {
		Usuario u = new Usuario();
		u.setLogin("CLOGIN");
		u.setEmail("CEMAIL");
		u.setNome("CNOME");
		u.setSenha("CSENHA");
		u.setPontos(12);
		System.out.println("4");
		d.inserir(u);
		System.out.println("5");	
	}
}