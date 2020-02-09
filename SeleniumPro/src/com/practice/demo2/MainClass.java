package com.practice.demo2;

// 1 - CLASS
class FirstClass{
	int a = 7;
	public void display(){
		System.out.println("First Class");
		System.out.println("a = "+a);
	}
}

//2 - INHERITANCE
class SecondClass extends FirstClass{
	int b;
	// CONSTRUCTOR OVERLOADING
	SecondClass(){
		b = 5;
	}
	SecondClass(int x){
		this.b = x;
	}
	// OVERRIDING
	public void display() {
		System.out.println("Second Class");
		System.out.println("b = "+b);
	}
}

// 3 - ENCAPSULATION
class EncapsulateTest{
	private String name;
	// Getter function
	public String getname() {
		return name;
	}
	// Setter function
	public void setname(String newname) {
		name = newname;
	}
}

// 4 - ABSTRACTION
abstract class AbstractClass{
	String color;
	
	// constructor in abstract class
	AbstractClass(String color){
		System.out.println("Abstract class constructor called");
		this.color = color;
	}
	
	// abstract method
	public abstract String shape();
	
	// concrete method
	public String getcolor() {
		return this.color;
	}
}

class Circle extends AbstractClass{
	double radius;
	Circle(String color, double radius){
		// calling super class constructor
		super(color);
		System.out.println("Circle constructor called");
		this.radius = radius;
	}
	double area() {
		return Math.PI*Math.pow(radius,2);
	}
	@Override
	public String shape() {
		// TODO Auto-generated method stub
		return "Circle color is "+super.color+" and area is "+area();
	}
}
	
// 5 - OVERLOADING CLASS
class OverloadSum{
	//overloading sum method
	// sum takes two int parameters and return type is int
	public int sum(int x, int y) {
		return (x+y);
	}
	
	// sum takes three int values and return type is int 
	public int sum(int x, int y,int z) {
		return (x+y+z);
	}
	
	// sum takes two double values and return type is double 
	public double sum(double x, double y) {
		return (x+y+5);
	}
}

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("********************");
		// First class
		FirstClass ob1 = new FirstClass();
		ob1.display();
		
		System.out.println("********************");
		// Second class
		SecondClass ob2 = new SecondClass();
		ob2.display();
		SecondClass ob3 = new SecondClass(6);
		ob3.display();
		
		System.out.println("********************");
		// EncapsulateTest class
		EncapsulateTest ob4 = new EncapsulateTest();
		ob4.setname("Vibha");
		System.out.println("Name: "+ob4.getname());
		
		System.out.println("********************");
		// Abstract class
		Circle ob5 = new Circle("Red",5.5);
		System.out.println(ob5.shape());
		
		System.out.println("********************");
		// overloading class
		OverloadSum ob6 = new OverloadSum();
		System.out.println("100 + 200 = "+ob6.sum(100,200));
		System.out.println("3 + 4 +5 = "+ob6.sum(3, 4, 5));
		System.out.println("54.45 + 65.75 + 5 = "+ob6.sum(54.45, 65.75));
		
		System.out.println("********************");
		
	}

}
