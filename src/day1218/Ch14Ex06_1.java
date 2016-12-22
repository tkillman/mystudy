package day1218;

public class Ch14Ex06_1 {

	public static void main(String[] args) {
		Atm1 atm = new Atm1(1000);
		User u1 = new User(atm, "�赿��");
		User u2 = new User(atm, "�谡��");
		User u3 = new User(atm, "�ƺ�");

		u1.start();
		u2.start();
		u3.start();
	}

}

class Atm1 {

	int money; // �ܾ�

	public Atm1(int amount) {
		money = amount; // �ʱ� �Ա� �ݾ�
	}

	public void deposit(int m, String name) {

		money += m;
		System.out.println("�Ա��� : " + name + "�Ա� �ݾ� : " + m);
	}

	public void withdraw(int m, String name) {

		if (money > m) {
			Thread.yield();
			money -= m;
			System.out.println("����� : " + name + "��� �ݾ� : " + m);

		} else {

			System.out.println("�ܾ� ����");
		}

	}// withdraw �޼ҵ� ����

	public void getMoney() {
		System.out.println("���� �ܾ��� : " + money);
	}

}

class User extends Thread {
	Atm1 obj;
	boolean flag = false;
	
	public User(Atm1 obj, String name) {
		super(name);
		this.obj = obj;

	}

	@Override
	public void run() {
		
		
	for(int i=0;i<5;i++){	
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (flag) {
			obj.deposit((int) (Math.random() * 10 + 2) * 100, getName());
			
		} else {
			obj.withdraw((int) (Math.random() * 10 + 2) * 100, getName());
			

		}
		obj.getMoney();
		flag = !flag;
	}
		

	}

}