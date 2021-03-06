import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Comparador {

	public static <E> List<Diferenša> comparar(E velho, E novo) throws Exception {
		List <Diferenša> difs = new ArrayList<>();
		
		Class<?> clazz = velho.getClass();
		
		for(Method m : clazz.getMethods()) {
			if(m.getName().startsWith("get") &&
					m.getParameterCount()==0 &&
					m.getReturnType() != void.class &&
					!m.isAnnotationPresent(IgnorarNaComparacao.class)) {
				Object valorVelho = m.invoke(velho);
				Object valorNovo = m.invoke(novo);
				
				if(!valorNovo.equals(valorVelho)) {
					Diferenša d = new Diferenša (m.getName(), valorVelho, valorNovo);
					difs.add(d);
				}
				
			}
			
		}
		
		return difs;
	}
}
