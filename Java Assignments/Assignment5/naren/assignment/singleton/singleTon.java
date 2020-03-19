package naren.assignment.singleton;

public class singleTon {
    private String s;
    public static singleTon initialize(String val){
        singleTon singleton=new singleTon();
        singleton.s=val;
        return singleton;
    }
    public void printString(){
        System.out.println(s);
    }
}
