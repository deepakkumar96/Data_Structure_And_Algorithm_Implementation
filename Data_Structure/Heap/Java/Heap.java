

public class Heap{


    public static <T extends Comparable<T>> void buildHeap(T[] ar, int sz){
        System.out.println(sz);
        for( int i = (int)Math.floor( sz - 1 ); i >= 0; i-- ){
            heapify(ar, i, sz);
        }
    }
    public static <T extends Comparable<T>> void heapify(T ar[], int i, int sz){
        int lc = 2*i+1;
        int rc = lc+1;
        int largest = i;
        if(lc < sz && ar[lc].compareTo(ar[i]) > 0)
            largest = lc;
        else if( rc < sz && ar[rc].compareTo(ar[i]) > 0)
            largest = rc;
        if(largest != i){
            swap(ar, i, largest);
            heapify(ar, largest, sz);
        }
    }

    public static <T extends Comparable<T>> void swap(T[] ar, int i, int j){
        T temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
}
