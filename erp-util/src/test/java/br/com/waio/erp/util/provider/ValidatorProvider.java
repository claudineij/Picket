package br.com.waio.erp.util.provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.testng.annotations.DataProvider;

/**
 * Dados para execução dos testes do {@link br.com.waio.erp.util.ValidatorTest}.
 *
 * @since 2.0.2
 *
 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
 */
public final class ValidatorProvider {

	/**
	 * Construtor privado.
	 */
	private ValidatorProvider() {

	}

	/**
	 * Dados para o teste do {@link br.com.waio.erp.util.ValidatorTest#shouldIsEmptyString(String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] isEmptyString() {
		return new Object[][] {
				{ null },
				{ "" },
				{ new String() },
				{ new String("") }
		};
	}

	/**
	 * Dados para o teste {@link br.com.waio.erp.util.ValidatorTest#shouldIsNotEmptyString(String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] isNotEmptyString() {
		return new Object[][] {
				{ "a" },
				{ "aaa" },
				{ "456" },
				{ new String("a") },
				{ new String("aaa") },
				{ new String("15496adsf564") }
		};
	}

	/**
	 * Dados para o teste {@link br.com.waio.erp.util.ValidatorTest#shouldIsEmptyStringArray(String[])}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] isEmptyStringArray() {
		return new Object[][] {
				{ null },
				{ new String[]{} }
		};
	}

	/**
	 * Dados para o teste {@link br.com.waio.erp.util.ValidatorTest#shouldIsNotEmptyStringArray(String[])}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] isNotEmptyStringArray() {
		return new Object[][] {
				{ new String[]{ "a" } },
				{ new String[]{ "aa", "aa" } }
		};
	}

	/**
	 * Dados para o teste {@link br.com.waio.erp.util.ValidatorTest#shouldIsEmptyList(List)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] isEmptyList() {
		return new Object[][] {
				{ null },
				{ new ArrayList<String>() },
				{ new ArrayList<Long>() },
				{ new ArrayList<Boolean>() },
				{ new ArrayList<String>(2) },
				{ new ArrayList<Long>(2) },
				{ new ArrayList<Boolean>(2) },
				{ new LinkedList<String>() },
				{ new LinkedList<Long>() },
				{ new LinkedList<Boolean>() }
		};
	}

	/**
	 * Dados para o teste {@link br.com.waio.erp.util.ValidatorTest#shouldIsNotEmptyList(List)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] isNotEmptyList() {
		final List<String> strings = new ArrayList<>();
		strings.add("");
		strings.add("aaa");

		final List<Long> longs = new ArrayList<>();
		longs.add(1L);
		longs.add(2L);

		final List<Boolean> booleans = new ArrayList<>();
		booleans.add(true);
		booleans.add(false);

		final List<String> stringsLinked = new LinkedList<>();
		stringsLinked.add("");
		stringsLinked.add("aaa");

		final List<Long> longsLinked = new LinkedList<>();
		longsLinked.add(1L);
		longsLinked.add(2L);

		final List<Boolean> booleansLinked = new LinkedList<>();
		booleansLinked.add(true);
		booleansLinked.add(false);

		return new Object[][] {
				{ strings },
				{ longs },
				{ booleans },
				{ stringsLinked },
				{ longsLinked },
				{ booleansLinked }
		};
	}

	/**
	 * Dados para o teste {@link br.com.waio.erp.util.ValidatorTest#shouldIsEmptyMap(Map)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] isEmptyMap() {
		return new Object[][] {
				{ null },
				{ new HashMap<Long, String>() },
				{ new HashMap<Long, Long>(2, 2) },
				{ new ConcurrentHashMap<Long, String>() },
				{ new ConcurrentHashMap<Long, Long>(2, 2) }
		};
	}

	/**
	 * Dados para o teste {@link br.com.waio.erp.util.ValidatorTest#shouldIsNotEmptyMap(Map)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] isNotEmptyMap() {
		final Map<String, String> stringsHash = new HashMap<>();
		stringsHash.put("aa", "aa");
		stringsHash.put("bb", "bb");

		final Map<Long, Long> longsHash = new HashMap<>();
		longsHash.put(1L, 2L);
		longsHash.put(2L, 1L);

		final Map<String, Boolean> booleansHash = new HashMap<>();
		booleansHash.put("a", true);
		booleansHash.put("b", false);

		final ConcurrentMap<String, String> strings = new ConcurrentHashMap<>();
		strings.put("aa", "aa");
		strings.put("bb", "bb");

		final ConcurrentMap<Long, Long> longs = new ConcurrentHashMap<>();
		longs.put(1L, 2L);
		longs.put(2L, 1L);

		final ConcurrentMap<String, Boolean> booleans = new ConcurrentHashMap<>();
		booleans.put("a", true);
		booleans.put("b", false);

		return new Object[][] {
				{ stringsHash },
				{ longsHash },
				{ booleansHash },
				{ strings },
				{ longs },
				{ booleans }
		};
	}

	/**
	 * Dados para o teste {@link br.com.waio.erp.util.ValidatorTest#shouldIsEmptyObject(Object)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] isEmptyObject() {
		return new Object[][] {
				{ null },
				{ "" },
				{ new String() },
				{ new String("") } ,
				{ new String[]{} },
				{ new ArrayList<String>() },
				{ new ArrayList<Long>() },
				{ new ArrayList<Boolean>() },
				{ new ArrayList<String>(2) },
				{ new ArrayList<Long>(2) },
				{ new ArrayList<Boolean>(2) },
				{ new LinkedList<String>() },
				{ new LinkedList<Long>() },
				{ new LinkedList<Boolean>() },
				{ new HashMap<Long, String>() },
				{ new HashMap<Long, Long>(2, 2) },
				{ new ConcurrentHashMap<Long, String>() },
				{ new ConcurrentHashMap<Long, Long>(2, 2) }
		};
	}

	/**
	 * Dados para o teste {@link br.com.waio.erp.util.ValidatorTest#shouldIsNotEmptyObject(Object)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] isNotEmptyObject() {
		return new Object[][] {
				{ new Object() },
				{ Short.valueOf("1") },
				{ 1 },
				{ 1 },
				{ Integer.valueOf("1") },
				{ 1L },
				{ Long.valueOf(1) },
				{ Long.valueOf("1") },
				{ 1.5 },
				{ Double.valueOf(1.5) },
				{ Double.valueOf("1.5") },
				{ 1.5f },
				{ Float.valueOf(1.5f) },
				{ Float.valueOf("1.5") }
		};
	}

	/**
	 * Dados para o teste {@link br.com.waio.erp.util.ValidatorTest#shouldIsNumberWithoutDecimal(Object)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] isNumberWithoutDecimal() {
		return new Object[][] {
				{ "1" },
				{ "58807126303" },
				{ new String("1") },

				{ (short) 1 },
				{ Short.valueOf((short) 1) },
				{ Short.valueOf("1") },

				{ 1 },
				{ Integer.valueOf(1) },
				{ Integer.valueOf("1") },

				{ 1L },
				{ Long.valueOf(1) },
				{ Long.valueOf("1") }
		};
	}

	/**
	 * Dados para o teste {@link br.com.waio.erp.util.ValidatorTest#shouldIsNotNumberWithoutDecimal(Object)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] isNotNumberWithoutDecimal() {
		return new Object[][] {
				{ null },
				{ "" },

				{ "1a" },
				{ "asdf" },

				{ "25.0f" },
				{ "525.00a" },

				{ 25.0f },
				{ Float.valueOf(25.0f) },
				{ Float.valueOf("25.0") },

				{ 525.00 },
				{ Double.valueOf(525.00) },
				{ Double.valueOf("525.00") }
		};
	}

	/**
	 * Dados para o teste {@link br.com.waio.erp.util.ValidatorTest#shouldIsNumberWithDecimal(Object)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] isNumberWithDecimal() {
		return new Object[][] {
				{ "1" },
				{ new String("1") },

				{ (short) 1 },
				{ Short.valueOf((short) 1) },
				{ Short.valueOf("1") },

				{ 1 },
				{ Integer.valueOf(1) },
				{ Integer.valueOf("1") },

				{ 1L },
				{ Long.valueOf(1) },
				{ Long.valueOf("1") },

				{ 25.0f },
				{ Float.valueOf(25.0f) },
				{ Float.valueOf("25.0") },

				{ 525.00 },
				{ Double.valueOf(525.00) },
				{ Double.valueOf("525.00") }
		};
	}

	/**
	 * Dados para o teste {@link br.com.waio.erp.util.ValidatorTest#shouldIsNotNumberWithDecimal(Object)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] isNotNumberWithDecimal() {
		return new Object[][] {
				{ null },
				{ "" },

				{ "1a" },
				{ "asdf" },

				{ "25.0f" },
				{ "525.00a" }
		};
	}

	/**
	 * Dados para o teste {@link br.com.waio.erp.util.ValidatorTest#shouldIsEmail(String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] isEmail() {
		return new Object[][] {
				{ "a@a.com" },
				{ "a@a.net" },
				{ "a@a.com.br" },
				{ "teste@teste.com.br" },
				{ "teste_teste@teste-teste.com.br" },
				{ "teste_teste@teste123.com.br" },
				{ "teste_teste@teste-132.com.br" },
				{ "teste_132@teste-teste.com.br" },
				{ "teste_123@teste123.com.br" },
				{ "teste_132@teste-132.com.br" },
				{ "teste-132@teste-teste.com.br" },
				{ "teste-123@teste123.com.br" },
				{ "teste-132@teste-132.com.br" },
				{ "teste.132@teste-teste.com.br" },
				{ "teste.123@teste123.com.br" },
				{ "teste.132@teste-132.com.br" },
				{ "teste_teste@teste_teste.com.br" },
				{ "teste_teste@teste.teste.com.br" }
		};
	}

	/**
	 * Dados para o teste {@link br.com.waio.erp.util.ValidatorTest#shouldIsNotEmail(String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] isNotEmail() {
		return new Object[][] {
				{ null },
				{ "" },
				{ "a" },
				{ "a@" },
				{ "a@a" },
				{ "teste@teste" },
				{ "@" },
				{ "teste_teste@teste/teste.com.br" },
				{ "teste_teste@teste(teste.com.br" }
		};
	}

	/**
	 * Dados para o teste {@link br.com.waio.erp.util.ValidatorTest#shouldIsCpf(String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] isCpf() {
		return new Object[][] {
				{ "07227524159" },
				{ "58807126303" },
				{ "798.549.957-12" },
				{ "226.445.74900" },
				{ "226.44574900" },
				{ "226.445749-00" },
				{ "226445.749-00" },
				{ "226.445749-00" }
		};
	}

	/**
	 * Dados para o teste {@link br.com.waio.erp.util.ValidatorTest#shouldIsNotCpf(String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] isNotCpf() {
		return new Object[][] {
				{ null },
				{ "" },
				{ "0" },
				{ "00" },
				{ "000" },
				{ "0000" },
				{ "00000" },
				{ "00000" },
				{ "000000" },
				{ "0000000" },
				{ "00000000" },
				{ "000000000" },
				{ "0000000000" },
				{ "00000000000" },
				{ "11111111111" },
				{ "22222222222" },
				{ "33333333333" },
				{ "44444444444" },
				{ "55555555555" },
				{ "66666666666" },
				{ "77777777777" },
				{ "88888888888" },
				{ "99999999999" },
				{ "07227524155" },
				{ "58807136303" },
				{ "778.549.957-12" },
				{ "226.455.74900" },
				{ "226.44624900" },
				{ "226.4442349-00" },
				{ "2264456645.749-00" },
				{ "226.446878949-00" }
		};
	}

	/**
	 * Dados para o teste {@link br.com.waio.erp.util.ValidatorTest#shouldIsCnpj(String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] isCnpj() {
		return new Object[][] {
				{ "76613970000124" },
				{ "27279305000130" },
				{ "24.187.811/0001-01" },
				{ "24.666.474/000135" },
				{ "85.362.7100001-14" },
				{ "43.167805/000137" },
				{ "56465.5640001-54" },
				{ "81184221/0001-69" }
		};
	}

	/**
	 * Dados para o teste {@link br.com.waio.erp.util.ValidatorTest#shouldIsNotCnpj(String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] isNotCnpj() {
		return new Object[][] {
				{ null },
				{ "" },
				{ "0" },
				{ "00" },
				{ "000" },
				{ "0000" },
				{ "00000" },
				{ "00000" },
				{ "000000" },
				{ "0000000" },
				{ "00000000" },
				{ "000000000" },
				{ "0000000000" },
				{ "00000000000" },
				{ "000000000000" },
				{ "000000000000" },
				{ "0000000000000" },
				{ "00000000000000" },
				{ "11111111111111" },
				{ "22222222222222" },
				{ "33333333333333" },
				{ "44444444444444" },
				{ "55555555555555" },
				{ "66666666666666" },
				{ "77777777777777" },
				{ "88888888888888" },
				{ "99999999999999" },
				{ "76613970000224" },
				{ "27279305000230" },
				{ "24.187.811/1001-01" },
				{ "24.666.454/000135" },
				{ "85.892.7100001-14" },
				{ "23.167805/000137" },
				{ "8798641.5640001-54" },
				{ "81184221456546/0001-69" },
				{ "24.187.811/0001-010" }
		};
	}

	/**
	 * Dados para o teste {@link br.com.waio.erp.util.ValidatorTest#shouldIsZipCode(String).
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] isZipCode() {
		return new Object[][] {
				{ "13500000" },
				{ "13500-000" },
				{ "13.500-000" }
		};
	}

	/**
	 * Dados para o teste {@link br.com.waio.erp.util.ValidatorTest#shouldIsNotZipCode(String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] isNotZipCode() {
		return new Object[][] {
				{ null },
				{ "" },
				{ "1" },
				{ "13" },
				{ "135" },
				{ "1350" },
				{ "13500" },
				{ "135000" },
				{ "1350000" },
				{ "130500000" },
				{ "13500-0000" },
				{ "130500-000" },
				{ "13.0500-000" },
				{ "13.50a-000" }
		};
	}
	
	/**
	 * Dados para o teste {@link br.com.waio.erp.util.ValidatorTest#shouldIsStateInscription(String, String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] isStateInscription() {
		return new Object[][] {
				{ "01.379.871/348-04", "AC" },
				{ "248525840", "AL" },
				{ "036944831", "AP" },
				{ "04.137.224-7", "AM" },
				{ "919661-57", "BA" },
				{ "73609713-9", "CE" },
				{ "07803286001-08", "DF" },
				{ "27536800-9", "ES" },
				{ "11.289.392-9", "GO" },
				{ "12818420-5", "MA" },
				{ "2159580881-9", "MT" },
				{ "28337135-8", "MS" },
				{ "137.429.737/0060", "MG" },
				{ "15-956666-5", "PA" },
				{ "44054523-4", "PB" },
				{ "724.37530-87", "PR" },
				{ "18.1.001.0083944-8", "PE" },
				{ "29986489-8", "PI" },
				{ "78.045.418", "RJ" },
				{ "20.153.722-2", "RN" },
				{ "096/3156659", "RS" },
				{ "2187770092541-8", "RO" },
				{ "24005400-5", "RR" },
				{ "587.269.580.118", "SP" },
				{ "391.710.079", "SC" },
				{ "63666217-9", "SE" },
				{ "29.040.634-0", "TO" },

				{ "01.379.871/348-04", " AC" },
				{ "248525840", " AL" },
				{ "036944831", " AP" },
				{ "04.137.224-7", " AM" },
				{ "919661-57", " BA" },
				{ "73609713-9", " CE" },
				{ "07803286001-08", " DF" },
				{ "27536800-9", " ES" },
				{ "11.289.392-9", " GO" },
				{ "12818420-5", " MA" },
				{ "2159580881-9", " MT" },
				{ "28337135-8", " MS" },
				{ "137.429.737/0060", " MG" },
				{ "15-956666-5", " PA" },
				{ "44054523-4", " PB" },
				{ "724.37530-87", " PR" },
				{ "18.1.001.0083944-8", " PE" },
				{ "29986489-8", " PI" },
				{ "78.045.418", " RJ" },
				{ "20.153.722-2", " RN" },
				{ "096/3156659", " RS" },
				{ "2187770092541-8", " RO" },
				{ "24005400-5", " RR" },
				{ "587.269.580.118", " SP" },
				{ "391.710.079", " SC" },
				{ "63666217-9", " SE" },
				{ "29.040.634-0", " TO" },

				{ "01.379.871/348-04", "AC " },
				{ "248525840", "AL " },
				{ "036944831", "AP " },
				{ "04.137.224-7", "AM " },
				{ "919661-57", "BA " },
				{ "73609713-9", "CE " },
				{ "07803286001-08", "DF " },
				{ "27536800-9", "ES " },
				{ "11.289.392-9", "GO " },
				{ "12818420-5", "MA " },
				{ "2159580881-9", "MT " },
				{ "28337135-8", "MS " },
				{ "137.429.737/0060", "MG " },
				{ "15-956666-5", "PA " },
				{ "44054523-4", "PB " },
				{ "724.37530-87", "PR " },
				{ "18.1.001.0083944-8", "PE " },
				{ "29986489-8", "PI " },
				{ "78.045.418", "RJ " },
				{ "20.153.722-2", "RN " },
				{ "096/3156659", "RS " },
				{ "2187770092541-8", "RO " },
				{ "24005400-5", "RR " },
				{ "587.269.580.118", "SP " },
				{ "391.710.079", "SC " },
				{ "63666217-9", "SE " },
				{ "29.040.634-0", "TO " },

				{ "01.379.871/348-04", " AC " },
				{ "248525840", " AL " },
				{ "036944831", " AP " },
				{ "04.137.224-7", " AM " },
				{ "919661-57", " BA " },
				{ "73609713-9", " CE " },
				{ "07803286001-08", " DF " },
				{ "27536800-9", " ES " },
				{ "11.289.392-9", " GO " },
				{ "12818420-5", " MA " },
				{ "2159580881-9", " MT " },
				{ "28337135-8", " MS " },
				{ "137.429.737/0060", " MG " },
				{ "15-956666-5", " PA " },
				{ "44054523-4", " PB " },
				{ "724.37530-87", " PR " },
				{ "18.1.001.0083944-8", " PE " },
				{ "29986489-8", " PI " },
				{ "78.045.418", " RJ " },
				{ "20.153.722-2", " RN " },
				{ "096/3156659", " RS " },
				{ "2187770092541-8", " RO " },
				{ "24005400-5", " RR " },
				{ "587.269.580.118", " SP " },
				{ "391.710.079", " SC " },
				{ "63666217-9", " SE " },
				{ "29.040.634-0", " TO " },

				{ "01.379.871/348-04", "ac" },
				{ "248525840", "al" },
				{ "036944831", "ap" },
				{ "04.137.224-7", "am" },
				{ "919661-57", "ba" },
				{ "73609713-9", "ce" },
				{ "07803286001-08", "df" },
				{ "27536800-9", "es" },
				{ "11.289.392-9", "go" },
				{ "12818420-5", "ma" },
				{ "2159580881-9", "mt" },
				{ "28337135-8", "ms" },
				{ "137.429.737/0060", "mg" },
				{ "15-956666-5", "pa" },
				{ "44054523-4", "pb" },
				{ "724.37530-87", "pr" },
				{ "18.1.001.0083944-8", "pe" },
				{ "29986489-8", "pi" },
				{ "78.045.418", "rj" },
				{ "20.153.722-2", "rn" },
				{ "096/3156659", "rs" },
				{ "2187770092541-8", "ro" },
				{ "24005400-5", "rr" },
				{ "587.269.580.118", "sp" },
				{ "391.710.079", "sc" },
				{ "63666217-9", "se" },
				{ "29.040.634-0", "to" },

				{ "01.379.871/348-04", " ac" },
				{ "248525840", " al" },
				{ "036944831", " ap" },
				{ "04.137.224-7", " am" },
				{ "919661-57", " ba" },
				{ "73609713-9", " ce" },
				{ "07803286001-08", " df" },
				{ "27536800-9", " es" },
				{ "11.289.392-9", " go" },
				{ "12818420-5", " ma" },
				{ "2159580881-9", " mt" },
				{ "28337135-8", " ms" },
				{ "137.429.737/0060", " mg" },
				{ "15-956666-5", " pa" },
				{ "44054523-4", " pb" },
				{ "724.37530-87", " pr" },
				{ "18.1.001.0083944-8", " pe" },
				{ "29986489-8", " pi" },
				{ "78.045.418", " rj" },
				{ "20.153.722-2", " rn" },
				{ "096/3156659", " rs" },
				{ "2187770092541-8", " ro" },
				{ "24005400-5", " rr" },
				{ "587.269.580.118", " sp" },
				{ "391.710.079", " sc" },
				{ "63666217-9", " se" },
				{ "29.040.634-0", " to" },

				{ "01.379.871/348-04", "ac " },
				{ "248525840", "al " },
				{ "036944831", "ap " },
				{ "04.137.224-7", "am " },
				{ "919661-57", "ba " },
				{ "73609713-9", "ce " },
				{ "07803286001-08", "df " },
				{ "27536800-9", "es " },
				{ "11.289.392-9", "go " },
				{ "12818420-5", "ma " },
				{ "2159580881-9", "mt " },
				{ "28337135-8", "ms " },
				{ "137.429.737/0060", "mg " },
				{ "15-956666-5", "pa " },
				{ "44054523-4", "pb " },
				{ "724.37530-87", "pr " },
				{ "18.1.001.0083944-8", "pe " },
				{ "29986489-8", "pi " },
				{ "78.045.418", "rj " },
				{ "20.153.722-2", "rn " },
				{ "096/3156659", "rs " },
				{ "2187770092541-8", "ro " },
				{ "24005400-5", "rr " },
				{ "587.269.580.118", "sp " },
				{ "391.710.079", "sc " },
				{ "63666217-9", "se " },
				{ "29.040.634-0", "to " },

				{ "01.379.871/348-04", " ac " },
				{ "248525840", " al " },
				{ "036944831", " ap " },
				{ "04.137.224-7", " am " },
				{ "919661-57", " ba " },
				{ "73609713-9", " ce " },
				{ "07803286001-08", " df " },
				{ "27536800-9", " es " },
				{ "11.289.392-9", " go " },
				{ "12818420-5", " ma " },
				{ "2159580881-9", " mt " },
				{ "28337135-8", " ms " },
				{ "137.429.737/0060", " mg " },
				{ "15-956666-5", " pa " },
				{ "44054523-4", " pb " },
				{ "724.37530-87", " pr " },
				{ "18.1.001.0083944-8", " pe " },
				{ "29986489-8", " pi " },
				{ "78.045.418", " rj " },
				{ "20.153.722-2", " rn " },
				{ "096/3156659", " rs " },
				{ "2187770092541-8", " ro " },
				{ "24005400-5", " rr " },
				{ "587.269.580.118", " sp " },
				{ "391.710.079", " sc " },
				{ "63666217-9", " se " },
				{ "29.040.634-0", " to " }
		};
	}

	/**
	 * Dados para o teste {@link br.com.waio.erp.util.ValidatorTest#shouldNotIsStateInscription(String, String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] isNotStateInscription() {
		return new Object[][] {
			{ null, "AC" },
			{ "42423423423", null },
			{ "29.040.634-0", "PPPP" },
			{ "42423423423", "AC" },
			{ "3453453453", "AL" },
			{ "1546546546", "AP" },
			{ "55.999.224-7", "AM" },
			{ "132131-57", "BA" },
			{ "7131313.99", "CE" },
			{ "654654654-111.22", "DF" },
			{ "232323-9", "ES" },
			{ "11.234.333-9", "GO" },
			{ "12818333-5", "MA" },
			{ "33333333-9", "MT" },
			{ "23237135-x", "MS" },
			{ "137.333.737/0060", "MG" },
			{ "15-933366-5", "PA" },
			{ "440533333-4", "PB" },
			{ "724.3753330-87", "PR" },
			{ "18.1.00333083944-8", "PE" },
			{ "2933389-8", "PI" },
			{ "78.335.418", "RJ" },
			{ "20.012.722-2", "RN" },
			{ "09633156659", "RS" },
			{ "2183330092541-8", "RO" },
			{ "24033400-5", "RR" },
			{ "583369.580.118", "SP" },
			{ "333710.079", "SC" },
			{ "63366217-9", "SE" },
			{ "33333983351-9", "TO" },

			{ "42423423423", " AC" },
			{ "3453453453", " AL" },
			{ "1546546546", " AP" },
			{ "55.999.224-7", " AM" },
			{ "132131-57", " BA" },
			{ "7131313.99", " CE" },
			{ "654654654-111.22", " DF" },
			{ "232323-9", " ES" },
			{ "11.234.333-9", " GO" },
			{ "12818333-5", " MA" },
			{ "33333333-9", " MT" },
			{ "23237135-x", " MS" },
			{ "137.333.737/0060", " MG" },
			{ "15-933366-5", " PA" },
			{ "440533333-4", " PB" },
			{ "724.3753330-87", " PR" },
			{ "18.1.00333083944-8", " PE" },
			{ "2933389-8", " PI" },
			{ "78.335.418", " RJ" },
			{ "20.012.722-2", " RN" },
			{ "09633156659", " RS" },
			{ "2183330092541-8", " RO" },
			{ "24033400-5", " RR" },
			{ "583369.580.118", " SP" },
			{ "333710.079", " SC" },
			{ "63366217-9", " SE" },
			{ "33333983351-9", " TO" },

			{ "42423423423", "AC " },
			{ "3453453453", "AL " },
			{ "1546546546", "AP " },
			{ "55.999.224-7", "AM " },
			{ "132131-57", "BA " },
			{ "7131313.99", "CE " },
			{ "654654654-111.22", "DF " },
			{ "232323-9", "ES " },
			{ "11.234.333-9", "GO " },
			{ "12818333-5", "MA " },
			{ "33333333-9", "MT " },
			{ "23237135-x", "MS " },
			{ "137.333.737/0060", "MG " },
			{ "15-933366-5", "PA " },
			{ "440533333-4", "PB " },
			{ "724.3753330-87", "PR " },
			{ "18.1.00333083944-8", "PE " },
			{ "2933389-8", "PI " },
			{ "78.335.418", "RJ " },
			{ "20.012.722-2", "RN " },
			{ "09633156659", "RS " },
			{ "2183330092541-8", "RO " },
			{ "24033400-5", "RR " },
			{ "583369.580.118", "SP " },
			{ "333710.079", "SC " },
			{ "63366217-9", "SE " },
			{ "33333983351-9", "TO " },

			{ "42423423423", " AC " },
			{ "3453453453", " AL " },
			{ "1546546546", " AP " },
			{ "55.999.224-7", " AM " },
			{ "132131-57", " BA " },
			{ "7131313.99", " CE " },
			{ "654654654-111.22", " DF " },
			{ "232323-9", " ES " },
			{ "11.234.333-9", " GO " },
			{ "12818333-5", " MA " },
			{ "33333333-9", " MT " },
			{ "23237135-x", " MS " },
			{ "137.333.737/0060", " MG " },
			{ "15-933366-5", " PA " },
			{ "440533333-4", " PB " },
			{ "724.3753330-87", " PR " },
			{ "18.1.00333083944-8", " PE " },
			{ "2933389-8", " PI " },
			{ "78.335.418", " RJ " },
			{ "20.012.722-2", " RN " },
			{ "09633156659", " RS " },
			{ "2183330092541-8", " RO " },
			{ "24033400-5", " RR " },
			{ "583369.580.118", " SP " },
			{ "333710.079", " SC " },
			{ "63366217-9", " SE " },
			{ "33333983351-9", " TO " },

			{ "42423423423", "ac" },
			{ "3453453453", "al" },
			{ "1546546546", "ap" },
			{ "55.999.224-7", "am" },
			{ "132131-57", "ba" },
			{ "7131313.99", "ce" },
			{ "654654654-111.22", "df" },
			{ "232323-9", "es" },
			{ "11.234.333-9", "go" },
			{ "12818333-5", "ma" },
			{ "33333333-9", "mt" },
			{ "23237135-x", "ms" },
			{ "137.333.737/0060", "mg" },
			{ "15-933366-5", "pa" },
			{ "440533333-4", "pb" },
			{ "724.3753330-87", "pr" },
			{ "18.1.00333083944-8", "pe" },
			{ "2933389-8", "pi" },
			{ "78.335.418", "rj" },
			{ "20.012.722-2", "rn" },
			{ "09633156659", "rs" },
			{ "2183330092541-8", "ro" },
			{ "24033400-5", "rr" },
			{ "583369.580.118", "sp" },
			{ "333710.079", "sc" },
			{ "63366217-9", "se" },
			{ "33333983351-9", "to" }
		};
	}
	
	/**
	 * Dados para o teste {@link br.com.waio.erp.util.ValidatorTest#shouldNotIsStateInscriptionOtherState(String, String)}.
	 *
	 * @return Lista de dados
	 */
	@DataProvider
	public static Object[][] isNotStateInscriptionOtherState() {
		return new Object[][] {
				{ "01.379.871/348-04", "SE" },
				{ "248525840", "AC" },
				{ "036944831", "SP" },
				{ "04.137.224-7", "RR" },
				{ "919661-57", "TO" },
				{ "73609713-9", "RO" },
				{ "07803286001-08", "RS" },
				{ "27536800-9", "RN" },
				{ "11.289.392-9", "RJ" },
				{ "12818420-5", "MS" },
				{ "2159580881-9", "PI" },
				{ "07803286001-8", "MT" },
				{ "137.429.737/0060", "PA" },
				{ "15-956666-5", "MG" },
				{ "44054523-4", "PE" },
				{ "724.37530-87", "PB" },
				{ "18.1.001.0083944-8", "PR" },
				{ "29986489-8", "GO" },
				{ "78.045.418", "MA" },
				{ "20.153.722-2", "DF" },
				{ "096/3156659", "ES" },
				{ "2187770092541-8", "CE" },
				{ "24005400-5", "BA" },
				{ "587.269.580.118", "AM" },
				{ "391.710.079", "AP" },
				{ "63666217-9", "AL" },
				{ "5003983351-9", "SC " }
		};
	}

}
