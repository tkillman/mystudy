package com.silentpeople.getset;

public class Cat1 {
	
	int age;
	String name;
	static int salary;
	private String spices;
	public static int price;
	
	
	
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

	public static int getSalary() {
		return salary;
	}

	public static void setSalary(int salary) {
		Cat1.salary = salary;
	}

	public String getSpices() {
		return spices;
	}

	public void setSpices(String spices) {
		this.spices = spices;
	}

	
	
	
	
	
}
