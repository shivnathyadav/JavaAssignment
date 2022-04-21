package Assignment5.shivnath.assignment.singleton;

public class Singleton {
    public String stringVar;

    public static Singleton initializeStr(String str){
        Singleton singleton = new Singleton();

        singleton.stringVar = str;
        return singleton;
    }

    public void printStr(){
        System.out.println(stringVar);
    }

}
