import java.io.*;
import java.util.*;
import java.math.BigInteger;
//Yonatan Shimroni
/*
Answer: 837799
*/

public class P14
{
	public static ArrayList<Integer> collatzList(BigInteger upperbound)
	{
	ArrayList<Integer> list = new ArrayList<Integer>();
	BigInteger bound = upperbound;
	int count = 0;
	while(true)
	{
		if (bound.mod(BigInteger.valueOf(2)) == BigInteger.valueOf(0))
		{
			bound = bound.divide(BigInteger.valueOf(2));
			count++;
		}

		else
		{
			bound = bound.multiply(BigInteger.valueOf(3)).add(BigInteger.valueOf(1));
			count++;
		}

		if (bound.intValue() == 13)
		{
			count +=9;
			break;
		}
		if (bound.intValue() == 1)
		{
			break;
		}
	}
		System.out.println("Finished collatzList for: " + upperbound);
		list.add(upperbound.intValue()); list.add(count);
		return list;

	}
	public static void main(String[] args)
	{
		int max = 0;
		int collatzNum = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 1000000; i++)
		{
			int collatzRowCount = 0;
			list = collatzList(BigInteger.valueOf(i));
			if (list.get(1) > max)
			{
				max = list.get(1);
				collatzNum = list.get(0);
			}
		}
		System.out.println("Collatz Number: "+collatzNum+"\nCount: " + max);
	}
}