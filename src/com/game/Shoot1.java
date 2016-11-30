package com.game;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import javax.swing.*;

public class Shoot1 extends JFrame implements Runnable, KeyListener { 
	//�̹����� ���� jframe ���, thread�� ���� runnable �̺�Ʈ ó���� ���� keylistener implement
 private BufferedImage bi = null; // �̹����� ���۽�Ų��.
 private ArrayList msList = null; // �̻��� ������ �迭�� �޴´�.
 private ArrayList msList1 = null;// �̻��� ������ �迭�� �޴´�.
 private ArrayList msList2 = null; // �̻��� ������ �迭�� �޴´�.
 private ArrayList enList = null; // ������ ������ �迭�� �޴´�.
 private boolean left = false, right = false, up = false, down = false, fire = false;
 // �ʱ� ������ �� false ����
 private boolean start = false, end = false;
 // ���۰� ���� false ����
 private int w = 300, h = 500, x = 130, y = 450, xw = 20, xh = 20;
 // w : ������ ����, h : ������ ����, x : �÷��̾� x ��ǥ, y : �÷��̾� y��ǥ , xw : �÷��̾� �� ũ��, xh : �÷��̾� ���� ũ��
 
 
 public Shoot1() { // thread�� ���� �޼ҵ�
  bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
  // ��ü���� ���� �̹���
  msList = new ArrayList();// �̻��� ������ �ν��Ͻ� �Ҵ�
  msList1 = new ArrayList();// �̻��� ������ �ν��Ͻ� �Ҵ�
  msList2 = new ArrayList();// �̻��� ������ �ν��Ͻ� �Ҵ�
  enList = new ArrayList(); // ���� ������ �ν��Ͻ� �Ҵ�
  this.addKeyListener(this); // Ű ������ ���� 
  this.setSize(w, h); // ������ ũ�� ����
  this.setTitle("Shooting Game"); // ������ �̸� ����
  this.setResizable(false); // ������ ũ�⸦ ����ڰ� ������ �� �ֵ������� ���ϰ� ��.
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� ���� �� �ֵ��� ��.
  this.setVisible(true);  // ������ â�� ��Ÿ������ ��
 }
 
