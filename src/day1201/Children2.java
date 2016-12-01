package day1201;

public class Children2 extends Lunch{
   
   
	
	
   public Children2(int rice, int bulgogi, int banana, int milk, int almond) {
      // TODO Auto-generated constructor stub
      super(rice, bulgogi, banana, milk, almond);
   }

   @Override
   public int calculating() {
      // TODO Auto-generated method stub
      return rice + bulgogi + milk + almond;
   }

}