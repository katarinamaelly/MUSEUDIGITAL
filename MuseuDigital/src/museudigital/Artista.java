package museudigital;
import java.util.Arrays;

public class Artista {
	private String nome; 
	private String bio;
	private String[] expressao;
	private int vendas = 0; 
	
	public Artista(String nome, String bio, String[] expressao) {
		this.nome = nome; 
		this.bio = bio; 
		this.expressao = expressao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String[] getExpressao() {
		return expressao;
	}

	public void setExpressao(String[] expressao) {
		this.expressao = expressao;
	}
	
	public void incrementarVendas() {
	    vendas++;
	}
	
	public int getVendas() { return vendas; }

	@Override
	public String toString() {
	    return "Artista [nome=" + nome + ", bio=" + bio
	         + ", expressao=" + Arrays.toString(expressao)
	         + ", vendas=" + vendas + "]";
	}

	
}
