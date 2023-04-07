import java.awt.Color;

import java.awt.Color.*;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import javax.swing.ImageIcon;


public class MyFrame extends JFrame implements KeyListener
{
	private static final long serialVersionUID = 1L;
	JLabel label;
	ImageIcon personaggioDestra = new ImageIcon(getClass().getResource("/dx.png"));
	ImageIcon personaggioSinistra = new ImageIcon(getClass().getResource("/sx.png"));
	ImageIcon personaggio = personaggioDestra;
	String direzione = "sinistra";
	//BufferedImage icon;
	
	MyFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.black);
		
		//getImage();
		//BufferedImage scaledImage = new BufferedImage(200, 200, icon.getType());
		label = new JLabel();
		label.setBounds(0, -200, 500, 500);
		
		//label.setBackground(Color.red);
		//label.setOpaque(true);
		this.addKeyListener(this); 
		label.setIcon(personaggio);
		this.add(label);
		this.setVisible(true);
	}
	
	/*
	public void getImage() {
		try {
            icon = ImageIO.read(getClass().getResourceAsStream("/personaggio.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	/*
	public BufferedImage setup(String imagePath, int width, int height) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(imagePath + ".png")));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return UtilityTool.scaleImage(image, width, height);
    }
	*/
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyChar()) {
		
		case 'a': label.setLocation(label.getX()-10, label.getY());
				label.setIcon(personaggioSinistra);
			break;
		case 'w': label.setLocation(label.getX(), label.getY()-10);
			break;
		case 's': label.setLocation(label.getX(), label.getY()+10);
			break;
		case 'd': label.setLocation(label.getX()+10, label.getY());
				label.setIcon(personaggioDestra);
			break;
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()) {
		
		case 37: label.setLocation(label.getX()-10, label.getY());
				label.setIcon(personaggioSinistra);
			break;
		case 38: label.setLocation(label.getX(), label.getY()-10);
			break;
		case 39: label.setLocation(label.getX()+10, label.getY());
				label.setIcon(personaggioDestra);
			break;
		case 40: label.setLocation(label.getX(), label.getY()+10);
			break;
		
		}
	}

//	@Override
	public void keyReleased(KeyEvent e) {
//		System.out.println("You releasd key char: " + e.getKeyChar());
//		System.out.println("You releasd key code: " + e.getKeyCode());
	}
	
	 
}