package leetcode;

public class ReverseBits {
	public int reverseBits(int n) {
		int x = 0;
		for (int i = 0; i < 32; i++) {
			x = (x << 1) | (n & 1);
			n >>= 1;
		}
		return x;
	}

	public final static void main(String[] args) {
		ReverseBits reverse_bits = new ReverseBits();
		System.out.println(reverse_bits.reverseBits(-2));
	}
}
