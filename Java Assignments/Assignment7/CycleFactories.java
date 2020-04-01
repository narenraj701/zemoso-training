/* Create a Cycle interface, with implementations Unicycle, Bicycle and Tricycle.
 Create factories for each type of Cycle, and code that uses these factories*/
interface Cycle{
    void rideNow();
}
interface CycleFactory{
    Cycle getCycle();
}
class Unicycle implements Cycle{
    public void rideNow(){
        System.out.println("Riding unicycle");
    }
}
class Unifactory implements CycleFactory{
    public Cycle getCycle(){
        return new Unicycle();
    }
}
class Bicycle implements Cycle{
    public void rideNow(){
        System.out.println("Riding Bicycle");
    }
}
class Bifactory implements CycleFactory{
    public Cycle getCycle(){
        return new Bicycle();
    }
}
class Tricycle implements Cycle{
    public void rideNow(){
        System.out.println("Riding Tricycle");
    }
}
class Trifactory implements CycleFactory{
    public Cycle getCycle(){
        return new Tricycle();
    }
}
public class CycleFactories{
    public static void main(String[] args) {
        Cycle unicycle=new Unifactory().getCycle();
        Cycle Bicycle=new Bifactory().getCycle();
        Cycle Triycle=new Trifactory().getCycle();
        unicycle.rideNow();
        Bicycle.rideNow();
        Triycle.rideNow();
    }
}
