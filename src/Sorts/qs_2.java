package Sorts;
import java.util.Random;
public class qs_2{

	    private boolean randomPivot;

	    public qs_2(boolean randomPivot) {
	        this.randomPivot = randomPivot;
	    }

	    
	    public void sort(int[] tab) {
	        // random pivot
	        quicksort(tab, 0, tab.length - 1);
	    }

	    public int[] halfSort(int arr[]) {
	        quicksort(arr, 0, arr.length / 2);

	        return arr;
	    }

	    private void quicksort(int[] data, int left, int right) {
	        int pi;
	        if (left < right) {
	            pi = partition(data, left, right);

	            quicksort(data, left, pi - 1);
	            quicksort(data, pi + 1, right);
	        }
	    }

	    private int partition(int[] data, int left, int right) {

	        Random rand = new Random();
	        if (randomPivot == true) {
	            int index = left + rand.nextInt(right - left);
	            swap(data, right, index);
	        } else {
	            int mid = ((right + left) / 2);


	            if (data[left] > data[mid])
	                swap(data, left, mid);
	            if (data[mid] > data[right])
	                swap(data, mid, right);
	            if (data[left] > data[mid])
	                swap(data, mid, left);
	            swap(data, mid, right);
	        }

	        int pivot = data[right];
	        int i = left;

	        for (int j = left; j < right; j++) {
	            if (data[j] <= pivot) {
	                swap(data, i, j);
	                i++;
	            }
	        }

	        swap(data, i, right);

	        return i;
	    }

	    private void swap(int[] data, int index1, int index2) {
	        int temp = data[index1];

	        data[index1] = data[index2];
	        data[index2] = temp;
	    }
	}
