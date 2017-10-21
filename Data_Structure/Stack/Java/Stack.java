import java.util.*;
import java.util.stream.*;

public class Stack<E extends Comparable<E>> {

    //private int size;
    private int curr = -1;
    private Comparable[] data;
    private final int defaultSize = 8;

    public Stack(){
        this(8);
    }
    public Stack(int size){
        data = new Comparable[size];
    }
    public Stack(E...data){
        this(data.length);
        for(E e : data){
            push(e);
        }
    }

    public boolean isEmpty(){
        return curr < 0;
    }

    public boolean push(E e){
        ensureSize(); // increase size if required
        data[++curr] = e;
        return true;
    }

    /*
        pop() remove the top value and return it.
        It wraps the stack value in Optional Object so that client will
        have to handle null Checking.
        **(Throwing an exception will be better than return null or Optional.)
    */
    public Optional<E> pop(){
        if(isEmpty())
            return Optional.empty(); // Java 8's way of handling NULLS
        E val = (E)data[curr];
        data[curr--] = null; // to avoide memory leak
        return Optional.of(val);
    }

    public Optional<E> min(){
        if(isEmpty())
            return Optional.empty();
        E minVal = (E)data[0];
        for(int i=0; i<=curr; i++){
            if(data[i].compareTo(minVal) < 0)
                minVal = (E)data[i];
        }
        return Optional.of(minVal);
    }

    public int size(){
        return curr+1;
    }

    protected void ensureSize(){
        if(curr == size()-1){
            data = Arrays.copyOf(data, size()+defaultSize);
          }
    }

    @Override
    public String toString(){
        return IntStream.range(0, curr+1)
                        .mapToObj(e -> data[e]+"")
                        .collect(Collectors.joining(" "));
    }
}
