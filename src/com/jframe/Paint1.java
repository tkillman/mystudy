package com.jframe;
import java.awt.*;


public class Paint1 extends Frame{
  
  
  public void paint(Graphics g){ // Graphics ��� Ŭ���� - �׸� �׸��� ���� ������ �����ؾ� �Ѵ�.
    g.drawLine(10,30,50,50);              // ���� �׸���. ������ x, ������ y, ���� x
    g.drawRect(60,30,50,50);             // �簢���� �׸���.
    g.drawString("Hello!",120,50);         // ���ڿ��� �׸���.
  }
  
  
  public static void main(String[] args){
    Paint1 f= new Paint1();
    f.setSize(200,100);
    f.setVisible(true);                     // �������� ������ �� paint�� ȣ��ȴ�.
  }
}