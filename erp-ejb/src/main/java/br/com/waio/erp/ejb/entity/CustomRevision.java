package br.com.waio.erp.ejb.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import br.com.waio.erp.ejb.listener.CustomRevisionListener;

/**
 * Entidade da auditoria.
 *
 * @since 2.0.0
 *
 * @author <a href="mail:fabio.zanardi@w2z.com.br">Fábio Zanardi</a>
 */
@Entity
@RevisionEntity(CustomRevisionListener.class)
@Table(name = "revision_info", schema = "erp_audit")
public class CustomRevision implements Serializable {

	/**
	 * Serial version da classe.
	 */
	private static final long serialVersionUID = -8563889241023525708L;

	/**
	 * Chave primária.
	 */
	@Id
	@GeneratedValue
	@RevisionNumber
	private Long id;

	/**
	 * Data da revisão.
	 */
	@RevisionTimestamp
	private Long timestamp;

	/**
	 * Nome do usuário.
	 */
	@Column
	private String username;

	/**
	 * @return valor do id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id o valor a ser setado no id
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * @return valor do timestamp
	 */
	public Long getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp o valor a ser setado no timestamp
	 */
	public void setTimestamp(final Long timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return valor do timestamp
	 */
	@Transient
	public Date getRevisionDate() {
		return new Date(timestamp);
	}

	/**
	 * @return valor do username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username o valor a ser setado no username
	 */
	public void setUsername(final String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "DefaultRevisionEntity(id = " + id + ", revisionDate = "
				+ DateFormat.getDateTimeInstance().format(getRevisionDate()) + ", username = " + username + ")";
	}

}
