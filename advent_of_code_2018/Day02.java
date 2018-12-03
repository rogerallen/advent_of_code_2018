package advent_of_code_2018;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

public class Day02 {
	
	public static class BoxResult {
		public int twoMatches;
		public int threeMatches;
		public void calculate(String s) {
			twoMatches = threeMatches = 0;
			Map<Character, Integer> frequencies = new HashMap<Character, Integer>();
			for(char c: s.toCharArray()) {
				if (frequencies.containsKey(c)) {
					frequencies.put(c, frequencies.get(c) + 1);
				}
				else {
					frequencies.put(c, 1);
				}
			}
			Iterator<Map.Entry<Character, Integer>> entryIter = frequencies.entrySet().iterator();
			while(entryIter.hasNext()) {
				Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>) entryIter.next();
			    //Character key = (Character)entry.getKey();
			    Integer value = (Integer)entry.getValue();
			    if(value == 2) {
			    	twoMatches += 1;
			    } 
			    else if(value == 3) {
			    	threeMatches += 1;
			    }
			}
		}
	}

	public static int solve1(Stream<String> inputStream) {
		int appearsTwice = 0;
		int appearsThrice = 0;
		for(String s: inputStream.toArray(String[]::new)) {
			BoxResult r = new Day02.BoxResult();
			r.calculate(s);
			if(r.twoMatches > 0) {
				appearsTwice += 1;
			}
			if(r.threeMatches > 0) {
				appearsThrice += 1;
			}
		}
		int checksum = appearsTwice * appearsThrice;
		return checksum;
	}
	
	private static String differByOneCommonLetters(String a, String b) {
		int differences = 0;
		String commonLetters = "";
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) == b.charAt(i)) {
				commonLetters += a.charAt(i);
			} else {
				differences += 1;
			}
		}
		if(differences == 1) {
			return commonLetters;
		} 
		else {
			return "";
		}
	}

	public static String solve2(Stream<String> inputStream) {
		String[] boxes = inputStream.toArray(String[]::new);
		for(int i = 0; i < boxes.length; i++) {
			for(int j = i+1; j < boxes.length; j++) {
				String a = boxes[i];
				String b = boxes[j];
				String c = differByOneCommonLetters(a,b);
				if(c != "") {
					return c;
				}
			}
		}
		return "B0rKeN";
	}
}
