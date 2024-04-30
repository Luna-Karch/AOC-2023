using System;
using System.IO;

namespace Solution {
    public class Solution {
        public static void Main(string[] args) {
            Part1();
            Part2();
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
            Console.WriteLine("Part 1: " + total);
        }

        public static void Part2() {

            Dictionary<string, string> tokenMap = new() {
                {"one", "1"}, {"two", "2"}, {"three", "3"}, {"four", "4"},
                {"five", "5"}, {"six", "6"}, {"seven", "7"}, {"eight", "8"},
                {"nine", "9"}, {"1", "1"}, {"2", "2"}, {"3", "3"}, {"4", "4"},
                {"5", "5"}, {"6", "6"}, {"7", "7"}, {"8", "8"}, {"9", "9"} 
            };

            int total = 0;

            foreach(string line in File.ReadLines("input.txt")) {
                int first = -1;
                int last = -1;

                string firstFound = "";
                string lastFound = "";

                foreach(string token in tokenMap.Keys) {
                    if (!line.Contains(token)) { continue; }

                    List<int> foundIndices = findAllIndices(token, line);

                    if (first == -1 || first > foundIndices.Min()) {
                        first = foundIndices.Min();
                        firstFound = token;
                    }

                    if (last == -1 || last < foundIndices.Max()) {
                        last = foundIndices.Max();
                        lastFound = token;
                    }
                }

                int result = int.Parse(tokenMap[firstFound] + tokenMap[lastFound]);
                total += result;   
            }

            Console.WriteLine("Part 2: " + total);
        }

        private static List<int> findAllIndices(string subString, string fullString) {
            List<int> result = [];
            
            int index = fullString.IndexOf(subString);

            while (index != -1) {
                result.Add(index);
                index = fullString.IndexOf(subString, index + 1);
            }

            return result;
        }
    }
}