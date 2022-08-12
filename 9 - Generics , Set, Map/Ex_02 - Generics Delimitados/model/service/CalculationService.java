package model.service;

import java.util.List;

public class CalculationService {
	
	public static <T extends Comparable<? super T>> T max(List<T> list) {
		
		if(list.isEmpty()) {
			throw new IllegalStateException("A lista não pode estar vazia!");
		}
		
		T max = list.get(0);
		
		for(T obj : list) {
			if(obj.compareTo(max) > 0) {
				max = obj;
			}
		}
		
		return max;
	}

}
