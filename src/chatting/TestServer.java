package chatting;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
 
public class TestServer{
	
 private Vector vector;
 Socket s = null;
 ServerSocket ss = null;
 
 public void go() throws IOException{
  try{
   vector = new Vector();
   ss = new ServerSocket(5432);
   System.out.println("**서버 실행**");
   
   //다수의 클라이언트와 통신하기 위해 loop
   while(true){
   
	s = ss.accept();  //클라이언트 접속시 새로운 소켓이 리턴
    System.out.println(s.getInetAddress()+"님 입장!!");
    ServerThread st = new ServerThread(s,this);
    //받은 손님 소켓을 쓰레드로 보내면서 자신의 객체도 보낸다.
    addThread(st); //Vector에 추가한다.
    st.start(); 
   }
  }finally{
   if (s != null)
    s.close();
   if (ss != null)
    ss.close();
   System.out.println("**서버 종료**");   
  }
 }
 
 //클라이언트 접속시 생성된 스레드를 Vector에 추가하는 메서드
 public void addThread(ServerThread st){
  
	 vector.add(st);
 }
 
 //클라이언트와 접속종료시 해당 ServerThread를 Vector에서 삭제
 public void deleteThread(ServerThread st){
  vector.remove(st);
 
 }
 
 //클라이언트의 메세지를 Vector에 저장된 모든 ServerThread(접속자에 전달)
 public void broadCasting(String message){
  for(int i=0; i<vector.size(); i++){
   ServerThread st = (ServerThread)vector.get(i);
   st.sendMessage(message);
  }
 }
 
 
 public static void main(String[] args) {
  
	TestServer ts = new TestServer();
  try {
   
	  ts.go(); //벡터와 서버 소켓을 만듬
	  
  } catch (IOException e) {
   e.printStackTrace();
  }
  
 }
}
