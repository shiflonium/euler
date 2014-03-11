import java.io.*;
import java.util.*;
//Yonatan Shimroni
/*
Answer: 76576500
*/

public class P12
{
	public static int findNumDiv()
	{
		int num = 1;
		int triangleNum = 0;
		int count = 0;
		while (count < 500)
		{
			triangleNum += num;
			System.out.println("Checking on: "+triangleNum);
			if (triangleNum % 2 ==0)
			{
				for (int i = triangleNum/2; i > 1; i--)
				{
				
					if (triangleNum % i == 0)
					{
						count++;
					}
				
				}
			}
			else
			{
				for (int i = triangleNum / 2; i > 2; i -= 2 ) {
					if (triangleNum % i == 0)
					{
						count++;
					}	
				}
			}
			System.out.println("Count is: "+count);
			if (count < 500)
			{
				count = 0;
			}
			else
			{
				break;
			}
			num++;
		}
		return triangleNum;
	}

	public static void main(String[] args)
	{
		int triNum = findNumDiv();
		System.out.println("Triangle number with over 500 divisors: " + triNum);
	}
}