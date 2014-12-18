package br.com.waio.erp.util.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.waio.erp.util.EqualsHashCode;

/**
 * Classe filha para test de equals e hashCode.
 *
 * @since 3.1.1
 *
 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
 */
public class TestClassChild implements Serializable {

	/**
	 * Serial version da classe.
	 */
	private static final long serialVersionUID = 4463836869248479097L;

	/**
	 * String.
	 */
	private String string;

	/**
	 * Short Wrapper.
	 */
	private Short wShort;

	/**
	 * Long Wrapper.
	 */
	private Long wLong;

	/**
	 * Double Wrapper.
	 */
	private Double wDouble;

	/**
	 * Flaot Wrapper.
	 */
	private Float wFloat;

	/**
	 * Integer Wrapper.
	 */
	private Integer wInteger;

	/**
	 * Boolean Wrapper.
	 */
	private Boolean wBoolean;

	/**
	 * Short primitive.
	 */
	private short pShort;

	/**
	 * Long primitive.
	 */
	private long pLong;

	/**
	 * Double primitive.
	 */
	private double pDouble;

	/**
	 * Float primitive.
	 */
	private float pFloat;

	/**
	 * Int primitive.
	 */
	private int pInt;

	/**
	 * Boolean primitive.
	 */
	private boolean pBoolean;

	/**
	 * Date.
	 */
	private Date wDate;

	/**
	 * Lista de string.
	 */
	private List<String> strings;

	/**
	 * @return valor do string
	 */
	public String getString() {
		return string;
	}

	/**
	 * @param string o valor a ser setado no string
	 */
	public void setString(final String string) {
		this.string = string;
	}

	/**
	 * @return valor do wShort
	 */
	public Short getwShort() {
		return wShort;
	}

	/**
	 * @param wShort o valor a ser setado no wShort
	 */
	public void setwShort(final Short wShort) {
		this.wShort = wShort;
	}

	/**
	 * @return valor do wLong
	 */
	public Long getwLong() {
		return wLong;
	}

	/**
	 * @param wLong o valor a ser setado no wLong
	 */
	public void setwLong(final Long wLong) {
		this.wLong = wLong;
	}

	/**
	 * @return valor do wDouble
	 */
	public Double getwDouble() {
		return wDouble;
	}

	/**
	 * @param wDouble o valor a ser setado no wDouble
	 */
	public void setwDouble(final Double wDouble) {
		this.wDouble = wDouble;
	}

	/**
	 * @return valor do wFloat
	 */
	public Float getwFloat() {
		return wFloat;
	}

	/**
	 * @param wFloat o valor a ser setado no wFloat
	 */
	public void setwFloat(final Float wFloat) {
		this.wFloat = wFloat;
	}

	/**
	 * @return valor do wInteger
	 */
	public Integer getwInteger() {
		return wInteger;
	}

	/**
	 * @param wInteger o valor a ser setado no wInteger
	 */
	public void setwInteger(final Integer wInteger) {
		this.wInteger = wInteger;
	}

	/**
	 * @return valor do wBoolean
	 */
	public Boolean getwBoolean() {
		return wBoolean;
	}

	/**
	 * @param wBoolean o valor a ser setado no wBoolean
	 */
	public void setwBoolean(final Boolean wBoolean) {
		this.wBoolean = wBoolean;
	}

	/**
	 * @return valor do pShort
	 */
	public short getpShort() {
		return pShort;
	}

	/**
	 * @param pShort o valor a ser setado no pShort
	 */
	public void setpShort(final short pShort) {
		this.pShort = pShort;
	}

	/**
	 * @return valor do pLong
	 */
	public long getpLong() {
		return pLong;
	}

	/**
	 * @param pLong o valor a ser setado no pLong
	 */
	public void setpLong(final long pLong) {
		this.pLong = pLong;
	}

	/**
	 * @return valor do pDouble
	 */
	public double getpDouble() {
		return pDouble;
	}

	/**
	 * @param pDouble o valor a ser setado no pDouble
	 */
	public void setpDouble(final double pDouble) {
		this.pDouble = pDouble;
	}

	/**
	 * @return valor do pFloat
	 */
	public float getpFloat() {
		return pFloat;
	}

	/**
	 * @param pFloat o valor a ser setado no pFloat
	 */
	public void setpFloat(final float pFloat) {
		this.pFloat = pFloat;
	}

	/**
	 * @return valor do pInt
	 */
	public int getpInt() {
		return pInt;
	}

	/**
	 * @param pInt o valor a ser setado no pInt
	 */
	public void setpInt(final int pInt) {
		this.pInt = pInt;
	}

	/**
	 * @return valor do pBoolean
	 */
	public boolean ispBoolean() {
		return pBoolean;
	}

	/**
	 * @param pBoolean o valor a ser setado no pBoolean
	 */
	public void setpBoolean(final boolean pBoolean) {
		this.pBoolean = pBoolean;
	}

	/**
	 * @return valor do wDate
	 */
	public Date getwDate() {
		return wDate;
	}

	/**
	 * @param wDate o valor a ser setado no wDate
	 */
	public void setwDate(final Date wDate) {
		this.wDate = wDate;
	}

	/**
	 * @return valor do strings
	 */
	public List<String> getStrings() {
		return strings;
	}

	/**
	 * @param strings o valor a ser setado no strings
	 */
	public void setStrings(final List<String> strings) {
		this.strings = strings;
	}

	@Override
	public int hashCode() {
		return EqualsHashCode.hashCode(this.string, this.wShort, this.wLong, this.wDouble, this.wFloat, this.wInteger,
			this.wBoolean, this.pShort, this.pLong, this.pDouble, this.pFloat, this.pInt, this.pBoolean, this.wDate,
			this.strings);
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof TestClassChild) {
			final TestClassChild equalsHashCodeClassChild = (TestClassChild) obj;
			return EqualsHashCode.equalsHelper()
					.append(this.string, equalsHashCodeClassChild.string)
					.append(this.wShort, equalsHashCodeClassChild.wShort)
					.append(this.wLong, equalsHashCodeClassChild.wLong)
					.append(this.wDouble, equalsHashCodeClassChild.wDouble)
					.append(this.wFloat, equalsHashCodeClassChild.wFloat)
					.append(this.wInteger, equalsHashCodeClassChild.wInteger)
					.append(this.wBoolean, equalsHashCodeClassChild.wBoolean)
					.append(this.pShort, equalsHashCodeClassChild.pShort)
					.append(this.pLong, equalsHashCodeClassChild.pLong)
					.append(this.pDouble, equalsHashCodeClassChild.pDouble)
					.append(this.pFloat, equalsHashCodeClassChild.pFloat)
					.append(this.pInt, equalsHashCodeClassChild.pInt)
					.append(this.pBoolean, equalsHashCodeClassChild.pBoolean)
					.append(this.wDate, equalsHashCodeClassChild.wDate)
					.append(this.strings, equalsHashCodeClassChild.strings).isEquals();
		}

		return false;
	}

}
