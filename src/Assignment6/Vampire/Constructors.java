/*
2. Create a class with two (overloaded) constructors. Using this, call the second constructor inside the first one.
 */


package Assignment6.Vampire;

class class2{
    public class2(int a){
        //calling parameterized constructor inside default constructor
        this('c');
    }
    class2(char c){
        System.out.println(c);
    }
}
public class Constructors {
    public static void main(String[] args) {
        class2 obj=new class2(10);
    }
}




