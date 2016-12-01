package day1201;

public class Children extends Lunch {

	
   
   public Children(int rice, int bulgogi, int banana, int milk, int almond) {
      // TODO Auto-generated constructor stub
     /* super(rice, bulgogi, banana, milk, almond);*/
   }
   
   
   
   @Override
   public int calculating() {
      // TODO Auto-generated method stub
      return rice + bulgogi + banana;
   }

}