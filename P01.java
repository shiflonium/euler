import java.io.*;
import java.util.*;
//Yonatan Shimroni
/*
Project Euler #1
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
Find the sum of all the multiples of 3 or 5 below 1000.
*/

public class P1
{
	public static boolean checkDiv(int num)
	{
		if (num % 3 == 0) //check divisibility by 3
		{
			return true;
		}
		if (num % 5 == 0) //check divisibility by 5
		{
			return true;
		}

		else
		{
			return false;
		}
	}

	public static int numOfMultipiles(int bound)
	{
		int sum = 0;
		for (int i = 1; i < bound; i++)
		{
			if(checkDiv(i))
			{
				sum += i;
			}
		}
		return sum;
	}

	public static void main(String[] args)
	{
		int bound = Integer.parseInt(args[0]); //parse string from command line to integer
		System.out.println("The sum is: " + numOfMultipiles(bound));
	}
} 
