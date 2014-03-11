import java.io.*;
import java.util.*;
import java.math.BigInteger;
//Yonatan Shimroni
/*
Answer: 1366
*/

public class P16
{
	public static ArrayList<Integer> getResult(int num,int power)
	{
		BigInteger bigInt = BigInteger.valueOf(num);
		BigInteger result = bigInt.pow(power);
		String strResult = result.toString();
		char[] charArray = strResult.toCharArray();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (char c:charArray)
		{
			list.add(Character.getNumericValue(c));
		}

		return list;
	}

	public static void main(String[] args)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		list = getResult(2,1000);
		int sum = 0;
		for( int i =0; i < list.size(); i ++)
		{
			sum += list.get(i);
		}

		System.out.println("Sum of digits of the power 2^1000: " + sum);

	}
}