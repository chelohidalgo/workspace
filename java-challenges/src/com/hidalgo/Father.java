package com.hidalgo;

public class Father {
	
	protected Son son;
	
	public Father(int counter) {
		if(counter < 1000){
			System.out.println("iteration: " + counter);
			counter ++;
			son = new Son(counter);
		}
	}
	
	public Father() {
	}
	
	public static int iterate(int counter){
		if(counter < 1000){
			System.out.println("iteration: " + counter);
			counter ++;
			return iterate(counter);
		} else {
			return counter;
		}
	}

}
