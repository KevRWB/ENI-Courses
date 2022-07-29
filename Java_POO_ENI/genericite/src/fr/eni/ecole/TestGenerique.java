package fr.eni.ecole;

import java.util.ArrayList;
import java.util.List;

public class TestGenerique {

	public static void main(String[] args) {
		
		List<Object> maList = new ArrayList<>();
		maList.add(5);
		maList.add(5);
		maList.add(2);
		maList.add(5);
		
		int total = 0;
		
		for(Object ele : maList) {
			System.out.println(ele);
			total += (Integer)ele;
		}
		System.out.println(total);
	}

}
