package br.gms.wsvaleuboi.business;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import br.gms.wsvaleuboi.entity.Fazenda;
import br.gms.wsvaleuboi.entity.LoteGado;
import br.gms.wsvaleuboi.entity.MovimentacaoGado;
import br.gms.wsvaleuboi.entity.Usuario;
import br.gms.wsvaleuboi.persistence.UsuarioDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class UsuarioBC extends DelegateCrud<Usuario, Long, UsuarioDAO> {
	

	private static final long serialVersionUID = 1L;
	
	
	@Inject
	UsuarioDAO dao;


	public Object cadastrarUsuario(Usuario body) {
		
		Object retorno = new String("ERRO_CADASTRO");
		
		List<Usuario> lista = dao.findByUserName(body.getUsuario());
		
		if(!lista.isEmpty()){
			retorno = new String("USUARIO_JA_CADASTRADO");
		} else {
			body = dao.insert(body);
			if(body.getId() != null && !body.getId().equals("")){
				retorno = new String("USUARIO_CADASTRADO_SUCESSO");
			}
		}
			
		return retorno;
	}
	
	
	/**
	 * Changes the annotation value for the given key of the given annotation to newValue and returns
	 * the previous value.
	 */
//	@SuppressWarnings("unchecked")
//	public static Object changeAnnotationValue(Annotation annotation, String key, Object newValue){
//	    Object handler = Proxy.getInvocationHandler(annotation);
//	    Field f;
//	    try {
//	        f = handler.getClass().getDeclaredField("memberValues");
//	    } catch (NoSuchFieldException | SecurityException e) {
//	        throw new IllegalStateException(e);
//	    }
//	    f.setAccessible(true);
//	    Map<String, Object> memberValues;
//	    try {
//	        memberValues = (Map<String, Object>) f.get(handler);
//	    } catch (IllegalArgumentException | IllegalAccessException e) {
//	        throw new IllegalStateException(e);
//	    }
//	    Object oldValue = memberValues.get(key);
//	    if (oldValue == null || oldValue.getClass() != newValue.getClass()) {
//	        throw new IllegalArgumentException();
//	    }
//	    memberValues.put(key,newValue);
//	    return oldValue;
//	}

	public Object logar(Usuario body) {
		Object retorno;
		
		List<Usuario> lista = dao.findByUserName(body.getUsuario());
		if(lista.isEmpty()){
			retorno = new String("USER_NAO_CADASTRADO");
		} else if(lista.get(0).getSenha().equals(body.getSenha())){
			Usuario usuario = lista.get(0);
			usuario.setFazendas(new ArrayList<Fazenda>());
			usuario.setLoteGados(new ArrayList<LoteGado>());
			usuario.setMovimentacaoGados(new ArrayList<MovimentacaoGado>());
			retorno = usuario;
		} else {
			retorno = new String("SENHA_INCORRETA");
		}
		
		return retorno;
	}

}
