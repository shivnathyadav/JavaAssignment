package Assignment11;

/*Using TextFile and a Map<Character,Integer>,
 * create a program that takes the file name as a command line argument and
 *  counts the occurrence of all the different characters.
 *  Save the results in a text file.*/


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CountOccurencesOfCharacters {
    public static void main(String[] args) throws IOException {
        Scanner sc =new Scanner(System.in);
        FileReader inputStream = null;
        FileWriter resultsFile = null;
       // HashMap<Character, Integer> myMap = new HashMap<Character, Integer>();
        int[] count =new int[256];

        String str = sc.nextLine();



        try {

            inputStream = new FileReader(str);
            resultsFile = new FileWriter("results.txt");
        //    System.out.println("debug");
            int i;
            while ((i = inputStream.read()) != -1) {
            //    System.out.println("debug2");
                Character c = (char) i;
         //       System.out.println("debug3");
                count[(int) c] = count[(int) c] + 1;



        }
            for(int j=0;j<256;j++){
                if(count[j]>0){
                    System.out.println((char)j + " "+count[j]);
                }

            }

        } catch (IOException exception){
            System.out.println("File not found");
        }
    }
}

