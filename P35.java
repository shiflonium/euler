import java.util.ArrayList;
import java.lang.StringBuilder;
//Euluer P35 Yonatan Shimroni
public class P35{

	ArrayList<String> primes;
	/**
	*This constructor will generate a P35 object containing an ArrayList with all
	*prime numbers under the upper bound that do not contain even digits or 5 (exluding the number 5)
	*since these numbers can never be circular primes
	*/
	public P35(int upperBound){
		primes = new ArrayList<String>();
		for (int i = 1; i < upperBound; i++){
			if (isPrime(i) && !(isContainEven(i))){
					primes.add(Integer.toString(i));
			}
		}
	}

	/**
	*This method checks if a number is prime or not
	*/
	public static boolean isPrime(double num)
	{	
		if(num <= 1)
    		return false;
  		
  		int s = (int)Math.sqrt(num);
  		
  		for(int i = 2; i <= s; i++)
    	
    		if(num % i == 0)
      			return false;
  		
  		return true;
		
	}
	/**
	*This method will determine if the number needs to be tested for circular prime
	*if number contains an even digit then there is no point to check since it cannot be
	* a circular prime number	
	*/
	public static boolean isContainEven(int num){
		if (num == 2)
			return false;
		String [] strNumArr = Integer.toString(num).split("");
		for (int i = 0; i < strNumArr.length; i++){
			if (Integer.parseInt(strNumArr[i]) % 2 == 0 || 
				(Integer.parseInt(strNumArr[i]) == 5) && Integer.parseInt(strNumArr[i]) > 5){
				return true;
			}

		}
		return false;
	}

	/**
	*This method will check all the rotations of a number for being prime. if this fails
	*once then we know that the nu,ber is not a circulr prime
	*/
	public static boolean isCircular(ArrayList<Integer> list){
		boolean flag = true;
		for (int i = 0; i < list.size(); i++){
			if (!isPrime(list.get(i))){
				flag = false;
				return flag;
			}
		}
		return flag;
	}

	/**
	*This method will generate all the rotations of a number. rotatations are different then all permutations
	*in the following manner: it is only the permuatations when sfhiting the first digit from the right
	* to the end of the number until we have completed a full round of shifting
	*/
	public static ArrayList<Integer> rotataions(int num){
		int size = Integer.toString(num).length();
		ArrayList<Integer> result = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder(Integer.toString(num));
		for (int i = 0; i < size; i++){
			result.add(Integer.parseInt(sb.toString()));
			sb.append(sb.substring(0,1));
			sb.deleteCharAt(0);		
		}

		return result;
	}


	public static void main(String[] args){
		P35 test = new P35(1000000);
		int count = 0;
		ArrayList<String> candidates = test.primes;
		for (int i = 0; i < candidates.size(); i++){	
			ArrayList<Integer> per = new ArrayList<Integer>();	
			per = rotataions(Integer.parseInt(candidates.get(i)));
			if (isCircular(per)){
				System.out.println(per.get(0));
				count++;
			}
		}
		
		System.out.println("\n" + "Number of circular primes under 1000000: " + count);
	}


}