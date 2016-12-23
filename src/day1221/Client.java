package day1221;

public class Client extends Thread{
	
	DataBox db;
	
	
	public Client(DataBox db) {
		this.db = db;
	}
	
	
	
	@Override
	public void run() {
		
		for(int i=0;i<4;i++){
			
			String data = "data_"+i;
			
			db.setData(data);
		}
		
		
	}
}
