package naren.assignment.main;

import naren.assignment.data.DefaultInitializationAssignment;
import naren.assignment.singleton.singleTon;

public class Main {
    public static void main(String[] args) {
        DefaultInitializationAssignment obj1=new DefaultInitializationAssignment();

        obj1.printVariables();
        //obj1.printLocal();

        singleTon obj2=new singleTon();
        singleTon returnedObj=obj2.initialize("naren");
        returnedObj.printString();
    }
}
