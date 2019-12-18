
import java.util.ArrayList;
import java.util.List;


public class Principal {
    
    public static void main(String[] args) {
        Cesta<Fruta> frutas = new Cesta();
        frutas.adiciona(new Fruta("maça"));
        frutas.adiciona(new Fruta("banana"));
        frutas.adiciona(new Fruta("uva"));
        frutas.adiciona(new Fruta("pera"));
        frutas.adiciona(new FrtuaVermelha("morango"));
        
        List<FrtuaVermelha> vermelhas = new ArrayList<>();
        vermelhas.add(new FrtuaVermelha("Amora"));
        vermelhas.add(new FrtuaVermelha("Cereja"));
        
        frutas.adicionaTodos(vermelhas);

        
        while(frutas.temItens()){
            System.out.println(frutas.retira());
        }
    }
    
}
