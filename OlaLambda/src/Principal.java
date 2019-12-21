
import java.util.ArrayList;
import java.util.List;

public class Principal {

	public Principal() {
	}

	public static void main(String[] args) {
		List<Produto> lista= new ArrayList<>();
		lista.add(new Produto("Tenis",300));
		lista.add(new Produto("Camiseta",80));
		lista.add(new Produto("Tenis", 50));

		Carrinho c = new Carrinho(lista);
		
		c.darDesconto(20, Produto :: caro);
		
	
		//lista.forEach(Produto :: darDesconto);
		c.getLista().forEach(System.out :: println);
	}

}
