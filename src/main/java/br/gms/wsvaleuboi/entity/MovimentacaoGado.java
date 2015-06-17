package br.gms.wsvaleuboi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the movimentacao_gado database table.
 * 
 */
@Entity
@Table(name="movimentacao_gado")
@NamedQuery(name="MovimentacaoGado.findAll", query="SELECT m FROM MovimentacaoGado m")
public class MovimentacaoGado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MOVIMENTACAO_GADO_ID_GENERATOR", sequenceName="seq_movimentacao")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOVIMENTACAO_GADO_ID_GENERATOR")
	private Integer id;

	@Column(name="dt_inclusao")
	private Timestamp dtInclusao;

	@Column(name="dt_modificacao")
	private Integer dtModificacao;

	@Column(name="qtd_arrobas")
	private Integer qtdArrobas;

	@Column(name="qtd_gado")
	private Integer qtdGado;

	private char sexo;

	@Column(name="valor_arroba")
	private float valorArroba;

	//bi-directional many-to-one association to LoteGado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="lote_gado_id")
	private LoteGado loteGado;

	//bi-directional many-to-one association to TipoMovimentacao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipo_movimentacao_id")
	private TipoMovimentacao tipoMovimentacao;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuario;

	public MovimentacaoGado() {
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

	public Integer getDtModificacao() {
		return this.dtModificacao;
	}

	public void setDtModificacao(Integer dtModificacao) {
		this.dtModificacao = dtModificacao;
	}

	public Integer getQtdArrobas() {
		return this.qtdArrobas;
	}

	public void setQtdArrobas(Integer qtdArrobas) {
		this.qtdArrobas = qtdArrobas;
	}

	public Integer getQtdGado() {
		return this.qtdGado;
	}

	public void setQtdGado(Integer qtdGado) {
		this.qtdGado = qtdGado;
	}

	public char getSexo() {
		return this.sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public float getValorArroba() {
		return this.valorArroba;
	}

	public void setValorArroba(float valorArroba) {
		this.valorArroba = valorArroba;
	}

	public LoteGado getLoteGado() {
		return this.loteGado;
	}

	public void setLoteGado(LoteGado loteGado) {
		this.loteGado = loteGado;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return this.tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}