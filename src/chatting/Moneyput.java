package chatting;

public class Moneyput {

	
	
	public static void main(String[] args) {
	/*	
		Money m;  /// Money 클래스의    m이 래퍼런스변수  클라스 
		
		new Money(); /// 인스턴스    Money 클래스의 인스턴스
		*/
		
		
		Money m = new Money();   //// 객체  == 래퍼런스변수 + 인스턴스
		
		
		m.sum(1000);     // 인자 
		/* System.out.println(m.count);
		 System.out.println(m.total);
		 */
		 Money m1 = new Money();
		 //객체를 하나 더 만든다.
		 // 래퍼런스변수 m1
		 //인스턴스는 Money
		 
		 m1.sum(1000);
		System.out.println(m1.count);
		
		System.out.println(m1.total);
		
		
		Money.sum1(); 
		
		
	}
	
	
}
