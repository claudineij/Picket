package br.com.waio.erp.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.ie.IEAcreValidator;
import br.com.caelum.stella.validation.ie.IEAlagoasValidator;
import br.com.caelum.stella.validation.ie.IEAmapaValidator;
import br.com.caelum.stella.validation.ie.IEAmazonasValidator;
import br.com.caelum.stella.validation.ie.IEBahiaValidator;
import br.com.caelum.stella.validation.ie.IECearaValidator;
import br.com.caelum.stella.validation.ie.IEDistritoFederalValidator;
import br.com.caelum.stella.validation.ie.IEEspiritoSantoValidator;
import br.com.caelum.stella.validation.ie.IEGoiasValidator;
import br.com.caelum.stella.validation.ie.IEMaranhaoValidator;
import br.com.caelum.stella.validation.ie.IEMatoGrossoDoSulValidator;
import br.com.caelum.stella.validation.ie.IEMatoGrossoValidator;
import br.com.caelum.stella.validation.ie.IEMinasGeraisValidator;
import br.com.caelum.stella.validation.ie.IEParaValidator;
import br.com.caelum.stella.validation.ie.IEParaibaValidator;
import br.com.caelum.stella.validation.ie.IEParanaValidator;
import br.com.caelum.stella.validation.ie.IEPernambucoValidator;
import br.com.caelum.stella.validation.ie.IEPiauiValidator;
import br.com.caelum.stella.validation.ie.IERioDeJaneiroValidator;
import br.com.caelum.stella.validation.ie.IERioGrandeDoNorteValidator;
import br.com.caelum.stella.validation.ie.IERioGrandeDoSulValidator;
import br.com.caelum.stella.validation.ie.IERondoniaValidator;
import br.com.caelum.stella.validation.ie.IERoraimaValidator;
import br.com.caelum.stella.validation.ie.IESantaCatarinaValidator;
import br.com.caelum.stella.validation.ie.IESaoPauloValidator;
import br.com.caelum.stella.validation.ie.IESergipeValidator;
import br.com.caelum.stella.validation.ie.IETocantinsValidator;
import br.com.waio.erp.util.exception.FileInvalidException;

/**
 * Classe responsável por prover as validações.
 *
 * @since 2.0.2
 *
 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
 */
public final class Validator {

	/**
	 * Regex para número sem casa decimal.
	 */
	private static final String PATTERN_NUMBER_WITHOUT_DECIMAL = "^(\\d)++$";

	/**
	 * Regex para número com casa decimal.
	 */
	private static final String PATTERN_NUMBER_WITH_DECIMAL = "-?\\d+(\\.\\d+)?";

	/**
	 * Regex para email.
	 */
	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*"
			+ "@[A-Za-z0-9-_]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	/**
	 * CNPJ inválidos.
	 */
	private static final List<String> CNPJ_INVALID = Arrays.asList(new String[] { "00000000000000", "11111111111111",
			"22222222222222", "33333333333333", "44444444444444", "55555555555555", "66666666666666", "77777777777777",
			"88888888888888", "99999999999999" });

	/**
	 * Construtor privado.
	 */
	private Validator() {

	}

	/**
	 * Verificar se a {@link String} está nula ou vazia.<br /><br />
	 *
	 * Exemplo de como utilizar:
	 * <pre>
	 * if (Validator.isEmpty(nomeDoAtributo)) {
	 *
	 * }
	 * </pre>
	 *
	 * @param value Valor a ser testado do tipo {@link String}
	 *
	 * @return Retorna true se verdadeiro, senão false
	 */
	public static boolean isEmpty(final String value) {
		return value == null || value.trim().isEmpty();
	}

	/**
	 * Verificar se o array de {@link String} está nula ou vazia.<br /><br />
	 *
	 * Exemplo de como utilizar:
	 * <pre>
	 * if (Validator.isEmpty(itens)) {
	 *
	 * }
	 * </pre>
	 *
	 * @param values Lista de valores a ser testado do tipo {@link String}
	 *
	 * @return Retorna true se verdadeiro, senão false
	 */
	public static boolean isEmpty(final String[] values) {
		return values == null || values.length == 0;
	}

	/**
	 * Verificar se o {@link List} está nula ou vazia.<br /><br />
	 *
	 * Exemplo de como utilizar:
	 * <pre>
	 * if (Validator.isEmpty(itens)) {
	 *
	 * }
	 * </pre>
	 *
	 * @param list Valor a ser testado do tipo {@link List}
	 *
	 * @return Retorna true se verdadeiro, senão false
	 */
	public static boolean isEmpty(final List<?> list) {
		return list == null || list.isEmpty();
	}

