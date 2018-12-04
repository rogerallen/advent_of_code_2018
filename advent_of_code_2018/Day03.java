package advent_of_code_2018;

import java.util.stream.Stream;
import java.util.regex.Pattern;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;


public class Day03 {
	public static final int DIM = 1000;
	public static int[] cloth = new int[DIM*DIM];
	public static Set<Integer> claims = new HashSet<Integer>();
	
	public static class ClothRect {
		public static int claim, x, y, w, h;
		public static void parse(String s) {
			// #1 @ 1,3: 4x4
			// #(\d+) @ (\d+),(\d+): (\d+)x(\d+)
			Pattern pattern = Pattern.compile("#(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)");
	        Matcher matcher = pattern.matcher(s);

	        if(matcher.find()) {
	            claim = Integer.parseInt(matcher.group(1));
	            claims.add(claim);
	            x = Integer.parseInt(matcher.group(2));
	            y = Integer.parseInt(matcher.group(3));
	            w = Integer.parseInt(matcher.group(4));
	            h = Integer.parseInt(matcher.group(5));
	        } else {
	        	System.err.println("NO MATCH: "+s);
	        }
		}
		public static void rasterize() {
			for(int j = y; j < y + h; j++) {
				for(int i = x; i < x + w; i++) {
					cloth[j*DIM + i] += 1;
				}
			}
		}
		public static void rasterizeOverlap() {
			for(int j = y; j < y + h; j++) {
				for(int i = x; i < x + w; i++) {
					if(cloth[j*DIM + i] != 0) {
						// overlap case
						claims.remove(cloth[j*DIM + i]);
						claims.remove(claim);
					}
					cloth[j*DIM + i] = claim;
				}
			}
		}
	}
	
	public static void clear() {
		for(int y = 0; y < DIM; y++) {
			for(int x = 0; x < DIM; x++) {
				cloth[y*DIM + x] = 0;
			}
		}
	}

	public static int solve1(Stream<String> inputStream) {
		String [] inputs = inputStream.toArray(String[]::new);
		clear();
		for(String s: inputs) {
			ClothRect.parse(s);
			ClothRect.rasterize();
		}
		
		int overlap = 0;
		for(int y = 0; y < DIM; y++) {
			for(int x = 0; x < DIM; x++) {
				if(cloth[y*DIM + x] > 1) {
					overlap += 1;
				}
			}
		}
		return overlap;
	}

	public static int solve2(Stream<String> inputStream) {
		String [] inputs = inputStream.toArray(String[]::new);
		clear();
		claims.clear();
		for(String s: inputs) {
			ClothRect.parse(s);
			ClothRect.rasterizeOverlap();
		}
		if(claims.size() != 1) {
			System.err.println("More than one claim remains!"+claims.toString());
		}
		return claims.iterator().next();
	}
}
