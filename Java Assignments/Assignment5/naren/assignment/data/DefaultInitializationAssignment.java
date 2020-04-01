package naren.assignment.data;

public class DefaultInitializationAssignment {
    private int a;
    private char b;

    /*instance variable or static variables gets intialized to default values at the time of object creation*/
    public void printVariables() {
        System.out.println("Instance variables are --->Integer value is " + a + "\n"
                + "--->Character value is " + b);
    }
    /*Local variables cannot be declared or used without initialization ,
     if tried compiler throws an error
     */
    /*
public void printLocal(){
    int a;
    char b;
    System.out.println(a+" "+b);
}
*/
}
