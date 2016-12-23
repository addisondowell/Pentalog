import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;

public class PentalogGame{ 
	public static Window window = new Window(900,700,"Pentalog");
	private static ImageIcon character = new ImageIcon("icyman.png");
	private static JLabel cHolder = new JLabel(character);
	public static boolean go;

	//variables for the idle state of the main character (no player input)
	public static boolean idleCheck = true;
	public static int idle = 0;

	public static void main(String[] args){
		//Turn on the window and the beginning of the game
		window.turnOn();

		//Draws the main guy
		window.screen.add(cHolder);
		window.screen.validate();

		go = true;
		yuri();
		//System.out.println("The yuri loop stopped");

	}

	public static void yuri(){
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
		window.screen.add(cHolder);
		window.screen.validate();
		if(idle == 0){
			idle = 1;
		} else {
			idle = 0;
		}

	}




}