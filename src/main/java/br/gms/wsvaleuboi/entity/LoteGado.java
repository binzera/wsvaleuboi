package br.gms.wsvaleuboi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the lote_gado database table.
 * 
 */
@Entity
@Table(name="lote_gado")
@NamedQuery(name="LoteGado.findAll", query="SELECT l FROM LoteGado l")
public class LoteGado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LOTE_GADO_ID_GENERATOR", sequenceName="seq_lote")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOTE_GADO_ID_GENERATOR")
	private Integer id;

	@Column(name="dt_inclusao")
	private Timestamp dtInclusao;

	@Column(name="dt_modificacao")
	private Timestamp dtModificacao;

	@Column(name="qtd_arrobas")
	private Integer qtdArrobas;

	@Column(name="qtd_gado")
	private Integer qtdGado;

	private char sexo;

	@Column(name="valor_arroba")
	private float valorArroba;

	//bi-directional many-to-one association to Fazenda
	@ManyToOne(fetch=FetchType.LAZY)
	private Fazenda fazenda;

	//bi-directional many-to-one association to Idade
	@ManyToOne(fetch=FetchType.LAZY)
	private Idade idade;

	//bi-directional many-to-one association to RacaGado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="raca_gado_id")
	private RacaGado racaGado;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuario;

	//bi-directional many-to-one association to MovimentacaoGado
	@OneToMany(mappedBy="loteGado")
	private List<MovimentacaoGado> movimentacaoGados;

	public LoteGado() {
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

	public Fazenda getFazenda() {
		return this.fazenda;
	}

	public void setFazenda(Fazenda fazenda) {
		this.fazenda = fazenda;
	}

	public Idade getIdade() {
		return this.idade;
	}

	public void setIdade(Idade idade) {
		this.idade = idade;
	}

	public RacaGado getRacaGado() {
		return this.racaGado;
	}

	public void setRacaGado(RacaGado racaGado) {
		this.racaGado = racaGado;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<MovimentacaoGado> getMovimentacaoGados() {
		return this.movimentacaoGados;
	}

	public void setMovimentacaoGados(List<MovimentacaoGado> movimentacaoGados) {
		this.movimentacaoGados = movimentacaoGados;
	}

	public MovimentacaoGado addMovimentacaoGado(MovimentacaoGado movimentacaoGado) {
		getMovimentacaoGados().add(movimentacaoGado);
		movimentacaoGado.setLoteGado(this);

		return movimentacaoGado;
	}

	public MovimentacaoGado removeMovimentacaoGado(MovimentacaoGado movimentacaoGado) {
		getMovimentacaoGados().remove(movimentacaoGado);
		movimentacaoGado.setLoteGado(null);

		return movimentacaoGado;
	}

}