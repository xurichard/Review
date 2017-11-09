/* 
	HailStone.java 
	http://mvhs-fuhsd.org/java/Prompts/U05-Loops/Hailstone.pdf
*/
import java.util.Arrays;	
import java.util.Scanner;

public class HailStone
{

	public static void main(String[] args) {
		HailStone HS = new HailStone();

		Scanner scanner = new Scanner(System.in);
		int n = 1;

		while(true){
			System.out.print("Enter a positive integer ( 1 - 10000 ). To quit, enter -1: ");

			if (scanner.hasNextInt())
	            n = scanner.nextInt();
	        else {
	            scanner.next();
	            continue;
	        }

			if(n >= 1 && n <= 1000){
				HS.findIt(n);
			} else if(n == -1){
				break;
			} else{
				System.out.println("Enter a value within the range, please!");
			}
		}

		System.out.println("Thank you for playing Hailstone.");
		scanner.close(); 
	}


	public void findIt(int n){
		int totalRuns = 0;
		int[] line = new int[10];
		line[0] = n;
		while(n != 1){
			//Hailstorm pattern
			if(n%2 == 0){
				n = n/2;
			} else{
				n = n*3 + 1;
			}
			totalRuns += 1;

			//Keeping track of lines
			if(totalRuns % 10 == 0){
				this.printLine(line);
				line = new int[10];
			}
			line[totalRuns%10] = n;
		}
		this.printLine(line);

		totalRuns += 1; // to account for the first loop
		System.out.println("The loop executed " + totalRuns + " times.");
	}

	public void printLine(int[] arr){
		String temp = "";
		for(int i = 0; i < arr.length; i ++){
			if(arr[i] != 0){
				temp += arr[i] + " "; //Adds one more space at the end of each line
			}
		}
		System.out.println(temp);
	}
}

// Test cases: 20, 30, -3, -1
// Edge cases: non integer inputs, 1, 0, 1001









