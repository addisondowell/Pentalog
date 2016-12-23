import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window extends JFrame{
    public static JFrame frame;
    public static JPanel screen;
    
    public Window(int w, int h, String title){

	/*
	 * Creates a frame labelled by String title and panel
	 * with dimensions w width and h height.
	 */

	
	frame = new JFrame(title);
	screen = new JPanel();
	Dimension d = new Dimension(w, h);

	//Adjusting frame
	
	frame.setSize(d);
	frame.setMaximumSize(d);
	frame.setMinimumSize(d);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//Adjusting screen
	
	screen.setSize(d);
	screen.setBackground(Color.blue);
	frame.getContentPane().add(screen);

	//noGap is a User-defined method
	
	noGap();
    }

    private static void lineDraw(){

	Graphics g = screen.getGraphics();
	g.drawLine(0,0,500,500);

    }
    
    public void turnOn(){
	/*
	 * Toggles visibilitity and resizability of window.
	 */
	
	frame.setVisible(true);
	frame.setResizable(false);
    }
    
    public void noGap(){

	/*
	 * Sets a vertical and horizontal gap of 0 for JPanel screen.
	 */
	
	FlowLayout layout = (FlowLayout)screen.getLayout();
	layout.setVgap(0);
	layout.setHgap(0);
    }
    
    public static void main(String[] args){
	Window window = new Window(500, 500, "test");
	window.turnOn();

	lineDraw();
	
	System.out.println("Hello!");
    }
}
