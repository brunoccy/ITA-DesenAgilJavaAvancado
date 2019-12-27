import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteUsuarioDAO {
	
	JdbcDatabaseTester jdt;
	
	@BeforeEach 
	void setUp() throws Exception {
		
		jdt = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost/usuarios", "postgres", "284693");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jdt.setDataSet(loader.load("/inicio.xml"));
		jdt.onSetup();
	}
	
	@Test
	void recuperaTodos() {
		List<Usuario> lista = UsuarioDAO.todosUsuarios();
		assertEquals(2, lista.size());
		assertEquals("ANOME", lista.get(0).getNome());	
	}
	@Test
	void inserirNovoUsuario() throws Exception {
		Usuario u = new Usuario();
		u.setEmail("teste@gmail.com");
		u.setLogin("CLOGIN");
		u.setNome("CNOME");
		UsuarioDAO.insertUsuario(u);
		
		IDataSet currentDataset = jdt.getConnection().createDataSet();
		ITable currentTable = currentDataset.getTable("USUARIO");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataset = loader.load("/verificaDataset.xml");
		ITable expectedTable = expectedDataset.getTable("USUARIO");
		Assertion.assertEquals(expectedTable, currentTable);
		
	}
}
