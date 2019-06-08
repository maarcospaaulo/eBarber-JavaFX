package model;

public class Produto {
	
	private int codigo;
	private String nome;
	private String marca;
	private String validade;
	private double precoFornecedor; // preco pago ao fornecedor
	private double precoVenda; // valor do produto para venda
	
	// Construtor
	public Produto(int codigo, String nome, String marca, String validade, double precoFornecedor, double precoVenda)
	{
		this.codigo = codigo;
		this.nome = nome;
		this.marca = marca;
		this.validade = validade;
		this.precoFornecedor = precoFornecedor;
		this.precoVenda = precoVenda;
	}
	public Produto(String nome, String marca, String validade, double precoFornecedor, double precoVenda)
	{
		this.nome = nome;
		this.marca = marca;
		this.validade = validade;
		this.precoFornecedor = precoFornecedor;
		this.precoVenda = precoVenda;
	}
	
	//metodos get e set
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
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getValidade() {
		return validade;
	}
	public void setValidade(String validade) {
		this.validade = validade;
	}
	public double getPrecoFornecedor() {
		return precoFornecedor;
	}
	public void setPrecoFornecedor(double precoFornecedor) {
		this.precoFornecedor = precoFornecedor;
	}
	public double getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}
}
