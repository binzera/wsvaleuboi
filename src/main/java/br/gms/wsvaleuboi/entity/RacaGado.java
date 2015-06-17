package br.gms.wsvaleuboi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the raca_gado database table.
 * 
 */
@Entity
@Table(name="raca_gado")
@NamedQuery(name="RacaGado.findAll", query="SELECT r FROM RacaGado r")
public class RacaGado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RACA_GADO_ID_GENERATOR", sequenceName="HIBERNATE_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RACA_GADO_ID_GENERATOR")
	private Integer id;

	private String nome;

	//bi-directional many-to-one association to LoteGado
	@OneToMany(mappedBy="racaGado")
	private List<LoteGado> loteGados;

	public RacaGado() {
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

	public List<LoteGado> getLoteGados() {
		return this.loteGados;
	}

	public void setLoteGados(List<LoteGado> loteGados) {
		this.loteGados = loteGados;
	}

	public LoteGado addLoteGado(LoteGado loteGado) {
		getLoteGados().add(loteGado);
		loteGado.setRacaGado(this);

		return loteGado;
	}

	public LoteGado removeLoteGado(LoteGado loteGado) {
		getLoteGados().remove(loteGado);
		loteGado.setRacaGado(null);

		return loteGado;
	}

}