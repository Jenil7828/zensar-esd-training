package day19;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Collection_Map {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>(); 
		map.put(1, "Apple");
		map.put(2, "Banana");
		map.put(2, "Cherry");
		System.out.println("Map: "+map);
		
		System.out.println("Value for key 2 : "+map.get(2));

		Map<Integer,String> lm=new LinkedHashMap<>();
		lm.put(1,"Kiwi");
		lm.put(2,"Banana");
		lm.put(3,"Orange");
		lm.put(4,"Melon");
		System.out.println("List : "+lm);
		System.out.println("Value for key 2 : "+lm.get(2));

		Map<Integer,String> tm=new TreeMap<>();
		tm.put(1,"Cucumber");
		tm.put(2,"Carrots");
		tm.put(3,"Beetroot");
		tm.put(4,"Tomato");
		System.out.println("List : "+tm);
		System.out.println("Value for key 2 : "+tm.get(2));
		
	}
}
