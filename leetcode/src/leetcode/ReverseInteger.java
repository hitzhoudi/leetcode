package leetcode;

public class ReverseInteger {
	public int reverse(int x) {
		int y = 0;
		while (x != 0) {
			if (y * 10 / 10 != y)
				return 0;
			y = y * 10 + x % 10;
			x /= 10;
		}
		return y;
	}

	public static final void main(String[] args) {
		ReverseInteger reverse_integer = new ReverseInteger();
		System.out.println(reverse_integer.reverse(123456));
		return;
	}
}
