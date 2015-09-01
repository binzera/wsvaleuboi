package br.gms.wsvaleuboi.business;

import java.util.List;

import javax.inject.Inject;

import br.gms.wsvaleuboi.entity.Fazenda;
import br.gms.wsvaleuboi.entity.Usuario;
import br.gms.wsvaleuboi.persistence.FazendaDAO;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

public class FazendaBC extends DelegateCrud<Fazenda, Long, FazendaDAO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FazendaDAO dao;

	public String cadastrarFazenda(Fazenda entity) {
		String retorno = "";
		
		if(!dao.isExisteFazenda(entity)){
			try{
				Fazenda faz = dao.insert(entity);
				if(faz != null){
					retorno = "CADASTRO_FAZ_SUCESSO";
				}
			} catch (Exception e) {
				retorno = "ERRO_CADASTRO_FAZ";
			}
		} else {
			retorno = "FAZ_JA_EXISTE";
		}
		
		return retorno;
	}
	
	public List<Fazenda> findByUserId(Usuario user) {
		return dao.findByUserId(user);
	}

}
