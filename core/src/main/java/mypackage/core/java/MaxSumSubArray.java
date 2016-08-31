package mypackage.core.java;

public class MaxSumSubArray {

	public static void main(String[] args) {

		int a[] = { -4, -1, 2, -2, 6, -3 };
		
		int maxSum = 0;
		int currentmaxsum = 0;

		for (int i = 0; i < a.length; i++) {

			currentmaxsum += a[i];
			if (currentmaxsum > maxSum) {
				maxSum = currentmaxsum;
			}
			if (currentmaxsum < 0) {
				currentmaxsum = 0;
			}
		}
		System.out.println(maxSum);
	}
}
