import java.io.*;
import java.util.*;
//Yonatan Shimroni
/*
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
Find the sum of all the primes below two million.

answer: 142913828922
*/

public class P10
{
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


public static long findSum(int limit)
{	
	boolean flag = false;
	int i = 3;
	long sum = 0L;
	while (i < limit)
	{
		if (i == limit)
		{
			break;
		}
		flag = isPrime(i);
		if (flag == true)
		{
			sum += i;
			System.out.println("Found a prime: "+i+" adding to sum = "+sum);

		}
		i += 2;
	}
	return sum + 2L;
}

public static void main(String[] args)
{
	long sum = 0L;
	sum = findSum(Integer.parseInt(args[0]));
	System.out.println("Sum of primes under "+ args[0]+" is: "+sum);
}

}