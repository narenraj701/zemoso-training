

//2. Create a class with two (overloaded) constructors. Using this, call the second constructor inside the first one.


class c2{
    public c2(int a){
        //calling parameterized constructor inside default constructor
       this('c');
    }
     c2(char c){
        System.out.println(c);
    }
}
public class Constructors {
    public static void main(String[] args) {
        c2 obj=new c2(10);
    }
}




/*3. Create a class with a constructor that takes a String argument. During construction, print the argument. Create an array of object references to this class, but don’t actually create objects to assign into the array. When you run the program, notice whether the initialization messages from the constructor calls are printed.
4. Complete the previous exercise by creating objects to attach to the array of references. */

import java.util.Arrays;
public class conTest {
    private String s;
    public conTest(String s){
        this.s=s;
        System.out.println(s);
    }

    public static void main(String[] args) {
        conTest arr[]=new conTest[5];
        for(int i=0;i<5;i++){
            arr[i]=new conTest("naren");
        }
    }

}




