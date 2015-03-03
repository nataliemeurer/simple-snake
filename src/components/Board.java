package components;

import game.*;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.border.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JPanel;

public class Board extends JPanel {
	private Snake snake;
	private SnakeGame game;
	
	private final int B_WIDTH = 400;
	private final int B_ROW_COUNT = 25; 	// create n x n board
	private final int UNIT_WIDTH = (int)B_WIDTH / B_ROW_COUNT;
	
	private final int UP_KEY = 38;
	private final int DOWN_KEY = 40;
	private final int LEFT_KEY = 37;
	private final int RIGHT_KEY = 39;
	private final int PAUSE_KEY = 32;
	
	
	public Board(SnakeGame thisGame) {
		game = thisGame;
		snake = new Snake(this);
		initListeners();
		initGUI();
	}
	
	public void playGame(){
		while(true){
			
			try {
				
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void initGUI(){
		
		setBackground(new java.awt.Color(250, 250, 250));
		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		Dimension boardSize = new Dimension(B_WIDTH, B_WIDTH);
		setSize(boardSize);
		setVisible(true);
	}
	
	/* initListeners - setup keyListeners and add them to the 
	 * JPanel (the board)
	 * 
	 * @param none
	 * @return none
	 * 
	 */
	public void initListeners() {
		KeyListener listener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		};
		addKeyListener(listener);
		
		// The keyboard can only listen on the focused component.
		// Here, we set the focus to the JPanel that the keyboard
		//listening to.
		setFocusable(true);

	}
	
	@Override
	public void paint(Graphics theGraphic) {
		super.paint(theGraphic);
		Graphics2D the2DGraphic = (Graphics2D) theGraphic;
		the2DGraphic.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		snake.paint(the2DGraphic);
//		racquet.paint(the2DGraphic);
	}
	
	public int getUnitWidth(){
		return UNIT_WIDTH;
	}
	
	
	
}