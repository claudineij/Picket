package br.com.waio.erp.util.bean;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.com.waio.erp.util.EqualsHashCode;

/**
 * Classe para test de equals e hashCode.
 *
 * @since 3.1.1
 *
 * @author <a href="mail:vitor.moraes@w2z.com.br">Vitor de Moraes</a>
 */
public class TestClass extends TestClassExtend implements Serializable {

	/**
	 * Serial version da classe.
	 */
	private static final long serialVersionUID = 5991485790916700982L;

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
	 * Classe filha.
	 */
	private TestClassChild equalsHashCodeClassChild;

	/**
	 * Lista de string.
	 */
	private List<String> strings;

	/**
	 * Lista de classe filha.
	 */
	private List<TestClassChild> equalsHashCodeClassChilds;

	/**
	 * Campo publico.
	 */
	public String fPublic;

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
	 * @return valor do equalsHashCodeClassChild
	 */
	public TestClassChild getEqualsHashCodeClassChild() {
		return equalsHashCodeClassChild;
	}

	/**
	 * @param equalsHashCodeClassChild o valor a ser setado no equalsHashCodeClassChild
	 */
	public void setEqualsHashCodeClassChild(final TestClassChild equalsHashCodeClassChild) {
		this.equalsHashCodeClassChild = equalsHashCodeClassChild;
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

	/**
	 * @return valor do equalsHashCodeClassChilds
	 */
	public List<TestClassChild> getEqualsHashCodeClassChilds() {
		return equalsHashCodeClassChilds;
	}

	/**
	 * @param equalsHashCodeClassChilds o valor a ser setado no equalsHashCodeClassChilds
	 */
	public void setEqualsHashCodeClassChilds(final List<TestClassChild> equalsHashCodeClassChilds) {
		this.equalsHashCodeClassChilds = equalsHashCodeClassChilds;
	}

	@Override
	public int hashCode() {
		return EqualsHashCode.hashCode(this.string, this.wShort, this.wLong, this.wDouble, this.wFloat, this.wInteger,
			this.wBoolean, this.pShort, this.pLong, this.pDouble, this.pFloat, this.pInt, this.pBoolean, this.wDate,
			this.equalsHashCodeClassChild, this.strings, this.equalsHashCodeClassChilds);
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof TestClass) {
			final TestClass equalsHashCodeClass = (TestClass) obj;
			return EqualsHashCode.equalsHelper().append(this.string, equalsHashCodeClass.string)
					.append(this.wShort, equalsHashCodeClass.wShort).append(this.wLong, equalsHashCodeClass.wLong)
					.append(this.wDouble, equalsHashCodeClass.wDouble).append(this.wFloat, equalsHashCodeClass.wFloat)
					.append(this.wInteger, equalsHashCodeClass.wInteger)
					.append(this.wBoolean, equalsHashCodeClass.wBoolean)
					.append(this.pShort, equalsHashCodeClass.pShort).append(this.pLong, equalsHashCodeClass.pLong)
					.append(this.pDouble, equalsHashCodeClass.pDouble).append(this.pFloat, equalsHashCodeClass.pFloat)
					.append(this.pInt, equalsHashCodeClass.pInt).append(this.pBoolean, equalsHashCodeClass.pBoolean)
					.append(this.wDate, equalsHashCodeClass.wDate)
					.append(this.equalsHashCodeClassChild, equalsHashCodeClass.equalsHashCodeClassChild)
					.append(this.strings, equalsHashCodeClass.strings)
					.append(this.equalsHashCodeClassChilds, equalsHashCodeClass.equalsHashCodeClassChilds).isEquals();
		}

		return false;
	}

	/**
	 * Gerar dados para teste.
	 *
	 * @param field Posição do campo
	 *
	 * @return {@code this}
	 */
	public TestClass data(final int field) {
		return data(field, false);
	}

