package br.gms.wsvaleuboi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the fazenda database table.
 * 
 */
@Entity
@NamedQuery(name="Fazenda.findAll", query="SELECT f FROM Fazenda f")
public class Fazenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FAZENDA_ID_GENERATOR", sequenceName="seq_fazenda")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FAZENDA_ID_GENERATOR")
	private Integer id;

	@Column(name="dt_inclusao")
	private Timestamp dtInclusao;

	@Column(name="dt_modificacao")
	private Timestamp dtModificacao;

	private String nome;

	@Column(name="qtd_alqueires")
	private Integer qtdAlqueires;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuario;

	//bi-directional many-to-one association to LoteGado
	@OneToMany(mappedBy="fazenda")
	private List<LoteGado> loteGados;

	public Fazenda() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDtInclusao() {
		return this.dtInclusao;
	}

	public void setDtInclusao(Timestamp dtInclusao) {
		this.dtInclusao = dtInclusao;
	}

	public Timestamp getDtModificacao() {
		return this.dtModificacao;
	}

	public void setDtModificacao(Timestamp dtModificacao) {
		this.dtModificacao = dtModificacao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQtdAlqueires() {
		return this.qtdAlqueires;
	}

	public void setQtdAlqueires(Integer qtdAlqueires) {
		this.qtdAlqueires = qtdAlqueires;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<LoteGado> getLoteGados() {
		return this.loteGados;
	}

	public void setLoteGados(List<LoteGado> loteGados) {
		this.loteGados = loteGados;
	}

	public LoteGado addLoteGado(LoteGado loteGado) {
		getLoteGados().add(loteGado);
		loteGado.setFazenda(this);

		return loteGado;
	}

	public LoteGado removeLoteGado(LoteGado loteGado) {
		getLoteGados().remove(loteGado);
		loteGado.setFazenda(null);

		return loteGado;
	}

}