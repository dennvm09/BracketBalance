package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author Dennys Valentina Mosquera
 *  19/02/2019
 *  AED - 191
 */

public class BracketBalance {

	char pA = '(';
	char lA = '[';
	char cA = '{';
	
	public boolean checkBalanced(String data) {
		Stack<Character> c = new Stack<>();
		boolean balanced = false;
		for(int i = 0; i < data.length(); i++) {
			if(data.charAt(i) == pA || data.charAt(i) == cA || data.charAt(i) == lA) {
				c.push(data.charAt(i));
			}else {
				switch(data.charAt(i)) {
				case ')':
					if(c.peek() == '(') {
//						System.out.println(c.pop());
						c.pop();
						balanced = true;
					}
					break;
				case ']':
					if(c.peek() == '[') {
//						System.out.println(c.pop());
						c.pop();
						balanced = true;
					}
					break;
				case '}':
					if(c.peek() == '{') {
//						System.out.println(c.pop());
						c.pop();
						balanced = true;
					}
					break;
				default:
					balanced = false;
				}
			}
		}
//		System.out.println(c.isEmpty());
		return balanced;
	}


	public static void main(String[] args) throws IOException {
		BracketBalance bb = new BracketBalance();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String data = reader.readLine();
		boolean balanced = bb.checkBalanced(data);
		
		if(balanced) {
			System.out.println("Balanced");
		}else {
			System.out.println("Not Balanced");
		}
		
	}
}
