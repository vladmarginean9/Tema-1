package model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Monom {
	private double coeficient;
	int putere;

	public Monom(double coeficient, int putere) {
		this.coeficient = coeficient;
		this.putere = putere;
	}

	public double getCoeficient() {
		return this.coeficient;
	}

	public void setCoeficient(double coef) {
		this.coeficient = coef;
	}

	public int getPutere() {
		return this.putere;
	}

	@Override
	public String toString() {
		DecimalFormatSymbols customSymbols = new DecimalFormatSymbols(
				Locale.getDefault());
		customSymbols.setDecimalSeparator('.');
		DecimalFormat customFormat = new DecimalFormat("#.###", customSymbols);
		String sign = "", coef = "", exponent = "";
		/*
		 * Creem stringul reprezentand semnul monomului
		 */
		if (this.coeficient < 0) {
			sign = "-";
		} else {
			sign = "+";
		}
		/*
		 * Creem stringul reprezentand coeficientul
		 */
		if (Math.abs(coeficient) != 1) {
			coef = customFormat.format(Math.abs(this.coeficient));
		}
		/*
		 * Creem X^exponent
		 */
		if (this.putere == 1) {
			exponent = "x";
		} else if (this.putere != 0) {
			exponent = "x^" + customFormat.format(this.putere);
		} else {
			coef = customFormat.format(Math.abs(this.coeficient));
		}
		
		if (this.coeficient != 0) {
			return sign + coef + exponent;
		}
		else {
			return "";
		}
	}
}
