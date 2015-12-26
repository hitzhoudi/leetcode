package leetcode;

public class Sqrt {
	public int mySqrt(int x) {
		long l = 0, r = x;
		while (l < r) {
			long p = l + (r - l) / 2;
			if (p * p > x)
				r = p - 1;
			else
				l = p + 1;
		}
		if (l * l > x)
			return (int)l - 1;
		return (int)l;
	}

	public final static void main(String[] args) {
		Sqrt sqrt = new Sqrt();
		System.out.println(sqrt.mySqrt(2147483647));
	}
}
