package day1221;

public class DataBox {
	
	String data;

	public synchronized String getData() {
		
		if(data == null){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		String result = data;
		data =null;
		
		notify();
		System.out.println("Ŭ���̾�Ʈ�� ������ ������ : " +result);
		return result;
		
	}

	public synchronized void setData(String data) {
		
		if(this.data !=null){
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		this.data = data;
		
		System.out.println("���ε༭�� ������ ������ : " +this.data);
		notify();
	}
	
	
	
	
	

}
