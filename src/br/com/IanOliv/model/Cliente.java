package br.com.IanOliv.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cliente {
		
		@Id
		@GeneratedValue(strategy =GenerationType.IDENTITY)
		private Integer id;
		private String nome;
		private String codigo;

		@JoinColumn(unique= true)
		@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
		private Endereco endereco;
		
		@JoinColumn(unique= true)
		@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
		private Contato contato;
		
		@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="cliente")
		private List<Pedido> pedidos;
		
		
		@Deprecated
		public Cliente() {
			super();
		}

		public Cliente(String nome, String codigo, Endereco endereco, Contato contato) {
			super();
			this.nome = nome;
			this.codigo = codigo;
			this.endereco = endereco;
			this.contato = contato;
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

		public Endereco getEndereco() {
			return endereco;
		}

		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}

		public Contato getContato() {
			return contato;
		}

		public void setContato(Contato contato) {
			this.contato = contato;
		}

	
	
	
}
