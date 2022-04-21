package Assignment2;

import java.io.BufferedReader;
import java.io.*;

public class CheckAlphabets
{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        boolean[] list = new boolean[26];
        int index = 0;
        int flag = 1;
        for (int i = 0; i < str.length(); i++) {
            if ( str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                index = str.charAt(i) - 'a';
                list[index] = true;
            }
            if ( str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                index = str.charAt(i) - 'A';
                list[index] = true;
            }

        }
        for (int i = 0; i <= 25; i++) {
            if (list[i] == false)
                flag = 0;
        }
        if (flag == 1)
            System.out.print("\nnThe string " + str + " contains all Alphabets");
        else
            System.out.print("\nThe string " + str + " does not contain all Alphabets");
    }

}
