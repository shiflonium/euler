using System;
using System.Collections;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;
namespace problem26
{
    //Project Euler Problem 26 Solution by Yonatan Shimroni
    
    class Program
    {
            
        static void Main(string[] args)
        {
            //variables decleration       
            int max = 0;
            int term = 0;
            int divisor;
            int rem;
            int current;
            int size = 0;
            for (int i = 2; i < 1000; i++)
            {
                //store remeniders in a list to find when a remainder is repeating
                ArrayList remaindersList = new ArrayList();
                //current will be the integer quotient of the current calculation
                current = 0;
                //this value is used to break out of while loop once a pattern has been found
                bool FOUND = false;
                //initialize remainder variable
                rem = -1;
                //for this problem our dividend is always 1
                int dividend = 1;
                //our divisor is th ith term of the for loop
                divisor = i;
                while (rem != 0) //if remainder is 0 so there will not be a repeating pattern
                {
                    current = dividend / divisor; //get integer quotient 
                    rem = dividend - (divisor * current); //determine remainder
                    dividend = rem * 10; //add 0 to the remender for next digit calculation
                    //if our list contains a remenider already, that means we found a pattern
                    if (remaindersList.Contains(rem))
                    {
                        int counter = 0;
                        foreach (int elm in remaindersList)
                        {
                            //find the index position of the first occurance of the repeating remainder
                            if (elm == rem)
                            {
                                size = remaindersList.Count;
                                FOUND = true;
                                break;
                            }
                            else
                            {
                                counter++;
                            }
                        }
                    }
                    else
                    {
                        remaindersList.Add(rem);
                    }
                    if (FOUND)
                    {
                        FOUND = false;
                        break;
                    }
                }
                //if the pattern's size we found is greater than any previous one then overwrite
                if (size > max)
                {
                    max = size;
                    term = i;
                }
                
                
                
                
            }
            //Output the term yielding the longest repeating pattern
            System.Diagnostics.Debug.WriteLine("Term: " + term + " Size: " + max);
                
        }
    }
}