import java.io.*;
import java.util.*;
//Yonatan Shimroni
/*
There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.

answer: 31875000
*/

public class P9
{
	public static ArrayList<Double> triplet()
	{
		double a = 1, b = 1, c =1;
		int j = 0;
		int k = 0;
		double sqrt = 0.0;
		ArrayList<Integer> numList = new ArrayList<Integer>();
		ArrayList<Double> result = new ArrayList<Double>();
		for (int i = 1; i < 1000; i++)
		{
			numList.add(i);
		}
		while (a + b + c != 1000)
		{
			if (j == 998)
				break;

			a = numList.get(j);
			for (int h = j + 1; h < 998; h ++)
			{
				b = numList.get(h);
				System.out.println("Checking for a: " + a + " b: " +b);
				sqrt = Math.sqrt(Math.pow(a,2) + Math.pow(b, 2));
				if (sqrt * sqrt == Math.pow(a,2) + Math.pow(b, 2) && Math.sqrt(Math.pow(a,2) + Math.pow(b, 2)) < 1000)
				{	
					c = sqrt;
					if (a + b + c == 1000)	
						break;
				}
			}
			j++;
		}
			
		
		result.add(a);result.add(b);result.add(c);
		return result;
	}
	public static void main(String[] args)
	{
		ArrayList<Double> res = triplet();
		double product = 0;
		product = res.get(0) * res.get(1) * res.get(2);
		System.out.println("Found Pythgorian triplet with sum 1000:\na: "+res.get(0)+"\nb: "+res.get(1)+"\nc: "+res.get(2)+
			"\nProduct: " + (int)product);
	}
}
