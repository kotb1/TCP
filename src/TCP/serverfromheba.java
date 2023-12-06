package TCP;
import java.net.ServerSocket;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.DataInputStream;
import java.net.Socket;
import java.util.Scanner;
public class serverfromheba {
	static ServerSocket serverSocket ;
	public static void main(String arg[])
	{
		try
		{
		
			serverSocket = new ServerSocket (6003);
			System.out.println("the server is booted up");
	
   
   while (true)
   {
	   Socket clientSocket = serverSocket.accept();
	   System.out.println("A new client is connected to the server");
	   DataInputStream input = new DataInputStream(clientSocket.getInputStream());
	   DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
	   Scanner scanner = new Scanner (System.in);
	   output.writeUTF("connected");
	   
	   while(true)
	   {
		   output.writeUTF("send your request or 'close' to terminate the connection");
		   String request = input.readUTF();
		   output.writeUTF("server: "+request);
		   if(request.equals("close"))
		   {
			   System.out.println("closing the connection with this client");
			   clientSocket.close();
			   System.out.println("the connection with this client is closed");
			   break;
		   }
		   //String reply = scanner.nextLine();
		   //output.writeUTF(reply);
		   
	   }
	   scanner.close();
		 input.close();
		 output.close();
   }
		}
 
		catch(IOException e)
		{
			System.out.println("problem with socket server");
		}
		}
   }

