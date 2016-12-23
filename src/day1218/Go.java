package day1218;

public class Go {
	Shape ref;

	public static void main(String[] args) {

		
	Circle circle = new Circle();	
	circle.setColor(Drawable.Green);	
	switch (circle.getColor()) {
	case 1:
		System.out.println("빨간색입니다.");
		break;

	case 2:
		System.out.println("파란색입니다.");
		break;

	case 3:
		System.out.println("초록색입니다.");
		break;
		
	default:
		break;
	}
	
	
		
	System.out.println(polyMethod(new Circle()));
	System.out.println(polyMethod(new Rec()));
	System.out.println(polyMethod(new Try()));
		
		
	}

	public static double polyMethod(Shape ref) {

		

		if (ref instanceof Circle) {

			return ref.area();

		} else if (ref instanceof Rec) {
			return ref.area();
		} else if (ref instanceof Try) {
			return ref.area();
		}

		return -1;
	}

}
