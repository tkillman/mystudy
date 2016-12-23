package day1221;

public class Producer extends Thread {
	DataBox db;
	
	public Producer(DataBox db) {
	
		this.db = db;
		
	}
	
	
	@Override
	public void run() {
	
		for(int i=0;i<4;i++){
			db.getData();
		}
		
		
	}
	
	
}
