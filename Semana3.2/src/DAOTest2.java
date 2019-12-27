import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;


	

public class DAOTest2 {

	JdbcDatabaseTester jdt;
	DAO d;
	@Before
	public void setUp() throws Exception {
	 d = new DAO();
	 jdt = new JdbcDatabaseTester("org.postgresql.Driver","jdbc:postgresql://localhost/coursera","postgres", "284693");
	 FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
	 jdt.setDataSet(loader.load("/inicio.xml"));
	 jdt.onSetup();
	}
	
	@Test
	public void ranking() {
		List<Usuario> lista = d.ranking();
		System.out.println(lista);
	}
	
	@Test
	public void inserirUsuario() throws SQLException, Exception {
		Usuario u = new Usuario();
		u.setLogin("CLOGIN");
		u.setEmail("CEMAIL");
		u.setNome("CNOME");
		u.setSenha("CSENHA");
		u.setPontos(12);
		
		d.inserir(u);
		
		IDataSet currentDataset = jdt.getConnection().createDataSet();
		ITable currentTable = currentDataset.getTable("USUARIO");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataset = loader.load("/verifica.xml");
		ITable expectedTable = expectedDataset.getTable("USUARIO");
		Assertion.assertEquals(expectedTable, currentTable);
	}

}
