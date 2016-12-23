package day1221;

public class Thread1 extends Thread {

	@Override
	public void run() {

		for (long i = 0; i < 1000000000; i++) {
		}

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (long i = 0; i < 1000000000; i++) {
		}

	}

}
