package com.game;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import javax.swing.*;

public class Shoot1 extends JFrame implements Runnable, KeyListener { 
	//이미지를 위한 jframe 상속, thread를 위한 runnable 이벤트 처리를 위한 keylistener implement
 private BufferedImage bi = null; // 이미지를 버퍼시킨다.
 private ArrayList msList = null; // 미사일 갯수를 배열로 받는다.
 private ArrayList msList1 = null;// 미사일 갯수를 배열로 받는다.
 private ArrayList msList2 = null; // 미사일 갯수를 배열로 받는다.
 private ArrayList enList = null; // 적군의 갯수를 배열로 받는다.
 private boolean left = false, right = false, up = false, down = false, fire = false;
 // 초기 움직임 값 false 설정
 private boolean start = false, end = false;
 // 시작과 끝값 false 설정
 private int w = 300, h = 500, x = 130, y = 450, xw = 20, xh = 20;
 // w : 프레임 넓이, h : 프레임 높이, x : 플레이어 x 좌표, y : 플레이어 y좌표 , xw : 플레이어 폭 크기, xh : 플레이어 높이 크기
 
 
 public Shoot1() { // thread로 돌릴 메소드
  bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
  // 전체적인 버퍼 이미지
  msList = new ArrayList();// 미사일 갯수를 인스턴스 할당
  msList1 = new ArrayList();// 미사일 갯수를 인스턴스 할당
  msList2 = new ArrayList();// 미사일 갯수를 인스턴스 할당
  enList = new ArrayList(); // 적군 갯수를 인스턴스 할당
  this.addKeyListener(this); // 키 리스너 설정 
  this.setSize(w, h); // 프레임 크기 지정
  this.setTitle("Shooting Game"); // 프레임 이름 설정
  this.setResizable(false); // 프레임 크기를 사용자가 지정할 수 있도록하지 못하게 함.
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임이 꺼질 수 있도록 함.
  this.setVisible(true);  // 프레임 창이 나타나도록 함
 }
 
