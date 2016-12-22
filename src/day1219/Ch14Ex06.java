package day1219;

public class Ch14Ex06 {

	public static void main(String[] args) {
		
		Bank bank = new Bank(1000);
		user u1 = new user(bank, "김동규");
		user u2 = new user(bank, "최빛찬");
		user u3 = new user(bank, "김인철");
		
		u1.start();
		u2.start();
		u3.start();
		
	}

}

class Bank {

	int money; // 잔돈

	public Bank(int m) {
		money = m;
	}// 통장 개설

	public synchronized void deposit(int amount, String name) {
		money += amount;
		System.out.println("입금자 : " + name + "입금 금액 : " + amount);

	}

	public synchronized void withdraw(int amount, String name) {

		if (money > amount) {
			Thread.yield();
			money -= amount;
			System.out.println("출금자 : " + name + "출금 금액 : " + amount);

		} else {
			Thread.yield();
			System.out.println("출금자 : " + name + "출금 불가 (잔액 부족)");

		}

	} // withdraw 메소드 종료

	public void getMoney() {
		System.out.println("현재 잔액 : " + money);
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