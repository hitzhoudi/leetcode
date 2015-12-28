package problems;

public class MedianInSortedArray {
	double medianInSortedArray(int[] nums, int threashold) {
		int idx = binarySearch(nums, threashold);
		// 所有元素小于threashold
		if (idx == -1) {
			return -1.0;
		}
		int n_left = nums.length - idx;
		if (n_left % 2 == 0) {
			int tmp = idx + (nums.length - 1 - idx) / 2;
			return nums[tmp] + ((double)(nums[tmp + 1] - nums[tmp])) / 2;
		}
		return (double)nums[idx + (nums.length - 1 - idx) / 2];
	}

	// 二分查找数组中第一个大于等于threashold的元素的位置
	public int binarySearch(int[] nums, int threashold) {
		int l = 0, r = nums.length - 1;
		while (l < r) {
			int p = l + (r - l) / 2;
			if (nums[p] >= threashold) {
				r = p;
			} else if (nums[p] < threashold) {
				l = p + 1;
			}
		}
		// 检查上一个while中未被检查到的情况，即：
		if (l == nums.length - 1 && nums[l] < threashold)
			return -1;
		return l;
	}

	public final static void main(String[] args) {
		int[] nums = {0, 2, 4, 6, 8, 10, 11, 11, 11, 11};
		MedianInSortedArray solution = new MedianInSortedArray();
		System.out.println(solution.medianInSortedArray(nums, 11));
		System.out.println(solution.medianInSortedArray(nums, 0));
		System.out.println(solution.medianInSortedArray(nums, 12));
		System.out.println(solution.medianInSortedArray(nums, -1));
		System.out.println(solution.medianInSortedArray(nums, 17));
		System.out.println(solution.medianInSortedArray(nums, 18));
	}
}
