/*Create an inheritance hierarchy of Rodent: Mouse, Gerbil, Hamster,etc. In the base class, provide methods that are common to all Rodents, and override these in the derived classes to perform different behaviors depending on the specific type of Rodent. Create an array of Rodent, fill it with different specific types of Rodents, and call your base-class methods to see what happens. Make the methods of Rodent abstract whenever possible and all classes should have default constructors that print a message about that class.*/


public interface Rodent {
    void getMyLooks();
    void getRunSpeed();
}


public class Mouse implements Rodent {
    public Mouse() {
        System.out.println("Hii , Iam Mouse from Rodent Family");
    }

    @Override
    public void getMyLooks() {
        System.out.println("I have a long tail and face");
    }

    @Override
    public void getRunSpeed() {
        System.out.println("I run Faster than all Rodents");
    }
}


public class Gerbil implements Rodent {
    public Gerbil() {
        System.out.println("Hii , Iam Gerbil from Rodent Family");
    }

    @Override
    public void getRunSpeed() {
    System.out.println("I run faster than Hamster but slower than Mouse");
    }

    @Override
    public void getMyLooks(){
        System.out.println("I have long tails, smallish ears, and long, flat foreheads/noses");
    }
}


public class Hamster implements Rodent {
    public Hamster() {
        System.out.println("Hii , Iam Hamster from Rodent Family");
    }

    @Override
    public void getRunSpeed() {
        System.out.println("I don't run very fast ");
    }
    @Override
    public void getMyLooks() {
        System.out.println(" I have short tails or no tails, and much rounder, stouter faces");

    }
}

public class Rodents {
    public static void main(String[] args) {
        Rodent []rodents=new Rodent[3];
        rodents[0]=new Gerbil();
        rodents[0].getMyLooks();
        rodents[0].getRunSpeed();
        rodents[1]=new Hamster();
        rodents[1].getMyLooks();
        rodents[1].getRunSpeed();
        rodents[2]=new Mouse();
        rodents[2].getMyLooks();
        rodents[2].getRunSpeed();
    }
}

