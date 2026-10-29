package museudigital;

import java.util.Arrays;

public class Colecionador {
	private String nome;
	private String cpf;
	private String[] interesses;
	private String link; 
	
	public Colecionador(String nome, String cpf, String[] interesses) {
	    this(nome, cpf, interesses, "");
	}

	public Colecionador(String nome, String cpf, String[] interesses, String link) {
	    this.nome = nome;
	    this.cpf = cpf;
	    this.interesses = interesses;
	    this.link = link;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String[] getInteresses() {
		return interesses;
	}

	public void setInteresses(String[] interesses) {
		this.interesses = interesses;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Colecionador [nome=" + nome + ", cpf=" + cpf + ", interesses=" + Arrays.toString(interesses) + ", link="
				+ link + "]";
	}

}