 public void run() { // ��Ƽ �����带 ������ ���� run �޼ҵ�
  try {
   int msCnt = 0; // �ʱ� �̻��ϰ�
   int enCnt = 0; // ��
   while(true) {
    Thread.sleep(10); // �ð� ��
    
    if(start) {
     if(enCnt > 2000) { // ������ 2000�� �Ѿ��
      enCreate(); // ���� ����
      enCnt = 0; // ���� �� 0 �ʱ�ȭ
     }
     if(msCnt >= 100) { // �̻��� ������ 100���� �Ѿ��
      fireMs(); // �̻��� �߻�
      msCnt = 0; // �̻��� ���� 0 �ʱ�ȭ
     }
     msCnt += 10; // �����尡 �ѹ� �� ������ 10�� ���� �̻��� ���� �ӵ��� ����
     enCnt += 10; // �����尡 �ѹ� �� ������ 10�� ���� ���� ���� �ӵ��� ����
     keyControl(); // Ű �̺�Ʈ
     crashChk(); // �浹 �̺�Ʈ
    }
    draw(); //�̹����� �׸�
   } 
  } catch(Exception e) { //���� ó��
   e.printStackTrace(); // ���ܸ� ��Ÿ��
  }
 }
 public void fireMs() { //�̻��� �߻� �޼ҵ�
  if(fire) { // �߻簡 true �Ǹ� ����
  
	if(msList.size() < 100) { // �̻��� ������ 100�� ���ϸ�
    Ms m = new Ms(this.x, this.y); // �̻��� ��ü ����, �̻��� ���� ��ġ�� �÷��̾� ��ġ x,y
    msList.add(m); // �̻��� ��ü�� ����Ʈ�� ��´�.
   }
   
   if(msList1.size() < 100) {// �̻��� ������ 100�� ���ϸ�
	    Ms1 m1 = new Ms1(this.x, this.y);// �̻��� ��ü ����, �̻��� ���� ��ġ�� �÷��̾� ��ġ x,y
	    msList1.add(m1);// �̻��� ��ü�� ����Ʈ�� ��´�.
	   }
   
   if(msList2.size() < 100) {// �̻��� ������ 100�� ���ϸ�
	    Ms2 m2 = new Ms2(this.x, this.y);// �̻��� ��ü ����, �̻��� ���� ��ġ�� �÷��̾� ��ġ x,y
	    msList2.add(m2);// �̻��� ��ü�� ����Ʈ�� ��´�.
	   }
  }
 }
 public void enCreate() { // ���� ���� �޼ҵ�
  for(int i = 0; i < 9; i++) { // �����ϰ�
   double rx = Math.random() * (w - xw); // ���� ���� x ��ġ
   double ry = Math.random() * 50; // ���� ���� y ��ġ
   Enemy1 en = new Enemy1((int)rx, (int)ry); // ���� ����
   enList.add(en); // ���� ��ü�� ����Ʈ�� ��´�.
  }
 }
 
 
 public void crashChk() { // �浹 �޼ҵ�
  Graphics g = this.getGraphics(); // �׷��� ǥ���� ���� Graphics ��ü ����
  Polygon p = null; Polygon p1 = null; Polygon p2 = null;
  // �׷����� ��ġ���� Ȯ�� �� Polygon ��ü ����
  for(int i = 0; i < msList.size(); i++) { // �̻��� ��ü ���� �˻�
   Ms m = (Ms)msList.get(i);
   Ms1 m1 = (Ms1)msList1.get(i);
   Ms2 m2 = (Ms2)msList2.get(i); //
   for(int j = 0; j < enList.size(); j++) { // ���� ��ü ���� �˻�
    Enemy1 e = (Enemy1)enList.get(j);
    int[] xpoints = {m.x, (m.x + m.w), (m.x + m.w), m.x};
    int[] xpoints1 = {m1.x, (m1.x + m1.w), (m1.x + m1.w), m1.x};
    int[] xpoints2 = {m2.x, (m2.x + m2.w), (m2.x + m2.w), m2.x};// �̻��� x ��ġ�� int[]�迭�� ����
    int[] ypoints = {m.y, m.y, (m.y + m.h), (m.y + m.h)};
    int[] ypoints1 = {m1.y, m1.y, (m1.y + m1.h), (m1.y + m1.h)};
    int[] ypoints2 = {m2.y, m2.y, (m2.y + m2.h), (m2.y + m2.h)};// �̻��� y ��ġ�� int[]�迭�� ����
    p = new Polygon(xpoints, ypoints, 4); // Polygon�� �ν��Ͻ� �Ҵ�
    p1 = new Polygon(xpoints1, ypoints1, 4);
    p2 = new Polygon(xpoints2, ypoints2, 4);
    
    
    if(p.intersects((double)e.x, (double)e.y, (double)e.w, (double)e.h)) { //���� ��ġ�� ��ġ���� Ȯ��
     msList.remove(i); // ��ġ�� �̻��� ����
     enList.remove(j); }
     if(p1.intersects((double)e.x, (double)e.y, (double)e.w, (double)e.h)) { //���� ��ġ�� ��ġ���� Ȯ��
         msList1.remove(i); // ��ġ�� �̻��� ����
         enList.remove(j);}
     if(p2.intersects((double)e.x, (double)e.y, (double)e.w, (double)e.h)) { //���� ��ġ�� ��ġ���� Ȯ��
             msList2.remove(i); // ��ġ�� �̻��� ����
             enList.remove(j);}
    
   } //j �ݺ��� ����
  } // i �ݺ��� ����
   
   for(int i = 0; i < enList.size(); i++) { // ���� ��ü ���� �˻�
   Enemy1 e = (Enemy1)enList.get(i);
   int[] xpoints = {x, (x + xw), (x + xw), x}; // �÷��̾� x ��ġ��
   int[] ypoints = {y, y, (y + xh), (y + xh)}; // �÷��̾� y ��ġ��
   
   p = new Polygon(xpoints, ypoints, 4); // p�� ���� ��ġ polygon �ν��Ͻ� �Ҵ�
   if(p.intersects((double)e.x, (double)e.y, (double)e.w, (double)e.h)) { //��ġ���� Ȯ��
    enList.remove(i); //��ġ�� ���� ����
    start = false; // start ���� false�� �ٲ�
    end = true; // end ���� true �� �ٲ�
   } //if �� ����
  } //for�� ����
 }
 
