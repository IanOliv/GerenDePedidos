
package br.com.IanOliv.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id;

	private String nome;

	@Column(nullable = false, length = 12)
	private String codigo;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "produto")
	private List<ProdutoPreco> precos= new ArrayList<>();

	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "produto" )
	private List<PedidoProduto> pePr;

	@Deprecated
	public Produto() {
		super();
	}

	public Produto(String nome, String codigo) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		
	}

	public List<ProdutoPreco> getPrecos() {
		return precos;
	}

	public void setPrecos(List<ProdutoPreco> precos) {
		this.precos = precos;
	}

	public void addPreco(ProdutoPreco preco) {
		this.precos.add(preco);
	}

	public void removePreco(ProdutoPreco preco) {
		this.precos.remove(preco);
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

}