 public void run() { // 멀티 쓰레드를 돌리기 위한 run 메소드
  try {
   int msCnt = 0; // 초기 미사일값
   int enCnt = 0; // 초
   while(true) {
    Thread.sleep(10); // 시간 차
    
    if(start) {
     if(enCnt > 2000) { // 적군이 2000이 넘어가면
      enCreate(); // 적군 생성
      enCnt = 0; // 적군 값 0 초기화
     }
     if(msCnt >= 100) { // 미사일 갯수가 100개가 넘어가면
      fireMs(); // 미사일 발사
      msCnt = 0; // 미사일 갯수 0 초기화
     }
     msCnt += 10; // 쓰레드가 한번 돌 때마다 10씩 증가 미사일 생성 속도를 조절
     enCnt += 10; // 쓰레드가 한번 돌 때마다 10씩 증가 적군 생성 속도를 조절
     keyControl(); // 키 이벤트
     crashChk(); // 충돌 이벤트
    }
    draw(); //이미지를 그림
   } 
  } catch(Exception e) { //예외 처리
   e.printStackTrace(); // 예외를 나타냄
  }
 }
 public void fireMs() { //미사일 발사 메소드
  if(fire) { // 발사가 true 되면 실행
  
	if(msList.size() < 100) { // 미사일 갯수가 100개 이하면
    Ms m = new Ms(this.x, this.y); // 미사일 객체 생성, 미사일 생성 위치는 플레이어 위치 x,y
    msList.add(m); // 미사일 객체를 리스트에 담는다.
   }
   
   if(msList1.size() < 100) {// 미사일 갯수가 100개 이하면
	    Ms1 m1 = new Ms1(this.x, this.y);// 미사일 객체 생성, 미사일 생성 위치는 플레이어 위치 x,y
	    msList1.add(m1);// 미사일 객체를 리스트에 담는다.
	   }
   
   if(msList2.size() < 100) {// 미사일 갯수가 100개 이하면
	    Ms2 m2 = new Ms2(this.x, this.y);// 미사일 객체 생성, 미사일 생성 위치는 플레이어 위치 x,y
	    msList2.add(m2);// 미사일 객체를 리스트에 담는다.
	   }
  }
 }
 public void enCreate() { // 적군 생성 메소드
  for(int i = 0; i < 9; i++) { // 랜덤하게
   double rx = Math.random() * (w - xw); // 적군 생성 x 위치
   double ry = Math.random() * 50; // 적군 생성 y 위치
   Enemy1 en = new Enemy1((int)rx, (int)ry); // 적군 생성
   enList.add(en); // 적군 객체를 리스트에 담는다.
  }
 }
 
 
 public void crashChk() { // 충돌 메소드
  Graphics g = this.getGraphics(); // 그래픽 표현을 위한 Graphics 객체 생성
  Polygon p = null; Polygon p1 = null; Polygon p2 = null;
  // 그래픽이 겹치는지 확인 할 Polygon 객체 생성
  for(int i = 0; i < msList.size(); i++) { // 미사일 객체 전부 검색
   Ms m = (Ms)msList.get(i);
   Ms1 m1 = (Ms1)msList1.get(i);
   Ms2 m2 = (Ms2)msList2.get(i); //
   for(int j = 0; j < enList.size(); j++) { // 적군 객체 전부 검색
    Enemy1 e = (Enemy1)enList.get(j);
    int[] xpoints = {m.x, (m.x + m.w), (m.x + m.w), m.x};
    int[] xpoints1 = {m1.x, (m1.x + m1.w), (m1.x + m1.w), m1.x};
    int[] xpoints2 = {m2.x, (m2.x + m2.w), (m2.x + m2.w), m2.x};// 미사일 x 위치값 int[]배열로 받음
    int[] ypoints = {m.y, m.y, (m.y + m.h), (m.y + m.h)};
    int[] ypoints1 = {m1.y, m1.y, (m1.y + m1.h), (m1.y + m1.h)};
    int[] ypoints2 = {m2.y, m2.y, (m2.y + m2.h), (m2.y + m2.h)};// 미사일 y 위치값 int[]배열로 받음
    p = new Polygon(xpoints, ypoints, 4); // Polygon에 인스턴스 할당
    p1 = new Polygon(xpoints1, ypoints1, 4);
    p2 = new Polygon(xpoints2, ypoints2, 4);
    
    
    if(p.intersects((double)e.x, (double)e.y, (double)e.w, (double)e.h)) { //적군 위치와 겹치는지 확인
     msList.remove(i); // 겹치면 미사일 제거
     enList.remove(j); }
     if(p1.intersects((double)e.x, (double)e.y, (double)e.w, (double)e.h)) { //적군 위치와 겹치는지 확인
         msList1.remove(i); // 겹치면 미사일 제거
         enList.remove(j);}
     if(p2.intersects((double)e.x, (double)e.y, (double)e.w, (double)e.h)) { //적군 위치와 겹치는지 확인
             msList2.remove(i); // 겹치면 미사일 제거
             enList.remove(j);}
    
   } //j 반복문 끝남
  } // i 반복문 끝남
   
   for(int i = 0; i < enList.size(); i++) { // 적군 객체 전부 검색
   Enemy1 e = (Enemy1)enList.get(i);
   int[] xpoints = {x, (x + xw), (x + xw), x}; // 플레이어 x 위치값
   int[] ypoints = {y, y, (y + xh), (y + xh)}; // 플레이어 y 위치값
   
   p = new Polygon(xpoints, ypoints, 4); // p에 적군 위치 polygon 인스턴스 할당
   if(p.intersects((double)e.x, (double)e.y, (double)e.w, (double)e.h)) { //겹치는지 확인
    enList.remove(i); //겹치면 적군 제거
    start = false; // start 값을 false로 바꿈
    end = true; // end 값을 true 로 바꿈
   } //if 문 종료
  } //for문 종료
 }
 
