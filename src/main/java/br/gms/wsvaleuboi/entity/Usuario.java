package br.gms.wsvaleuboi.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_ID_GENERATOR", sequenceName="seq_usuario")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_ID_GENERATOR")
	private Integer id;
	
	@Pattern(regexp="[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message="Email Invalido")
	private String email;

	private String nome;

	private String senha;

	private String usuario;

	//bi-directional many-to-one association to Fazenda
	@OneToMany(mappedBy="usuario")
	private List<Fazenda> fazendas;

	//bi-directional many-to-one association to LoteGado
	@OneToMany(mappedBy="usuario")
	private List<LoteGado> loteGados;

	//bi-directional many-to-one association to MovimentacaoGado
	@OneToMany(mappedBy="usuario")
	private List<MovimentacaoGado> movimentacaoGados;

	public Usuario() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<Fazenda> getFazendas() {
		return this.fazendas;
	}

	public void setFazendas(List<Fazenda> fazendas) {
		this.fazendas = fazendas;
	}

	public Fazenda addFazenda(Fazenda fazenda) {
		getFazendas().add(fazenda);
		fazenda.setUsuario(this);

		return fazenda;
	}

	public Fazenda removeFazenda(Fazenda fazenda) {
		getFazendas().remove(fazenda);
		fazenda.setUsuario(null);

		return fazenda;
	}

	public List<LoteGado> getLoteGados() {
		return this.loteGados;
	}

	public void setLoteGados(List<LoteGado> loteGados) {
		this.loteGados = loteGados;
	}

	public LoteGado addLoteGado(LoteGado loteGado) {
		getLoteGados().add(loteGado);
		loteGado.setUsuario(this);

		return loteGado;
	}

	public LoteGado removeLoteGado(LoteGado loteGado) {
		getLoteGados().remove(loteGado);
		loteGado.setUsuario(null);

		return loteGado;
	}

	public List<MovimentacaoGado> getMovimentacaoGados() {
		return this.movimentacaoGados;
	}

	public void setMovimentacaoGados(List<MovimentacaoGado> movimentacaoGados) {
		this.movimentacaoGados = movimentacaoGados;
	}

	public MovimentacaoGado addMovimentacaoGado(MovimentacaoGado movimentacaoGado) {
		getMovimentacaoGados().add(movimentacaoGado);
		movimentacaoGado.setUsuario(this);

		return movimentacaoGado;
	}

	public MovimentacaoGado removeMovimentacaoGado(MovimentacaoGado movimentacaoGado) {
		getMovimentacaoGados().remove(movimentacaoGado);
		movimentacaoGado.setUsuario(null);

		return movimentacaoGado;
	}

}