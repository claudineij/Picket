package br.com.waio.erp.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utilitário para aplicação de máscaras.
 *
 * @since 2.0.2
 *
 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
 */
public final class Mask {

	/**
	 * Regex para remover máscara.
	 */
	private static final String PATTERN_CLEAR = "[\\W|_]";

	/**
	 * Regex para remover tudo que não for dígito.
	 */
	private static final String PATTERN_NO_DIGIT = "\\D";

	/**
	 * Regex do CEP sem máscara.
	 */
	private static final String PATTERN_ZIPCODE = "^(\\d{5})(\\d{3})$";

	/**
	 * Regex do telefone com DDD e 9 ou 8 dígitos.
	 */
	private static final String PATTERN_PHONE = "^(\\d{2})(\\d{4,5})(\\d{4})$";

	/**
	 * Pattern do CPF sem máscara.
	 */
	private static final String PATTERN_CPF = "^(\\d{3})(\\d{3})(\\d{3})(\\d{2})$";

	/**
	 * Regex do CNPJ sem máscara.
	 */
	private static final String PATTERN_CNPJ = "^(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})$";

	/**
	 * Regex da placa do veículo sem máscara.
	 */
	private static final String PATTERN_LICENSE_PLATE = "^(\\w{3})(\\d{4})$";

	/**
	 * Máscara a ser aplicada no Pattern.
	 */
	private static final String MASK_CLEAR = "";

	/**
	 * Máscara no formato do CEP.
	 */
	private static final String MASK_ZIPCODE = "$1-$2";

	/**
	 * Máscara no formato de telefone com DDD e 9 ou 8 dígitos.
	 */
	private static final String MASK_PHONE = "($1) $2-$3";

	/**
	 * Máscara no formato do CPF.
	 */
	private static final String MASK_CPF = "$1.$2.$3-$4";

	/**
	 * Máscara no formato do CNPJ.
	 */
	private static final String MASK_CNPJ = "$1.$2.$3/$4-$5";

	/**
	 * Máscara no formato de placa de veículo.
	 */
	private static final String MASK_LICENSE_PLATE = "$1-$2";

	/**
	 * Construtor privado.
	 */
	private Mask() {

	}

	/**
	 * Efetua a limpeza de tudo que não for texto (a-z), números (0-9) e '_'.<br /><br />
	 *
	 * Exemplo de como utilizar:
	 * <pre>
	 * String value = Mask.clear("280.000.000-00"); // return 28000000000
	 * String value2 = Mask.clear(nomeAtributo);
	 * </pre>
	 *
	 * @param value Valor a ser limpo
	 *
	 * @return Valor limpo
	 */
	public static String clear(final String value) {
		String clear = value;
		final Matcher m = Pattern.compile(PATTERN_CLEAR).matcher(clear);
		if (m.find()) {
			clear = m.replaceAll(MASK_CLEAR);
		}

		return clear;
	}

	/**
	 * Efetua a limpeza de tudo que não for dígitos (0-9).<br /><br />
	 *
	 * Exemplo de como utilizar:
	 * <pre>
	 * String value = Mask.clearNoDigit("R$ 200,00"); // return 200000
	 * String value2 = Mask.clearNoDigit(nomeAtributo);
	 * </pre>
	 *
	 * @param value Valor a ser limpo
	 *
	 * @return Valor limpo
	 */
	public static String clearNoDigit(final String value) {
		String clearNoDigit = value;
		final Matcher m = Pattern.compile(PATTERN_NO_DIGIT).matcher(clearNoDigit);
		if (m.find()) {
			clearNoDigit = m.replaceAll(MASK_CLEAR);
		}

		return clearNoDigit;
	}

	/**
	 * Efetua aplicação de máscara para CEP.<br /><br />
	 *
	 * Exemplo de como utilizar:
	 * <pre>
	 * String value = Mask.zipCode("13500123"); // return 13500-123
	 * String value2 = Mask.zipCode(nomeAtributo);
	 * </pre>
	 *
	 * @param value Valor a ser colocado máscara
	 *
	 * @return CEP com máscara
	 */
	public static String zipCode(final String value) {
		String zipCode = value;
		final Matcher m = Pattern.compile(PATTERN_ZIPCODE).matcher(zipCode);
		if (m.find()) {
			zipCode = m.replaceAll(MASK_ZIPCODE);
		}

		return zipCode;
	}

	/**
	 * Efetua aplicação de máscara para telefone.<br /><br />
	 *
	 * Exemplo de como utilizar:
	 * <pre>
	 * String value = Mask.phone("1935551234"); // return (19) 3555-1234
	 * String value = Mask.phone("19935551234"); // return (19) 93555-1234
	 * String value2 = Mask.phone(nomeAtributo);
	 * </pre>
	 *
	 * @param value Valor a ser colocado máscara
	 *
	 * @return Telefone com máscara
	 */
	public static String phone(final String value) {
		String phone = value;
		final Matcher m = Pattern.compile(PATTERN_PHONE).matcher(phone);
		if (m.find()) {
			phone = m.replaceAll(MASK_PHONE);
		}

		return phone;
	}

	/**
	 * Efetua aplicação de máscara para placa de veículo.<br /><br />
	 *
	 * Exemplo de como utilizar:
	 * <pre>
	 * String value = Mask.licensePlate("XXX1111"); // return XXX-1111
	 * String value2 = Mask.licensePlate(nomeAtributo);
	 * </pre>
	 *
	 * @param value Valor a ser colocado máscara
	 *
	 * @return Placa com máscara
	 */
	public static String licensePlate(final String value) {
		String licensePlate = value;
		final Matcher m = Pattern.compile(PATTERN_LICENSE_PLATE).matcher(licensePlate);
		if (m.find()) {
			licensePlate = m.replaceAll(MASK_LICENSE_PLATE);
		}

		return licensePlate;
	}

	/**
	 * Efetua aplicação de máscara para CPF.<br /><br />
	 *
	 * Exemplo de como utilizar:
	 * <pre>
	 * String value = Mask.cpf("12312312312"); // return 123.123.123-12
	 * String value2 = Mask.cpf(nomeAtributo);
	 * </pre>
	 *
	 * @param value Valor a ser colocado máscara
	 *
	 * @return CPF com máscara
	 */
	public static String cpf(final String value) {
		String cpf = value;
		final Matcher m = Pattern.compile(PATTERN_CPF).matcher(cpf);
		if (m.find()) {
			cpf = m.replaceAll(MASK_CPF);
		}

		return cpf;
	}

	/**
	 * Efetua aplicação de máscara para CNPJ.<br /><br />
	 *
	 * Exemplo de como utilizar:
	 * <pre>
	 * String value = Mask.cnpj("05123123000111"); // return 05.123.123/0001-11
	 * String value2 = Mask.cnpj(nomeAtributo);
	 * </pre>
	 *
	 * @param value Valor a ser colocado máscara
	 *
	 * @return CNPJ com máscara
	 */
	public static String cnpj(final String value) {
		String cnpj = value;
		final Matcher m = Pattern.compile(PATTERN_CNPJ).matcher(cnpj);
		if (m.find()) {
			cnpj = m.replaceAll(MASK_CNPJ);
		}

		return cnpj;
	}

}
