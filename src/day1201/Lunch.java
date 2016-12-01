package day1201;

public abstract class Lunch {
   
	
   public int rice;
   public int bulgogi;
   
   public int banana;
   public int milk;
   public int almond;
   
   
   public Lunch(){}
   
   public Lunch(int rice, int bulgogi, int banana, int milk, int almond) {
      
	   // TODO Auto-generated constructor stub
      
      this.rice = rice;
      this.bulgogi = bulgogi;
      
      this.banana = banana;
      this.milk = milk;
      this.almond = almond;
   }
   
   public abstract int calculating();
}