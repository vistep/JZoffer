package JZoffer;

import java.util.*;

public class problem30 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if (input == null) {
    		return null;
    	}
    	int len = input.length;
    	if (len == 0) {
    		return result;
    	}
    	if (len < k) {
    		for (int i = 0; i < len; i ++) {
    			result.add(Integer.valueOf(input[i]));
    		}
    		return result;
    	}
//    	System.out.println("Enter here");
    	int[] arrayForHeap = new int[k];
    	for (int i = 0; i < k; i++) {
    		arrayForHeap[i] = input[i];
    	}
    	Heap heap = new Heap(arrayForHeap);
    	for (int i = k; i < len; i++){
    		if (input[i] < heap.peek()) {
    			heap.pop();
    			heap.push(input[i]);
    		}
    	}
    	heap.sort();
    	for (int i = 0; i < k; i++) {
    		result.add(Integer.valueOf(arrayForHeap[i]));
//    		System.out.print(arrayForHeap[i]);
    	}
//    	for (int i = 0; i < heap.A.length; i ++) {
//    		System.out.print(heap.A[i]);
//    	}
//    	System.out.println();
    	return result;
    }
    
    public static void main(String[] args) {
    	int[] input = {4,5,1,6,2,7,3,8};
    	ArrayList<Integer> result = GetLeastNumbers_Solution(input, 8);
    	Iterator<Integer> itr = result.iterator();
    	while(itr.hasNext()) {
    		System.out.print(itr.next());
    	}
    }

}

class Heap {
	public int heapSize;
	public int[] A;
	//convert heap index to array index
	private int arrayIndex(int i) {
		if (i < 1) {
			System.err.println("Index of heap can not be less than 1,");
			return -1;
		} else {
			return i-1;
		}
	}
	
	private int parent(int i) {
		return i/2;
	}
	
	private int left(int i) {
		return 2*i;
	}
	
	private int right(int i) {
		return 2*i+1;
	}
	
	private void keepHeap(int i) {
		int l = left(i);
		int r = right(i);
		int largest;
		if (l <= heapSize && A[arrayIndex(l)] > A[arrayIndex(i)]) {
			largest = l;
		} else {
			largest = i;
		}
		if(r <= heapSize && A[arrayIndex(r)] > A[arrayIndex(largest)]) {
			largest = r;
		}
		if (largest != i) {
			int tmp = A[arrayIndex(i)];
			A[arrayIndex(i)] = A[arrayIndex(largest)];
			A[arrayIndex(largest)] = tmp;
			keepHeap(largest);
		}
	}
	
	public Heap(int[] array) {
//		int len = array.length;
//		int[] A = new int[len];
//		for (int i = 0; i < len; i++) {
//			A[i] = array[i];
//		}
		A = array;
		heapSize = A.length;
		for (int i = parent(heapSize); i > 0; i--) {
			keepHeap(i);
		}
	}
	
	public void sort() {
		for(int i = heapSize; i > 1; i--) {
			int tmp = A[arrayIndex(1)];
			A[arrayIndex(1)] = A[arrayIndex(i)];
			A[arrayIndex(i)] = tmp;
			heapSize--;
			keepHeap(1);
		}
	}
	
	public int peek() {
		if (heapSize > 0) {
			return A[arrayIndex(1)];
		} else {
			System.out.println("Heap underflow!");
			return -1;
		}
	}
	
	public int pop() {
		if (heapSize > 0) {
			int tmp = A[arrayIndex(1)];
			A[arrayIndex(1)] = A[arrayIndex(heapSize)];
			A[arrayIndex(heapSize)] = A[arrayIndex(1)];
			heapSize--;
			keepHeap(1);
			return tmp;
		} else {
			System.out.println("Heap underflow!");
			return -1;
		}
	}
	
	public void push(int d) {
		heapSize++;
		A[arrayIndex(heapSize)] = d;
		int k = heapSize;
		while (k > 1 && A[arrayIndex(parent(k))] < A[arrayIndex(k)]) {
			int tmp = A[arrayIndex(parent(k))];
			A[arrayIndex(parent(k))] =  A[arrayIndex(k)];
			A[arrayIndex(k)] = tmp;
			k = parent(k);
		}
	}
}