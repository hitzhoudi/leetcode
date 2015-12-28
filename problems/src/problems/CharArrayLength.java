package problems;

public class CharArrayLength {
	public int length(String str) {
		if (str.equals(""))
			return 0;
		return 1 + length(str.substring(1));
	}

	public int length(String str, int idx) {
		int ret = 0;
		try {
			str.charAt(idx);
			ret = length(str, idx + 1);
		} catch(IndexOutOfBoundsException e) {
			return idx;
		}
		return ret;
	}

	public int length(char[] str) {
		return helper(str, 0);
	}

	private int helper(char[] str, int idx) {
		if (str[idx] == '\0')
			return 0;
		return helper(str, idx + 1) + 1;
	}

	public final static void main(String[] args) {
		CharArrayLength solution = new CharArrayLength();
		String str = "ABC\0";
		System.out.println(solution.length(str.toCharArray()));
		System.out.println(solution.length(str));
		System.out.println(solution.length(str, 0));
	}
}