	/**
	 * Gerar dados para teste.
	 *
	 * @param field Posição do campo
	 * @param multiple Valor para gerar objeto diferente
	 *
	 * @return {@code this}
	 */
	public TestClass data(final int field, final boolean multiple) {
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			final Date date = multiple ? sdf.parse("1990-10-4") : sdf.parse("1990-10-5");
			final List<String> stringList = multiple ? Arrays.asList("a", "b", "c", "d") : Arrays.asList("a", "b", "c");
			final String number1 = multiple ? "1" : "11";
			final String number2 = multiple ? "2" : "22";
			final String number3 = multiple ? "3" : "33";
			final String number4 = multiple ? "4" : "44";
			final String number5 = multiple ? "5" : "55";
			final String number6 = multiple ? "6" : "66";

			final TestClassChild child = new TestClassChild();
			child.setString("Teste EqualsHashCodeClassChild" + multiple);
			child.setwShort(Short.valueOf(number1));
			child.setwLong(Long.valueOf(number1));
			child.setwDouble(Double.valueOf(number1 + ".6"));
			child.setwFloat(Float.valueOf(number1 + ".6"));
			child.setwInteger(Integer.valueOf(number1));
			child.setwBoolean(multiple);
			child.setpShort(Short.valueOf(number2));
			child.setpLong(Long.valueOf(number2));
			child.setpDouble(Double.valueOf(number2 + ".6"));
			child.setpFloat(Float.valueOf(number2 + ".6"));
			child.setpInt(Integer.valueOf(number2));
			child.setpBoolean(multiple);
			child.setwDate(date);
			child.setStrings(stringList);

			final TestClassChild child2 = new TestClassChild();
			child2.setString("Teste EqualsHashCodeClassChild" + multiple);
			child2.setwShort(Short.valueOf(number3));
			child2.setwLong(Long.valueOf(number3));
			child2.setwDouble(Double.valueOf(number3 + ".6"));
			child2.setwFloat(Float.valueOf(number3 + ".6"));
			child2.setwInteger(Integer.valueOf(number3));
			child2.setwBoolean(multiple);
			child2.setpShort(Short.valueOf(number4));
			child2.setpLong(Long.valueOf(number4));
			child2.setpDouble(Double.valueOf(number4 + ".6"));
			child2.setpFloat(Float.valueOf(number4 + ".6"));
			child2.setpInt(Integer.valueOf(number4));
			child2.setpBoolean(multiple);
			child2.setwDate(date);
			child.setStrings(stringList);

			final List<TestClassChild> childs = new ArrayList<>();
			childs.add(child2);

			final Map<String, Object> values = new LinkedHashMap<>();
			values.put("string", "teste" + multiple);
			values.put("wShort", Short.valueOf(number5));
			values.put("wLong", Long.valueOf(number5));
			values.put("wDouble", Double.valueOf(number5 + ".6"));
			values.put("wFloat", Float.valueOf(number5 + ".6"));
			values.put("wInteger", Integer.valueOf(number5));
			values.put("wBoolean", multiple);
			values.put("pShort", Short.valueOf(number6));
			values.put("pLong", Long.valueOf(number6));
			values.put("pDouble", Double.valueOf(number6 + ".6"));
			values.put("pFloat", Float.valueOf(number6 + ".6"));
			values.put("pInt", Integer.valueOf(number6));
			values.put("pBoolean", multiple);
			values.put("wDate", date);
			values.put("equalsHashCodeClassChild", child);
			values.put("strings", stringList);
			values.put("equalsHashCodeClassChilds", childs);
			values.put("fPublic", "fPublic");

			setfExtend("fExtend");

			final List<String> keys = new ArrayList<>(values.keySet());
			final int init = (field == -1) ? 0 : field;
			final int total = (field == -1) ? keys.size() : field + 1;
			final Class<? extends TestClass> obj = this.getClass();
			for (int i = init; i < total; i++) {
				final String key = keys.get(i);
				final Field f = obj.getDeclaredField(key);
				f.setAccessible(true);
				f.set(this, values.get(key));
			}
		} catch (ParseException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException
				| SecurityException e) {
			e.printStackTrace();
		}

		return this;
	}

}
