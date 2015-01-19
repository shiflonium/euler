import java.io.*;
import java.util.*;
//Yonatan Shimroni
/*
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

Answer: 232792560
*/

public class P5
{

	public static boolean checkPrimes(int num)
	{
		boolean flag = true;
		ArrayList<Integer> primesList = new ArrayList<Integer>(Arrays.asList(11,13,17,19));
		for (int i = 0; i < primesList.size(); i++)
		{
			System.out.println("Checking: " + num);
			if (num % primesList.get(i) != 0)
			{
				flag = false;
				break;
			}
		}
		return flag;
	}

	public static boolean checkNonPrimes(int num)
	{
		/*
		each of the numbers in the list represents also fators between 1-20 so there is no need to
		specifically check for thise factors. the rest are prime numbers and are being checked
		in the checkPrimes method
		*/
		System.out.println("Checking: " + num);
		boolean flag = true;
		ArrayList<Integer> nonPrimesList = new ArrayList<Integer>(Arrays.asList(12,14,15,16,18,20));
		
		for (int i = 0; i < nonPrimesList.size(); i++)
		{
			if (num % nonPrimesList.get(i) != 0)
			{
				flag = false;
				break;
			}
		}
		return flag;
	}

	public static void main (String[] args)
	{	
		/*
		start from 20 and increament by 20 since the number we are looking for has to be divisble 
		by 20
		*/
		boolean prime = false,nonPrime = false;
		int num = 20;
		while (nonPrime ==false)
		{
			prime =  checkPrimes(num);
			if (prime==true)
			{	
				nonPrime = checkNonPrimes(num);
				if (nonPrime==true)
				{
					break;
				}
				else if(nonPrime == false)
				{
					num+=20;
					continue;
				}

			}
			else
			{
				num +=20;
			}
		}
		System.out.println("Number is: " + (num));
	}
}
