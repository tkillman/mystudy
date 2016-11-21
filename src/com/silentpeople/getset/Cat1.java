package com.silentpeople.getset;

public class Cat1 {
	
	int age;
	String name;
	
	private String spices;
	public  int price;
	static int catCount;
	
	
	
	public void setAge(int age){
		
		this.age=age;
		
	}
	
	public int getAge(){
		
		return this.age;
		
	}

	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		
		this.name = name;
	}

	

	public String getSpices() {
		return spices;
	}

	public void setSpices(String spices) {
		this.spices = spices;
	}

	public int getCatCount() {
		return catCount;
	}

	public void setCatCount(int catCount) {
		this.catCount = catCount;
	}

	
	
	
	
	
}
