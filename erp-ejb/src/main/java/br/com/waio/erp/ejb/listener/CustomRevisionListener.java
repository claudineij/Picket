package br.com.waio.erp.ejb.listener;

import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.hibernate.envers.RevisionListener;

import br.com.waio.erp.ejb.entity.CustomRevision;

/**
 * Listener responsável pelas informações de auditoria.
 *
 * @since 2.0.0
 *
 * @author <a href="mail:fabio.zanardi@w2z.com.br">Fábio Zanardi</a>
 */
public class CustomRevisionListener implements RevisionListener {

	/**
	 * Cria a nova revisão na auditoria.
	 *
	 * @param revisionEntity Do tipo {@link CustomRevision}
	 */
	@Override
	public void newRevision(final Object revisionEntity) {
		try {
			final CustomRevision revEntity = (CustomRevision) revisionEntity;
			final InitialContext ic = new InitialContext();
			final SessionContext sc = (SessionContext) ic.lookup("java:comp/EJBContext");

			revEntity.setUsername(sc.getCallerPrincipal().getName());
		} catch (final NamingException e) {
			Logger.getLogger(this.getClass()).error(e.getMessage(), e);
		}
	}

}
