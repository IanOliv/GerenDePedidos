package br.com.IanOliv.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ProdutoPreco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column( nullable = false)
	private Regioes regiao;
	
	@Column( nullable = false)
	private Double preco;

	@Temporal(TemporalType.TIMESTAMP)
	@Column( nullable = false)
	private Calendar date;

	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "produto_id", nullable = false)
	private Produto produto;

	
	
	
	
	@Deprecated
	public ProdutoPreco() {
		super();
		this.date = Calendar.getInstance();
		this.produto = null;
	}

	public ProdutoPreco(Regioes regiao, Double preco, Produto produto) {
		super();
		this.regiao = regiao;
		this.preco = preco;
		this.date = Calendar.getInstance();
		this.produto = produto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Regioes getRegiao() {
		return regiao;
	}

	public void setRegiao(Regioes regiao) {
		this.regiao = regiao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
