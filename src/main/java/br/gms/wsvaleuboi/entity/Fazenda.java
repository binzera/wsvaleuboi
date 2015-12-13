package br.gms.wsvaleuboi.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;





/**
 * The persistent class for the fazenda database table.
 * 
 */
@Entity
@NamedQuery(name="Fazenda.findAll", query="SELECT f FROM Fazenda f")
public class Fazenda extends AbstractTimestampEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FAZENDA_ID_GENERATOR", sequenceName="FAZENDA_SEQUENCE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FAZENDA_ID_GENERATOR")
	private Integer id;

	private String nome;

	@Column(name="qtd_alqueires")
	private Integer qtdAlqueires;
	
	@Transient
	private Integer id_usuario;
	
	//bi-directional many-to-one association to MovimentacaoGado
	@OneToMany(mappedBy="fazenda", fetch=FetchType.LAZY)
	@JsonManagedReference(value="faz-mov")
	private List<MovimentacaoGado> movimentacaoGados;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JsonBackReference(value="user-faz")
	private Usuario usuario;

	//bi-directional many-to-one association to LoteGado
	@OneToMany(mappedBy="fazenda", fetch=FetchType.LAZY)
	@JsonManagedReference(value="faz-lote")
	private List<LoteGado> loteGados;

	public Fazenda() {
	}
	
	/**
	 * @return the id_usuario
	 */
	public Integer getId_usuario() {
		return this.getUsuario().getId();
	}

	/**
	 * @param id_usuario the id_usuario to set
	 */
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	/**
	 * @return the movimentacaoGados
	 */
	public List<MovimentacaoGado> getMovimentacaoGados() {
		return movimentacaoGados;
	}

	/**
	 * @param movimentacaoGados the movimentacaoGados to set
	 */
	public void setMovimentacaoGados(List<MovimentacaoGado> movimentacaoGados) {
		this.movimentacaoGados = movimentacaoGados;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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