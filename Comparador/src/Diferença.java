
public class Diferenša {

	private String propriedade;
	private Object valorNovo;
	private Object valorVelho;
	
	public Diferenša(String propriedade, Object valorNovo, Object valorVelho) {
		super();
		this.propriedade = propriedade;
		this.valorNovo = valorNovo;
		this.valorVelho = valorVelho;
	}

	@Override
	public String toString() {
		return "Diferenša [propriedade=" + propriedade + ", valorNovo=" + valorNovo + ", valorVelho=" + valorVelho
				+ "]";
	}
}
