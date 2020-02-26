package Sorts;
import Interfejs.*;

public class Shells {

	 public int sort(int arr[]) 
	    { 
	        int n = arr.length; 
	  
	        for (int gap = n/2; gap > 0; gap /= 2) 
	        { 

	            for (int i = gap; i < n; i += 1) 
	            { 

	                int temp = arr[i]; 
	                int j; 
	                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) 
	                    arr[j] = arr[j - gap]; 

	                arr[j] = temp; 
	            } 
	        } 
	        return 0; 
	    }
	 
	 public int sort2(int arr[]) {
		 int n = arr.length; 
		  
	        for (int gap = n/4; gap > 0; gap /= 4) 
	        { 

	            for (int i = gap; i < n; i += 1) 
	            { 
	                int temp = arr[i]; 

	                int j; 
	                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) 
	                    arr[j] = arr[j - gap]; 

	                arr[j] = temp; 
	            } 
	        } 
	        return 0; 
	 }
	 
	 public int sort3(int arr[]) {

		 int n = arr.length; 
		  
	        for (int gap = n/7; gap > 0; gap /= 7) 
	        { 

	            for (int i = gap; i < n; i += 1) 
	            { 

	                int temp = arr[i]; 

	                int j; 
	                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) 
	                    arr[j] = arr[j - gap]; 

	                arr[j] = temp; 
	            } 
	        } 
	        return 0; 

	 }
}