 public void draw() { // 이미지를 위한 draw 메소드 정의
  Graphics gs = bi.getGraphics(); // 그래픽을 위한 gs 값 설정
  gs.setColor(Color.white); // 배경 화면색
  gs.fillRect(0, 0, w, h); // 플레이 상태 확인(적군 숫자, 미사일 숫자, 게임시작 )을 설정하기 위한 공간 설정
  gs.setColor(Color.black); //  플레이어 색깔 설정
  gs.drawString("Enemy 객체수 : " + enList.size(), 180, 50); // 프레임 창에 적군 갯수 표시그림
  gs.drawString("Ms 객체수 : " + msList.size(), 180, 70); //  프레임 창에 미사일 갯수 표시 그림
  gs.drawString("게임시작 : Enter", 180, 90); // 게임 시작은 ender 그림 표시
  
  if(end) { // 엔드값이 true가 될 경우 이미지 표시
   gs.drawString("G A M E     O V E R", 100, 250);
  }
  
  gs.fillRect(x, y, xw, xh); // 플레이어 모습 설정
   
  for(int i = 0; i < msList.size(); i++) { //미사일 객체들의 이미지 표현
   Ms m = (Ms)msList.get(i);
   gs.setColor(Color.blue); // 미사일 색깔
   gs.drawOval(m.x, m.y, m.w, m.h); // 미사일 이미지
   
   if(m.y < 0) msList.remove(i); // 미사일의 위치 y값이 0 이하가 되면 미사일 삭제
   m.moveMs(); //미사일 움직임 
  }
  
  for(int i = 0; i < msList1.size(); i++) { //미사일 객체들의 이미지 표현
	   Ms1 m1 = (Ms1)msList1.get(i);
	   gs.setColor(Color.blue);// 미사일 색깔
	   gs.drawOval(m1.x, m1.y, m1.w, m1.h);// 미사일 이미지
	   if(m1.y < 0) msList1.remove(i);// 미사일의 위치 y값이 0 이하가 되면 미사일 삭제
	   m1.moveMs();//미사일 움직임 
	  }
  

  for(int i = 0; i < msList2.size(); i++) {

	   Ms2 m2 = (Ms2)msList2.get(i);
	   gs.setColor(Color.blue);// 미사일 색깔
	   gs.drawOval(m2.x, m2.y, m2.w, m2.h);// 미사일 이미지
	   if(m2.y < 0) msList2.remove(i);// 미사일의 위치 y값이 0 이하가 되면 미사일 삭제
	   m2.moveMs();//미사일 움직임 
	  }
  
  
  gs.setColor(Color.black); // 적군 색깔 설정
  for(int i = 0; i < enList.size(); i++) { // 적군 객체를 모두 불러옴
   Enemy1 e = (Enemy1)enList.get(i); 
   gs.fillRect(e.x, e.y, e.w, e.h); //적군 크기 지정
   if(e.y > h) enList.remove(i); // 적군이 설정 h보다 높아지면 사라지게 만듬
   e.moveEn(); //적군 움직임
  }
  
  Graphics ge = this.getGraphics(); // 전체적인 이미지 그리기
  ge.drawImage(bi, 0, 0, w, h, this); 
 }
 
 public void keyControl() { //키 움직임
  if(0 < x) { // x값이 0보다 클때는
   if(left) x -= 3; // 왼쪽으로 움직일 수 있고 -3만큼 이동
  }
  if(w > x + xw) { // 폭 값보다 플레이어의 위치 x 값과 플레이어의 크기 xw 값을 합친 값보다 많을때
   if(right) x += 3; //오른쪽으로 움직일 수 있고 +3만큼 이동
  }
  if(25 < y) { // y값이 25보다 작을 땐
   if(up) y -= 3; // 위로 이동 가능
  }
  if(h > y + xh) { // 플레이어의 위치 y값과 플레이어의 크기 xh값을 합친 값이 창 크기 h보다 작을 때
   if(down) y += 3; // 아래로 이동 가능
  }
 }
 
 public void keyPressed(KeyEvent ke) {//키가 눌리면 발생하는 이벤트 처리
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
 
 public void keyReleased(KeyEvent ke) { //키를 땔때 발생하는 이벤트 처리
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
 
 public void keyTyped(KeyEvent ke) {} // implement 한 메소드이기 때문에 형식적으로 있어줘야 한다.
 
 public static void main(String[] args) { //메인 메소드
  Thread t = new Thread(new Shoot1());
  t.start();
 }
}

class Ms { //미사일 클래스
 int x;
 int y;
 int w = 5;
 int h = 5;
 
 public Ms(int x, int y) { // 미사일 생성 위치
  this.x = x+7;
  this.y = y+7;
 }
 public void moveMs() { //미사일 움직임
  y--;
 }
}

class Ms1 {//미사일 클래스
	 int x;
	 int y;
	 int w = 5;
	 int h = 5;
	 
	 public Ms1(int x, int y) {// 미사일 생성 위치
	  this.x = x+7;
	  this.y = y+7;
	 }
	 public void moveMs() { //미사일 움직임
		 x+=1;
		 y--;
	 }
	}

class Ms2 {//미사일 클래스
	 int x;
	 int y;
	 int w = 5;
	 int h = 5;
	 
	 public Ms2(int x, int y) {// 미사일 생성 위치
	  this.x = x;
	  this.y = y;
	 }
	 public void moveMs() {//미사일 움직임
		 x-=1;
		 y--;
	 }
	}


class Enemy1 { // 적군 클래스
 
int hp =5;	
 int x;
 int y;
 int w = 10;
 int h = 10;

 public Enemy1(int rx, int ry) { // 적군 생성 위치
  this.x = rx; 
  this.y = ry;
 }
 
 public void moveEn() { // 적군 움직임
  y++;
 } 
}