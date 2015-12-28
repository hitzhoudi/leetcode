package problems;

import java.util.ArrayList;
import java.util.Stack;

public class DFSMatrix {
	public boolean search(char[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		boolean[][] mark = new boolean[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				mark[i][j] = true;

		Stack<ArrayList<Integer>> stack = new Stack<>();
		if (matrix[0][0] == '.') {
			ArrayList<Integer> start = new ArrayList<>();
			start.add(0);
			start.add(0);
			stack.push(start);
		}
		while(!stack.empty()) {
			ArrayList<Integer> cur_pos = stack.pop();
			int x = cur_pos.get(0), y = cur_pos.get(1);
			mark[x][y] = false;
			if (x == n - 1 && y == m - 1) return true;
			if (x - 1 >= 0 && mark[x - 1][y] && matrix[x - 1][y] == '.') {
				ArrayList<Integer> pos = new ArrayList<>();
				pos.add(x - 1);
				pos.add(y);
				stack.push(pos);
			}
			if (x + 1 < n && mark[x + 1][y] && matrix[x + 1][y] == '.') {
				ArrayList<Integer> pos = new ArrayList<>();
				pos.add(x + 1);
				pos.add(y);
				stack.push(pos);
			}
			if (y - 1 >= 0 && mark[x][y - 1] && matrix[x][y - 1] == '.') {
				ArrayList<Integer> pos = new ArrayList<>();
				pos.add(x);
				pos.add(y - 1);
				stack.push(pos);
			}
			if (y + 1 < m && mark[x][y + 1] && matrix[x][y + 1] == '.') {
				ArrayList<Integer> pos = new ArrayList<>();
				pos.add(x);
				pos.add(y + 1);
				stack.push(pos);
			}
		}
		return false;
	}

	public final static void main(String[] args) {
		char[][] matrix = {{'.', '#', '.', '.', '.'},
						{'.', '#', '.', '#', '.'},
						{'.', '#', '.', '#', '.'},
						{'.', '#', '.', '#', '.'},
						{'.', '.', '.', '#', '.'}};
		DFSMatrix solution = new DFSMatrix();
		System.out.println(solution.search(matrix));
	}
}
