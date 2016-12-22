package day1218;

public class Ch14Ex06 {

	public static void main(String[] args) {
		
		Atm obj = new Atm(1000);
		AtmUser user1 = new AtmUser(obj, "�Ѽ���");
		AtmUser user2 = new AtmUser(obj, "����ȭ");
		AtmUser user3 = new AtmUser(obj, "�̺���");

		user1.start();
		user2.start();
		user3.start();
	}

}

class Atm {
	
	private int money;

	public Atm(int m) {
		money = m;
	}

	synchronized void deposit(int amount, String name) {
		money += amount;
		System.out.println("�Ա��� : " + name + "�Ա� �ݾ� : " + amount);
	}

	synchronized void withdraw(int amount, String name) {

		if (money > amount) {
			Thread.yield();
			money -= amount;
			System.out.println("����� : " + name + " ��� �ݾ� :" + amount);
	
		} else {
			Thread.yield();
			System.out.println("�ܾ� ����");
		}
	} // withdraw �޼ҵ� ����

	public void getMoney() {
		System.out.println("���� �ܾ��� : " + money);
	}

} // Atm Ŭ�� ����

class AtmUser extends Thread {
	boolean flag = false;
	Atm obj;

	public AtmUser(Atm obj, String name) {
		super(name);
		this.obj = obj;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			if (flag) {
				obj.deposit((int)(Math.random()*10+2)*100 , getName());
				obj.getMoney();
			} else {
				obj.withdraw((int)(Math.random()*10+2)*100, getName());
				obj.getMoney();
			}
			flag = !flag;

		}

	}

}
