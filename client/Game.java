

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JComponent;
import javax.swing.*;

public class Game extends JComponent implements ActionListener {
	private Image ball, plane;
	private Timer t;
	public int x = 50;
	public int y = 50;
	private int a = 100;
	private int b = 100;
	private int c = 200;
	private int d = 200;
	private Rectangle r1, r2, r3;

	public Game() {
		t = new Timer(5, this);
		t.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		ImageIcon[] i = new ImageIcon[2];
		i[0] = new ImageIcon(this.getClass().getResource("bomb.png"));
		i[1] = new ImageIcon(this.getClass().getResource("plane.png"));
		ball = i[0].getImage();
		plane = i[1].getImage();
		Graphics g2 = (Graphics) g;
		g2.drawImage(ball, a, b, 50, 50, null);
		g2.drawImage(ball, c, d, 50, 50, null);
		g2.drawImage(plane, x, y, 50, 50, null);
		r1 = new Rectangle(x, y, 40, 40);
		r2 = new Rectangle(a, b, 30, 30);
		r3 = new Rectangle(c, d, 30, 30);
		if (r1.intersects(r2) || r1.intersects(r2)) {
			System.out.println("Game Over");
			da = 0;
			db = 0;
			dc = 0;
			dd = 0;
		}
	}

	public void moveRight() {
		x = x + 5;
		repaint();
	}

	public void moveLeft() {
		x = x - 5;
		repaint();
	}

	public void moveDown() {
		y = y + 5;
		repaint();
	}

	public void moveUp() {
		y = y - 5;
		repaint();
	}

	int da = 1;
	int db = 1;
	int dc = 1;
	int dd = 1;

	public void move() {

		a = a + da;
		b = b + db;
		c = c + dc;
		d = d + dd;

	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		move();

		if (a == 0) {
			da = 1;
		} else if (a == 600 - 100) {
			da = -1;
		}
		if (b == 0) {
			db = 2;
		} else if (b == 600 - 100) {
			db = -1;
		}
		if (c == 0) {
			dc = 2;
		} else if (c == 600 - 100) {
			dc = -1;
		}
		if (d == 0) {
			dd = 1;
		} else if (d == 600 - 100) {
			dd = -1;
		}

		repaint();
	}
}