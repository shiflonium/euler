using System;
using System.Collections;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;
namespace problem27
{
    //Euler problem 27 by Yonatan Shimroni
    
    class Program
    {
        //This function will test if a number is prime
        public static bool isPrime(int num)
        {
            if (num.Equals(1))
                return false;
            if (num.Equals(2))
                return true;
            if (num % 2 == 0)
                return false;
            for (int i = 3; i <= Math.Sqrt(num); i += 2)
            {
                if ((num % i) == 0)
                {
                    return false;
                }
            }
            return true;
        }
        static void Main(string[] args)
        {
            //variables decleration       
            int n = 0, a = 0, b = 0;
            int max = 0;
            int product = 0;
            int finalA = 0, finalB = 0;
            for (int i = -1000; i < 1000; i++)
            {
                for (int j = -1000; j < 1000; j++)
                {
                    a = i;
                    b = j;
                    n = 0;
                    while (true)
                    {
                        //if the formula yields a prime number increase n by 1 until its not prime
                        if (isPrime(Math.Abs(n * n + a * n + b)))
                        {
                            n++;
                        }
                        else
                        {
                            break;
                        }
                    }
                    //if n is greater than previous formulas then overwrite
                    if (n > max)
                    {
                        max = n;
                        finalA = a;
                        finalB = b;    
                    }
                    
 
                }
            }
            product = finalA * finalB;
            System.Diagnostics.Debug.WriteLine(finalA + " x " + finalB + " = " + product);
        }
    }
}