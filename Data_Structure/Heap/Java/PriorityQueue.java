import java.lang.reflect.*;
import java.util.*;

public class PriorityQueue<T extends Comparable<T>>{

    private Comparable[] arr;
    private int size = 0;
    private int capacity = 16;

    public PriorityQueue(){
        this(16);
    }

    @SuppressWarnings("unchecked")
    public PriorityQueue(int size){
        this.capacity = size;
        arr = (Comparable[]) Array.newInstance(Comparable.class, capacity);
        //Heap.buildHeap(arr, this.size);
    }

    @SuppressWarnings("unchecked")
    public PriorityQueue(T...vals){
        this.capacity = vals.length;
        arr = (Comparable[]) Array.newInstance(Comparable.class, capacity);
        for(int i=0; i<vals.length; i++){
            arr[size++] = vals[i];
        }
        Heap.buildHeap(arr, this.size);
    }

    static class Person{}
    static class Student extends Person{}

    public static void main(String...args){
        PriorityQueue<Integer> pq = new PriorityQueue<>(1, 2, 3, 4, 7, 8, 9, 10, 14, 16);

        System.out.println(pq);
        System.out.println(pq.pop());

        System.out.println(pq);
        System.out.println(pq.pop());
        System.out.println(pq);
        System.out.println(pq.pop());
        System.out.println(pq);
        System.out.println(pq.pop());
        System.out.println(pq);

        Person[] p = new Student[5];
        p[0] = new Student();
        //System.out.println(((String)ar[0]).trim());
        List<String>[] stringLists = new List<String>[1];
    }

    protected void restructure(){
        Heap.buildHeap(arr, size);
    }

    public T top(){
        return (T) arr[0];
    }
    public T pop(){
        T top = (T) arr[0];
        arr[0] = arr[size-1];
        size--;
        Heap.heapify(arr, 0, size);
        return top;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for(int i=0; i<size; i++){
            sb.append(arr[i] + " ");
        }
        return sb.toString() + "]";
    }
}
