package com.react.kodbook.entities;

public class Data {
	String data1;
	String data2;
	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Data(String data1, String data2) {
		super();
		this.data1 = data1;
		this.data2 = data2;
	}
	public String getData1() {
		return data1;
	}
	public void setData1(String data1) {
		this.data1 = data1;
	}
	public String getData2() {
		return data2;
	}
	public void setData2(String data2) {
		this.data2 = data2;
	}
	@Override
	public String toString() {
		return "Data [data1=" + data1 + ", data2=" + data2 + "]";
	}
}
