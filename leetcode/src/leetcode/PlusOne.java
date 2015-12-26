package leetcode;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int p = digits.length - 1;
		while (p >= 0 && digits[p] == 9)
			digits[p--] = 0;
		if (p == -1) {
			int[] array = new int[digits.length + 1];
			array[0] = 1;
			return array;
		}
		++digits[p];
		return digits;
	}
}
