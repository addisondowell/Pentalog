import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;

public class PentalogGame{ 
	//Window and boolean that tells us the game is running;
	public static Window window = new Window(900,700,"Pentalog");
	public static boolean go;

	//info for the initial character drawing
	private static int localeX;
	private static int localeY;
	private static int sizeX;
	private static int sizeY;
	private static ImageIcon character = new ImageIcon("icyman.png");
	private static JLabel cHolder = new JLabel(character);

	//variables for the idle state of the main character (no player input)
	public static boolean idleCheck = true;
	public static int idle = 0;

	public static void gameUpdate() {
		if(idleCheck == true){
			idleAnimation();
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

	public static void animation(){
		System.out.println("This will animate soon");
	}

	//Yuri is the "tick" function for the game, all animations, actions, etc, are synced here.
	public static void yuri(){
		go = true;
		long origin = System.nanoTime();
		while(go == true){
			double currently = (System.nanoTime() - origin) / 10e7;
			if(currently >= 1.0){
				System.out.println("A second has passed");
				gameUpdate();
				origin = System.nanoTime();
			}
		}
	}


	public static void main(String[] args){
		//Turn on the window and the beginning of the game
		window.turnOn();

		//Draws the main guy
		localeX=0;
		localeY=0;
		sizeX=90;
		sizeY=200;
		cHolder.setBounds(localeX, localeY, sizeX, sizeY);
		window.screen.add(cHolder);
		window.screen.repaint();

		yuri();
	}




}