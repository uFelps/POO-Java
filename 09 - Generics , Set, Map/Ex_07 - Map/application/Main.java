package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import model.entities.Product;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> votes = new TreeMap<>();
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
	
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			
			while(line != null) {
				String[] fields = line.split(",");
				
				String name = fields[0];
				Integer vote = Integer.parseInt(fields[1]);
				
				if(votes.containsKey(name)) {
					votes.put(name, votes.get(name) + vote);
				}
				
				else {
					votes.put(name, vote);
				}
				line = br.readLine();
			}
			
			for(String key : votes.keySet()) {
				System.out.println(key + ": " + votes.get(key));
			}
			
			
		}
		
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
		sc.close();
	}

}
