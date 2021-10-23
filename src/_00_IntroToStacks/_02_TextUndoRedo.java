package _00_IntroToStacks;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JButton button = new JButton();
	Stack<String> charStack = new Stack<String>();

	public static void main(String[] args) {

		/*
		 * Create a JFrame with a JPanel and a JLabel.
		 * 
		 * Every time a key is pressed, add that character to the JLabel. It should look
		 * like a basic text editor.
		 * 
		 * Make it so that every time the BACKSPACE key is pressed, the last character
		 * is erased from the JLabel.
		 * 
		 * Save that deleted character onto a Stack of Characters.
		 * 
		 * Choose a key to be the Undo key. Make it so that when that key is pressed,
		 * the top Character is popped off the Stack and added back to the JLabel.
		 */

		_02_TextUndoRedo classObject = new _02_TextUndoRedo();
		classObject.writing();
	}

	public void writing() {

		frame.add(panel);
		panel.add(label);
		label.setText(" ");
		frame.setVisible(true);
		frame.addKeyListener(this);
		frame.setSize(new Dimension(500, 300));

	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			label.setText(label.getText() + charStack.pop());
			System.out.println(e.getKeyCode());
		} else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

			char toBeStacked = label.getText().charAt(label.getText().length() - 1);
			String toBeReplaced = label.getText().substring(0, label.getText().length() - 1);
			label.setText(toBeReplaced);
			String stringStacked = Character.toString(toBeStacked);
			charStack.add(stringStacked);

		} else {
			char keytyped = e.getKeyChar();
			String putInBuilder = Character.toString(keytyped);
			label.setText(label.getText() + putInBuilder);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
