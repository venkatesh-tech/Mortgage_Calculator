package com.calculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int principal = (int) readNumber("Principal ", 1000, 1_000_000);
		float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
		byte years = (byte) readNumber("Period (Years): ", 1, 30);

		System.out.println(calculateMortgage(principal, annualInterest, years));

	}

	public static double readNumber(String prompt, double min, double max) {
		Scanner scanner = new Scanner(System.in);
		double value;
		while (true) {
			System.out.print(prompt);
			value = scanner.nextFloat(); // Always use descriptive and meaningful names
			if (value >= min && value <= max)
				break;
			System.out.println("Enter a value between " + min + " and " + max + "");
		}
		return value;
	}

	public static double calculateMortgage(int principal, float annualInterest, byte years) {

		final byte MONTHS_IN_YEAR = 12; // Always use constants like these do not use numbers directly
		final byte PERCENT = 100;

		float monthlyInterest = 0;
		short numberOfPayments = 0;

		monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
		numberOfPayments = (short) (years * MONTHS_IN_YEAR);

		double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
				/ (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

		String calcMortgage = NumberFormat.getCurrencyInstance().format(mortgage);

		System.out.println(calcMortgage);

		return (Double) null;

	}

}
