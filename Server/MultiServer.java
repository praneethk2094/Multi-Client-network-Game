//package cnProject;

//Handling multiple clients and checking for key inputs from client



import java.io.*;
import java.net.Socket;




public class MultiServer extends Thread{

	private Socket clientsocket = null;
	private PrintWriter out =null;
	private BufferedReader in=null;
	private boolean flag=true;
	
	public MultiServer(Socket clientSocket)
	{
		this.clientsocket=clientSocket;
	}


	public void run()
	{

		try
		{
			
			in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream())); 
			out = new PrintWriter(clientsocket.getOutputStream(), true);
			while(flag)
			{	
				String inString = in.readLine();
				clientMessageReadr(inString);
			}
			closeResources();
			stopThread();
		}
		catch(Exception e)
		{
			System.out.println("Client Exited");
			//e.printStackTrace();
		}


	}

//Here the server checks whether the Key entered by client is correct or not

	public void clientMessageReadr(String inString)
	{
		
			
			System.out.println("Waiting for key");
			//String inString = in.readLine();

			if (inString.equals("Right")) {
				System.out.println("key pressed" + inString);
				messagesender(inString);
			}
			if (inString.equals("Left")) {
				System.out.println("key pressed" + inString);
				messagesender(inString);
			}
			if (inString.equals("Down")) {
				System.out.println("key pressed" + inString);
				messagesender(inString);
			}
			if (inString.equals("Up")) {
				System.out.println("key pressed" + inString);
				messagesender(inString);
			}
			

	}


	public void messagesender(String message) {                                      
		try
		{
			out.println(message);
		}
		catch(Exception e)
		{
			closeResources();
			stopThread();
			e.printStackTrace();
		}
	} 

	@SuppressWarnings("deprecation")
	private void stopThread()
	{
		try
		{
			this.stop();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void closeResources()
	{
		try
		{
			if(in!=null)
			{
				in.close();
				in=null;
			}
			if(clientsocket!=null)
			{
				clientsocket.close();
				clientsocket=null;
			}
			if(out!=null)
			{
				out.close();
				in=null;
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


}
