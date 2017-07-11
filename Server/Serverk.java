//package cnProject;



import java.io.*;

import java.net.*;

//import cnProject.MultiClientServerThread;

/**
 * @author sjp111
 *
 */
public class Serverk {
	//public InputStream in;
	//public OutputStream out;
	private static Socket clientsocket = null;
	// Port number that server listens to
	// private final static int DEST_PORT = 5985;

	/**
	 * @param args
	 */
	public Serverk() {

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// Create server socket
			ServerSocket svrSocket = new ServerSocket(Integer.parseInt(args[0]));

			while (true) {
				// Accept client request, this returns a local Socket
				// to communicate with the client
				System.out.println("Waiting for client:");
				clientsocket = svrSocket.accept();

				InetAddress clientIP = clientsocket.getInetAddress();
				System.out.println("Connected to " + clientIP.toString());
				MultiServer m=new MultiServer(clientsocket);
				m.start();

				} while (flag = true);*/


			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