	/**
	 * Verificar se o {@link Map} está nula ou vazia.<br /><br />
	 *
	 * Exemplo de como utilizar:
	 * <pre>
	 * if (Validator.isEmpty(itens)) {
	 *
	 * }
	 * </pre>
	 *
	 * @param values Valor a ser testado do tipo {@link Map}
	 *
	 * @return Retorna true se verdadeiro, senão false
	 */
	public static boolean isEmpty(final Map<?, ?> values) {
		return values == null || values.isEmpty();
	}

	/**
	 * Verificar se a {@link Object} está nula ou vazia.<br /><br />
	 *
	 * Exemplo de como utilizar:
	 * <pre>
	 * if (Validator.isEmpty(item)) {
	 *
	 * }
	 * </pre>
	 *
	 * @param value Valor a ser testado do tipo {@link Object}
	 *
	 * @return Retorna true se verdadeiro, senão false
	 */
	public static boolean isEmpty(final Object value) {
		if (value == null) {
			return true;
		}

		final Class<?> clazz = value.getClass();
		if (String.class.equals(clazz)) {
			return Validator.isEmpty((String) value);
		} else if (String[].class.equals(clazz)) {
			return Validator.isEmpty((String[]) value);
		} else if (List.class.isAssignableFrom(clazz)) {
			return Validator.isEmpty((List<?>) value);
		} else if (Map.class.isAssignableFrom(clazz)) {
			return Validator.isEmpty((Map<?, ?>) value);
		} else {
			return false;
		}
	}

	/**
	 * Verificar se a {@link String} é númerico sem casa decimal.<br /><br />
	 *
	 * Exemplo de como utilizar:
	 * <pre>
	 * if (Validator.isNumberWithoutDecimal("200.222.111.000")) {
	 *
	 * }
	 * </pre>
	 *
	 * @param value Valor a ser testado do tipo {@link String}
	 *
	 * @return Retorna true se verdadeiro, senão false
	 */
	public static boolean isNumberWithoutDecimal(final String value) {
		return !Validator.isEmpty(value) && value.matches(PATTERN_NUMBER_WITHOUT_DECIMAL);
	}

	/**
	 * Verificar se a {@link String} é númerico com casa decimal.<br /><br />
	 *
	 * Exemplo de como utilizar:
	 * <pre>
	 * if (Validator.isNumberWithDecimal("200.222.111.000")) {
	 *
	 * }
	 * </pre>
	 *
	 * @param value Valor a ser testado do tipo {@link String}
	 *
	 * @return Retorna true se verdadeiro, senão false
	 */
	public static boolean isNumberWithDecimal(final String value) {
		return !Validator.isEmpty(value) && value.matches(PATTERN_NUMBER_WITH_DECIMAL);
	}

	/**
	 * Válida se é um e-mail válido.<br /><br />
	 *
	 * Exemplo de como utilizar:
	 * <pre>
	 * if (Validator.isEmail("email@dominio.com.br")) {
	 *
	 * }
	 * </pre>
	 *
	 * @param value Valor a ser testado do tipo {@link String}
	 *
	 * @return Retorna true se verdadeiro, senão false
	 */
	public static boolean isEmail(final String value) {
		return !Validator.isEmpty(value) && value.matches(PATTERN_EMAIL);
	}

	/**
	 * Válida se é um CPF válido.<br /><br />
	 *
	 * Exemplo de como utilizar:
	 * <pre>
	 * if (Validator.isCpf("222.111.111-98")) {
	 *
	 * }
	 *
	 * if (Validator.isCpf("22211111198")) {
	 *
	 * }
	 * </pre>
	 *
	 * @param value Valor a ser testado do tipo {@link String}
	 *
	 * @return Retorna true se verdadeiro, senão false
	 */
	public static boolean isCpf(final String value) {
		if (Validator.isEmpty(value)) {
			return false;
		}

		return new CPFValidator().invalidMessagesFor(Mask.clearNoDigit(value)).isEmpty();
	}

	/**
	 * Válida se é um CNPJ válido.<br /><br />
	 *
	 * Exemplo de como utilizar:
	 * <pre>
	 * if (Validator.isCnpj("05.123.123/0001-11")) {
	 *
	 * }
	 *
	 * if (Validator.isCnpj("05123123000111")) {
	 *
	 * }
	 * </pre>
	 *
	 * @param value Valor a ser testado do tipo {@link String}
	 *
	 * @return Retorna true se verdadeiro, senão false
	 */
	public static boolean isCnpj(final String value) {
		if (Validator.isEmpty(value) || CNPJ_INVALID.contains(Mask.clearNoDigit(value))) {
			return false;
		}

		return new CNPJValidator().invalidMessagesFor(Mask.clearNoDigit(value)).isEmpty();
	}

