
package chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
/**
 * �������� �Ѿ���� �����͸� ��� �д� ������
 */
public class ClientThread extends Thread{
 
	private Socket socket;
 private BufferedReader br = null;
 
 public ClientThread(Socket s){
  this.socket = s;
 }
 
 //run()�� �����Ҷ� �޼ҵ� ȣ��, Ʈ����ĳġ
 public void run(){
  try {
   service();
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
 }
 
 private void service()throws IOException{
  
	 try{
   br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
   
   while(true){
    String str = br.readLine();
    if(str == null){
     break;
    }
    System.out.println(str);
   }
  }catch(IOException e){
   System.out.println("����!!");
  }finally{
   if (br != null)
    br.close();
   if (socket != null)
    socket.close();
  }
 } 
}