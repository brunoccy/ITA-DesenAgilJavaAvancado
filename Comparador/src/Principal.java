import java.util.List;

public class Principal {

	public static void main(String[] args) throws Exception {
		Pessoa p1= new Pessoa("Bruno", "chen", 28);
		Pessoa p2= new Pessoa("Mariana", "chen", 25);
		
		List<Diferença> difs= Comparador.comparar(p1, p2);
		
		difs.forEach(System.out::println);
	}

}
