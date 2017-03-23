package com.hidalgo;

public class Son {

	public static int max_value;

	public Son() {
		iterate(1);
	}
	public Son(int counter) {
		max_value = counter;
		Father father = new Father(counter);
	}
	
	public void iterate(int counter){
		if(counter <= 1000){
			System.out.println("iteration: " + counter);
			max_value = counter;
			counter ++;
			iterate2(counter);
		}
	}
	
	public void iterate2(int counter){
		if(counter <= 1000){
			System.out.println("iteration: " + counter);
			max_value = counter;
			counter ++;
			iterate(counter);
		}
	}
}
