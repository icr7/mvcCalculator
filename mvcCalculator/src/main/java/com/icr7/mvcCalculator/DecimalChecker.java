package com.icr7.mvcCalculator;

public class DecimalChecker {
	public Boolean isInteger(String s) {
		double d = Double.parseDouble(s);
		double diffrence = d - (int) d;
		if (diffrence == 0) {
			return true;
		}

		return false;

	}
}
