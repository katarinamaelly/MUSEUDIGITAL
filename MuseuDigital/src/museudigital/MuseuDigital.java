package museudigital;

import java.util.ArrayList;
import java.util.List;

public class MuseuDigital {
	
	private List<Artista> artistas = new ArrayList<>();
	private List<Obra> obras = new ArrayList<>();
	private List<Colecionador> colecionadores = new ArrayList<>();
	
	private Artista buscarArtista(String nome) {
		for (Artista a: artistas) {
			if (a.getNome().equalsIgnoreCase(nome)) {
				return a;
			}
		}
		throw new IllegalArgumentException("Artista não encontrado: " + nome);
	}
	
	private Colecionador buscarColecionador(String cpf) {
		for(Colecionador c: colecionadores) {
			if (c.getCpf().equals(cpf)) {
				return c;
			}
		}
		throw new IllegalArgumentException("CPF não encontrado" + cpf);
	}
	
	
	public boolean cadastrarArtista(String nome, String bio, String[] expressao) {
		for(Artista a: artistas) {
			if(a.getNome().equalsIgnoreCase(nome)) {
				return false;
			}
			
		}
		Artista novo = new Artista(nome, bio, expressao);
		artistas.add(novo); 
		return true; }
	
	
	public void atualizarBioArtista(String nomeArtista, String novaBio) {
		/** acessar o artista pelo nome passado no parâmetro e trocar sua bio */ 
		buscarArtista(nomeArtista).setBio(novaBio);
	}
		
	public String[] listarArtistas() {
		String[] resultado = new String[artistas.size()];
		int i = 0;
		for(Artista a: artistas) {
			resultado[i] = a.toString();
			i++;
		}
		return resultado;
	}
	
	public int cadastrarObra(String titulo, String tipo, String artistaResponsavel, int edicoes, double valor, String[] caracteristicas) {
	// retorna o indexObra, representando a ordem de cadastro no sistema. Retorna -1 em caso de erro no cadastro.
		/** para cadastrar a obra,o artista já dee existir */ 
		/** uma das caracteristicas tem que estar na expressao do artista */ 
		Artista a = buscarArtista(artistaResponsavel);
		boolean tipoValido = false;
		for (String t: a.getExpressao()) {
			tipoValido = true;
		}
		if (!tipoValido) {
			return -1;
		}
		
			
		Obra nova = new Obra(titulo, tipo, a, edicoes, valor, caracteristicas);
		obras.add(nova);
		return obras.size() - 1;
			
		}
	
	
	public String[] listarObras() {
		String[] resultado = new String[obras.size()];
		int i = 0;
		for(Obra o: obras) {
			resultado[i] = o.toString();
			i++;
		}
		return resultado;
	}
	
	public String exibirDetalhesObra(int indexObra) {
		return obras.get(indexObra).toString();
	}
	
	/** comparar os cpfs dos colecionadores */ 
	
	public boolean cadastrarColecionador(String nome, String cpf, String link,  String[] interesses) {
		for(Colecionador c: colecionadores) {
			if(c.getCpf().equals(cpf)) {
				return false;
			}
			
		}
		Colecionador novo = new Colecionador(nome, cpf, interesses, link);
		colecionadores.add(novo); 
		return true; 
		}
	
	
	public boolean cadastrarColecionador(String nome, String cpf, String[] interesses) {
		return cadastrarColecionador(nome, cpf, "", interesses);
	}
	
	
	public void atualizarLinkPerfil(String cpf, String novoLink) {
		/** acessar o artista pelo nome passado no parâmetro e trocar sua bio */ 
		buscarColecionador(cpf).setLink(novoLink);
	}
	
	public String[] listarColecionadores() {
		String[] resultado = new String[colecionadores.size()];
		int i = 0;
		for(Colecionador c: colecionadores) {
			resultado[i] = c.toString();
			i++;
		}
		return resultado;
	}
	
