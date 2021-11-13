package _03_Hangman;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener{
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel labelWords = new JLabel();
	JLabel labelLives = new JLabel();
	Stack<String> words = new Stack<String>();
	String hangmanWord = "";
	
	int lives;
	
	public static void main(String[] args) {
	
     
		 Hangman object = new Hangman();
		object.setup();
		}
	

	public void setup() {
		lives = 10;
		frame.add(panel);
		panel.add(labelWords);
		frame.setSize(new Dimension(300,100));		
		labelLives.setText("lives : " + lives+"");
		panel.add(labelLives);
		frame.addKeyListener(this);
		frame.setVisible(true);
		
		String theNumber = JOptionPane.showInputDialog(null, "Pick a number less thatn 266");
		System.out.println(theNumber);
		
		words.add(Utilities.readRandomLineFromFile("dictionary.txt"));
		 hangmanWord = words.pop();
		int wordLength = hangmanWord.length();

		for (int i = 0; i < wordLength; i++) {
			labelWords.setText(labelWords.getText() + "_ ");
		}
		
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char keyTyped = e.getKeyChar();
	System.out.println(keyTyped);
	if(hangmanWord.contains(""+keyTyped)) {
			String before = labelWords.getText();
			for(int i = 0; i < hangmanWord.length(); i++) {
				if(hangmanWord.charAt(i) == keyTyped) {
					int neededRemoval = i*2;
					before = before.substring(0,neededRemoval)+keyTyped+before.substring(neededRemoval+1);
					
				}
			}
			String after = before;
			labelWords.setText(after);
			System.out.println(after);
		}else {
			lives--;
			labelLives.setText("lives : " + lives);
			if(lives==0) {
				JOptionPane.showMessageDialog(null, "GAME OVER  \n      GG" + "\n correct answer :" + hangmanWord);
				frame.dispose();
				int startOver = JOptionPane.showConfirmDialog(null, "Do you want to start over?");
				if(startOver == 0) {
				setup();
				}
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
