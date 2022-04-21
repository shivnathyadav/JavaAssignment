package Assignment5.shivnath.assignment.data;

public class DefaultInitialization {
    int num;
    char ch;
    public void printGVariable(){
        System.out.println("Global Integer variable is " + num);
        System.out.println("Global Char variable is " + ch);
    }
    public void printLocalVariable(){
        int localNum;
        char localChar;
        /*
        System.out.println("Local Int variable is "+ localNum);
        System.out.println("Local Char variable is "+ localChar);

        getting error we cannot print local variable without initialization
         */
    }
}
