package chatting;

public class Moneyput {

	
	
	public static void main(String[] args) {
	/*	
		Money m;  /// Money Ŭ������    m�� ���۷�������  Ŭ�� 
		
		new Money(); /// �ν��Ͻ�    Money Ŭ������ �ν��Ͻ�
		*/
		
		
		Money m = new Money();   //// ��ü  == ���۷������� + �ν��Ͻ�
		
		
		m.sum(1000);     // ���� 
		/* System.out.println(m.count);
		 System.out.println(m.total);
		 */
		 Money m1 = new Money();
		 //��ü�� �ϳ� �� �����.
		 // ���۷������� m1
		 //�ν��Ͻ��� Money
		 
		 m1.sum(1000);
		System.out.println(m1.count);
		
		System.out.println(m1.total);
		
		
		Money.sum1(); 
		
		
	}
	
	
}