 public void draw() { // �̹����� ���� draw �޼ҵ� ����
  Graphics gs = bi.getGraphics(); // �׷����� ���� gs �� ����
  gs.setColor(Color.white); // ��� ȭ���
  gs.fillRect(0, 0, w, h); // �÷��� ���� Ȯ��(���� ����, �̻��� ����, ���ӽ��� )�� �����ϱ� ���� ���� ����
  gs.setColor(Color.black); //  �÷��̾� ���� ����
  gs.drawString("Enemy ��ü�� : " + enList.size(), 180, 50); // ������ â�� ���� ���� ǥ�ñ׸�
  gs.drawString("Ms ��ü�� : " + msList.size(), 180, 70); //  ������ â�� �̻��� ���� ǥ�� �׸�
  gs.drawString("���ӽ��� : Enter", 180, 90); // ���� ������ ender �׸� ǥ��
  
  if(end) { // ���尪�� true�� �� ��� �̹��� ǥ��
   gs.drawString("G A M E     O V E R", 100, 250);
  }
  
  gs.fillRect(x, y, xw, xh); // �÷��̾� ��� ����
   
  for(int i = 0; i < msList.size(); i++) { //�̻��� ��ü���� �̹��� ǥ��
   Ms m = (Ms)msList.get(i);
   gs.setColor(Color.blue); // �̻��� ����
   gs.drawOval(m.x, m.y, m.w, m.h); // �̻��� �̹���
   
   if(m.y < 0) msList.remove(i); // �̻����� ��ġ y���� 0 ���ϰ� �Ǹ� �̻��� ����
   m.moveMs(); //�̻��� ������ 
  }
  
  for(int i = 0; i < msList1.size(); i++) { //�̻��� ��ü���� �̹��� ǥ��
	   Ms1 m1 = (Ms1)msList1.get(i);
	   gs.setColor(Color.blue);// �̻��� ����
	   gs.drawOval(m1.x, m1.y, m1.w, m1.h);// �̻��� �̹���
	   if(m1.y < 0) msList1.remove(i);// �̻����� ��ġ y���� 0 ���ϰ� �Ǹ� �̻��� ����
	   m1.moveMs();//�̻��� ������ 
	  }
  

  for(int i = 0; i < msList2.size(); i++) {

	   Ms2 m2 = (Ms2)msList2.get(i);
	   gs.setColor(Color.blue);// �̻��� ����
	   gs.drawOval(m2.x, m2.y, m2.w, m2.h);// �̻��� �̹���
	   if(m2.y < 0) msList2.remove(i);// �̻����� ��ġ y���� 0 ���ϰ� �Ǹ� �̻��� ����
	   m2.moveMs();//�̻��� ������ 
	  }
  
  
  gs.setColor(Color.black); // ���� ���� ����
  for(int i = 0; i < enList.size(); i++) { // ���� ��ü�� ��� �ҷ���
   Enemy1 e = (Enemy1)enList.get(i); 
   gs.fillRect(e.x, e.y, e.w, e.h); //���� ũ�� ����
   if(e.y > h) enList.remove(i); // ������ ���� h���� �������� ������� ����
   e.moveEn(); //���� ������
  }
  
  Graphics ge = this.getGraphics(); // ��ü���� �̹��� �׸���
  ge.drawImage(bi, 0, 0, w, h, this); 
 }
 
