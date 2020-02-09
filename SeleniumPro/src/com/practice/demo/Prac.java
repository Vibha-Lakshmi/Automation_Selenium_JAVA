package com.practice.demo;

/*//Abstract class
abstract class Animal {
// Abstract method (does not have a body)
public abstract void animalSound();
// Regular method
public void sleep() {
 System.out.println("Zzz");
}
}

//Subclass (inherit from Animal)
class Pig extends Animal {
public void animalSound() {
 // The body of animalSound() is provided here
 System.out.println("The pig says: wee wee");
}
}

class MyMainClass {
public static void main(String[] args) {
 Pig myPig = new Pig(); // Create a Pig object
 myPig.animalSound();
 myPig.sleep();
}
}*/

public class Prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int arr[] = {1, 12, 13}; 
		
		// final with for-each statement 
		// legal statement 
		for (final int i : arr) 
			System.out.print(i + " "); 

	}

}
