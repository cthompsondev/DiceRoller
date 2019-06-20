package dev.cthompson.diceroller.roller;

import java.util.ArrayList;

public class Roller {
	public ArrayList<Integer> Roller(int num, int die) {
		ArrayList<Integer> results = new ArrayList<Integer>(num);
		
		for(int i = 0; i < num; i++) {
			int rand = (int)(Math.random() * die) +1;
			results.add(rand);
		}
		
		return results;
	}
	
}
