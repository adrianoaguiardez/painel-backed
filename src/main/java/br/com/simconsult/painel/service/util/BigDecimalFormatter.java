package br.com.simconsult.painel.service.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class BigDecimalFormatter {
	public final static int SCALE = 2;
	public final static RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;
	private DecimalFormat decimalFormat;

	public BigDecimalFormatter(String pattern) {
		NumberFormat format = NumberFormat.getInstance(Locale.US);
		decimalFormat = (DecimalFormat) format;
		decimalFormat.setParseBigDecimal(true);
		decimalFormat.applyPattern("#,##0.###");
	}

	/**
	 * 
	 * @param priceInCents valor em string e em centesimos. Ex: 2050=20.50
	 * @return
	 */
	public BigDecimal stringInCentsToBigDecimal(String priceInCents) {
		return new BigDecimal(priceInCents).divide(new BigDecimal(100)).setScale(SCALE, ROUNDING_MODE);
	}

	public String bigDecimalToStringInCents(BigDecimal value) {
		return String.format("%.0f", value.multiply(new BigDecimal(100)));
	}

	/**
	 * 
	 * @param valor
	 * @return retorna o BigDecimal normalizado com scale=2 e RoundingMode=HALF_EVEN
	 */
	public BigDecimal normalizaBigDecimal(BigDecimal valor) {
		return valor.setScale(SCALE, ROUNDING_MODE);
	}

	public BigDecimal normalizaBigDecimalReais(BigDecimal valor) {
		return valor.setScale(2, ROUNDING_MODE);
	}

	public BigDecimal parse(String text, Locale locale) {
		BigDecimal big = null;
		try {
			big = (BigDecimal) decimalFormat.parse(text);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return big;
	}

	public static BigDecimal normalizaBigDecimalReaisDuasCasa(BigDecimal minimo) {
		return minimo.setScale(2, ROUNDING_MODE);

	}

	public static BigDecimal normalizaBigDecimalReaisQuatroCasa(BigDecimal minimo) {
		return minimo.setScale(4, ROUNDING_MODE);

	}

	public static String normalizaBigDecimalReaisDuasCasaT(BigDecimal minimo) {

		NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
		DecimalFormat df = (DecimalFormat) nf;
		df.applyPattern("#,##0.###");

		return df.format(minimo);

	}

	public static double converte(String minimo) {
		NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
		// converte um número com vírgulas ex: 2,56 para double
		double number = 0;
		try {
			number = nf.parse(minimo).doubleValue();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;
	}

}
