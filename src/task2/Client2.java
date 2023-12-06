package task2;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Client2 {
	  public static void main(String args[] ) {
		  try
		  {
		  InetAddress ip = InetAddress.getByName("localhost");
		  Socket ClientSocket = new Socket (ip, 4000);
		  System.out.println("connecting to the server...");
		  DataInputStream input = new DataInputStream (ClientSocket.getInputStream());
		   DataOutputStream output = new DataOutputStream (ClientSocket.getOutputStream());
		   Scanner scanner = new Scanner (System.in);
		   String connectionconfirm = input.readUTF();
		   System.out.println("server: "+ connectionconfirm);
		   while(true ) {
			 String serverAsk = input.readUTF();
			 System.out.println("Server: "+ serverAsk );
			 String request = scanner.nextLine();
			 output.writeUTF(request);
			 if (request.contentEquals("close"))
			 {
				 System.out.println("closing the connection with this server");
				 ClientSocket.close();
	 		   	System.out.println("connection with server is closed");
	 		   	break;
	 		   	
			 }
			 String reply = input.readUTF();
			 System.out.println("server: "+reply);
		   }
		   scanner.close();
		   input.close();
		   output.close();
		  }
		  catch (IOException e)
		  {
			  System.out.println("connection with the server terminated");
			  
		  }
		  
	  }
	
}
