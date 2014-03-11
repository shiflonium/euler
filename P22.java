import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

//Answer: 871198282
public  class P22
{
	/**
	*This method opens the text file and returns a scanner of that file
	*/
	public static Scanner openFile(String filename)
	{   
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

	/**
	*This method reads all neams to a string arraylist
	*/
	public static ArrayList<String> listMaker(Scanner sc)
	{


		ArrayList<String> name_list = new ArrayList<String>(); 
		String line;  
		sc.useDelimiter(",");

		while (sc.hasNext())
		{
			name_list.add(sc.next().replaceAll("^\"|\"$", ""));
		}

	return name_list;
}
	/**
	*Method to find the desired sum using characers positions and name location in sorted list
	*/
	public static int findSum(ArrayList<String> names)
	{
		int sum = 0;
		for (int i = 0; i < names.size(); i++)
		{
			int nameSum = 0;
			for (int j = 0; j < names.get(i).length(); j++)
			{
				nameSum = nameSum + alphaPosition(Character.getNumericValue(names.get(i).charAt(j)));
			}
			sum  = sum + (nameSum * (i + 1));
		}

		return sum;

	}

	/**
	*Method to compute alphabetical position from ascii code
	*/
	public static int alphaPosition(int ascii)
	{
		return ascii - 9;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = openFile(args[0]);
		ArrayList<String> names = new ArrayList<String>();
		names = listMaker(sc);
		Collections.sort(names);  //sort the list
		System.out.println("The Sum is: " + findSum(names));		
	}
}