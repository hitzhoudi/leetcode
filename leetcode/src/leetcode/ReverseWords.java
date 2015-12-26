package leetcode;

public class ReverseWords {
	public String reverseWords(String s) {
		if (s == null) return null;

		String[] tokens = s.trim().split(" ", -1);
		StringBuilder result = new StringBuilder();
		for (int i = tokens.length - 1; i >= 0; i--)
			if (!tokens[i].equals(""))
				result.append(tokens[i] + " ");
		return result.toString().trim();
	}

	public void reverseWords(char[] s) {
		int n = s.length;
		reverse(s, 0, n - 1);
		int start = 0, end = 0;
		while (end < n) {
			if (s[end] == ' ') {
				reverse(s, start, end - 1);
				start = end + 1;
				end = start;
			} else {
				++end;
			}
		}
		reverse(s, start, n - 1);
	}

	private void reverse(char[] s, int l, int r) {
		while (l < r) {
			char tmp = s[r];
			s[r] = s[l];
			s[l] = tmp;
			++l;
			--r;
		}
	}

	public final static void main(String[] args) {
		ReverseWords reverse_words = new ReverseWords();
		System.out.println(reverse_words.reverseWords("  the    sky   is  blue   "));
		String s = "the sky is blue";
		char[] s_str = s.toCharArray();
		reverse_words.reverseWords(s_str);
		System.out.println(s_str);
	}
}
