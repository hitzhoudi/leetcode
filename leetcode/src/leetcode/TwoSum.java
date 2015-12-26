package leetcode;

import java.util.HashMap;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] idx = new int[2];
		HashMap<Integer, Integer> hash_map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (hash_map.containsKey(target - nums[i])) {
				idx[0] = hash_map.get(target - nums[i]) + 1;
				idx[1] = i + 1;
				break;
			}
			hash_map.put(nums[i], i);
		}
		return idx;
	}

	public final static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		TwoSum twosum = new TwoSum();
		int[] idx = twosum.twoSum(nums, 9);
		System.out.println(idx[0] + " " + idx[1]);
	}
	
}
