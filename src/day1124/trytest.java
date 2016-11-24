package day1124;

public class trytest {

	
	public static void main(String[] args) {
		
		try {
			오류가 날만한 코드를 쓰면 그 오류 나면 캐치로 넘어가
			
			for(int i=0; i<10000; i++){
			
				System.out.println(4/0);}
		
		} catch (Exception e) {
			
		System.out.println(e.getMessage());	
		
		}
		
		
	}
	
	
}
