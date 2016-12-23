package day1219;

public class Ch14Ex06 {

	public static void main(String[] args) {
		
		Bank bank = new Bank(1000);
		user u1 = new user(bank, "�赿��");
		user u2 = new user(bank, "�ֺ���");
		user u3 = new user(bank, "����ö");
		
		u1.start();
		u2.start();
		u3.start();
		
	}

}

class Bank {

	int money; // �ܵ�

	public Bank(int m) {
		money = m;
	}// ���� ����

	public synchronized void deposit(int amount, String name) {
		money += amount;
		System.out.println("�Ա��� : " + name + "�Ա� �ݾ� : " + amount);

	}

	public synchronized void withdraw(int amount, String name) {

		if (money > amount) {
			Thread.yield();
			money -= amount;
			System.out.println("����� : " + name + "��� �ݾ� : " + amount);

		} else {
			Thread.yield();
			System.out.println("����� : " + name + "��� �Ұ� (�ܾ� ����)");

		}

	} // withdraw �޼ҵ� ����

	public void getMoney() {
		System.out.println("���� �ܾ� : " + money);
	}

}

class user extends Thread {

	Bank bank;
	boolean flag = false;

	public user(Bank bank, String name) {
		super(name);
		this.bank = bank;

	}

	@Override
	public void run() {

		try {
			Thread.sleep(500);

		} catch (Exception e) {
			// TODO: handle exception
		}

		for (int i = 0; i < 10; i++) {

			if (flag) {
				bank.deposit((int) (Math.random() * 10 + 2) * 100, getName());
				bank.getMoney();
			} else {
				bank.withdraw((int) (Math.random() * 10 + 2) * 100, getName());
				bank.getMoney();
			}
			flag = !flag;
		}

	}

}