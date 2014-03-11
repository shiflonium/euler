import java.io.*;
import java.util.*;
import java.math.BigInteger;
//Yonatan Shimroni
/*
Answer: 5537376230
*/


public class P13
{
	public static Scanner openFile(String filename)
	{   
		/*this method opens a text file and returns a Scanner to read the file*/
		Scanner file = null;
		try
		{
			file = new Scanner(new File(filename));
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}

		return file;
	}

	public static ArrayList<BigInteger> listMaker(Scanner sc)
	{
		/*
		This method opens the text file and convert the triangle to a multidimensional
		arraylist of arraylists of integers
		*/

		ArrayList<BigInteger> row_list = new ArrayList<BigInteger>(); //list to store lists of integers
		String line; 	//string variable to store each line.  

		while(sc.hasNextLine())
		{ 									
				line = sc.nextLine().trim();
				BigInteger bigInt = new BigInteger(line);								//remove spaces 						
    			row_list.add(bigInt);								//inner list is added to row list (inner_list represents a row)
		}

	return row_list;
}

public static void main(String[] args)
{
	Scanner file = openFile(args[0]);
	ArrayList<BigInteger> list = listMaker(file);
	BigInteger sum = BigInteger.valueOf(0);
	String firstTen = "";
	for (int i = 0; i < list.size() ;i++) {
		//System.out.println(list.get(i));
		sum = sum.add(list.get(i));
	}
	firstTen = sum.toString();
	System.out.println(firstTen.substring(0,10));

}

}