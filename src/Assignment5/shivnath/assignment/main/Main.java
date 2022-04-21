package Assignment5.shivnath.assignment.main;
import Assignment5.shivnath.assignment.data.DefaultInitialization;
import Assignment5.shivnath.assignment.singleton.Singleton;


public class Main {
    public static void main(String[] args) {
        DefaultInitialization variable = new DefaultInitialization();
        variable.printGVariable();
        variable.printLocalVariable();

        Singleton single = Singleton.initializeStr("Single");
        single.printStr();
    }
}
