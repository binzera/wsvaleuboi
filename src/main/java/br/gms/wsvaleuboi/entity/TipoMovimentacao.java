package br.gms.wsvaleuboi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the tipo_movimentacao database table.
 * 
 */
@Entity
@Table(name="tipo_movimentacao")
@NamedQuery(name="TipoMovimentacao.findAll", query="SELECT t FROM TipoMovimentacao t")
public class TipoMovimentacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_MOVIMENTACAO_ID_GENERATOR", sequenceName="HIBERNATE_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_MOVIMENTACAO_ID_GENERATOR")
	private Integer id;

	private String descricao;

	@Column(name="dt_inclusao")
	private Timestamp dtInclusao;

	@Column(name="dt_modificacao")
	private Timestamp dtModificacao;

	//bi-directional many-to-one association to MovimentacaoGado
	@OneToMany(mappedBy="tipoMovimentacao")
	private List<MovimentacaoGado> movimentacaoGados;

	public TipoMovimentacao() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public List<MovimentacaoGado> getMovimentacaoGados() {
		return this.movimentacaoGados;
	}

	public void setMovimentacaoGados(List<MovimentacaoGado> movimentacaoGados) {
		this.movimentacaoGados = movimentacaoGados;
	}

	public MovimentacaoGado addMovimentacaoGado(MovimentacaoGado movimentacaoGado) {
		getMovimentacaoGados().add(movimentacaoGado);
		movimentacaoGado.setTipoMovimentacao(this);

		return movimentacaoGado;
	}

	public MovimentacaoGado removeMovimentacaoGado(MovimentacaoGado movimentacaoGado) {
		getMovimentacaoGados().remove(movimentacaoGado);
		movimentacaoGado.setTipoMovimentacao(null);

		return movimentacaoGado;
	}

}