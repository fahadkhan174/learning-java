package oops;

import java.io.FileNotFoundException;

public class Child extends Parent {

	public FileNotFoundException eat() {
		System.out.println("I Likes Mangoes");
		// return "abc";
		return null;
	}

	public String eat(int i, String name) {
		System.out.println("I Likes Mangoes");

		return name;
	}

	public int eat(String name, int i) {
		System.out.println("I Likes Mangoes");

		return i;
	}

	Child() {
		System.out.println("Child Const");
	}

	Child(int i) {
		System.out.println("Child Const: " + i);
	}

	// void eat() {
	// System.out.println("I like Grape");
	// }

}
