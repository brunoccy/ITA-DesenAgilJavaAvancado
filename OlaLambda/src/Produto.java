
public class Produto {
	private String nome;
	private int preco;
	public Produto(String nome, int preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPreco() {
		return preco;
	}
	public void setPreco(int preco) {
		this.preco = preco;
	}
	public void darDesconto() {
		preco = preco*90/100;
	}
	public void darDesconto2() {
		preco = preco*90/100;
	}
	public boolean caro() {
		return preco > 200;
	}
	
	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", preco=" + preco + "]";
	}
	

}
