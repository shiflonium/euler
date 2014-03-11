import java.io.*;
import java.util.*;
import java.math.BigInteger;
//Yonatan Shimroni
//Answer: 21124

public class P17{

public static int getSome(int num)
	{
		int[] singles = {0, 3, 3, 5, 4, 4, 3, 5, 5, 4};
		int[] teens = {0, 6, 6, 8, 8 , 7, 7, 9, 8, 8};
		int[] tenths = {0, 3, 6, 6, 5, 5, 5, 7, 6, 6};
		int sum = 11; //one thousand = 11 ninety

		while (num <1000)
		{
			int ind = 0;
			String numStr = String.valueOf(num);
			if (numStr.length() == 3)
			{

				if (numStr.substring(1,2).equals("0") && !numStr.substring(1,2).equals(numStr.substring(numStr.length() - 1)))
				{
					
					sum += singles[Integer.parseInt(numStr.substring(0,1))]; //hundreds
					sum += 10; ////hundred = 7 and = 3
					sum += singles[Integer.parseInt(numStr.substring(numStr.length() - 1))];//singles
					ind = singles[Integer.parseInt(numStr.substring(0,1))] + singles[Integer.parseInt(numStr.substring(numStr.length() - 1))] + 10;
					System.out.println("Sum for: "+num+" is: "+ ind);
				}

				if(!numStr.substring(numStr.length() - 1).equals("0") && Integer.parseInt(numStr.substring(1,2)) > 1)
				 //case for digits 1-9
				{

					sum += singles[Integer.parseInt(numStr.substring(numStr.length() - 1))];//singles   
					sum += tenths[Integer.parseInt(numStr.substring(1,2))]; //tenths
					sum += singles[Integer.parseInt(numStr.substring(0,1))]; //hundreds
					sum += 10; //hundred = 7 and = 3
					ind = singles[Integer.parseInt(numStr.substring(numStr.length() - 1))] +
						tenths[Integer.parseInt(numStr.substring(1,2))] + singles[Integer.parseInt(numStr.substring(0,1))] + 10;

					System.out.println("Sum for: "+num+" is: "+ ind);
				}
				
				if(numStr.substring(numStr.length() - 1).equals("0") &&
				 !numStr.substring(numStr.length() - 1).equals(numStr.substring(1,2)))//case for thenths
				{

					sum += tenths[Integer.parseInt(numStr.substring(1,2))];
					sum += singles[Integer.parseInt(numStr.substring(0,1))]; //hundreds
					sum += 10; //hundred = 7 and = 3
					ind = tenths[Integer.parseInt(numStr.substring(1,2))] + singles[Integer.parseInt(numStr.substring(0,1))] + 10;
					System.out.println("Sum for: "+num+" is: "+ ind);
				}
				if (numStr.substring(1,2).equals("0") && numStr.substring(numStr.length() - 1).equals("0"))//case for 100 200 300 etc
				{

					sum += singles[Integer.parseInt(numStr.substring(0,1))];
					sum += 7; //hundred = 7
					ind = singles[Integer.parseInt(numStr.substring(0,1))] + 7;
					System.out.println("Sum for: "+num+" is: "+ ind);
				}
				if (numStr.substring(1,2).equals("1") && !numStr.substring(numStr.length() - 1).equals("0")) //case for numners between 10-20
				{

					sum += teens[Integer.parseInt(numStr.substring(numStr.length() - 1))]; //teens
					sum += singles[Integer.parseInt(numStr.substring(0,1))]; //hundreds
					sum += 10; //hundred = 7 and = 3 
					ind = teens[Integer.parseInt(numStr.substring(numStr.length() - 1))] + singles[Integer.parseInt(numStr.substring(0,1))] + 10;
					System.out.println("Sum for: "+num+" is: "+ ind);
				}
			}

			if (numStr.length() == 2)
			{
				//this if is for 11,12,13...
				if (numStr.substring(0, 1).equals("1") && !numStr.substring(numStr.length() - 1).equals("0"))
				{
					
					String gg = numStr.substring(numStr.length() - 1);
					sum += teens[Integer.parseInt(numStr.substring(numStr.length() - 1))];
					ind = teens[Integer.parseInt(numStr.substring(numStr.length() - 1))];
					System.out.println("Sum for: "+num+" is: "+ ind);
				}
				//this if is for all the rest but 10,20,30...90
				if (Integer.parseInt(numStr.substring(0,1)) > 1 && !numStr.substring(numStr.length() - 1).equals("0"))
				{
					sum += singles[Integer.parseInt(numStr.substring(numStr.length() - 1))];
					sum += tenths[Integer.parseInt(numStr.substring(0,1))];
					ind = singles[Integer.parseInt(numStr.substring(numStr.length() - 1))] + tenths[Integer.parseInt(numStr.substring(0,1))];
					System.out.println("Sum for: "+num+" is: "+ ind);
				}
				//this is for 10,20....90
				if (numStr.substring(numStr.length() - 1).equals("0"))
				{
					
					String gg = numStr.substring(numStr.length() - 1);
					sum += tenths[Integer.parseInt(numStr.substring(0,1))];
					ind = tenths[Integer.parseInt(numStr.substring(0,1))];
					System.out.println("Sum for: "+num+" is: "+ ind);
				}
			
			}
			if (numStr.length() == 1)
			{
				sum += singles[Integer.parseInt(numStr.substring(0,1))];
				ind = singles[Integer.parseInt(numStr.substring(0,1))];
				System.out.println("Sum for: "+num+" is: "+ ind);
			}
			num++;
		}
		return sum;
	}
	public static void main(String[] args)
	{
		int sum = 0;
		sum = getSome(1);
		System.out.println("The Sum is: " + sum);
	}
}