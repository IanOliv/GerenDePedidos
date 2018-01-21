package br.com.IanOliv.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Pedido {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER )
	private Cliente cliente;

	private Double total;
	@Enumerated(EnumType.STRING)
	private StatusPedido status;

	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="pedido")
	private List<PedidoProduto> pePr;
	
	@Deprecated
	public Pedido() {
		super();
		this.status = StatusPedido.PENDENTE;
		this.total = 00.00;
	}

	public Pedido(Cliente cliente, StatusPedido status, Double total) {
		super();
		this.cliente = cliente;
		this.status = status;
		this.total = total;
	}
	public List<PedidoProduto> getPePr() {
		return pePr;
	}
	
	public void setPePr(List<PedidoProduto> pePr) {
		this.pePr = pePr;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
