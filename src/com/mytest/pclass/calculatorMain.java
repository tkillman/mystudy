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
           
            System.out.println("�Է¹��� �ʰ�: -2147483648~2147483647");

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
            // ù��° �ԷµǴ� ���� ������ �������� �ʴ´�.
            System.out.println("������ �Էµ��� �ʽ��ϴ�.");
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
         //���ڿ� �迭�� ���� �迭�� �ٲٴ� �ڵ� �Է�
         /*num = StringArrToInterArr(splitValues);*/
         
         
         
        /* for(int cnt=0; cnt<splitValues.length;cnt++){
            try{
               num[cnt] = Integer.parseInt(splitValues[cnt]);
               System.out.println(num[cnt]);
            }catch(java.lang.NumberFormatException e){
           
            System.out.println("�Է¹��� �ʰ�: -2147483648~2147483647");

            }
         }//�Լ��� �ٲ㺸��
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
            System.out.println("0���� ������� �Ұ����մϴ�. �ٽ� �Է����ּ���!!");
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
      System.out.println("����Ǿ����ϴ�.");   
   }   
   
}