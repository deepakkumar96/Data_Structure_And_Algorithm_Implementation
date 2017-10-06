import java.util.*;

public class BstTest{
    public static void main(String...args) throws Exception{
        Bst<Integer> bst = new Bst<Integer>(Arrays.asList(1,2,3,4,5,6));
        Collection<Integer> coll = bst;

        bst.add(100);

        System.out.println(coll);
        System.out.println(coll.contains(7));
        for(Integer i: coll){
            System.out.println(i+ " ");
        }
    }
}
