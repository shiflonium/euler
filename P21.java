import java.io.*;
import java.util.*;
import java.math.BigInteger;
//Yonatan Shimroni
//Naswer: 31626

public class P21
{
	/**
		*This function takes all integers under num and sums and sums their proper divisors
		*each integer is the index for its sum. for example: the sum of all proper divisors 
		*of 220 is 284. Therefore, list.get(220) will return 284
		*this function returns an arraylist of all integers under num and their sums
		*/
	public static ArrayList<Integer> amicable(int num)
	{
		ArrayList<Integer> amiTable = new ArrayList<Integer>();
		amiTable.add(0);
		for (int i = 1; i < num; i++)
		{	
			int sum = 0;
			for(int j = i / 2; j > 1; j--)
			{
				if (i % j == 0)
				{
					sum += j;
				}
		
			}
			sum +=1;
			amiTable.add(sum);
		}
		return amiTable;
	}

		/**
		*This function will check the returned list from amicable() and will find amicable numbers
		*/
	public static int findPairs(ArrayList<Integer> list)
	{

		int sum = 0;
		System.out.println(list.size()); 
		for (int i = 1; i < list.size(); i ++)
		{
			if (list.get(i) < 10000 && list.get(list.get(i)) == i && i != list.get(i)) //check that index and sum matches sum and index
			{
				System.out.println("found pair d("+i+")="+list.get(i)+" d("+list.get(i)+")="+i);
				sum = sum + i;
			}
		}
		return sum;
	}

	public static void main(String[] args)
	{	
		int sum = 0;
		ArrayList<Integer> ami = new ArrayList<Integer>();
		ami = amicable(10000);
		sum = findPairs(ami);
		System.out.println("The Sum is: " + sum);
	}
}