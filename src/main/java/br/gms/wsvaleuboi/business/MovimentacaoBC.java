package br.gms.wsvaleuboi.business;

import javax.inject.Inject;

import br.gms.wsvaleuboi.entity.MovimentacaoGado;
import br.gms.wsvaleuboi.persistence.MovimentacaoGadoDAO;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

public class MovimentacaoBC extends DelegateCrud<MovimentacaoGado, Long, MovimentacaoGadoDAO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private MovimentacaoGadoDAO dao;

	public String cadastrarMovimentacao(MovimentacaoGado entity) {
		String retorno = "";

		try{
			MovimentacaoGado mov = dao.insert(entity);
			if(mov != null){
				retorno = "CADASTRO_MOV_SUCESSO";
			}
		} catch (Exception e) {
			retorno = "ERRO_CADASTRO_MOV";
		}
		
		return retorno;
	}
	

}
