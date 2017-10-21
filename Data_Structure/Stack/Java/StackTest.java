public class StackTest{

      public static void main(String[] args) {
          Stack<Integer> st = new Stack<>(5,6,3,2,100);

          System.out.println(st);
          st.pop();
          st.pop();
          st.push(1000);
          System.out.println(st + " , " + st.size());
          st.min().ifPresent(System.out::println);
      }

}
