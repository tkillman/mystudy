package day1218;

public class Ch14Ex06 {

	public static void main(String[] args) {
		
		Atm obj = new Atm(1000);
		AtmUser user1 = new AtmUser(obj, "한석희");
		AtmUser user2 = new AtmUser(obj, "유명화");
		AtmUser user3 = new AtmUser(obj, "이복정");

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
		System.out.println("입금자 : " + name + "입금 금액 : " + amount);
	}

	synchronized void withdraw(int amount, String name) {

		if (money > amount) {
			Thread.yield();
			money -= amount;
			System.out.println("출금자 : " + name + " 출금 금액 :" + amount);
	
		} else {
			Thread.yield();
			System.out.println("잔액 부족");
		}
	} // withdraw 메소드 종료

	public void getMoney() {
		System.out.println("현재 잔액은 : " + money);
	}

} // Atm 클라스 종료

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
