package model;

public class Servico {
	
	private int codigo;
	private String nome;
	private double preco;
	
	// Construtor
	public Servico(int codigo, String nome, double preco)
	{
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
	}
	public Servico(String nome, double preco)
	{
		this.nome = nome;
		this.preco = preco;
	}
	
	// get e sets
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
}