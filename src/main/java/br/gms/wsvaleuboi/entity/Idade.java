package br.gms.wsvaleuboi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the idade database table.
 * 
 */
@Entity
@NamedQuery(name="Idade.findAll", query="SELECT i FROM Idade i")
public class Idade extends AbstractTimestampEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IDADE_ID_GENERATOR", sequenceName="IDADE_SEQUENCE", allocationSize=1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IDADE_ID_GENERATOR")
	private Integer id;

	private String descricao;

	//bi-directional many-to-one association to LoteGado
	@OneToMany(mappedBy="idade")
	private List<LoteGado> loteGados;

	public Idade() {
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

	public List<LoteGado> getLoteGados() {
		return this.loteGados;
	}

	public void setLoteGados(List<LoteGado> loteGados) {
		this.loteGados = loteGados;
	}

	public LoteGado addLoteGado(LoteGado loteGado) {
		getLoteGados().add(loteGado);
		loteGado.setIdade(this);

		return loteGado;
	}

	public LoteGado removeLoteGado(LoteGado loteGado) {
		getLoteGados().remove(loteGado);
		loteGado.setIdade(null);

		return loteGado;
	}

}