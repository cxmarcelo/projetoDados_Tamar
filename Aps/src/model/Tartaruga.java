package model;


public class Tartaruga{

	private int id;
	private String especie;
	private String nome_popular;
	private String tipo_de_localizador;
	private String risco_de_extincao;
	
	public Tartaruga() {
		
	}
	
	public Tartaruga(int id, String especie, String nome_popular, String tipo_de_localizador, String risco_de_extincao) {
		this.id = id;
		this.especie = especie;
		this.nome_popular = nome_popular;
		this.tipo_de_localizador = tipo_de_localizador;
		this.risco_de_extincao = risco_de_extincao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getNome_popular() {
		return nome_popular;
	}

	public void setNome_popular(String nome_popular) {
		this.nome_popular = nome_popular;
	}

	public String getTipo_de_localizador() {
		return tipo_de_localizador;
	}

	public void setTipo_de_localizador(String tipo_de_localizador) {
		this.tipo_de_localizador = tipo_de_localizador;
	}

	public String getRisco_de_extincao() {
		return risco_de_extincao;
	}

	public void setRisco_de_extincao(String risco_de_extincao) {
		this.risco_de_extincao = risco_de_extincao;
	}

	
}

