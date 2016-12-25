import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window{
	public static JFrame frame;
	public static JPanel screen;

	public Window(int w, int h, String title){
		frame = new JFrame(title);
		screen = new JPanel();
		Dimension d = new Dimension(w, h);

		frame.setSize(d);
		frame.setMaximumSize(d);
		frame.setMinimumSize(d);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		screen.setSize(d);
		screen.setBackground(Color.black);
		screen.setLayout(null);
		frame.getContentPane().add(screen);

		//noGap();
	}

	public void turnOn(){
		frame.setVisible(true);
		frame.setResizable(false);
	}

	//may not be necessary
	/**
	public void noGap(){
		FlowLayout layout = (FlowLayout)screen.getLayout();
		layout.setVgap(0);
		layout.setHgap(0);
	}
	*/

	public static void main(String[] args){
		Window window = new Window(800, 500, "WindowWindow");
		window.turnOn();
	}
}