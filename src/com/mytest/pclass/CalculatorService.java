
package com.mytest.pclass;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * ��� ����
 * 
 * @author
 * @version
 * @since
 * @created 2015. 1. 12.
 */

public class CalculatorService {

    public static void main(String[] args) {
    	
    	Scanner sc= new Scanner(System.in);
    	String qu = sc.nextLine();
    	
        String result = getCalculate(qu);
        System.out.println(result);
        sc.close();
        
    }

    /**
     * ���ó��
     */
    private static String getCalculate(String content) {

        char[] operationCode = {'+', '-', '*', '/', '(', ')'}; //���� ��ȣ

        ArrayList<String> postfixList = new ArrayList<String>(); //����ǥ������� ��ȯ �� ���� �� ArrayList
        Stack<Character> opStack = new Stack<Character>(); // ���� ��ȣ �켱����ó�� �ϸ� ���� ǥ������� �����ϴ� Stack
        Stack<String> calculatorStack = new Stack<String>(); //���� ǥ����� ����ϴ� Stack

        int index = 0;//content.substring() �μ�

        for (int i = 0; i < content.length(); i++) {
            for (int j = 0; j < operationCode.length; j++) {
                if (content.charAt(i) == operationCode[j]) { //���ڿ��� ���� ��ȣ ��

                    //postfixList�� ���� ��ȣ�� ������ �������� ���ڸ� ��´�(��������)
                    postfixList.add(content.substring(index, i).trim().replace("(", "").replace(")", ""));
                    if (content.charAt(i) == '(') {
                        if (content.charAt(i) == ')') {//�� ��ȣ�� ������ �� ��ȣ�� �����ų� ���ÿ� ��������� ���� pop�Ͽ� list�� ����
                            while (true) {
                                postfixList.add(opStack.pop().toString());
                                if (opStack.pop() == '(' || opStack.isEmpty()) {
                                    break;
                                }
                            }
                        }
                    }


                    if (opStack.isEmpty()) { //opStack�� ��� ���� ���
                        opStack.push(operationCode[j]); //���� ��ȣ ����
                    } else { //opStack�� ��� ���� ���� ���
                        if (opOrder(operationCode[j]) > opOrder(opStack.peek())) { //�켱 ���� ��
                            opStack.push(operationCode[j]); //���ÿ� top �� ���� ���� �켱�����̸� �״�� ����
                        } else if (opOrder(operationCode[j]) <= opOrder(opStack.peek())) {//�켱 ���� ��
                            postfixList.add(opStack.peek().toString());//���ÿ� �ִ� ���� �켱������ ���ų� ���� ��� list�� ����
                            opStack.pop();//���� ����
                            opStack.push(operationCode[j]);//���� �켱���� ���� ��ȣ ���ÿ� ����
                        }
                    }
                    index = i + 1;// ���� ���� ó��
                }
            }
        }
        postfixList.add(content.substring(index, content.length()).trim().replace("(", "").replace(")", "")); //������ ���� ó��

        if (!opStack.isEmpty()) { //Stack�� �����ִ� ���� ��� postfixList�� �߰�
            for (int i = 0; i < opStack.size();) {
                postfixList.add(opStack.peek().toString());
                opStack.pop();
                
            }
        }

        //list�� ����, ��ȣ ����
        for (int i = 0; i < postfixList.size(); i++) {
            if (postfixList.get(i).equals("")) {
                postfixList.remove(i);
                i = i - 1;
            } else if (postfixList.get(i).equals("(")) {
                postfixList.remove(i);
                i = i - 1;
            } else if (postfixList.get(i).equals(")")) {
                postfixList.remove(i);
                i = i - 1;
            }
        }

        /*System.out.println(postfixList);*/

        opStack.clear(); //Stack ����

       
        //postfixList�� calculatorStack�� �����ϸ鼭 �������� ó��
        for (int i = 0; i < postfixList.size(); i++) {
            calculatorStack.push(postfixList.get(i));
            
            for (int j = 0; j < operationCode.length; j++) {
                if (postfixList.get(i).charAt(0) == operationCode[j]) { //���� ��ȣ ��
                    calculatorStack.pop(); //stack�� ����� ���� ��ȣ ����
                    double s2, s1; //stack���� pop �Ǵ� ������ ������ ����
                    String rs; // ���� ó�� �� ���ڿ��� ��ȯ �� stack�� ������ ����

                    s2 = Double.parseDouble(calculatorStack.pop()); //���ÿ��� pop�Ͽ� ���ڿ��� ���ڷ� ����ȯ
                    s1 = Double.parseDouble(calculatorStack.pop());

                    //���� ��ȣ�� �ش��ϴ� ��� ó�� �� stack�� ����
                    switch (operationCode[j]) {
                        case '+':
                            rs = String.valueOf(s1 + s2);
                            calculatorStack.push(rs);
                            break;
                        case '-':
                            rs = String.valueOf(s1 - s2);
                            calculatorStack.push(rs);
                            break;
                        case '*':
                            rs = String.valueOf(s1 * s2);
                            calculatorStack.push(rs);
                            break;
                        case '/':
                            rs = String.valueOf(s1 / s2);
                            calculatorStack.push(rs);
                            break;
                    }
                }
            }
        }

        double re = Double.parseDouble(calculatorStack.peek()); //Stack Top ������ 
        String result = String.format("%.10f", re); //�Ҽ��� 10°¥��

        //���� �κ� �ڸ� ���ϱ�
        int num = 0;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '.') {
                num = i;
                break;
            }
        }

        //�����κ�
        String mok = result.substring(0, num);

        //������ ����
        double divde = Double.parseDouble(result) % Double.parseDouble(mok);

        //�������� 0�̸� �Ҽ��� �ڸ� �� �Ⱥ��̰�
        if (divde == 0) {
            result = String.format("%.0f", re);
        }
        System.out.println(postfixList);
        return result;
    }

    /**
     * ���� ��ȣ �켱���� ���ϴ� �޼���
     * 
     * @param op - ���� ��ȣ
     */
    public static int opOrder(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

}