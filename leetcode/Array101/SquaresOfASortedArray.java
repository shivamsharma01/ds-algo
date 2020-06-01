package leetcode.Array101;

public class SquaresOfASortedArray {

	public int[] sortedSquares(int[] A) {
        int left = 0, right = A.length-1, i=right;
        int[] output = new int[A.length];
        while(i >= 0) {
            if(Math.abs(A[left]) > Math.abs(A[right]))
                output[i--] = A[left]*A[left++];
            else
                output[i--] = A[right]*A[right--];
        }
        return output;
    }

}