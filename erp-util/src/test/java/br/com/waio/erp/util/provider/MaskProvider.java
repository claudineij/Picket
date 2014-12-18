package br.com.waio.erp.util.provider;

import org.testng.annotations.DataProvider;

/**
 * Dados para execução dos teste da {@link br.com.waio.erp.util.MaskTest}.
 *
 * @since 2.0.2
 *
 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
 */
public final class MaskProvider {

	/**
	 * Construtor privado.
	 */
	private MaskProvider() {

	}

	/**
	 * Dados para o teste do {@link br.com.waio.erp.util.MaskTest#shouldClean(String, String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] clean() {
		return new Object[][] {
				{ "", "" },
				{ "A", "A" },
				{ "A2", "A2" },
				{ "AAA-2223", "AAA2223" },
				{ "AAA_2223", "AAA2223" },
				{ "100.100.100-10", "10010010010" },
				{ "10.100.100/0001-20", "10100100000120" },
				{ "(00) 2030-0000", "0020300000" }
		};
	}

	/**
	 * Dados para o teste do {@link br.com.waio.erp.util.MaskTest#shouldClearNoDigit(String, String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] clearNoDigit() {
		return new Object[][] {
				{ "", "" },
				{ "A", "" },
				{ "A2", "2" },
				{ "AAA-2223", "2223" },
				{ "AAA_2223", "2223" },
				{ "100.100.100-10", "10010010010" },
				{ "10.100.100/0001-20", "10100100000120" },
				{ "(00) 2030-0000", "0020300000" }
		};
	}

	/**
	 * Dados para o teste do {@link br.com.waio.erp.util.MaskTest#shouldZipCode(String, String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] zipCode() {
		return new Object[][] {
				{ "", "" },
				{ "13500000", "13500-000" },
				{ "13510000", "13510-000" },
				{ "13510-000", "13510-000" }
		};
	}

	/**
	 * Dados para o teste do {@link br.com.waio.erp.util.MaskTest#shouldNotZipCode(String, String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] notZipCode() {
		return new Object[][] {
				{ "A3500000", "A3500000" },
				{ "1350000A", "1350000A" },
				{ "A3500-000", "A3500-000" },
				{ "13500-00A", "13500-00A" },
				{ "13.500000", "13.500000" },
				{ "13-510000", "13-510000" },
				{ "1351000.0", "1351000.0" }
		};
	}

	/**
	 * Dados para o teste do {@link br.com.waio.erp.util.MaskTest#shouldPhone(String, String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] phone() {
		return new Object[][] {
				{ "9999999999", "(99) 9999-9999" },
				{ "99999999999", "(99) 99999-9999" },
				{ "(99) 9999-9999", "(99) 9999-9999" },
				{ "(99) 99999-9999", "(99) 99999-9999" }
		};
	}

	/**
	 * Dados para o teste do {@link br.com.waio.erp.util.MaskTest#shouldNotPhone(String, String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] notPhone() {
		return new Object[][] {
				{ "999999999", "999999999" },
				{ "999999999999", "999999999999" },
				{ "999999-9999", "999999-9999" },
				{ "9999999-9999", "9999999-9999" },
				{ "(9999999999", "(9999999999" },
				{ "(99)99999999", "(99)99999999" },
				{ "(99) 999999999", "(99) 999999999" },
				{ "(99) 9999999-99", "(99) 9999999-99" },
				{ "(99) 9999.9999", "(99) 9999.9999" }
		};
	}

	/**
	 * Dados para o teste do {@link br.com.waio.erp.util.MaskTest#shouldCpf(String, String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] cpf() {
		return new Object[][] {
				{ "00000000000", "000.000.000-00" },
				{ "000.000.000-00", "000.000.000-00" },
				{ "00026500010", "000.265.000-10" },
				{ "000.265.000-10", "000.265.000-10" }
		};
	}

	/**
	 * Dados para o teste do {@link br.com.waio.erp.util.MaskTest#shouldNotCpf(String, String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] notCpf() {
		return new Object[][] {
				{ "0", "0" },
				{ "00", "00" },
				{ "000", "000" },
				{ "0000", "0000" },
				{ "00000", "00000" },
				{ "000000", "000000" },
				{ "0000000", "0000000" },
				{ "00000000", "00000000" },
				{ "000000000", "000000000" },
				{ "0000000000", "0000000000" },
				{ "000000000000", "000000000000" },
				{ "aaaaa", "aaaaa" },
				{ "000000000a0", "000000000a0" }
		};
	}

	/**
	 * Dados para o teste do {@link br.com.waio.erp.util.MaskTest#shouldCnpj(String, String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] cnpj() {
		return new Object[][] {
				{ "00000000000000", "00.000.000/0000-00" },
				{ "00.000.000/0000-00", "00.000.000/0000-00" },
				{ "00265000000110", "00.265.000/0001-10" },
				{ "00.265.000/0001-10", "00.265.000/0001-10" }
		};
	}

	/**
	 * Dados para o teste do {@link br.com.waio.erp.util.MaskTest#shouldNotCnpj(String, String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] notCnpj() {
		return new Object[][] {
				{ "0", "0" },
				{ "00", "00" },
				{ "000", "000" },
				{ "0000", "0000" },
				{ "00000", "00000" },
				{ "000000", "000000" },
				{ "0000000", "0000000" },
				{ "00000000", "00000000" },
				{ "000000000", "000000000" },
				{ "0000000000", "0000000000" },
				{ "00000000000", "00000000000" },
				{ "000000000000", "000000000000" },
				{ "0000000000000", "0000000000000" },
				{ "aaaaa", "aaaaa" },
				{ "002650000001a0", "002650000001a0" }
		};
	}

}
