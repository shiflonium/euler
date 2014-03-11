import java.io.*;
import java.util.*;
//Yonatan Shimroni
/*

*/



public class P11
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

	public static ArrayList<ArrayList<Integer>> multiListMaker(Scanner sc)
	{
		/*
		This method opens the text file and convert the triangle to a multidimensional
		arraylist of arraylists of integers
		*/

		ArrayList<ArrayList<Integer>> row_list = new ArrayList<ArrayList<Integer>>(); //list to store lists of integers
		String line; 	//string variable to store each line.  

		while(sc.hasNextLine())
		{ 									
				ArrayList<Integer> inner_list = new ArrayList<Integer>();	//list to store each line
				line = sc.nextLine().trim();								//remove spaces
				Scanner scanner = new Scanner(line); 						//add the trimmed line to a new scanner
				scanner.useDelimiter(" ");									//seperate elements seperated by space

        			while (scanner.hasNextInt()) 							//while scanner has not finished reading current line
        			{						
        				inner_list.add(scanner.nextInt());					//add the next element to the inner list
    				}
    				row_list.add(inner_list);								//inner list is added to row list (inner_list represents a row)
		}

	return row_list;
}


public static ArrayList<Integer> horizontalProduct(ArrayList<ArrayList<Integer>> list)
{	
	ArrayList<Integer> result = new ArrayList<Integer>();
	int max = 0;
	int product = 0;
	int row = 0, col = 0;
	for (int i = 0; i < list.size(); i++)
	{
		for (int j = 0; j <= 16; j++)//16 to avoid index error
		{
			product = list.get(i).get(j) * list.get(i).get(j + 1) * list.get(i).get(j + 2) * list.get(i).get(j + 3);
			if (product > max)
			{
				max = product;
				row = i + 1; //row location
				col = j + 1; //column location
			}
		}

	}
	result.add(max);result.add(row);result.add(col);
	return result;
}

public static ArrayList<Integer> verticalProduct(ArrayList<ArrayList<Integer>> list)
{	
	ArrayList<Integer> result = new ArrayList<Integer>();
	int max = 0;
	int product = 0;
	int row = 0, col = 0;
	for (int i = 0; i < list.size(); i++)
	{
		for (int j = 0; j <= 16; j++)//16 to avoid index error
		{
			product = list.get(j).get(i) * list.get(j + 1).get(i) * list.get(j + 2).get(i) * list.get(j + 3).get(i);
			if (product > max)
			{
				max = product;
				row = j + 1;
				col = i + 1;
			}
		}

	}
	result.add(max);result.add(row);result.add(col);
	return result;
}

public static ArrayList<Integer> leftUpDiagProduct(ArrayList<ArrayList<Integer>> list)
{	
	ArrayList<Integer> result = new ArrayList<Integer>();
	int max = 0;
	int product = 0;
	int row = 0, col = 0;
	for (int i = 0; i <= 16; i++)
	{
		for (int j = 0; j <= 16; j++)//16 to avoid index error
		{
			product = list.get(i).get(j) * list.get(i + 1).get(j + 1) * list.get(i + 2).get(j + 2) * list.get(i + 3).get(j + 3);
			if (product > max)
			{
				max = product;
				row = i + 1;
				col = j + 1;
			}
		}

	}
	result.add(max);result.add(row);result.add(col);
	return result;
}

public static ArrayList<Integer> rightUpDiagProduct(ArrayList<ArrayList<Integer>> list)
{	
	ArrayList<Integer> result = new ArrayList<Integer>();
	int max = 0;
	int product = 0;
	int row = 0, col = 0;
	for (int i = 3; i < list.size(); i++)//start from 3 since there is no 4 elements for diagnol below 3
	{
		for (int j = 0; j <= 16; j++)//16 to avoid index error
		{
			product = list.get(i).get(j) * list.get(i - 1).get(j + 1) * list.get(i - 2).get(j + 2) * list.get(i - 3).get(j + 3);
			if (product > max)
			{
				max = product;
				row = i + 1;
				col = j + 1;
			}
		}

	}
	result.add(max);result.add(row);result.add(col);
	return result;
}


public static void main(String[] args)
{
	int maxProduct = 0;
	Scanner file = openFile(args[0]);
	ArrayList<ArrayList<Integer>> list = multiListMaker(file);
	ArrayList<Integer> horProd = horizontalProduct(list);
	ArrayList<Integer> verProd = verticalProduct(list);
	ArrayList<Integer> leftUpDiagProd = leftUpDiagProduct(list);
	ArrayList<Integer> rightUpDiagProd = rightUpDiagProduct(list);
	ArrayList<Integer> finalAnswer = new ArrayList<Integer>();

	System.out.println("Horizontal Max Product: " + horProd.get(0)+"\nRow: "+horProd.get(1)+"\nColumn: "+ horProd.get(2));
	System.out.println("Vertical Max Product: " + verProd.get(0)+"\nRow: "+verProd.get(1)+"\nColumn: "+ verProd.get(2));
	System.out.println("Left Up Max Product: " + leftUpDiagProd.get(0)+"\nRow: "+leftUpDiagProd.get(1)+"\nColumn: "+ leftUpDiagProd.get(2));
	System.out.println("Right Up Max Product: " + rightUpDiagProd.get(0)+"\nRow: "+rightUpDiagProd.get(1)+"\nColumn: "+ rightUpDiagProd.get(2));
	
	finalAnswer.add(horProd.get(0)); finalAnswer.add(verProd.get(0));
	finalAnswer.add(leftUpDiagProd.get(0)); finalAnswer.add(rightUpDiagProd.get(0));
	
	maxProduct = finalAnswer.get(0);
	for (int i = 1; i < finalAnswer.size(); i ++)
	{
		if (finalAnswer.get(i) > maxProduct)
		{
			maxProduct = finalAnswer.get(i);
		}
	}
	System.out.println("\nGreatest Product in Grid: " + maxProduct);
}
}