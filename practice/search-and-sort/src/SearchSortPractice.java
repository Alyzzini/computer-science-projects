// Search and Sort Practice. Reference exercise added during portfolio preparation.
import java.util.Arrays;
public final class SearchSortPractice {
    /** Returns a sorted copy using insertion sort; does not modify input. */
    public static int[] insertionSort(int[] input){
        if(input==null)throw new IllegalArgumentException("Input cannot be null");
        int[] a=input.clone();
        for(int i=1;i<a.length;i++){
            int value=a[i],j=i-1;
            while(j>=0&&a[j]>value){a[j+1]=a[j];j--;}
            a[j+1]=value;
        }
        return a;
    }
    /** Returns a sorted copy using merge sort. */
    public static int[] mergeSort(int[] input){
        if(input==null)throw new IllegalArgumentException("Input cannot be null");
        int[] a=input.clone();sort(a,new int[a.length],0,a.length);return a;
    }
    private static void sort(int[] a,int[] buffer,int lo,int hi){
        if(hi-lo<2)return;
        int mid=lo+(hi-lo)/2;sort(a,buffer,lo,mid);sort(a,buffer,mid,hi);
        int left=lo,right=mid,k=lo;
        while(left<mid&&right<hi)buffer[k++]=a[left]<=a[right]?a[left++]:a[right++];
        while(left<mid)buffer[k++]=a[left++];
        while(right<hi)buffer[k++]=a[right++];
        System.arraycopy(buffer,lo,a,lo,hi-lo);
    }
    /** Precondition: ascending input. Returns first matching index, or -1. */
    public static int binarySearchFirst(int[] sorted,int target){
        if(sorted==null)throw new IllegalArgumentException("Input cannot be null");
        int lo=0,hi=sorted.length-1,found=-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(sorted[mid]<target)lo=mid+1;
            else{if(sorted[mid]==target)found=mid;hi=mid-1;}
        }
        return found;
    }
    public static void main(String[] args){
        int[] sample={7,-2,7,0,4};int[] result=mergeSort(sample);
        System.out.println("Original: "+Arrays.toString(sample));
        System.out.println("Insertion: "+Arrays.toString(insertionSort(sample)));
        System.out.println("Merge: "+Arrays.toString(result));
        System.out.println("First index of 7: "+binarySearchFirst(result,7));
        System.out.println("Index of 99: "+binarySearchFirst(result,99));
    }
}
