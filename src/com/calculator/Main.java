package com.calculator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

//		int principal = 0;
//		float annualInterest = 0;
//		byte years = 0;

		Scanner scanner = new Scanner(System.in);

		int principal = (int) readNumber("Principal", 1000, 1_000_000);
//		while (true) {
//			System.out.print("Principal: ");
//			principal = scanner.nextInt();
//			if (principal >= 1000 && principal <= 1_000_000)
//				break;
//			System.out.println("Enter a value between 1000 and 1000000 ");
//		}

		float annualInterest = (float) readNumber("Annual Interest Rate:", 1, 30);
//		while (true) {
//			System.out.print("Annual Interest Rate: ");
//			annualInterest = scanner.nextFloat(); // Always use descriptive and meaningful names
//			if (annualInterest >= 1 && annualInterest <= 30)
//				break;
//			System.out.println("Enter a value between 0 and 30");
//		}

		byte years = (byte) readNumber("Period (Years): ", 1, 30);
//		while (true) {
//			System.out.print("Period (Years): ");
//			years = scanner.nextByte();
//			if (years >= 1 && years <= 30)
//				break;
//			System.out.println("Enter a value between 1 and 30");
//		}

		calculateMortgage(principal, annualInterest, years);

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
		return mortgage;

	}

}
