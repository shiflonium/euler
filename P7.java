import java.io.*;
import java.util.*;
//Yonatan Shimroni
/*
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
What is the 10 001st prime number?

Answer: 104743
*/



public class P7
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

	public static void main(String[] args)
	{
		int count = 6;
		int primeNum = Integer.parseInt(args[0]);
		while (count <10001)
		{
			if (isPrime(primeNum))
			{
				count++;
				System.out.println("Found a prime.\nCount is: " + count + "\nPrime is: "+primeNum);
			}
			if (count < 10001)
			{
				primeNum += 2;
			}
			
		}
		System.out.println("Final count is: "+ count+"\n10001 Prime is: "+ primeNum);
	}
}