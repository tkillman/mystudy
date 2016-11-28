package com.jframe;
import java.awt.*;


public class Paint1 extends Frame{
  
  
  public void paint(Graphics g){ // Graphics 라는 클래스 - 그림 그리기 전에 무조건 생성해야 한다.
    g.drawLine(10,30,50,50);              // 선을 그린다. 시작점 x, 시작점 y, 끝점 x
    g.drawRect(60,30,50,50);             // 사각형을 그린다.
    g.drawString("Hello!",120,50);         // 문자열을 그린다.
  }
  
  
  public static void main(String[] args){
    Paint1 f= new Paint1();
    f.setSize(200,100);
    f.setVisible(true);                     // 프레임이 보여질 때 paint가 호출된다.
  }
}