
/* Create a Cycle interface, with implementations Unicycle, Bicycle and Tricycle.
 Create factories for each type of Cycle, and code that uses these factories*/


package Assignment7;

interface Cycles{
    void rideNow();
}
interface CycleFactory{
    Cycles getCycle();
}
class Unicycles implements Cycles{
    public void rideNow(){
        System.out.println("Riding unicycle");
    }
}
class Unifactory implements CycleFactory{
    public Cycles getCycle(){
        return new Unicycles();
    }
}
class Bicycles implements Cycles{
    public void rideNow(){
        System.out.println("Riding Bicycle");
    }
}
class Bifactory implements CycleFactory{
    public Cycles getCycle(){
        return new Bicycles();
    }
}
class Tricycles implements Cycles{
    public void rideNow(){
        System.out.println("Riding Tricycle");
    }
}
class Trifactory implements CycleFactory{
    public Cycles getCycle(){
        return new Tricycles();
    }
}
public class FactoriesCycle{
    public static void main(String[] args) {
        Cycles unicycle=new Unifactory().getCycle();
        Cycles Bicycle=new Bifactory().getCycle();
        Cycles Triycle=new Trifactory().getCycle();
        unicycle.rideNow();
        Bicycle.rideNow();
        Triycle.rideNow();
    }
}
