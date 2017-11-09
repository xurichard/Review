/* 
	NumberSequence.java 
	http://mvhs-fuhsd.org/java/Prompts/U05-Loops/NumberSequence.pdf
	
	Creates a quadratic equation
	queries users for next point and equation

*/

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;	

public class NumberSequence
{
	// store equation as y = ax^2 + bx + c, can be addition, sub, mult or div
	private int a;
	private int b;
	private int c;
	private Scanner scanner; 

	public static void main(String[] args) {
		NumberSequence game = new NumberSequence();
		game.run();
	}

	// generates [a,b,c]
	public void equationGenerator(){
		Random rand = new Random();

		this.a = 10 - rand.nextInt(20) -1; // range [-10, 10]
		this.b = 10 - rand.nextInt(20) -1;
		this.c = 10 - rand.nextInt(20) -1;
	}

	public void run(){
		this.scanner = new Scanner(System.in);

		this.equationGenerator();

		int[] points = new int[5]; // to get our pattern
		for(int i = 0; i < points.length; i++){
			points[i] = this.runEquation(i);
		}

		int answer = this.runEquation(5);

		if(this.findPattern(points, answer) && this.checkEquation()){
			System.out.println("Congradulations you found the right equation!");
		} else{
			System.out.println("You have failed");
		}

		this.scanner.close(); 
	}

	public boolean findPattern(int[] points, int answer){
		// Print pattern
		System.out.println(answer);
		String pointsStr = Arrays.toString(points);
		System.out.println(pointsStr.substring(1, pointsStr.length()-1) + ",__");
		
		// Finding next number
		int tries = 0; // Three tries
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
	        	break;
	        } else{
	        	System.out.print("Try again.");
	        }
	        tries += 1;
	    }

	    if(tries == 3){
	    	System.out.print("Out of tries");
	    	return false;
	    } else{
	    	return true;
	    }
	}

	public boolean checkEquation(){
		int tries = 0; // Three tries
		System.out.println(this.a);
		System.out.println(this.b);
		System.out.println(this.c);
		this.scanner.nextLine(); // to flush out stndin
		for(int i = 0; i < 3; i ++){
			String answer = "";
			System.out.print("What’s the pattern? format as 'a,b,c' in y=ax^2+bx+c: ");
			if (this.scanner.hasNextLine())
	            answer = this.scanner.nextLine();
	        else {
	            this.scanner.next();
	            System.out.print("Try again.");
	            continue;
	        }

	        String[] answerSplit = answer.split(",");
	        System.out.println(Integer.parseInt(answerSplit[0])==this.a);

			if(answerSplit.length == 3 && Integer.parseInt(answerSplit[0])==this.a && Integer.parseInt(answerSplit[1])==this.b && Integer.parseInt(answerSplit[2])==this.c){
				break;
			} else{
				System.out.print("Try again.");
			}
			tries += 1;

	    }

		if(tries == 3){
	    	System.out.print("Out of tries");
	    	return false;
	    } else{
	    	return true;
	    }

	}

	public int runEquation(int n){
		return this.a * n*n + this.b * n + this.c;
	}
}