	/**
	 * Válida se é um CEP válido.<br /><br />
	 *
	 * Exemplo de como utilizar:
	 * <pre>
	 * if (Validator.isCep("13500-000") {
	 *
	 * }
	 *
	 * if (Validator.isCep("13500000") {
	 *
	 * }
	 * </pre>
	 *
	 * @param value Valor a ser testado do tipo {@link String}
	 *
	 * @return Retorna true se verdadeiro, senão false
	 */
	public static boolean isZipCode(final String value) {
		if (Validator.isEmpty(value)) {
			return false;
		}

		final String zipCode = Mask.clearNoDigit(value);
		return zipCode.length() == ConstantNumeric.EIGHT;
	}

	/**
	 * Valida a inscrição estadual.<br /><br />
	 *
	 * Exemplo de como utilizar:
	 * <pre>
	 * if (Validator.isStateInscription("121-111-222")) {
	 *
	 * }
	 *
	 * if (Validator.isStateInscription("121111222")) {
	 *
	 * }
	 * </pre>
	 *
	 * @param stateInscription Inscrição estadual
	 * @param sigla Sigla do estado
	 *
	 * @return Retorna true se verdadeiro, senão false
	 */
	public static boolean isStateInscription(final String stateInscription, final String sigla) {
		if (Validator.isEmpty(stateInscription) || Validator.isEmpty(sigla)) {
			return false;
		}

		final String inscription = Mask.clear(stateInscription);
		final br.com.caelum.stella.validation.Validator<String> validator;
		switch (sigla.trim().toUpperCase()) {
			case "AC":
				validator = new IEAcreValidator(false);
				break;
			case "AL":
				validator = new IEAlagoasValidator(false);
				break;
			case "AP":
				validator = new IEAmapaValidator(false);
				break;
			case "AM":
				validator = new IEAmazonasValidator(false);
				break;
			case "BA":
				validator = new IEBahiaValidator(false);
				break;
			case "CE":
				validator = new IECearaValidator(false);
				break;
			case "ES":
				validator = new IEEspiritoSantoValidator(false);
				break;
			case "GO":
				validator = new IEGoiasValidator(false);
				break;
			case "MA":
				validator = new IEMaranhaoValidator(false);
				break;
			case "MT":
				validator = new IEMatoGrossoValidator(false);
				break;
			case "MS":
				validator = new IEMatoGrossoDoSulValidator(false);
				break;
			case "MG":
				validator = new IEMinasGeraisValidator(false);
				break;
			case "PA":
				validator = new IEParaValidator(false);
				break;
			case "PB":
				validator = new IEParaibaValidator(false);
				break;
			case "PR":
				validator = new IEParanaValidator(false);
				break;
			case "PE":
				validator = new IEPernambucoValidator(false);
				break;
			case "PI":
				validator = new IEPiauiValidator(false);
				break;
			case "RJ":
				validator = new IERioDeJaneiroValidator(false);
				break;
			case "RN":
				validator = new IERioGrandeDoNorteValidator(false);
				break;
			case "RS":
				validator = new IERioGrandeDoSulValidator(false);
				break;
			case "RO":
				validator = new IERondoniaValidator(false);
				break;
			case "RR":
				validator = new IERoraimaValidator(false);
				break;
			case "SC":
				validator = new IESantaCatarinaValidator(false);
				break;
			case "SP":
				validator = new IESaoPauloValidator(false);
				break;
			case "SE":
				validator = new IESergipeValidator(false);
				break;
			case "TO":
				validator = new IETocantinsValidator(false);
				break;
			case "DF":
				validator = new IEDistritoFederalValidator(false);
				break;
			default:
				return false;
		}

		return validator.invalidMessagesFor(inscription).isEmpty();
	}

	/**
	 * Verificar se extensão do arquivo é permitida para upload.
	 *
	 * @param fileName nome do arquivo a ser verificado
	 * @param permittedExtensions lista de extensões permitidas
	 *
	 * @throws FileInvalidException Tipo de arquivo inválido
	 */
	public static void checkFileType(final String fileName, final List<String> permittedExtensions)
			throws FileInvalidException {
		if (!permittedExtensions.contains(FilenameUtils.getExtension(fileName))) {
			throw new FileInvalidException();
		}
	}

}
