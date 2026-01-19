package day19;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Collection_Set {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("Apple");
		set.add("Cherry");
		set.add("Banana");
		
		System.out.println("List:" +set);
		System.out.println("List:" +set);
		
		set = new TreeSet<>();
		set.add("Apple");
		set.add("Cherry");
		set.add("Banana");
		
		System.out.println("List:" +set);
		System.out.println("List:" +set);
		
		set = new LinkedHashSet<>();
		set.add("Banana");
		set.add("Apple");
		set.add("Cherry");
		System.out.println("List:" +set);
		System.out.println("List:" +set);
	}
}
