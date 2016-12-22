package day1218;

public class Circle extends Shape implements Drawable{
	
	double r =5;
	double res;
	int c;
	
	
	@Override
	public double area() {
		// TODO Auto-generated method stub
		
		res = r*r*Math.PI;
		
		return res;
		
 		
	}

	@Override
	public int getColor() {
		// TODO Auto-generated method stub
		return c;
	}

	@Override
	public void setColor(int c) {
		// TODO Auto-generated method stub
		this.c=c;
	}
	
	
	

}
