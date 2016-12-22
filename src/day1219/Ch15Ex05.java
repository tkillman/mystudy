package day1219;

public class Ch15Ex05 {

	public static void main(String[] args) {

		point p1 = new point(5, 3);
		point p2 = new point(5, 3);

		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());

		if (p1 == p2) {
			System.out.println("p1과 p2가 참조하는 인스턴스는 같다.");
		} else {
			System.out.println("p1과 p2가 참조하는 인스턴스는 다르다.");
		}

		if (p1.equals(p2)) {
			System.out.println("p1과 p2의 데이터는 같다.");
		} else {
			System.out.println("p1과 p2의 데이터는 다르다.");
		}

	}

}



class point {
	int x;
	int y;

	public point(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public boolean equals (Object obj) {
		point pt= null;
		
		if(obj instanceof point){
			pt = (point)obj;}
		
		if(x==pt.x && y==pt.y) {
			return true;
		}else{
			return false;
		}	
			
		}
	}			
			

	
	
