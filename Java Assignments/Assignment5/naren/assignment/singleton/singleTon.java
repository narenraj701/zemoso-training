package naren.assignment.singleton;

public class singleTon {
    private String s;
    public static singleTon initialize(String val,singleTon obj2){
        if((obj2 instanceof singleTon)){
            obj2.s=val;
            return obj2;
        }
        singleTon singleton=new singleTon();
        singleton.s=val;
        return singleton;
    }
    public void printString(){
        System.out.println(s);
    }
}
