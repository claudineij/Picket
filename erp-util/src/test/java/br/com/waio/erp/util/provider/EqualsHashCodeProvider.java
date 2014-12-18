package br.com.waio.erp.util.provider;

import org.testng.annotations.DataProvider;

import br.com.waio.erp.util.bean.TestClass;

/**
 * Dados para execução dos teste do {@link br.com.waio.erp.util.EqualsHashCodeTest}.
 *
 * @since 3.1.1
 *
 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
 */
public final class EqualsHashCodeProvider {

	/**
	 * Construtor privado.
	 */
	private EqualsHashCodeProvider() {

	}

	/**
	 * Dados para o teste do {@link br.com.waio.erp.util.EqualsHashCodeTest#shouldHashCode(int, int)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] shouldHashCode() {
		return new Object[][] {
				{ new TestClass().data(-1).hashCode(), new TestClass().data(-1).hashCode() },
				{ new TestClass().data(0).hashCode(), new TestClass().data(0).hashCode() },
				{ new TestClass().data(1).hashCode(), new TestClass().data(1).hashCode() },
				{ new TestClass().data(2).hashCode(), new TestClass().data(2).hashCode() },
				{ new TestClass().data(3).hashCode(), new TestClass().data(3).hashCode() },
				{ new TestClass().data(4).hashCode(), new TestClass().data(4).hashCode() },
				{ new TestClass().data(5).hashCode(), new TestClass().data(5).hashCode() },
				{ new TestClass().data(6).hashCode(), new TestClass().data(6).hashCode() },
				{ new TestClass().data(7).hashCode(), new TestClass().data(7).hashCode() },
				{ new TestClass().data(8).hashCode(), new TestClass().data(8).hashCode() },
				{ new TestClass().data(9).hashCode(), new TestClass().data(9).hashCode() },
				{ new TestClass().data(10).hashCode(), new TestClass().data(10).hashCode() },
				{ new TestClass().data(11).hashCode(), new TestClass().data(11).hashCode() },
				{ new TestClass().data(12).hashCode(), new TestClass().data(12).hashCode() },
				{ new TestClass().data(13).hashCode(), new TestClass().data(13).hashCode() },
				{ new TestClass().data(14).hashCode(), new TestClass().data(14).hashCode() },
				{ new TestClass().data(15).hashCode(), new TestClass().data(15).hashCode() },
				{ new TestClass().data(16).hashCode(), new TestClass().data(16).hashCode() }
		};
	}

	/**
	 * Dados para o teste do {@link br.com.waio.erp.util.EqualsHashCodeTest#shouldNotHashCode(int, int)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] shouldNotHashCode() {
		return new Object[][] {
				{ new TestClass().data(-1).hashCode(), new TestClass().data(-1, true).hashCode() },
				{ new TestClass().data(0).hashCode(), new TestClass().data(0, true).hashCode() },
				{ new TestClass().data(1).hashCode(), new TestClass().data(1, true).hashCode() },
				{ new TestClass().data(2).hashCode(), new TestClass().data(2, true).hashCode() },
				{ new TestClass().data(3).hashCode(), new TestClass().data(3, true).hashCode() },
				{ new TestClass().data(4).hashCode(), new TestClass().data(4, true).hashCode() },
				{ new TestClass().data(5).hashCode(), new TestClass().data(5, true).hashCode() },
				{ new TestClass().data(6).hashCode(), new TestClass().data(6, true).hashCode() },
				{ new TestClass().data(7).hashCode(), new TestClass().data(7, true).hashCode() },
				{ new TestClass().data(8).hashCode(), new TestClass().data(8, true).hashCode() },
				{ new TestClass().data(9).hashCode(), new TestClass().data(9, true).hashCode() },
				{ new TestClass().data(10).hashCode(), new TestClass().data(10, true).hashCode() },
				{ new TestClass().data(11).hashCode(), new TestClass().data(11, true).hashCode() },
				{ new TestClass().data(12).hashCode(), new TestClass().data(12, true).hashCode() },
				{ new TestClass().data(13).hashCode(), new TestClass().data(13, true).hashCode() },
				{ new TestClass().data(14).hashCode(), new TestClass().data(14, true).hashCode() },
				{ new TestClass().data(15).hashCode(), new TestClass().data(15, true).hashCode() },
				{ new TestClass().data(16).hashCode(), new TestClass().data(16, true).hashCode() }
		};
	}

	/**
	 * Dados para o teste do {@link br.com.waio.erp.util.EqualsHashCodeTest#shouldEquals(boolean)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] shouldEquals() {
		return new Object[][] {
				{ new TestClass().data(-1).equals(new TestClass().data(-1)) },
				{ new TestClass().data(0).equals(new TestClass().data(0)) },
				{ new TestClass().data(1).equals(new TestClass().data(1)) },
				{ new TestClass().data(2).equals(new TestClass().data(2)) },
				{ new TestClass().data(3).equals(new TestClass().data(3)) },
				{ new TestClass().data(4).equals(new TestClass().data(4)) },
				{ new TestClass().data(5).equals(new TestClass().data(5)) },
				{ new TestClass().data(6).equals(new TestClass().data(6)) },
				{ new TestClass().data(7).equals(new TestClass().data(7)) },
				{ new TestClass().data(8).equals(new TestClass().data(8)) },
				{ new TestClass().data(9).equals(new TestClass().data(9)) },
				{ new TestClass().data(10).equals(new TestClass().data(10)) },
				{ new TestClass().data(11).equals(new TestClass().data(11)) },
				{ new TestClass().data(12).equals(new TestClass().data(12)) },
				{ new TestClass().data(13).equals(new TestClass().data(13)) },
				{ new TestClass().data(14).equals(new TestClass().data(14)) },
				{ new TestClass().data(15).equals(new TestClass().data(15)) },
				{ new TestClass().data(16).equals(new TestClass().data(16)) }
		};
	}

	/**
	 * Dados para o teste do {@link br.com.waio.erp.util.EqualsHashCodeTest#shouldNotEquals(boolean)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] shouldNotEquals() {
		return new Object[][] {
				{ new TestClass().data(-1).equals(new TestClass().data(-1, true)) },
				{ new TestClass().data(0).equals(new TestClass().data(0, true)) },
				{ new TestClass().data(1).equals(new TestClass().data(1, true)) },
				{ new TestClass().data(2).equals(new TestClass().data(2, true)) },
				{ new TestClass().data(3).equals(new TestClass().data(3, true)) },
				{ new TestClass().data(4).equals(new TestClass().data(4, true)) },
				{ new TestClass().data(5).equals(new TestClass().data(5, true)) },
				{ new TestClass().data(6).equals(new TestClass().data(6, true)) },
				{ new TestClass().data(7).equals(new TestClass().data(7, true)) },
				{ new TestClass().data(8).equals(new TestClass().data(8, true)) },
				{ new TestClass().data(9).equals(new TestClass().data(9, true)) },
				{ new TestClass().data(10).equals(new TestClass().data(10, true)) },
				{ new TestClass().data(11).equals(new TestClass().data(11, true)) },
				{ new TestClass().data(12).equals(new TestClass().data(12, true)) },
				{ new TestClass().data(13).equals(new TestClass().data(13, true)) },
				{ new TestClass().data(14).equals(new TestClass().data(14, true)) },
				{ new TestClass().data(15).equals(new TestClass().data(15, true)) },
				{ new TestClass().data(16).equals(new TestClass().data(16, true)) }
		};
	}

}
