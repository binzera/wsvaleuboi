package br.gms.wsvaleuboi.business;

import java.util.List;

import javax.inject.Inject;

import br.gms.wsvaleuboi.entity.LoteGado;
import br.gms.wsvaleuboi.entity.Usuario;
import br.gms.wsvaleuboi.persistence.LoteDAO;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

public class LoteBC extends DelegateCrud<LoteGado, Long, LoteDAO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private LoteDAO dao;

	public String cadastrarLote(LoteGado entity) {
		String retorno = "";
		
		if(!dao.isExisteLote(entity)){
			try{
				LoteGado lote = dao.insert(entity);
				if(lote != null){
					retorno = "CADASTRO_LOTE_SUCESSO";
				}
			} catch (Exception e) {
				retorno = "ERRO_CADASTRO_LOTE";
			}
		} else {
			retorno = "LOTE_JA_EXISTE";
		}
		
		return retorno;
	}
	
	public List<LoteGado> findByUserId(Usuario user) {
		return dao.findByUserId(user);
	}

}
