package day1221;

public class gogo {
	
	public static void main(String[] args) {
		
		DataBox db = new DataBox();
		
		Producer pd = new Producer(db);
		Client c = new Client(db);
		
		
		pd.start();
		c.start();
		
		
	}

}