	public String comprarEdicao(String cpf, int indexObra) {
		Colecionador c = buscarColecionador(cpf);
		if (indexObra < 0 || indexObra >= obras.size()) {
			return "OBRA INDISPONÍVEL";
		}
		
		Obra o = obras.get(indexObra);
		
		if (o.getEdicoes() == 0) {
			return "OBRA INDISPONÍVEL";
		}
		
		o.registrarCompra(cpf);
		o.getArtistaResponsavel().incrementarVendas();
		return "Colecionador: " + c.getNome() + " | Link: " + c.getLink() +
				" | Obra: " + o.getTitulo() + " | Afinidade: " + calcularAfinidade(cpf, indexObra) + "%"; 
			
			/** ADICIONAR O COMPRADOR A LISTA DE COMPRADORES DA OBRA, SABENDO QUE COMPRADORES É UM ARRAY DE STRINGS NA CLASSE OBRA */ 
		}
			
		
	public String[] listarCompradoresObra(int indexObra) { 
		return listarCompradoresCompativeis(indexObra, 0); 
	}

			
	public int calcularAfinidade(String cpf, int indexObra)	{
		Colecionador c = buscarColecionador(cpf);
		Obra o = obras.get(indexObra);
		
		int emComum = 0; 
		for (String interesse: c.getInteresses()) {
			for (String car : o.getCaracteristicas()) {
				if (interesse.equalsIgnoreCase(car)) {
					emComum++;
					break;
				}
			}
		}
		
		if (emComum == 0) { return 0; }
		if (emComum == 1)  {return 30;} 
		if (emComum == 2) { return 70; }
		return 100;
		
		}
	
	public String[] listarCompradoresCompativeis(int indexObra, int afinidade) {
		Obra o = obras.get(indexObra);
		List<String> resultado = new ArrayList<>();
		
		for (int i = 0; i < o.getQtdCompradores(); i++) {
			String cpf = o.getCompradores()[i];
			int af = calcularAfinidade(cpf, indexObra);
			if (af >= afinidade) {
				Colecionador c = buscarColecionador(cpf);
				resultado.add(c.getNome() + " | " + c.getLink() + " | " + af + "%");
			}
		}
		return resultado.toArray(new String[0]);
		
			}
	
	public String[] listarObrasCompativeis(String cpf, int afinidade) {
		buscarColecionador(cpf);
		List<String> resultado = new ArrayList<>();
		
		for (int i = 0; i < obras.size(); i ++) {
			int af = calcularAfinidade(cpf, i);
			if (af >= afinidade) {
				Obra o = obras.get(i);
				resultado.add(o.getTitulo() + " | " + o.getTipo() + " | " + o.getArtistaResponsavel().getNome() + " | " + af + "%");
			}
			}
		return resultado.toArray(new String[0]);
		
		}
	
	public String emitirRelatorioMaioresVendas() {
		if (artistas.isEmpty()) {
			return "";
		}
		
		Artista melhor = artistas.get(0);
		for (Artista a : artistas) {
			if (a.getVendas() > melhor.getVendas()) {
				melhor = a; 
			}
		}
		return "Nome " + melhor.getNome() + " | Bio: " + melhor.getBio() +
				" |  Edições vendias: " + melhor.getVendas();
	}
	
	}
	
	
	
		
	
	
	



		
		
	

/** não pode ter dois artistas com o mesmo nome, quando for add artista, 
 * veja se já tem outro artista com o mesmo nome */ 

/** listar artistas cadastrados */ 

/** As obras são armazenadas na ordem em que forem cadastradas. Ao cadastrar

uma obra com sucesso, o sistema deve retornar o indexObra, representando a ordem de
cadastro no sistema. Caso o cadastro não possa ser realizado, deve ser retornado -1. */ 

/** O sistema deve impedir o cadastro de dois colecionadores com o mesmo
CPF; inclusive, o CPF é usado para identificar unicamente cada colecionador. */ 

/** listar todos os colecionadores */ 
