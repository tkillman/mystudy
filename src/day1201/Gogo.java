package day1201;



public class Gogo {
   
   public static void main(String[] args) {
      
      Children child1 = new Children(Price.RICE, Price.BULGOGI, Price.BANANA, Price.MILK, Price.ALMOND);
      Children2 child2 = new Children2(Price.RICE, Price.BULGOGI, Price.BANANA, Price.MILK, Price.ALMOND);
      
      System.out.println("child1 �� �ĺ� : " + child1.calculating() + "��");
      System.out.println("child2 �� �ĺ� : " + child2.calculating() + "��");
      
   }

}