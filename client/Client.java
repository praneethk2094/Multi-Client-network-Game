
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;

public class Client extends JFrame implements KeyListener {
	private static Game draw;
	public static boolean flag = true;
	private final static String SERVER_NAME = new String("localhost");
	public static PrintWriter out;
	public static BufferedReader in;

	public void keyPressed(KeyEvent e) {
		flag = true;

		System.out.println("keyPressed");
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			out.println("Right");
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			out.println("Left");

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			out.println("Down");

		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			out.println("Up");

		}

	}

	public void keyReleased(KeyEvent e) {
		System.out.println("Key Released");
	}

	public void exit() {

		System.exit(0);

	}

	public void keyTyped(KeyEvent e) {
		System.out.println("keyTyped");

	}

	public Client() {

		this.draw = new Game();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	public static void main(String[] args) {
		// javax.swing.SwingUtilities.invokeLater(new Runnable() {
		// public void run() {
		try {
			InetAddress dstIP = InetAddress.getByName(SERVER_NAME);

			// Create local socket and connect to server
			Socket clientSocket = new Socket(dstIP, Integer.parseInt("6200"));

			// Get the input and output streams of the socket
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			// out.println("Message from client");

			Client frame = new Client();
			frame.setTitle("Square Move Practice");
			frame.setResizable(false);
			frame.setSize(600, 600);
			frame.setMinimumSize(new Dimension(600, 600));
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(frame.draw);
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			Container c = frame.getContentPane();

			c.setBackground(new Color(56, 179, 203));
			while (flag = true) {
				System.out.println("Waiting for Server key");

				String inString = in.readLine();
				// if(String instanceof String){
				// String inString=String.toString();
				if (inString.equals("Right")) {
					draw.moveRight();

				}
				if (inString.equals("Left")) {
					draw.moveLeft();
				}
				if (inString.equals("Down")) {
					draw.moveDown();
				}
				if (inString.equals("Up")) {
					draw.moveUp();
				}
				System.out.println("print Crossed");
			}

		} catch (Exception e) {
			System.out.println("Exception catched");
			e.printStackTrace();
		}
	}
}