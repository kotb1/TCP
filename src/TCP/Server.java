package TCP;
import java.io.IOException;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
public class Server {
	   static ServerSocket ServerSocket;
	   public static void main(String args[] ) {
		   try
		   {
			  ServerSocket = new ServerSocket(4000); 
			  System.out.println("system is booted up");
		   
		   while (true)
		   {
			   Socket clientSocket = ServerSocket.accept();
			   System.out.println("A new client is connected to Server.");
			   DataInputStream input = new DataInputStream (clientSocket.getInputStream());
			   DataOutputStream output = new DataOutputStream (clientSocket.getOutputStream());
			   Scanner scanner = new Scanner (System.in);
	           output.writeUTF("CONNECTED");
	           while (true)
	           {
	        	   output.writeUTF("PLease enter ur number");
	        	   String request = input.readUTF();
	        	   int n = Integer.parseInt(request);
	        	   System.out.println(n);
                   int a[]= {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47};
	       		   for(int i=0;i<15;i++)
	       		   {
	       			   if(n == a[i])
	       			   {
	       				   output.writeUTF("This number is prime");
	       			   }
	       		   }
	       		for(int i=0;i<15;i++)
	       		   {
	       			   if(n != a[i])
	       			   {
	       				   continue;
	       			   }
	       		   }
	       		   
	       			  
	       			   if(n%2 == 0) {
	       				   output.writeUTF("this number is even");
	       				   
	       			   }
	       			   else {
	       				   output.writeUTF("This number is odd");
	       			   }
	       			
	       		   
	       		   
	        	   if(request.equals("close"))
	        	   {
	        		   	System.out.println("Closing the connection with this client");
	        		   	clientSocket.close();
	        		   	System.out.println("The connection with this client has closed");
	        		   	break;
	        		   	
	        	   }
	        	   String reply = scanner.nextLine();
	        	   output.writeUTF(reply); 
	           }
	           scanner.close();
	    	   input.close();
	    	   output.close();
		   }
		   }
		   catch(IOException e)
		   {
			   System.out.println("problem with socket Server");
		   
		   }
		   
	        }
}
