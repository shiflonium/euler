using System;
using System.Collections;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;
namespace problem30
{
    //Euler problem 30 by Yonatan Shimroni
    
    class Program
    {
        static void Main(string[] args)
        {
            Double a = 2;
            String num;
            Double generalSum = 0;
            while (a < 355000)
            {
                double sum = 0;
                int index = 0;
                num = a.ToString();
                while (index < num.Count())
                {
                    sum = sum + Math.Pow(Double.Parse(num[index].ToString()), 5);
                    index++;
                }
                if (sum == a)
                {
                    generalSum = generalSum + a;
                }
                a++;
            }
            System.Diagnostics.Debug.WriteLine(generalSum);
        }
    }
}