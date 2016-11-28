package com.jframe;
import java.awt.*;
import java.awt.geom.*;

public class Stroke1 extends Frame{
  public Stroke1(String title){
    super(title);
  }
  
  public void paint(Graphics g){
    Graphics2D g2=(Graphics2D)g;
    
    // CAP_ROUND�� ����� ���� �׸���
    g2.setStroke(new BasicStroke(30,BasicStroke.CAP_ROUND,0));
    g2.draw(new Line2D.Double(50,50,200,50));
    
    // JOIN_ROUND�� �簢�� �׸���
    g2.setStroke(new BasicStroke(30,0,BasicStroke.JOIN_ROUND));
    g2.draw(new Rectangle2D.Double(50,100,50,50));
    
    // JOIN_BEVEL���� �簢�� �׸���
    g2.setStroke(new BasicStroke(30,0,BasicStroke.JOIN_BEVEL));
    g2.draw(new Rectangle2D.Double(150,100,50,50));
    
    // JOIN_MITER�� ���� �׸���
    float[] dash=new float[]{10,5,5,5};
    g2.setStroke(new BasicStroke(5,0,BasicStroke.JOIN_MITER,1.0f,dash, 0));
    g2.draw(new Rectangle2D.Double(50,200,150,50));
    
  }
  
  public static void main(String[] args){
    Frame f=new Stroke1("��Ʈ��ũ");
    f.setSize(250,300);
    f.setVisible(true);
  }  
}