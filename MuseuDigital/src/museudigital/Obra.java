package museudigital;

import java.util.Arrays;

public class Obra {
	private String titulo; 
	private String tipo;
	private int edicoes;
	private double valor; 
	private String[] caracteristicas; 
	private String[] compradores;
	private int qtdCompradores = 0;
	private Artista artistaResponsavel;

	
	public Obra(String titulo, String tipo, Artista artistaResponsavel, int edicoes, double valor, String[] caracteristicas) {
		this.titulo = titulo;
		this.tipo = tipo;
		this.artistaResponsavel= artistaResponsavel;
		this.edicoes =  edicoes;
		this.valor = valor;
		this.caracteristicas = caracteristicas;
		this.compradores = new String[edicoes];
	
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Artista getArtistaResponsavel() {
		return artistaResponsavel;
	}

	public void setArtistaResponsavel(Artista artistaResponsavel) {
		this.artistaResponsavel = artistaResponsavel;
	}

	public int getEdicoes() {
		return edicoes;
	}

	public void setEdicoes(int edicoes) {
		this.edicoes = edicoes;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String[] getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String[] caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	@Override
	public String toString() {
		return "Obra [titulo=" + titulo + ", tipo=" + tipo + ", artistaResponsavel=" + artistaResponsavel.getNome() + ", edicoes="
				+ edicoes + ", valor=" + valor + ", caracteristicas=" + Arrays.toString(caracteristicas) + "]";
	}

	public String[] getCompradores() {
		return compradores;
	}

	public void setCompradores(String[] compradores) {
		this.compradores = compradores;
	}
	
	
	
	public int getQtdCompradores() {
		return qtdCompradores;
	}

	public void setQtdCompradores(int qtdCompradores) {
		this.qtdCompradores = qtdCompradores;
	}


	public void registrarCompra(String cpf) {
	    compradores[qtdCompradores++] = cpf;
	    edicoes--;
	
	}
	
	
	
}




