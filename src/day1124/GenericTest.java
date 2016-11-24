package day1124;



class Car<T>{
	
	private T description;
	
	
	
	public T getDescription() {
		return description;
	}



	public void setDescription(T description) {
		this.description = description;
	}



	public void carInfoPrint(){
		System.out.println(description);
		
	}
	
	
}










public class GenericTest {
	
	public static void main(String[] args) {
		
		Car<Integer> truck = new Car<Integer>();
		Car<String>	bungbung = new Car<String>();	
				
		
				truck.setDescription(100);
				truck.carInfoPrint();
				
				
				bungbung.setDescription("ºÀ°í");
				bungbung.carInfoPrint();
				
		
	}
	
	

}
