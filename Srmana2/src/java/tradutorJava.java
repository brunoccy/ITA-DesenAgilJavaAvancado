
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class tradutorJava {

    JSONObject acessarBancoPalavra(){
        JSONParser jsonParser = new JSONParser();
        JSONObject obj = null ;
        try {
            FileReader reader = new FileReader("C:\\Users\\Mariana\\Desktop\\git\\ITA-DesenAgilJavaAvancado\\Srmana2\\bancoPalavras.json");
            obj = (JSONObject) jsonParser.parse(reader);    
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(tradutorJava.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(tradutorJava.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(tradutorJava.class.getName()).log(Level.SEVERE, null, ex);
        }
            return obj;
    }
    
    String traduzirPalavra(String palavra){
        if(((acessarBancoPalavra()).get(palavra)) !=null){
            return (String) (acessarBancoPalavra()).get(palavra);
        }return palavra;
    }
 
}
