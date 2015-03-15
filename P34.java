import java.math.BigInteger;

public class P34{
	private static int fact = 0;
	public static int factorial(int n){
			int result  = 1, i = 1;

			while(i <= n){
				result *= i;
				i++;
			}
			return result;
	}

	public static boolean isCurious(int num){
		int candidate = num;
		int factSum = 0;
		if (candidate > 10 && factorial(num) > candidate)
			return false;
		while (num != 0){

			factSum = factSum + factorial(num % 10);
			if (factSum > candidate)
				return false;
			num = num / 10;
		}

		if (factSum == candidate)
			return true;
		
		else
			return false;

	}

	public static void main(String[] args){
		int sum = 0;
		for (int i = 3; i <= 3265920; i++){
			System.out.println("Checking number: " + i);
			if (isCurious(i)){
				sum = sum + i;
				System.out.println("Added: " + i);}
		}
		
		
		System.out.println(sum);
	}
		
		
		
		
}