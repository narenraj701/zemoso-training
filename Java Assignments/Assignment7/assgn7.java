/*
Create three interfaces, each with two methods.
Inherit a new interface that combines the three, adding a new method.
Create a class by implementing the new interface and also inheriting from a concrete class.
Now write four methods, each of which takes one of the four interfaces as an argument.
In main( ), create an object of your class and pass it to each of the methods.
 */
interface first{
    void m1();
    void m2();
}
interface second{
    void m3();
    void m4();
}
interface third{
    void m5();
    void m6();
}
class concrete{

}
interface last extends first,second,third {
    void m7();
}
class Implementor extends concrete implements last {
    @Override
    public void m1() {

    }

    @Override
    public void m2() {

    }

    @Override
    public void m3() {

    }

    @Override
    public void m4() {

    }

    @Override
    public void m5() {

    }

    @Override
    public void m6() {

    }

    @Override
    public void m7() {

    }
    public void method1(first obj){

    }
    public void method2(second obj){

    }
    public void method3(third obj){

    }
    public void method4(last obj){

    }

}
class assgn7{
    public static void main(String[] args) {
        Implementor implementor=new Implementor();
        implementor.method1(implementor);
        implementor.method2(implementor);
        implementor.method3(implementor);
        implementor.method4(implementor);
    }
}
