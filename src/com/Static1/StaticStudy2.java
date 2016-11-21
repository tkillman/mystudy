package com.Static1;

public class StaticStudy2 {
	
	static double pi = 3.14;
	int left, right;
	static int base=0;
	
	public void setInt(int left,int right){
		this.left = left;
		this.right = right;
		
	}
	
	
	public void sum(){
		
		System.out.println(this.left+this.right+base);
	}
	
	public void avg(){
		System.out.println((this.left+this.right)/2 + base);
		
	}
	
	public static void main(String[] args) {
		
		StaticStudy2 s1= new StaticStudy2();
		
	System.out.println(s1.pi);
	
	StaticStudy2 s2= new StaticStudy2();
	
	System.out.println(s2.pi);
	
	System.out.println(StaticStudy2.pi);
	
	s1.setInt(8, 10);
	s1.sum();
	s1.avg();
	
	StaticStudy2.base = 20;
	s1.sum();
	s1.avg();
		
	}
	

}