 public void keyControl() { //Ű ������
  if(0 < x) { // x���� 0���� Ŭ����
   if(left) x -= 3; // �������� ������ �� �ְ� -3��ŭ �̵�
  }
  if(w > x + xw) { // �� ������ �÷��̾��� ��ġ x ���� �÷��̾��� ũ�� xw ���� ��ģ ������ ������
   if(right) x += 3; //���������� ������ �� �ְ� +3��ŭ �̵�
  }
  if(25 < y) { // y���� 25���� ���� ��
   if(up) y -= 3; // ���� �̵� ����
  }
  if(h > y + xh) { // �÷��̾��� ��ġ y���� �÷��̾��� ũ�� xh���� ��ģ ���� â ũ�� h���� ���� ��
   if(down) y += 3; // �Ʒ��� �̵� ����
  }
 }
 
 public void keyPressed(KeyEvent ke) {//Ű�� ������ �߻��ϴ� �̺�Ʈ ó��
  switch(ke.getKeyCode()) {
  case KeyEvent.VK_LEFT:
   left = true;
   break;
  case KeyEvent.VK_RIGHT:
   right = true;
   break;
  case KeyEvent.VK_UP:
   up = true;
   break;
  case KeyEvent.VK_DOWN:
   down = true;
   break;
  case KeyEvent.VK_A:
   fire = true;
   break;
  case KeyEvent.VK_ENTER:
   start = true;
   end = false;
   break;
  }
 }
 
 public void keyReleased(KeyEvent ke) { //Ű�� ���� �߻��ϴ� �̺�Ʈ ó��
  switch(ke.getKeyCode()) {
  case KeyEvent.VK_LEFT:
   left = false;
   break;
  case KeyEvent.VK_RIGHT:
   right = false;
   break;
  case KeyEvent.VK_UP:
   up = false;
   break;
  case KeyEvent.VK_DOWN:
   down = false;
   break;
  case KeyEvent.VK_A:
   fire = false;
   break;
  }
 }
 
 public void keyTyped(KeyEvent ke) {} // implement �� �޼ҵ��̱� ������ ���������� �־���� �Ѵ�.
 
 public static void main(String[] args) { //���� �޼ҵ�
  Thread t = new Thread(new Shoot1());
  t.start();
 }
}

class Ms { //�̻��� Ŭ����
 int x;
 int y;
 int w = 5;
 int h = 5;
 
 public Ms(int x, int y) { // �̻��� ���� ��ġ
  this.x = x+7;
  this.y = y+7;
 }
 public void moveMs() { //�̻��� ������
  y--;
 }
}

class Ms1 {//�̻��� Ŭ����
	 int x;
	 int y;
	 int w = 5;
	 int h = 5;
	 
	 public Ms1(int x, int y) {// �̻��� ���� ��ġ
	  this.x = x+7;
	  this.y = y+7;
	 }
	 public void moveMs() { //�̻��� ������
		 x+=1;
		 y--;
	 }
	}

class Ms2 {//�̻��� Ŭ����
	 int x;
	 int y;
	 int w = 5;
	 int h = 5;
	 
	 public Ms2(int x, int y) {// �̻��� ���� ��ġ
	  this.x = x;
	  this.y = y;
	 }
	 public void moveMs() {//�̻��� ������
		 x-=1;
		 y--;
	 }
	}


class Enemy1 { // ���� Ŭ����
 
int hp =5;	
 int x;
 int y;
 int w = 10;
 int h = 10;

 public Enemy1(int rx, int ry) { // ���� ���� ��ġ
  this.x = rx; 
  this.y = ry;
 }
 
 public void moveEn() { // ���� ������
  y++;
 } 
}