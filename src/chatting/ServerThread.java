
package chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
 private Socket socket;
 private TestServer ts;
 private BufferedReader br = null;
 private PrintWriter pw = null;
 private String userIP = null;
 
 
 ServerThread(Socket s, TestServer ts){ //������
  this.socket = s;
  this.ts = ts;
  userIP = socket.getInetAddress().toString();
 }
 /**
  * �����尡 ����� deleteThread()�ؼ�
  * ���Ϳ� ����� �ڽ��� �����Ѵ�.
  */
 public void run(){
  /**
   * client���� ���� �޼����� broadCasting()ȣ���ؼ� 
   * ��ü client�� ���޵ǰ� �Ѵ�.
   */
  try{
   service();
  }catch(IOException e){
   System.out.println("**"+userIP+"�� ���� ����.");
  }finally{
   //�������� Vector�� �ڽ��� �����带 ����
   ts.deleteThread(this);
  }
 }
 
 private void service() throws IOException{
  /**
   * TestServer�� broadCasting()���� �� �����忡 �����
   * Ŭ���̾�Ʈ���� �޼����� ������ ���ؼ� ȣ���ϴ� �޼���
   */
  try{
   br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
   pw = new PrintWriter(socket.getOutputStream(), true);
   String str = null;
   
   while(true){
    str = br.readLine();
    if(str == null){
     System.out.println(userIP+"���� ������ �����߽��ϴ�.");
     break;
    }
    ts.broadCasting("["+userIP+"]"+str);
    pw.println(str);
   }
  }finally{
   if (pw != null)
    pw.close();
   if (br != null)
    br.close();
   if (socket != null)
    socket.close();
  }
 }
 /**
  * TestServer
  */
 
 public void sendMessage(String message){
  pw.println(message);
 }
}
