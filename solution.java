import java.util.ArrayList;

public class solution {

	static ArrayList<int[]> longestSubsequence = new ArrayList<int[]>();

	public static void main(String args[]) {
		solution ob = new solution();
		 int[] nums= { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
		int max = ob.lengthOfLIS(nums);
		System.out.println(max);

		printLIS(nums, max);

	}

	static void printLIS(int[] nums, int max) {

		for (int[] i : longestSubsequence) {
			if (max == i.length) {
				System.out.println();
				for (int h = 0; h < i.length; h++) {

					System.out.print(i[h] + " ");
				}
				System.out.println();
				break;
			}
		}
	}

	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length, len = 1;
		int[] result = new int[n];
		result[0] = nums[0];

		for (int i = 1; i < n; i++) {

			int currentElement = nums[i];
			if (currentElement <= result[0]) {
				result[0] = currentElement;
			} else if (currentElement > result[len - 1]) {
				result[len++] = currentElement;
			} else {
				int position = binarySearch(result, currentElement, 0, len - 1);
				result[position] = currentElement;
			}

			int[] copyofresult = new int[len];
			for (int t = 0; t < len; t++) {
				copyofresult[t] = result[t];
			}
			longestSubsequence.add(copyofresult);
		}

		return len;
	}

	public int binarySearch(int[] arr, int target, int start, int end) {
		int leftIndex = start, rightIndex = end;

		while (rightIndex - leftIndex > 1) {
			int middleIndex = (leftIndex + rightIndex) / 2;
			int middleElement = arr[middleIndex];
			if (middleElement == target) {
				return middleIndex;
			} else if (middleElement < target) {
				leftIndex = middleIndex;
			} else {
				rightIndex = middleIndex;
			}
		}
		return rightIndex;
	}
}
