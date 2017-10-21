
public class Stack<E>  implements Comparable<E>{

    private int size;
    private int curr = -1;
    private T[] data;

    public Stack(int size){
        this.size = size;
        data = (E[]) new Object[size];
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
        return Optional.of(data[curr--]);
    }

    public Optional<E> min(){
        if(isEmpty())
            return Optional.empty();
        E minVal = data[0];
        for(int i=0; i<=curr; i++){
            if(data[i].compareTo(minVal) < 0)
                minVal - data[i];
        }
        return Optional.of(minVal);
    }

}
