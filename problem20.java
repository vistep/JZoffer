package JZoffer;
import java.util.*;
public class problem20 {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null) {
        	return null;
        } else {
        	int m = matrix.length;
        	int n = matrix[0].length;
        	ArrayList<Integer> result = new ArrayList<Integer>();
        	printCore(matrix, result, 0, 0, m - 1, n - 1);
        	return result;
        }
    }
    public static void printCore(int[][] matrix, ArrayList<Integer> result, int a, int b, int c, int d){
    	System.out.println("enter printCore");
    	if (a > c || b > d) {
    		return;
    	}
		int i;
		int j;
    	if (a == c && b == d) {
    		result.add(Integer.valueOf(matrix[a][b]));
    	} else if (a == c) {
    		for (i = a, j = b; j <= d; j++) {
    			result.add(Integer.valueOf(matrix[i][j]));
    		}
    	} else if (b == d) {
    		for (j = b, i = a; i <= c; i++) {
    			result.add(Integer.valueOf(matrix[i][j]));
    		}
    	} else {
    		for (i = a, j = b; j < d; j++) {
    			result.add(Integer.valueOf(matrix[i][j]));
    		}
    		for (j = d, i = a; i < c; i++) {
    			result.add(Integer.valueOf(matrix[i][j]));
    		}
    		for (i = c, j = d; j > b; j--) {
    			result.add(Integer.valueOf(matrix[i][j]));
    		}
    		for (j = b, i = c; i > a; i--) {
    			result.add(Integer.valueOf(matrix[i][j]));
    		}
    	}
    	printCore(matrix, result, a + 1, b + 1, c - 1, d - 1);
    }
    
    public static void main(String[] args) {
//    	int[][] A = {{1},{2},{3},{4},{5}};
//    	int[][] A = {{1,2,3,4,5}};
    	int[][] A = {{1,2},{3,4}};
    	List<Integer> result = printMatrix(A);
    	Iterator<Integer> itr = result.iterator();
    	while (itr.hasNext()) {
    		System.out.print(itr.next());
    	}
    }
}
