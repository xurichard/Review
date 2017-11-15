/* 
	NumberSequence.java 
	http://mvhs-fuhsd.org/java/Prompts/U05-Loops/NumberSequence.pdf
*/

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;	

public class NumberSequence2
{
	private int diff;
	private Scanner scanner;

	public static void main(String[] args) {
		NumberSequence2 game = new NumberSequence2();
		game.run();
	}

	public void run(){
		this.scanner = new Scanner(System.in);
		this.equationGenerator();

		if(this.findPattern() && this.checkPattern()){
			System.out.println("Congradulations you found the right pattern!");
		} else{
			System.out.println("You have failed");
		}

		this.scanner.close(); 
	}

	public void equationGenerator(){
		this.diff = new Random().nextInt(21); //[0,21)
		// this.operator = ((new Random().nextInt(2) > 0) ? "Add" : "Subtract");
		if(new Random().nextInt(2) > 0) {this.diff = this.diff * -1;}
	}

	public boolean findPattern(){
		int firstNum = new Random().nextInt(11); //[0,11)
		System.out.print(firstNum + ", ");
		for(int i = 0; i < 5; i ++){
			firstNum += this.diff;
			System.out.print(firstNum + ", ");
		}
		System.out.println();
		int answer = firstNum + this.diff;
		for(int i = 0; i < 3; i ++){
			int n = 0;
			System.out.print("What’s the next number?");
			if (this.scanner.hasNextInt())
	            n = this.scanner.nextInt();
	        else {
	            this.scanner.next();
	            System.out.print("Try again.");
	            continue;
	        }
	        if(n == answer){
	        	return true;
	        } else{
	        	System.out.print("Try again.");
	        }
	    }
	    System.out.print("Out of tries");
	    return false;
	}

	public boolean checkPattern(){
		this.scanner.nextLine(); // to flush out stndin
		for(int i = 0; i < 3; i ++){
			String answer = "";
			System.out.print("What’s the pattern? (format as add/subtract value) ");
			if (this.scanner.hasNextLine())
	            answer = this.scanner.nextLine();
	        else {
	            this.scanner.next();
	            System.out.print("Try again.");
	            continue;
	        }

			if(diff<0 && answer.contains("subtract") && answer.contains(Integer.toString(Math.abs(this.diff))) || diff>0 && answer.contains("add") && answer.contains(Integer.toString(this.diff)) || diff==0 && (answer.contains("add") || answer.contains("subtract")) && answer.contains(Integer.toString(this.diff))){
				return true;
			}
	    }
	    return false;
	}

}












