package br.com.waio.erp.util.provider;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.testng.annotations.DataProvider;

/**
 * Dados para execução dos teste do {@link br.com.waio.erp.util.DirectPropertyAccessorTest}.
 *
 * @since 2.0.7
 *
 * @author <a href="mail:fabio.zanardi@w2z.com.br">Fábio Zanardi</a>
 */
public final class DirectPropertyAccessorProvider {
	
	/**
	 * Construtor privado.
	 */
	private DirectPropertyAccessorProvider() {
		
	}
	
	/**
	 * Dados para o teste do {@link br.com.waio.erp.util.DirectPropertyAccessorTest#shouldGet(String, Object)}.
	 *
	 * @return Lista de dados
	 *
	 * @throws ParseException String não pode ser convertida para data
	 */
	@DataProvider
	public static Object[][] get() throws ParseException {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		return new Object[][] {
				{ "string", "testefalse" },
				{ "wShort", Short.parseShort("55") },
				{ "wLong", 55L },
				{ "wDouble", 55.6D },
				{ "wFloat", 55.6F },
				{ "wInteger", 55 },
				{ "wBoolean", false },
				{ "pShort", Short.parseShort("66") },
				{ "pLong", 66L },
				{ "pDouble", 66.6 },
				{ "pFloat", 66.6F },
				{ "pInt", 66 },
				{ "pBoolean", false },
				{ "wDate", sdf.parse("1990-10-5") },
				{ "fPublic", "fPublic" },
				{ "fExtend", "fExtend" }
		};
	}

	/**
	 * Dados para o teste do {@link br.com.waio.erp.util.DirectPropertyAccessorTest#shouldSet(String, Object)}.
	 *
	 * @return Lista de dados
	 *
	 * @throws ParseException String não pode ser convertida para data
	 */
	@DataProvider
	public static Object[][] set() throws ParseException {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		return new Object[][] {
				{ "string", "testefalse" },
				{ "wShort", Short.parseShort("55") },
				{ "wLong", 55L },
				{ "wDouble", 55.6D },
				{ "wFloat", 55.6F },
				{ "wInteger", 55 },
				{ "wBoolean", false },
				{ "pShort", Short.parseShort("66") },
				{ "pLong", 66L },
				{ "pDouble", 66.6 },
				{ "pFloat", 66.6F },
				{ "pInt", 66 },
				{ "pBoolean", false },
				{ "wDate", sdf.parse("1990-10-5") },
				{ "fPublic", "fPublic" },
				{ "fExtend", "fExtend" }
		};
	}
	
	/**
	 * Dados para o teste do {@link br.com.waio.erp.util.DirectPropertyAccessorTest#shouldNotGetInexistentProperty(String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] getInexistentProperty() {
		return new Object[][] {
				{ "id" },
				{ "name" },
				{ "phone" },
				{ "email" },
				{ "password" },
				{ "address" },
				{ "salary" },
				{ "birthDate" }
		};
	}
	
	/**
	 * Dados para o teste do {@link br.com.waio.erp.util.DirectPropertyAccessorTest#shouldNotSetInexistentProperty(String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] setInexistentProperty() {
		return new Object[][] {
				{ "id" },
				{ "name" },
				{ "phone" },
				{ "email" },
				{ "password" },
				{ "address" },
				{ "salary" },
				{ "birthDate" }
		};
	}

}
