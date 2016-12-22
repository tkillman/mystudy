package day1218;

public class Ch14Ex06_1 {

	public static void main(String[] args) {
		Atm1 atm = new Atm1(1000);
		User u1 = new User(atm, "김동규");
		User u2 = new User(atm, "김가원");
		User u3 = new User(atm, "아빠");

		u1.start();
		u2.start();
		u3.start();
	}

}

class Atm1 {

	int money; // 잔액

	public Atm1(int amount) {
		money = amount; // 초기 입금 금액
	}

	public void deposit(int m, String name) {

		money += m;
		System.out.println("입금자 : " + name + "입금 금액 : " + m);
	}

	public void withdraw(int m, String name) {

		if (money > m) {
			Thread.yield();
			money -= m;
			System.out.println("출금자 : " + name + "출금 금액 : " + m);

		} else {

			System.out.println("잔액 부족");
		}

	}// withdraw 메소드 종료

	public void getMoney() {
		System.out.println("현재 잔액은 : " + money);
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