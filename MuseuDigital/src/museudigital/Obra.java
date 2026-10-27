package museudigital;

public class Obra {
	private String titulo; 
	private String tipo;
	private String artistaResponsavel; 
	private int edicoesDisponiveis;
	private int valor; 
	private String[] caracteristicas; 
	
	public Obra(String titulo, String tipo, String artistaResponsavel, int edicoesDisponiveis, int valor, String[] caracteristicas) {
		this.titulo = titulo;
		this.tipo = tipo;
		this.artistaResponsavel= artistaResponsavel;
		this.edicoesDisponiveis =  edicoesDisponiveis;
		this.valor = valor;
		this.caracteristicas = caracteristicas; 
	}
}

/** para cadastrar a obra,o artista já dee existir */ 

/** uma das caracteristicas tem que estar na expressao do artista */ 


