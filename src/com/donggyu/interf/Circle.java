package com.donggyu.interf;

public class Circle implements Dulre{

		int r= 5;
		
	
	@Override
	public void draw() {
		
		System.out.println("원입니다");
	}

	@Override
	public void dul() {
		
		
		System.out.println("원의 둘레는 :" + r*2*Math.PI );
		
	}

	@Override
	public void Area() {
		
		System.out.println("원의 넓이는 :"+ r*r*Math.PI);
		
	}

}
