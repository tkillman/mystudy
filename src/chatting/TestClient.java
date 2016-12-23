
package chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClient {
 /**
  * ClientThread(�������� �Ѿ���� �����͸� �д� ����) �����ؼ� start()
  * ClientThread�� �ѹ��� ����
  */
 private Socket s;
 private BufferedReader br;
 private PrintWriter pw;
 
 public void go() throws UnknownHostException, IOException{
  try{
   s = new Socket("127.0.0.1", 5432);
//   s = new Socket("192.168.0.108", 5432);
   //�������� ���޵Ǵ� �޽����� �д� ���
   ClientThread ct = new ClientThread(s);
   ct.start();
   
   //console���� �о ������ ������ ������ ���
   br = new BufferedReader(new InputStreamReader(System.in));
   pw = new PrintWriter(s.getOutputStream(), true);
   
   while(true){
    String str = br.readLine();
    if(str.equalsIgnoreCase("exit")){
     break;
    }
    pw.println(str);
   }
  }finally{
   if (pw != null)
    pw.close();
   if (br != null)
    br.close();
   if (s != null)
    s.close();
   System.out.println("**���� ����**");
  }//close all
 }
 
 public static void main(String[] args) {
  TestClient tc = new TestClient();
  try {
   tc.go();
  } catch (UnknownHostException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
 }

}