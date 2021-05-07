package com.dopang.machine.equitytrading.enumeration;


public enum Exchange {

	NSE(1, "National Stock Exchange"),
	BSE(2, "Bombay Stock Exchange");
	
	private int key;
	private String value;
	
	private Exchange(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
