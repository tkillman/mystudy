
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
 
 
 ServerThread(Socket s, TestServer ts){ //생성자
  this.socket = s;
  this.ts = ts;
  userIP = socket.getInetAddress().toString();
 }
 /**
  * 스레드가 종료시 deleteThread()해서
  * 벡터에 저장된 자신을 삭제한다.
  */
 public void run(){
  /**
   * client에서 읽은 메세지를 broadCasting()호출해서 
   * 전체 client에 전달되게 한다.
   */
  try{
   service();
  }catch(IOException e){
   System.out.println("**"+userIP+"님 접속 종료.");
  }finally{
   //종료직전 Vector에 자신의 스레드를 삭제
   ts.deleteThread(this);
  }
 }
 
 private void service() throws IOException{
  /**
   * TestServer의 broadCasting()에서 각 스레드에 연결된
   * 클라이언트에게 메세지를 보내기 위해서 호출하는 메서드
   */
  try{
   br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
   pw = new PrintWriter(socket.getOutputStream(), true);
   String str = null;
   
   while(true){
    str = br.readLine();
    if(str == null){
     System.out.println(userIP+"님이 연결을 종료했습니다.");
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
