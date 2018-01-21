package br.com.IanOliv.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.type.TrueFalseType;

@Entity
public class PedidoProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Integer id;
	@JoinColumn
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Produto produto;
	@JoinColumn
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Pedido pedido;

	public PedidoProduto(Produto produto, Pedido pedido) {
		super();
		this.produto = produto;
		this.pedido = pedido;
	}

	@Deprecated
	public PedidoProduto() {
		super();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
