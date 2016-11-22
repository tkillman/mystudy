package com.mytest.pclass;

import java.util.Scanner;

public class calculatorMain {
   
	
	   
    public static int[] StringArrToInterArr(String [] splitValues){
   	 
    	int [] num =new int[10];
   	 for(int cnt=0; cnt<splitValues.length;cnt++){
            try{
               num[cnt] = Integer.parseInt(splitValues[cnt]);
               System.out.println(num[cnt]);
            }catch(java.lang.NumberFormatException e){
           
            System.out.println("입력범위 초과: -2147483648~2147483647");

            }
         }
   	 
   	 return num;
   	 
    }
    
	
	
	
	
	
	
	
	
	
	public static void main(String [] args ) {
      
	  String inputVal;
      String YesOrNo;
      boolean yesno=true;
      
      do{
         System.out.println("Input:");
         Scanner scan = new Scanner(System.in);
         inputVal = scan.nextLine();
         
         inputVal = inputVal.replace(" ", "");
         
     
         if(inputVal.startsWith("-")){
            // 첫번째 입력되는 수는 음수를 지원하지 않는다.
            System.out.println("음수는 입력되지 않습니다.");
            continue;
         }
         
         System.out.println(inputVal);
         
         String [] splitValues = inputVal.split("[\\+\\-\\*\\/\\=]");
         
         
         
         
         System.out.println(splitValues.length);
         
         for(int cnt=0; cnt<splitValues.length;cnt++) { 
            System.out.println(splitValues[cnt]);
         }         
         
        
         //int [] num =new int[10];
         
         
         
         int [] num = new int[splitValues.length];
         //문자열 배열을 정수 배열로 바꾸는 코드 입력
         /*num = StringArrToInterArr(splitValues);*/
         
         
         
        /* for(int cnt=0; cnt<splitValues.length;cnt++){
            try{
               num[cnt] = Integer.parseInt(splitValues[cnt]);
               System.out.println(num[cnt]);
            }catch(java.lang.NumberFormatException e){
           
            System.out.println("입력범위 초과: -2147483648~2147483647");

            }
         }//함수로 바꿔보기
*/      
         
         
         System.out.println(num[0]);
         
         String [] signArray = {"+", "-","*","/"};
         char sign = '+';
         for(int cnt=0;cnt<signArray.length;cnt++){
            int signOrder = inputVal.indexOf(signArray[cnt]);
            if(signOrder < 0){
               continue;
            }
            System.out.println(signOrder);
            sign = inputVal.charAt(signOrder);
            System.out.println(sign);
         }
         
         if(num[1] == 0 && sign == '/') {
            System.out.println("0으로 나누기는 불가능합니다. 다시 입력해주세요!!");
            return;
         }
                     
         long result=0;
         double result2=0.0;
         switch(sign){
         case '+':
            result = (long)num[0]+(long)num[1];
            System.out.println(result);
            break;
         case '-':
            result = (long)num[0]-(long)num[1];
            System.out.println(result);
            break;
         case '*':
            result = (long)num[0]*(long)num[1];
            System.out.println(result);
         case '/':
            result2 = (double)num[0] / (double)num[1];
            System.out.println(result2);
            break; 
         default:
            break;
         }
         System.out.println("yes(y) or no(n)");
         //YesOrNo = scan.nextLine();
         inputVal = scan.nextLine();
/*         if(inputVal.equals("y") || inputVal.equals("Y")){
            continue;
         }
         else if(inputVal.equals("n") || inputVal.equals("N")){
            break;
         }*/
         
         switch(inputVal){
         case "y": case "Y":
            //System.out.println("y");
            yesno=true;
            continue;
            //break;
         case "n": case "N":
            //System.out.println("n");
            yesno=false;
            break;
         default:
            break;
         }
         
      }while( yesno );   
      System.out.println("종료되었습니다.");   
   }   
   
}