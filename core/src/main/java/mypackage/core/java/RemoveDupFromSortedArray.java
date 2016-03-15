package mypackage.core.java;

import java.util.Arrays;

// TODO: Auto-generated Javadoc
/**
 * http://www.programcreek.com/2013/01/leetcode-remove-duplicates-from-sorted-array-java/
 * 
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length. Do not allocate extra space for
 * another array, you must do this in place with constant memory. The Class
 * RemoveDupFromSortedArray.
 */
public class RemoveDupFromSortedArray {

	public static int[] removeDuplicates(int[] A) {
		if (A.length < 2)
			return A;
	 
		int j = 0;
		int i = 1;
	 
		while (i < A.length) {
			/**
			 * if jth element and current element ith are equal then increment i
			 * to move to find next non -dup element.
			 * else if non dup found then increment j and store non duplicate at j
			 * then increment i . 
			 * 
			 */
			if (A[i] == A[j]) {
				i++;
			} else {
				j++;
				A[j] = A[i];
				i++;
			}
		}
	 
		int[] B = Arrays.copyOf(A, j + 1);
	 
		return B;
	}
	 
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 3, 3 };
		arr = removeDuplicates(arr);
		System.out.println(arr.length);
	}
}
