package _00_IntroToStacks;

import java.util.Stack;

import javax.swing.JOptionPane;

import java.util.Random;

public class _01_IntroToStack {
	public static void main(String[] args) {
		// 1. Create a Stack of Doubles
		// Don't forget to import the Stack class
		Stack<Double> doubleStack = new Stack<Double>();
		Random random = new Random();
		// 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		for (int i = 0; i < 100; i++) {

			doubleStack.push(random.nextDouble());
		}
		// 3. Ask the user to enter in two numbers between 0 and 100, inclusive.
		String number1 = JOptionPane.showInputDialog("Choose a number between 0 and 100 inclusive.");
		String number2 = JOptionPane.showInputDialog("Choose a number between 0 and 100 inclusive, but not the exact one as last time.");
		// 4. Pop all the elements off of the Stack. Every time a double is popped that
		// is
		// between the two numbers entered by the user, print it to the screen.
		double number22 = Double.parseDouble(number2);
		double  number11 = Double.parseDouble(number1);
		if (number11 >= number22) {
			for (int i = 0; i < 100; i++) {
				if (i < number11 && i > number22) {
					System.out.println(doubleStack.pop());
				} else {
					doubleStack.pop();
				}
			}

		} else {
			for (int i = 0; i < 100; i++) {
				if (i < number22 && i > number11) {
					System.out.println(doubleStack.pop());
				} else {
					doubleStack.pop();
				}

			}

		}
		// EXAMPLE:
		// NUM 1: 65
		// NUM 2: 75

		// Popping elements off stack...
		// Elements between 65 and 75:
		// 66.66876846
		// 74.51651681
		// 70.05110654
		// 69.21350456
		// 71.54506465
		// 66.47984807
		// 74.12121224
	}

	private static int IntegerParseInt(String number2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
