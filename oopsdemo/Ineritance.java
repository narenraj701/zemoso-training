package com.demo.practice;
//demonstration of multi level Inheritance
class GrandFather{
	public void myProperties() {
	System.out.println("I have 4 four land properties");
}
}
class Father extends GrandFather{
	public void myBusiness() {
		System.out.println("I own a Business");
	}
}
class Son extends Father{
}

public class Inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Son son=new Son();
		son.myProperties();
		son.myBusiness();

	}

}

