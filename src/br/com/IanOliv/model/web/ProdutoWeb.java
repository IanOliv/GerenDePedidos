package br.com.IanOliv.model.web;

public class ProdutoWeb {
	private Integer id;
	private String nome;
	private String codigo;
	private Double Preco;

	public ProdutoWeb(Integer id, String nome, String codigo, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
		Preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Double getPreco() {
		return Preco;
	}

	public void setPreco(Double preco) {
		Preco = preco;
	}
}
