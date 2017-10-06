import java.util.*;

public class BstTest{
    public static void main(String...args) throws Exception{
        Bst<Integer> bst = new Bst<Integer>(Arrays.asList(1,3,5,3,2,6));
        System.out.println(bst);
        System.out.println(bst.contains(7));
        for(Integer i: bst){
            System.out.println(i+ " ");
        }
    }
}
