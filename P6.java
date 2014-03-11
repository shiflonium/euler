import java.io.*;
import java.util.*;
//Yonatan Shimroni
/*
The sum of the squares of the first ten natural numbers is,
1^2 + 2^2 + ... + 10^2 = 385
The square of the sum of the first ten natural numbers is,
(1 + 2 + ... + 10)^2 = 55^2 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

answer: 25164150
*/

public class P6
{
	public static Double sumSquares(int lowerBound,int upperBound)
	{
		Double sum = 0.0;
		for (int i = lowerBound; i <= upperBound; i++)
		{
			sum = sum + (Math.pow(i,2));
		}

		return sum;
	}

	public static Double squareSum(int lowerBound,int upperBound)
	{
		Double sum = 0.0;
		for (int i = lowerBound; i <= upperBound; i++)
		{
			sum += i;
		} 
		return Math.pow(sum, 2);
	}

	public static void main(String[] args)
	{
		System.out.println("Differnece is: " +(int)( 
			(squareSum(Integer.parseInt(args[0]),Integer.parseInt(args[1])) - 
				sumSquares(Integer.parseInt(args[0]),Integer.parseInt(args[1])))));
	}
}