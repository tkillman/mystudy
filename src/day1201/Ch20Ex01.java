package day1201;

public class Ch20Ex01 {
	
	
	public static void main(String[] args) {
		
		System.out.println("입력하세요");
		
		try {
			int data =0;
			System.out.println(data);
			while( (data = System.in.read()) != -1){
				System.out.print((char)data);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		
		
		
		
		
	}
	
	
}
