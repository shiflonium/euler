import java.io.*;
import java.util.*;
import java.math.BigInteger;
//Yonatan Shimroni
public class P20
{
	public static BigInteger fact(int num)
	{
		BigInteger factorial = BigInteger.valueOf(num);
		for (int i = num; i > 1; i--)
		{
			factorial = factorial.multiply((BigInteger.valueOf(i - 1)));
		}
		return factorial;
	}

	public static char[] bigIntToString(BigInteger bigInt)
	{
		String bigStr = bigInt.toString();
		char [] character = bigStr.toCharArray();
		return character;
	}
	public static int sumString(char[] charArray)
	{
		int sum = 0;
		for (int i = 0; i < charArray.length; i++)
		{
			sum = sum + Character.getNumericValue(charArray[i]);
		}
		return sum;
	}

	public static void main(String[] args)
	{
		//BigInteger bigInt = BigInteger.valueOf(0);
		char[] charArray = bigIntToString(fact(Integer.parseInt(args[0])));
		System.out.println("The sum of Factorial is: " + sumString(charArray));
	}
}