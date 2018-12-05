package advent_of_code_2018;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import advent_of_code_2018.Day03.ClothRect;

public class Day04 {
	// non-zero when asleep that minute integrated over time
	static Map<Integer, Integer[]> guard_minutes = new HashMap<Integer, Integer[]>();
	static int cur_guard  = -1;
	static boolean cur_awake = true;
	static int last_update_minute = -1;
	static Integer[] cur_guard_minutes;
	
	public static void clear() {
		guard_minutes.clear();
	}
	
	public static void parse(String s) {
		// one of
		// [1518-11-01 00:00] Guard #10 begins shift
		// [1518-11-01 00:05] falls asleep
		// [1518-11-01 00:25] wakes up
		Pattern date_pattern = Pattern.compile("(\\d+)-(\\d+)-(\\d+) (\\d+):(\\d+)");
        Matcher date_matcher = date_pattern.matcher(s);
        int year, month, day, hour, minute = 0;
        if(date_matcher.find()) {
            year   = Integer.parseInt(date_matcher.group(1));
            month  = Integer.parseInt(date_matcher.group(2));
            day    = Integer.parseInt(date_matcher.group(3));
            hour   = Integer.parseInt(date_matcher.group(4));
            minute = Integer.parseInt(date_matcher.group(5));
        } else {
        	System.err.println("NO DATE: "+s);
        }
		Pattern guard_pattern = Pattern.compile("Guard #(\\d+)");
        Matcher guard_matcher = guard_pattern.matcher(s);
        if(guard_matcher.find()) {
        	// new guard on duty, save last guard.
    		assert(cur_awake == true);
        	if(cur_guard > 0) {
        		if(guard_minutes.containsKey(cur_guard)) {
        			Integer[] mins = guard_minutes.get(cur_guard);
    				for(int i = 0; i < 60; i++) {
        				mins[i] += cur_guard_minutes[i];
        			}
        		} else {
            		guard_minutes.put(cur_guard, cur_guard_minutes);
        		}
        	}
        	cur_guard = Integer.parseInt(guard_matcher.group(1));
        	cur_awake = true;
        	last_update_minute = 0;
        	cur_guard_minutes = new Integer[60];
        	Arrays.fill(cur_guard_minutes, 0);
        } else if(s.contains("asleep")) {
        	cur_awake = false;
        	last_update_minute = minute;
        } else if(s.contains("wakes")) {
        	cur_awake = true;
        	for(int i = last_update_minute; i < minute; i++) {
        		cur_guard_minutes[i] += 1;	
        	}
        	last_update_minute = minute;
        } else {
        	System.err.println("UNEXPECTED INPUT: "+s);
        }
	}
	
	public static void post_parse() {
		Integer[] mins = guard_minutes.get(cur_guard);
		for(int i = 0; i < 60; i++) {
			mins[i] += cur_guard_minutes[i];
		}
	}
	
	public static int solve1(Stream<String> inputStream) {
		String [] inputs = inputStream.toArray(String[]::new);
		Arrays.sort(inputs); // tricky input!
		clear();
		for(String s: inputs) {
			parse(s);
		}
		post_parse();
		
		// Strategy 1: Find the guard that has the most minutes asleep. 
		// What minute does that guard spend asleep the most?
		int max_guard = 0, max_total = -1, max_minute = 0;
		Integer max_value = -1;
		Iterator<Map.Entry<Integer, Integer[]>> entryIter = guard_minutes.entrySet().iterator();
		while(entryIter.hasNext()) {
			Map.Entry<Integer, Integer[]> entry = (Map.Entry<Integer, Integer[]>) entryIter.next();
			Integer guard = (Integer)entry.getKey();
			Integer[] minutes = (Integer [])entry.getValue();
		    int total = 0;
		    for(int i = 0; i < 60; i++) {
		    	total += minutes[i];
		    }
		    if(total > max_total) {
		    	max_total = total;
		    	max_guard = guard;
		    }
		}
		Integer[] mins = guard_minutes.get(max_guard);
		for(int i = 0; i < 60; i++) {
			if(mins[i] > max_value) {
				max_value = mins[i];
				max_minute = i;
			}
		}
		    		
		// What is the ID of the guard you chose multiplied by the minute you chose?
		return max_guard * max_minute;
	}
	
	public static int solve2(Stream<String> inputStream) {
		String [] inputs = inputStream.toArray(String[]::new);
		Arrays.sort(inputs); // tricky input!
		clear();
		for(String s: inputs) {
			parse(s);
		}
		post_parse();

		// Strategy 1: Find the guard that has the most minutes asleep. 
		// What minute does that guard spend asleep the most?
		int max_guard = 0, max_minute = 0;
		int max_min_value = -1;//, max_value = -1;
		Iterator<Map.Entry<Integer, Integer[]>> entryIter = guard_minutes.entrySet().iterator();
		while(entryIter.hasNext()) {
			Map.Entry<Integer, Integer[]> entry = (Map.Entry<Integer, Integer[]>) entryIter.next();
			Integer guard = (Integer)entry.getKey();
			Integer[] minutes = (Integer [])entry.getValue();
		    for(int i = 0; i < 60; i++) {
		    	if(minutes[i] > max_min_value) {
		    		//System.out.println("max "+i+" "+minutes[i]+" "+guard);
		    		max_min_value = minutes[i];
		    		max_minute = i;
		    		max_guard = guard;
		    	}
		    }
		}
		    		
		// What is the ID of the guard you chose multiplied by the minute you chose?
		return max_guard * max_minute;
	}	
}
