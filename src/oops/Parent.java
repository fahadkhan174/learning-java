package oops;

import java.io.FileNotFoundException;

public class Parent {
	public FileNotFoundException eat() {
		System.out.println("I Likes Mangoes");
		return new FileNotFoundException();
	}

	private void sleep1() {
		System.out.println("this is sleeping owl");
	}

	Parent() {
		System.out.println("Parent constructor");
	}

	Parent(int i) {
		System.out.println("Parent const: " + i);
	}

	// void eat() {
	// System.out.println("I like Mango");
	// }
}
