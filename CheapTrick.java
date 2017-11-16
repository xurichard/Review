public class CheapTrick
{

	public static void main(String[] args) {
		for(int i = 0; i < 7; i++){
			if(i%2 == 0){
				verse();
			} else{
				chorus();
			}
			System.out.println();
		}
	}


	public static void verse(){
		String firstTwo = "";
		String secondToLast = "";
		for(int i = 0; i < 7; i++){
			// same thing as if else statements but with a switch statement
			// switch (i%4) {
			// 	case 0:	
			// 		firstTwo = "I want";
			// 		secondToLast = "want";
			// 		break;
			// 	case 1:
			// 		firstTwo = "I need";
			// 		secondToLast = "need";
			// 		break;
			// 	case 2:
	  		//		firstTwo = "I'd love";
			// 		secondToLast = "love";
			// 		break;
			// 	case 3:
			// 		firstTwo = "I'm begging";
			// 		secondToLast = "beg";
			// 		break;
			// }

			if(i%4 == 0){
				firstTwo = "I want";
				secondToLast = "want";
			} else if (i % 4 == 1) {
				firstTwo = "I need";
				secondToLast = "need";
			} else if (i % 4 == 2) {
				firstTwo = "I'd love";
				secondToLast = "love";
			} else if(i%4 == 3){
				firstTwo = "I'm begging";
				secondToLast = "beg";
			}

			System.out.println(firstTwo + " you to " + secondToLast + " me");
		}



	}



	public static void chorus(){
		System.out.println("I'll shine up the old brown shoes");
		System.out.println("Put on a brand new shirt");
		System.out.println("I'll get home early from work");
		System.out.println("If you say that you love me");
		System.out.println("Didn't I, didn't I, didn't I see you crying");
		System.out.println("Feeling all alone without a friend, you know you feelin like dying");
		System.out.println("Oh, didn't I, didn't I, didn't I see you crying");
	}

}