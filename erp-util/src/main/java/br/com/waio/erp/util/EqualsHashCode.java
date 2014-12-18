package br.com.waio.erp.util;

import java.util.Arrays;
import java.util.List;

/**
 * Utilitária para comparação de objetos.
 *
 * @since 3.1.1
 *
 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
 */
public final class EqualsHashCode {

	/**
	 * Construtor privado.
	 */
	private EqualsHashCode() {

	}

	/**
	 * Calcula o hashCode de uma lista de objetos.<br /><br />
	 *
	 * Exemplo de como utilizar:
	 * <pre>
	 * EqualsHashCode.hashCode(this.atributo1, this.atributo2, ...);
	 * </pre>
	 *
	 * @param objects Objetos para cálculo
	 *
	 * @return Valor calculado do hashCode
	 */
	public static int hashCode(final Object... objects) {
		return Arrays.hashCode(objects);
	}

	/**
	 * Cria instância para {@link EqualsHelper}.<br /><br />
	 *
	 * Exemplo de como utilizar:
	 * <pre>
	 * EqualsHashCode.equalsHelper()
	 * 		.append(this.atributo1, other.atributo1)
	 * 		.append(this.atributo2, other.atributo2)
	 * 		...
	 * 		.append(this.atributoN, other.atributoN)
	 * 		.isEquals();
	 * </pre>
	 *
	 * @return Nova instância do {@link EqualsHelper}
	 */
	public static EqualsHelper equalsHelper() {
		return new EqualsHelper();
	}

	/**
	 * Classe de suporte para {@link EqualsHashCode#equalsHelper}.
	 *
	 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
	 */
	public static final class EqualsHelper {

		/**
		 * Se objetos são iguais.
		 */
		private boolean isEquals = true;

		/**
		 * Adicionado o campo a ser comparado.
		 *
		 * @param a Campo do objeto atual
		 * @param b Campo do objeto a ser comparado
		 *
		 * @return Instância do {@link EqualsHelper}
		 */
		public EqualsHelper append(final Object a, final Object b) {
			if (a instanceof List && b instanceof List) {
				equalList(a, b);
			} else if (isEquals) {
				equal(a, b);
			}

			return this;
		}

		/**
		 * Se objetos são iguais.
		 *
		 * @return Se forem iguais retorna true, senão false
		 */
		public boolean isEquals() {
			return isEquals;
		}

		/**
		 * Executa a comparação entre campos.
		 *
		 * @param a Campo do objeto atual
		 * @param b Campo do objeto a ser comparado
		 */
		private void equal(final Object a, final Object b) {
			if (a == null && b == null) {
				return;
			}

			if (a == null || b == null) {
				isEquals = false;
			} else if (a.getClass() != b.getClass() || notEqualString(a, b) || !a.equals(b)) {
				isEquals = false;
			}
		}

		/**
		 * Compara se a string de um objeto é diferente do outro.
		 *
		 * @param a Campo do objeto atual
		 * @param b Campo do objeto a ser comparado
		 *
		 * @return Se forem diferentes retorna false, senão true
		 */
		private boolean notEqualString(final Object a, final Object b) {
			return a instanceof String && !((String) a).trim().equalsIgnoreCase(((String) b).trim());
		}

		/**
		 * Executa a comparação entre listas.
		 *
		 * @param a Campo do objeto atual
		 * @param b Campo do objeto a ser comparado
		 */
		private void equalList(final Object a, final Object b) {
			if (!((List) a).containsAll((List) b)) {
				isEquals = false;
			}
		}

	}

}
