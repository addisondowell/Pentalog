import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;


//Addison Dowell
//Keith Lovett
public class PentalogGame{ 
	//Window and boolean that tells us the game is running;
	private static Window window = new Window(900,700,"Pentalog");
	private static boolean go;

	//info for the initial character drawing
	private static int sizeX=90;
	private static int sizeY=200;
	private static int localeX=450-(sizeX/2);
	private static int localeY=350-(sizeY/2);
	private static ImageIcon character = new ImageIcon("icyman.png");
	private static JLabel cHolder = new JLabel(character);

	//variables for the idle state of the main character (no player input)
	private static boolean idleCheck = false;
	private static int idle = 0;

	//variables for the jump state of the main character
	private static boolean jumpCheck = true;
	private static int initialVelocity = 10;
	private static int jumpTime = 0;
	private static int height = localeY;
	private static int base = localeY;


	public static void gameUpdate() {
		if(idleCheck == true){
			idleAnimation();
		}
		if(jumpCheck == true){
			jumpAnimation();
		}
	}

	public static void idleAnimation() {
		window.screen.remove(cHolder);
		if(idle == 0){
			character = new ImageIcon("icyman2.png");
		}
		if(idle == 1){
			character = new ImageIcon("icyman.png");
		}
		cHolder = new JLabel(character);
		cHolder.setBounds(localeX, localeY, sizeX, sizeY);
		window.screen.add(cHolder);
		window.screen.repaint();
		if(idle == 0){
			idle = 1;
		} else {
			idle = 0;
		}
	}

	public static void jumpAnimation(){
		if(jumpTime > 5 && jumpTime < 16){
			initialVelocity = initialVelocity - 2;
		}
		height = height - initialVelocity;
		jumpTime += 1;
		window.screen.remove(cHolder);
		character = new ImageIcon("icyman.png");
		cHolder = new JLabel(character);
		cHolder.setBounds(localeX, height, sizeX, sizeY);
		window.screen.add(cHolder);
		window.screen.repaint();
		if(height >= base){
			jumpCheck = false;
			idleCheck = true;
		}
	}

	//Animates the background
	public void backgroundAnimation(){
		System.out.println("Background yayayaya");
	}

	//Yuri is the "tick" function for the game, all animations, actions, etc, are synced here.
	public static void yuri(){
		go = true;
		long origin = System.nanoTime();
		while(go == true){
			double currently = (System.nanoTime() - origin) / (10e7 + (10e7/2));
			if(currently >= 1.0){
				gameUpdate();
				origin = System.nanoTime();
			}
		}
	}


	public static void main(String[] args){
		//Turn on the window and the beginning of the game
		window.turnOn();
		//Draws the main guy
		cHolder.setBounds(localeX, localeY, sizeX, sizeY);
		window.screen.add(cHolder);
		window.screen.repaint();

		yuri();
	}

}