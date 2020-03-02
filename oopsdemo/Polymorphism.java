package com.demo.practice;
class compileTimePoly{
	//overloading add method
	public int add(int a,int b) {
		return a+b;
	}
	public int add(int a,int b,int c) {
		return a+b+c;
	}
}
class runTimePoly{
	public String whoAmI() {
		return "Iam parent and my name is Vishnu";
	}
	
}
class son extends runTimePoly{

	@Override
	public String whoAmI() {
		return "Iam son of Vishnu and my name is krishna" ;
	}
	
}
public class Polymorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		compileTimePoly ct=new compileTimePoly();
		System.out.println(ct.add(3, 4));
		System.out.println(ct.add(4, 5, 6));
		runTimePoly rt=new son();
		System.out.println(rt.whoAmI());

	}

}

