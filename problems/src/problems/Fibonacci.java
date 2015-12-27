package problems;

public class Fibonacci {
	// Basic Function to get sum from 0 to idx
	public int sumFibonacci(int idx) {
		if (idx < 0)
			return -1;
		if (idx == 0 || idx == 1)
			return idx;

		int[] fib_val = new int[idx + 1];
		int[] fib_sum = new int[idx + 1];
		fib_val[0] = 0;
		fib_val[1] = 1;
		fib_sum[0] = 0;
		fib_sum[1] = 1;
		for (int i = 2; i <= idx; i++) {
			fib_val[i] = fib_val[i - 1] + fib_val[i - 2];
			fib_sum[i] = fib_sum[i - 1] + fib_val[i];
		}
		return fib_sum[idx];
	}

	public int sumFibonacci(int idx, int version) {
		int[] f = {0, 1, 1};
		int[] s = {0, 1, 2};
		for (int i = 2; i <= idx; i++) {
			f[i % 3] = f[(i - 1) % 3] + f[(i - 2) % 3];
			s[i % 3] = f[i % 3] + s[(i - 1) % 3];
		}
		return s[idx % 3];
	}
	
	// Recursive Version to get Fibonacci Value
	public int getFibonacci(int idx) {
		if (idx == 0 || idx == 1)
			return idx;
		return getFibonacci(idx - 1) + getFibonacci(idx - 2);
	}

	public int getFibonacci(int idx, int version) {
		int[] t = {0, 1, 1};
		for (int i = 2; i <= idx; i++)
			t[i % 3] = t[(i - 1) % 3] + t[(i - 2) % 3];
		return t[idx % 3];
	}

	public final static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		System.out.println(fibonacci.sumFibonacci(4));
		System.out.println(fibonacci.getFibonacci(9));
		for (int i = 0; i < 100; i++)
			if (fibonacci.sumFibonacci(i) != fibonacci.sumFibonacci(i, 1))
				System.out.println("Error!");
	}
}
