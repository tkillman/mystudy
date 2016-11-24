package day1124;

public class Thred extends Thread {

	
	
	public Thred(String name){
		System.out.println("Thread Created!!");
		
	}
	
	
	
	
	public void run(){
		
		for(int count=0;count<100000;count++){
		System.out.println(getName()+ " :Attack" + count);
		
	
		
		
		}
	}
	
	
}
