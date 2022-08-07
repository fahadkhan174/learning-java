package oops;

class Employee {
	int eid;
	int salary;
	static String ceo;

	static { // when you load the class
		ceo = "static ceo";
	}

	public Employee() { // when you create an object
		System.out.println("Employee Const");
	}

	static class Inner {
		public Inner() {
			System.out.println("Inner const");
		}
	}
}

public class App {
	public static void main(String[] args) throws Exception {

		// String name = "";
		// int _count$ = 1;
		// short s = 32767;
		// double d = 5.5;
		//
		// Parent p1 = new Parent();
		// p1.eat();
		// Child p2 = new Child();
		// p2.eat();

		Employee fahad = new Employee();
		Employee test = new Employee();
		Employee.Inner inner = new Employee.Inner();

		System.out.println(fahad.ceo);
		System.out.println(test.ceo);

		Employee.ceo = "Updated CEO";

		System.out.println(fahad.ceo);
		System.out.println(test.ceo);
	}
}
