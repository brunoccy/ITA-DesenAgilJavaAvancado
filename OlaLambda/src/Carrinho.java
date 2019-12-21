import java.util.List;

public class Carrinho {

	List<Produto> lista;
	
	public Carrinho(List<Produto> lista) {
		this.lista = lista;
	}
	
	public void darDesconto(int porcentagem, Condicao<Produto> cond) {
		for(Produto p : lista) {
			if(cond.incluir(p)) {
				p.setPreco(p.getPreco()*porcentagem/100);
				
			}
		}
	}

	public List<Produto> getLista() {
		return lista;
	}
}
