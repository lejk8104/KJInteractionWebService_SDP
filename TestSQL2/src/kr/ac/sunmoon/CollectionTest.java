package kr.ac.sunmoon;

import java.util.*;
public class CollectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i =1;
		Integer x = Integer.valueOf(i);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(5);
		arrayList.add(2);
		arrayList.add(11);
		System.out.println(arrayList);
		
		Collections.sort(arrayList);
		System.out.println(arrayList);
	}

}
