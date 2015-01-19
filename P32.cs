using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;
namespace problem32
{
    //Euler problem 32 by Yonatan Shimroni
    
    class Program
    {
        static void Main(string[] args)
        {
            List<int> sumList = new List<int>();
            int a = 0, b= 0, prod= 0;
            int aSize = 0, bSize = 0, pSize = 0;
            int offset = 0;
            int sum = 0;
            String aStr, bStr, pStr;
            for (int i = 1; i < 10000; i++)
            {
                a = i;
                aStr = a.ToString();
                aSize = aStr.Count();
                for (int j = 1; j < 500; j++)
                {
                    Dictionary<String, String> digits = 
                        new Dictionary<String, String> { 
                            {"1",""},{ "2",""},{ "3",""},{ "4",""},{ "5",""},{ "6",""},
                            { "7",""},{ "8",""},{ "9",""}
                        };
                    b = j;
                    bStr = b.ToString();
                    pStr = prod.ToString();
                    bSize = bStr.Count();
                    offset = 9 - (aSize + bSize);
                    prod = a * b;
                    pStr = prod.ToString();
                    pSize = pStr.Count();
                    if (aStr.Contains("0") || bStr.Contains("0") || pStr.Contains("0"))
                    {
                        continue;
                    }
                    else
                    {
                        if (pSize == offset)
                        {
                            for (int h = 0; h < aStr.Count(); h++)
                            {
                                if (digits.ContainsKey(aStr[h].ToString()))
                                {
                                    digits.Remove(aStr[h].ToString());
                                }
                            }
                            for (int k = 0; k < bStr.Count(); k++)
                            {
                                if (digits.ContainsKey(bStr[k].ToString()))
                                    digits.Remove(bStr[k].ToString());
                            }
                            for (int g = 0; g < pStr.Count(); g++)
                            {
                                if (digits.ContainsKey(pStr[g].ToString()))
                                    digits.Remove(pStr[g].ToString());
                            }
                            if (digits.Count == 0)
                            {
                                if (!sumList.Contains(prod))
                                    sumList.Add(prod);
                            }
                        }
                    }
                    
                }
            }
            System.Diagnostics.Debug.WriteLine("Sum: " + sumList.Sum());
        }
        
    }
}