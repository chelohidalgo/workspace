package com.merchant;

import com.merchant.util.Constants;

public class CurrentLine {
	
	private String name;
	private String value;
	private boolean isConvertion;
	
	public boolean currentLineisConvertion() {
		return isConvertion;
	}

	public void setConvertion(boolean isConvertion) {
		this.isConvertion = isConvertion;
	}

	public CurrentLine(String name, String value) {
		this.name = name;
		this.value = value;
		if(name.contains(Constants.WORD_HOW) 
				|| name.contains(Constants.WORD_HOW.toLowerCase()) 
				|| name.contains(Constants.WORD_HOW.toUpperCase())) {
			setConvertion(true);
			this.name = value;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "CurrentLine [name=" + name + ", value=" + value + ", isConvertion=" + isConvertion + "]";
	}

}
