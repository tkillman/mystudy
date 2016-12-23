package day1221;

public class StateThread extends Thread{
	Thread1 t1;
	
	public StateThread(Thread1 t1) {
		this.t1 = t1;
	}

	@Override
	public void run() {
		
	
		
		while(true){
			
			Thread.State state = t1.getState();
			System.out.println(state);
			//°´Ã¼°¡ »ý¼ºµÆÀ» ¶§
			if(state ==Thread.State.NEW){
				t1.start();
			}
			
			//Thread °¡ Á¾·áµÆÀ» ¶§
			if(state == Thread.State.TERMINATED){
				break;
			}
			
			
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
	}
	
	
	
}
