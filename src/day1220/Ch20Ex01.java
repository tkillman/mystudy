package day1220;

public class Ch20Ex01 {
	
	public static void main(String[] args) {
		
		int data =0;
		try {
			System.out.println("문자를 입력해보세요");
			while((data = System.in.read()) != -1){
				
				
				System.out.println((char)data);
				
				
			}	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
