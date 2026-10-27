package museudigital;

import java.util.Arrays;

public class Colecionador {
	private String nome;
	private String cpf;
	private String[] interesses;
	private String link; 
	
	public Colecionador(String nome, String cpf, String[] interesses) {
		this.nome = nome;
		this.cpf = cpf; 
		this.interesses = interesses;
	}
	
	public Colecionador(String nome, String cpf, String[] interesses, String link) {
		this.nome = nome;
		this.cpf = cpf; 
		this.interesses = interesses;
		this.link = link; 
	}

	@Override
	public String toString() {
		return "Colecionador [nome=" + nome + ", cpf=" + cpf + ", interesses=" + Arrays.toString(interesses) + ", link="
				+ link + "]";
	}
	
	public String consultarAfinidade() {
		/** Se não houver nenhum interesse em comum, a
afinidade é de 0%. Havendo um interesse em comum, a afinidade deve ser de 30%. Para dois
interesses em comum, 70%. Para três interesses em comum, 100%. A afinidade artística é
apenas uma informação calculada pelo sistema para ajudar os colecionadores a encontrarem
obras com afinidades, mas não impede a compra da edição. Com isso, o sistema deve permitir
que um colecionador liste as obras com as quais possui afinidade artística maior ou igual a X%.
A listagem deve considerar todas as obras cadastradas no sistema e deve retornar, para cada
obra compatível, o título da obra, o tipo, o nome do artista e a afinidade calculada entre o
colecionador e a obra.*/ 
	}

}
