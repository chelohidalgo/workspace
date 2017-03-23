package com.hidalgo;

public class Divison {

	/**
	 * <b> Using definition for divison followig wikipedia "dividend =
	 * divisor \ quotient + rest".</b>
	 * 
	 * @author chelohidalgo
	 */
	public double divide(int dividend, int divisor) {
		if (divisor == 0) 
			return 0;
		double outcome = 0;
		
		if(divisor <= dividend){
			outcome ++;
			return outcome + divide(dividend - divisor ,divisor);
		} else if (dividend > 0){
			dividend *=10;
			return outcome + 0.1 * divide(dividend, divisor); 
		} else {
			return 0;
		}
	}
	
	public double divide2(double numerator, double denominator) 
	{ 
	double temp = 1.0; 

	if (numerator == 0) 
	return 0; 

	if (numerator < denominator) 
	{ 
	numerator *= 10; 
	temp = 0.1 * divide2(numerator, denominator); 
	numerator = denominator; 
	} 

	return temp + divide2(numerator - denominator, denominator); 
	}

}
