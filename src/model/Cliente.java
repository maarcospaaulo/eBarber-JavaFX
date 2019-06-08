package model;

public class Cliente {
	
	private int id;
	private String nome;
	private String nascimento;
	private String endereco;
	private String sexo;
	private String telefone;
	
	// Construtor
	public Cliente(int id, String nome, String nascimento, String endereco, String sexo)
	{
		this.id = id;
		this.nome = nome;
		this.nascimento = nascimento;
		this.endereco = endereco;
		this.sexo = sexo;
	}
	public Cliente(String nome, String nascimento, String endereco, String sexo, String telefone)
	{
		this.nome = nome;
		this.nascimento = nascimento;
		this.endereco = endereco;
		this.sexo = sexo;
		this.telefone = telefone;
	}
	
	public Cliente(int id, String nome, String nascimento, String endereco, String sexo, String telefone)
	{
		this.id = id;
		this.nome = nome;
		this.nascimento = nascimento;
		this.endereco = endereco;
		this.sexo = sexo;
		this.telefone = telefone;
	}
	public Cliente(String nome, String nascimento, String endereco, String sexo)
	{
		this.nome = nome;
		this.nascimento = nascimento;
		this.endereco = endereco;
		this.sexo = sexo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return +id+nome+nascimento+endereco+sexo+telefone;
	}
}
