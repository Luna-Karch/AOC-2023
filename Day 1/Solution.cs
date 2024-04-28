using System;
using System.IO;

namespace Solution {
    public class Solution {
        public static void Main(string[] args) {
            Part1();
        }

        public static void Part1() {
            int total = 0;
            foreach(string line in File.ReadLines("input.txt")) {
                int firstInt = -1;
                int lastInt = -1;
                foreach (char c in line) {
                    if (firstInt == -1 && char.IsNumber(c)) {
                        firstInt = (int)char.GetNumericValue(c);
                    }

                    if (char.IsNumber(c)) {
                        lastInt = (int)char.GetNumericValue(c);
                    }
                }

                string firstAndLast = "";
                firstAndLast += firstInt.ToString() + lastInt.ToString();
                int constructedNumberAsInt = int.Parse(firstAndLast);
                total += constructedNumberAsInt;
            }
            Console.WriteLine(total);
        }
    }
}