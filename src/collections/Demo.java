package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Demo {

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		map.put(1, "D");
		System.out.println(map); // will replace value for same key given
		
		List<String> list = new ArrayList<String>();
		list.add("X");
		list.add("Y");
		list.add("Z");
		list.add("X");
//		list.add(1); // only without type String it allows different values
		System.out.println(list);
		
		LinkedList<Character> linkedList = new LinkedList<Character>();
		linkedList.add('a');
		linkedList.add('b');
		linkedList.add('c');
		linkedList.add('d');
//		linkedList.add(1); // only without type Character it allows different values
		System.out.println(linkedList);
		
		Set<Integer> s1 = new HashSet<Integer>();
		s1.add(1);
		s1.add(2);
		s1.add(3);
		s1.add(1);
//		s1.add('a');
		System.out.println(s1); // doesn't allow duplicates
		
		Employee e1 = new Employee(1, "A");
		Employee e2 = new Employee(2, "B");
		Employee e3 = new Employee(1, "A");
		
		Set<Employee> s2 = new TreeSet<Employee>(); // TreeSet needs CompareTo method to compare objects
		s2.add(e1);
		s2.add(e2);
		s2.add(e3);
		System.out.println(s2);
		
	}

}
