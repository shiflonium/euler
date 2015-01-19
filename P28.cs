using System;
using System.Collections;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;
namespace problem28
{
    //Euler problem 28 by Yonatan Shimroni
    
    class Program
    {
       
        static void Main(string[] args)
        {
            int upperLeft = 0, upperRight = 0, bottomLeft = 0, bottomRight = 0;
            int spiralSize = 1001;
            int index = 1;
            int sum = 0;
            int evenIndex = 0;
            int sixIndex = 0;
            while (index <= spiralSize)
            {
                upperLeft = index * index; // this is adding upper left diagnols
                upperRight = upperLeft - evenIndex; //this is adding right upper diagonals
                bottomRight = upperRight - evenIndex;//this is adding right bottom diagonal
                bottomLeft = upperLeft - sixIndex; //the difference between upper and bottom left is always 6
                if (index != 1)
                    sum = sum + upperLeft + upperRight + bottomLeft + bottomRight;
                else
                    sum =1;
                index += 2;
                evenIndex += 2;
                sixIndex += 6;
            }
            System.Diagnostics.Debug.WriteLine("Sum: " + (sum));
        }
    }
}