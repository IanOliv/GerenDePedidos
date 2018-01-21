package br.com.IanOliv.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String estado;
	private String cidade;
	private String logradouro;
	private String cep;
	@Enumerated(EnumType.STRING)
	private Regioes regiao;

	@Deprecated
	public Endereco() {
		super();
	}

	public Endereco(String estado, String cidade, String logradouro, String cep) {
		super();
		this.estado = estado;
		this.cidade = cidade;
		this.logradouro = logradouro;
		this.cep = cep;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Regioes getRegiao() {
		return regiao;
	}

	public void setRegiao(Regioes regiao) {
		this.regiao = regiao;
	}

	public static Regioes veriRegiao(String estado) {
		if (estado.equals("AM") | estado.equals("RR") | estado.equals("AP") | estado.equals("PA") | estado.equals("TO")
				| estado.equals("RO") | estado.equals("AC")) {
			return Regioes.NORTE;
		} else if (estado.equals("MT") | estado.equals("MS") | estado.equals("GO") | estado.equals("DF")) {
			return Regioes.CENTRO_OESTE;
		} else if (estado.equals("SP") | estado.equals("RJ") | estado.equals("ES") | estado.equals("MG")) {
			return Regioes.SULDESTE;
		} else if (estado.equals("PR") | estado.equals("RS") | estado.equals("SC")) {
			return Regioes.SUL;
		} else {
			return Regioes.NORDESTE;

		}
	}
	
	public static Regioes converteToReg(String regiao) {

		if (regiao.equals("SULDESTE")) {
			return Regioes.SULDESTE;
		} else if (regiao.equals("SUL")) {
			return Regioes.SUL;
		} else if (regiao.equals("NORDESTE")) {
			return Regioes.NORDESTE;
		} else if (regiao.equals("NORTE")) {
			return Regioes.NORTE;
		} else if (regiao.equals("CENTRO_OESTE")) {
			return Regioes.CENTRO_OESTE;
		} else {
			return null;
		}
		
		
	}
}
