/*
        A vampire number v is a number with an even number of digits n, that can be factored into two numbers x and y each with n/2 digits and not both with trailing zeroes,
        where v contains precisely all the digits from x and from y, in any order. Write a java program to print first 100 vampire numbers. */

package Assignment6.Vampire;
import java.util.*;

public class Vampire {


    static ArrayList<String> list = new ArrayList();

    static void permute(String str, int l, int r) { // swapping the digits
        if (l == r)
            list.add(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    static String swap(String str1, int source, int destination) { // Sorting the array and checking.
        char[] charArray = str1.toCharArray();
        char temp = charArray[source];
        charArray[source] = charArray[destination];
        charArray[destination] = temp;
        return String.valueOf(charArray);
    }

    public void printVampireNumbers() { //checking odd or even number of digit.
        int n = 1200, count = 0;            // if even number of digits then continue.
        while (count < 100) {
            String num = String.valueOf(n);
            if (num.length() % 2 != 0) {
                n++;
                continue;
            }

            permute(num, 0, num.length() - 1);
            for (int i = 0; i < list.size(); i++) {
                String first = list.get(i).substring(0, num.length() / 2);
                String second = list.get(i).substring(num.length() / 2, num.length()); // finding factors of the given number

                if (first.charAt(first.length() - 1) == '0' && second.charAt(second.length() - 1) == '0') // no trailing zeros
                    continue;
                else {
                    if (Integer.parseInt(first) * Integer.parseInt(second) == n) {
                     //   System.out.println(Integer.parseInt(first) + " "+ Integer.parseInt(second));
                        System.out.println(num);
                        count++;
                        break;
                    }
                }
            }
            n++;
            list.clear();

        }
    }
    public static void main(String[] args) {
        Vampire obj = new Vampire();
        Vampire objectArray[] = new Vampire[2];

        obj.printVampireNumbers();
    }
}
