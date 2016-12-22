package day1220;

public class Ch14Ex06_1 {

	public static void main(String[] args) {
		
		Atm atm = new Atm(1000);
		User u1 = new User(atm, "김동규");
		User u2 = new User(atm,"김가원");
		User u3 = new User(atm,"김성옥");
		User u4 = new User(atm,"김재명");
		u1.start();
		u2.start();
		u3.start();
		u4.start();
	}

}

class Atm {

	int money; // 잔액

	public Atm(int m) {
		money = m;
	}

	public synchronized void deposit(int amount, String name) { // 돈을 입금하는 메소드
		money += amount;
		System.out.println("입금자 : " + name + "입금 금액 : " + amount);

	} // deposit 메소드 종료

	public synchronized void withdraw(int amount, String name) { // 돈을 인출하는 메소드
		if (money > amount) {
			Thread.yield();

			money -= amount;
			System.out.println("출금자 : " + name + "출금 금액 : " + amount);

		} else {
			Thread.yield();
			System.out.println("출금자 : " + name + "잔액이 부족합니다.");
		}

	}// withdraw 메소드 종료

	public void getMoney() { // 현재 잔액을 알려주는 메소드
		System.out.println("현재 잔액은 " +money);
	} // getMoney 메소드 종료

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

	}// run 메소드 종료

} // 클래스 종료