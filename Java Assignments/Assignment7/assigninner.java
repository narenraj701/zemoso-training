/*Create a class with an inner class that has a non-default constructor (one that takes arguments).
 Create a second class with an inner class that inherits from the first inner class.*/
class FirstOuter{
    class FirstInner{
        public FirstInner(String s){
            System.out.println(s);
        }
    }
}
class Second{
    class SecondInner extends FirstOuter.FirstInner{

        public SecondInner(FirstOuter firstOuter, String s) {
            firstOuter.super(s);
            // TODO Auto-generated constructor stub
        }

    }
}
class assigninner{
    public static void main(String[] args) {
        Second sec=new Second();
        FirstOuter firstOuter=new FirstOuter();
        Second.SecondInner secondInner=sec.new SecondInner(firstOuter,"Naren");
    }
}
