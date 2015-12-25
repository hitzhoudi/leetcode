package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FirstUniqueCharacter {
	// Basic Version
	public Character firstUniqueCharacter(String input) {
		HashMap<Character, Integer> hash_map = new HashMap<>();
		for (Character c : input.toCharArray())
			hash_map.put(c, hash_map.containsKey(c) ? hash_map.get(c) + 1 : 1);
		for (Character c : input.toCharArray())
			if (hash_map.get(c) == 1)
				return c;
		return null;
	}

	// Set & List
	public Character firstUniqueCharacter(String input, double list) {
		HashSet<Character> repeat_set = new HashSet<>();
		List<Character> unrepeat_list = new LinkedList<>();

		for (Character c : input.toCharArray()) {
			if (repeat_set.contains(c))
				continue;
			if (unrepeat_list.contains(c)) {
				unrepeat_list.remove(c);
				repeat_set.add(c);
			} else {
				unrepeat_list.add(c);
			}
		}
		if (unrepeat_list.size() == 0)
			return null;
		return unrepeat_list.get(0);
	}

	// LinkedHashMap: Ordered HashMap
	public Character firstUniqueCharacter(String input, int linkedHashMap) {
		Map<Character, Integer> linked_hash_map = new LinkedHashMap<>();
		for (char c : input.toCharArray())
			linked_hash_map.put(c, linked_hash_map.containsKey(c) ? linked_hash_map.get(c) + 1: 1);
		for (Entry<Character, Integer> entry : linked_hash_map.entrySet())
			if (entry.getValue() == 1)
				return entry.getKey();
		return null;
	}

	public final static void main(String[] args) {
		FirstUniqueCharacter solution = new FirstUniqueCharacter();
		System.out.println(solution.firstUniqueCharacter("abcabcdefefz"));
		System.out.println(solution.firstUniqueCharacter("abcabcdefefz", 1));
		System.out.println(solution.firstUniqueCharacter("abcabcefefz", 1.0));
	}
}
