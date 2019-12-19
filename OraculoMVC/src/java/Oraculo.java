
import java.util.ArrayList;
import java.util.List;

public class Oraculo {
    
    public List<String> melhoresProdutos(String tipo){
        List<String> lista = new ArrayList();
        if(tipo.equals("doce de leite")){
            lista.add("doce1");
            lista.add("doce2");
        }
        if(tipo.equals("queijo")){
            lista.add("queijo1");
            lista.add("queijo2");
            lista.add("queijo3");
        }
        return lista;
}
}
