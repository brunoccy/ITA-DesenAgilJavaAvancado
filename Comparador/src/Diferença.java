
public class Diferen�a {

	private String propriedade;
	private Object valorNovo;
	private Object valorVelho;
	
	public Diferen�a(String propriedade, Object valorNovo, Object valorVelho) {
		super();
		this.propriedade = propriedade;
		this.valorNovo = valorNovo;
		this.valorVelho = valorVelho;
	}

	@Override
	public String toString() {
		return "Diferen�a [propriedade=" + propriedade + ", valorNovo=" + valorNovo + ", valorVelho=" + valorVelho
				+ "]";
	}
}
