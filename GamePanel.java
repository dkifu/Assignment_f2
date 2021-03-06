package f2.spw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	private BufferedImage bi;	
	Graphics2D big;
	ArrayList<Sprite> sprites = new ArrayList<Sprite>();

	public GamePanel() { 
		bi = new BufferedImage(400, 650, BufferedImage.TYPE_INT_ARGB); //set buffer size of game area
		big = (Graphics2D) bi.getGraphics();
		big.setBackground(Color.BLACK); //set background color
	}

	public void updateGameUI(GameReporter reporter){

		
		big.clearRect(0, 0, 400, 650); //set size of game area
		
		big.setColor(Color.WHITE);		
		big.drawString(String.format("%08d", reporter.getScore()), 300, 20); //score display

		for(Sprite s : sprites){
			s.draw(big);
		}
		
		repaint(); //draw graphic game
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bi, null, 0, 0);
	}

}