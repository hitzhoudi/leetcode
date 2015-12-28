package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

class MyPair {
	public int value;
	public ArrayList<Integer> pos_a;
	public ArrayList<Integer> pos_b;
}

public class PairInMatrix {
	public List<MyPair> getPairs(int[][] matrix) {
		HashMap<Integer, ArrayList<ArrayList<Integer>>> hash_map = new HashMap<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (!hash_map.containsKey(matrix[i][j])) {
					ArrayList<Integer> pos = new ArrayList<>();
					pos.add(i);
					pos.add(j);
					ArrayList<ArrayList<Integer>> pos_list = new ArrayList<>();
					pos_list.add(pos);
					hash_map.put(matrix[i][j], pos_list);
				} else {
					ArrayList<ArrayList<Integer>> cur_pos_list = hash_map.get(matrix[i][j]);
					ArrayList<Integer> pos = new ArrayList<>();
					pos.add(i);
					pos.add(j);
					cur_pos_list.add(pos);
					hash_map.put(matrix[i][j], cur_pos_list);
				}
			}
		}
		List<MyPair> result = new ArrayList<>();
		for (Entry<Integer, ArrayList<ArrayList<Integer>>> elem : hash_map.entrySet()) {
			Integer key = elem.getKey();
			ArrayList<ArrayList<Integer>> value = elem.getValue();
			for (int i = 1; i < value.size(); i += 2) {
				MyPair my_pair = new MyPair();
				my_pair.value = key;
				my_pair.pos_a = value.get(i - 1);
				my_pair.pos_b = value.get(i);
				result.add(my_pair);
			}
		}
		return result;
	}

	public final static void main(String[] args) {
		int[][] matrix = {{1, 3, 4, 1}, {6, 1, 7, 8}, {9, 0, 5, 8}, {2, 2, 1, 2}};
		PairInMatrix solution = new PairInMatrix();
		List<MyPair> result = solution.getPairs(matrix);
		for (MyPair elem : result) {
			System.out.println("key:" + elem.value
					+ " x1:" + elem.pos_a.get(0) + " y1:" + elem.pos_a.get(1)
					+ " x2:" + elem.pos_b.get(0) + " y2:" + elem.pos_b.get(1));
		}
	}
}
