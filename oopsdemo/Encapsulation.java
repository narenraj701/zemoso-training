package com.demo.practice;


//encapsulated class with read and write permissions
class Employee{
	private String name;
	private int age;
	private int salary=1000000;
	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String toString() {
		return name+ " " + age+" "+salary;
	}
	
}
public class Encapsulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee naren=new Employee("Naren",21);
		naren.setAge(22);
		Employee suresh=new Employee("Suresh",32);
		suresh.setAge(33);
		System.out.println(naren.toString());
		System.out.println(suresh.toString());
	}

}

