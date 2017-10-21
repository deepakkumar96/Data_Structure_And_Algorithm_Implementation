import java.util.*;

public class BstTest{
    public static void main(String...args) throws Exception{
        Bst<Integer> bst = new Bst<Integer>(Arrays.asList(50, 30, 20, 40, 70, 60, 80));
        Collection<Integer> coll = bst;

        System.out.println(coll);

        bst.addGreaterToAll(new Bst.Adder<Integer>(){
          @Override
          public Integer add(Integer v1, Integer v2){
              System.out.println(v1 + " " + v2);
              return v1+v2;
          }
        });

        for(Integer i: coll){
            System.out.println(i+ " ");
        }
    }
}
