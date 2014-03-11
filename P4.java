import java.io.*;
import java.util.*;
//Yonatan Shimroni

/*
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
Find the largest palindrome made from the product of two 3-digit numbers.
*/
public class P4
{
	public static ArrayList<Integer> palindrome(int lowerBound, int upperBound)
	{
		int i;
		int product = 0;
		String strProduct = "";
		ArrayList<Integer> palList = new ArrayList<Integer>();
		for (int j = upperBound; j >= lowerBound; j--)
	{

		for (i = upperBound; i >= lowerBound; i--)
		{	//996*913
			//System.out.println("Checking on: "+j+" * "+i);
			product = j*i;
			System.out.println("Checking on: "+j+" * "+i+" = "+j*i);
			strProduct = Integer.toString(product);
			//System.out.println(strProduct.substring(0,1)+"?=?"+ strProduct.substring(strProduct.length() - 1));
			if (strProduct.length()==5) {
				//System.out.println("are we good");
				if (strProduct.substring(0,1).equals(strProduct.substring(strProduct.length() - 1))) {
					//System.out.println("are we good2");
					if (strProduct.substring(1,2).equals(strProduct.substring(3,4))) {
						palList.add(Integer.parseInt(strProduct));;
					}
				}
				
			}
			//if(j == 993 && i ==913)
			if(strProduct.length()==6)
			{	
				//System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
				//System.out.println(strProduct.substring(0,1) +" "+strProduct.substring(strProduct.length() - 1));
				if (strProduct.substring(0,1).equals(strProduct.substring(strProduct.length() - 1))) {
					
					if (strProduct.substring(1,2).equals(strProduct.substring(4,5))) {
						
						if (strProduct.substring(2,3).equals(strProduct.substring(3,4))) {
							
							palList.add(Integer.parseInt(strProduct));
							
						}
					}
					
				}
			}
		}
	}
		return palList;
	}
	public static int maxPalindrome(ArrayList<Integer> list)
	{
		int maxElement = list.get(0);
		for (int i = 1; i < list.size(); i++)
		{
			if (list.get(i) > maxElement)
			{
				maxElement = list.get(i);
			}
		}
		return maxElement;
	}
	public static void main(String[] args)
	{
		ArrayList<Integer> palList = new ArrayList<Integer>();
		palList = palindrome(100,999);
		System.out.println("found palindrome: " + maxPalindrome(palList));
	}
}