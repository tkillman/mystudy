package day1220;

public class Ch14Ex06_1 {

	public static void main(String[] args) {
		
		Atm atm = new Atm(1000);
		User u1 = new User(atm, "�赿��");
		User u2 = new User(atm,"�谡��");
		User u3 = new User(atm,"�輺��");
		User u4 = new User(atm,"�����");
		u1.start();
		u2.start();
		u3.start();
		u4.start();
	}

}

class Atm {

	int money; // �ܾ�

	public Atm(int m) {
		money = m;
	}

	public synchronized void deposit(int amount, String name) { // ���� �Ա��ϴ� �޼ҵ�
		money += amount;
		System.out.println("�Ա��� : " + name + "�Ա� �ݾ� : " + amount);

	} // deposit �޼ҵ� ����

	public synchronized void withdraw(int amount, String name) { // ���� �����ϴ� �޼ҵ�
		if (money > amount) {
			Thread.yield();

			money -= amount;
			System.out.println("����� : " + name + "��� �ݾ� : " + amount);

		} else {
			Thread.yield();
			System.out.println("����� : " + name + "�ܾ��� �����մϴ�.");
		}

	}// withdraw �޼ҵ� ����

	public void getMoney() { // ���� �ܾ��� �˷��ִ� �޼ҵ�
		System.out.println("���� �ܾ��� " +money);
	} // getMoney �޼ҵ� ����

}

class User extends Thread {
	Atm atm;
	String name;
	boolean flag = false;

	public User(Atm atm, String name) {
		this.atm = atm;
		this.name = name;
	}

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			if (flag) {
				atm.deposit((int) (Math.random() * 10 + 2) * 100, name);
				atm.getMoney();
				
			}

			else {
				atm.withdraw((int) (Math.random() * 10 + 2) * 100, name);
				atm.getMoney();
			}
			flag = !flag;
		}

	}// run �޼ҵ� ����

} // Ŭ���� ����