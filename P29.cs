using System;
using System.Collections;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;
namespace problem29
{
    //Euler problem 29 by Yonatan Shimroni
    
    class Program
    {
        static void Main(string[] args)
        {
            BigInteger a;
            int b;
            BigInteger power = 0;
            ArrayList list = new ArrayList();
            for (a = 2; a <= 100; a++)
            {
                for (b = 2; b <= 100; b++)
                {
                    power = BigInteger.Pow(a, b);
                    //if we havent seen this power store it 
                    if (!list.Contains(power))
                    {
                        list.Add(power);
                    }
                }
            }
            System.Diagnostics.Debug.WriteLine(list.Count);
        }
    }
}