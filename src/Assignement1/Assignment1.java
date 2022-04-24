
package  Assignement1;
import java.io.File;
import java.util.Scanner;

public class Assignment1 {
    public void findFile (String regex, String path) {
        File f = new File(path);
        if (f == null) {
            System.out.println("No files here");
        } else {
            File[] files = f.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    findFile(regex, file.getAbsolutePath());
                }
                if (file.getName().matches(regex)) {
                    System.out.println("Files with regex " + regex + " has absolute path " + file.getAbsolutePath());
                }
            }
        }
    }

    public static void main (String[] args) {
        Assignment1 a1 = new Assignment1();
        String home = System.getProperty("user.home");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a regex: ");
        String regex = "";
        while (!(regex = input.next()).equals("-1")){
            a1.findFile(regex, home);
            System.out.println("Enter a regex: ");
        }
        System.out.println("Program terminated");
    }
}
