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
   System.out.println("**���� ����**");
   
   //�ټ��� Ŭ���̾�Ʈ�� ����ϱ� ���� loop
   while(true){
   
	s = ss.accept();  //Ŭ���̾�Ʈ ���ӽ� ���ο� ������ ����
    System.out.println(s.getInetAddress()+"�� ����!!");
    ServerThread st = new ServerThread(s,this);
    //���� �մ� ������ ������� �����鼭 �ڽ��� ��ü�� ������.
    addThread(st); //Vector�� �߰��Ѵ�.
    st.start(); 
   }
  }finally{
   if (s != null)
    s.close();
   if (ss != null)
    ss.close();
   System.out.println("**���� ����**");   
  }
 }
 
 //Ŭ���̾�Ʈ ���ӽ� ������ �����带 Vector�� �߰��ϴ� �޼���
 public void addThread(ServerThread st){
  
	 vector.add(st);
 }
 
 //Ŭ���̾�Ʈ�� ��������� �ش� ServerThread�� Vector���� ����
 public void deleteThread(ServerThread st){
  vector.remove(st);
 
 }
 
 //Ŭ���̾�Ʈ�� �޼����� Vector�� ����� ��� ServerThread(�����ڿ� ����)
 public void broadCasting(String message){
  for(int i=0; i<vector.size(); i++){
   ServerThread st = (ServerThread)vector.get(i);
   st.sendMessage(message);
  }
 }
 
 
 public static void main(String[] args) {
  
	TestServer ts = new TestServer();
  try {
   
	  ts.go(); //���Ϳ� ���� ������ ����
	  
  } catch (IOException e) {
   e.printStackTrace();
  }
  
 }
}
