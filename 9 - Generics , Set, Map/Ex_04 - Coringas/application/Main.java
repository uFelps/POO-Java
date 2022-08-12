package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Integer> integers = Arrays.asList(1,2,3,4);
		List<Object> objects = new ArrayList<>();
		
		copy(integers, objects);
		printList(objects);

	}
	
	public static void copy(List<? extends Number> source, List<? super Number> destiny) {
		for(Number number : source) {
			destiny.add(number);
		}
	}
	
	public static void printList(List<?> list) {
		for(Object obj : list) {
			System.out.print(obj + " ");
		}
	}

}
