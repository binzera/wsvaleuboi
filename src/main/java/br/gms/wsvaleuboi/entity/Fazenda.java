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