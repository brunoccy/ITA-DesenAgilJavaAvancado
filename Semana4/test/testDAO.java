import java.util.List;
import org.dbunit.Assertion;
import org.dbunit.DatabaseUnitException;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

public class testDAO {
    UsuarioDAO u; 
    JdbcDatabaseTester jdt;    
    @Before
    public void iniciarDbunit() throws Exception{
        u= new UsuarioDAO();
        jdt = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost/semana4", "postgres", "284693");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        jdt.setDataSet(loader.load("/inicio.xml"));
        jdt.onSetup();
    }
    
    @Test
    public void testeconecao(){
    }
    
    @Test
    public void recuperarUsuarios(){
        List<Usuario> listTudo = u.recuperarTudo();
        assertEquals("ANOME", listTudo.get(0).getNome());
    }
    @Test
    public void recuperarUmUsuarios(){
        Usuario u = new UsuarioDAO().recuperarUm("ALOGIN");
        assertEquals("ANOME", u.getNome());
    }
    @Test
    public void cadastrarUsuario() throws Exception{
        Usuario newUser = new Usuario();
        newUser.setEmail("CEMAIL");
        newUser.setNome("CNOME");
        newUser.setLogin("CLOGIN");
        newUser.setSenha("CSENHA");
        newUser.setPontos(12);
        u.inserirUsuario(newUser);
        
        IDataSet currentDataset = jdt.getConnection().createDataSet();
        ITable currentTable = currentDataset.getTable("USUARIO");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet expectedDataset = loader.load("/verificaCadastro.xml");
        ITable expectedTable = expectedDataset.getTable("USUARIO");
        Assertion.assertEquals(expectedTable, currentTable);
    }
    
    @Test
    public void listRanking(){
        List<Usuario> listRankeado = u.ranking();
        assertEquals("BNOME", listRankeado.get(0).getNome());
    }
    
    
}
