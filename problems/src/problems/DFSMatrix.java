package problems;

import java.util.ArrayList;
import java.util.Stack;

public class DFSMatrix {
	public boolean searchRecursive(char[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		boolean[][] mark = new boolean[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (matrix[i][j] == '.') mark[i][j] = true;
				else mark[i][j] = false;
		return DFS(mark, 0, 0);
	}

	public boolean DFS(boolean[][] mark, int x, int y) {
		int n = mark.length;
		int m = mark[0].length;
		if (x == n - 1 && y == m - 1) return mark[x][y];
		if (x >= 0 && x < n && y >= 0 && y < m && mark[x][y]) {
			mark[x][y] = false;
			return DFS(mark, x - 1, y) || DFS(mark, x + 1, y) || DFS(mark, x, y - 1) || DFS(mark, x, y + 1);
		}
		return false;
	}


	public boolean searchIterative(char[][] matrix) {
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
			mark[0][0] = false;
		}
		while(!stack.empty()) {
			ArrayList<Integer> cur_pos = stack.pop();
			int x = cur_pos.get(0), y = cur_pos.get(1);
			if (x == n - 1 && y == m - 1) return true;
			if (x - 1 >= 0 && mark[x - 1][y] && matrix[x - 1][y] == '.') {
				ArrayList<Integer> pos = new ArrayList<>();
				pos.add(x - 1);
				pos.add(y);
				stack.push(pos);
				mark[x - 1][y] = false;
			}
			if (x + 1 < n && mark[x + 1][y] && matrix[x + 1][y] == '.') {
				ArrayList<Integer> pos = new ArrayList<>();
				pos.add(x + 1);
				pos.add(y);
				stack.push(pos);
				mark[x + 1][y] = false;
			}
			if (y - 1 >= 0 && mark[x][y - 1] && matrix[x][y - 1] == '.') {
				ArrayList<Integer> pos = new ArrayList<>();
				pos.add(x);
				pos.add(y - 1);
				stack.push(pos);
				mark[x][y - 1] = false;
			}
			if (y + 1 < m && mark[x][y + 1] && matrix[x][y + 1] == '.') {
				ArrayList<Integer> pos = new ArrayList<>();
				pos.add(x);
				pos.add(y + 1);
				stack.push(pos);
				mark[x][y + 1] = false;
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
		System.out.println(solution.searchRecursive(matrix));
		System.out.println(solution.searchIterative(matrix));
	}
}
