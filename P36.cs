using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;
using System.Diagnostics;
namespace problem36
{
    //Euler problem 36 by Yonatan Shimroni
    
    class Program
    {
        static String convertDecimalToBinary(int num)
        {
            String binary = "";
            int div = 0;
            char[] final;
            while (num > 0)
            {
                if (num % 2 == 0)
                    binary += "0";
                else
                    binary += "1";
                num = num / 2;
            }
            final = binary.ToCharArray();
            Array.Reverse(final);
            return new String(final);
        }
 
 
        static bool isPalindrome(String s)
        {
            bool flag = true;
            char [] c = s.ToCharArray();
            int mid = s.Length / 2;
            int len = s.Length;
            for (int i = 0; i < mid; i++)
            {
                if (c[i] != c[len - 1 - i])
                {
                    flag = false;
                    break;
                }
            }
            return flag;
        }
        static void Main(string[] args)
        {
            int sum = 0;
            for (int i = 1; i < 1000000; i++)
            {
                Debug.WriteLine("Testing number: " + i);
                String testedStr = i.ToString();
                if (isPalindrome(testedStr))
                {
                    if (isPalindrome(convertDecimalToBinary(i)))
                    {
                        sum += i;
                    }
                }
            }
            Debug.WriteLine("The sum is: " + sum);
        }
        
    }
}
 
