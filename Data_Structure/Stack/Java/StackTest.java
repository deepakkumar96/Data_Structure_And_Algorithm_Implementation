import java.util.*;

public class StackTest{
      static Scanner in = new Scanner(System.in);
      public static void main(String[] args) {
          Stack<Integer> st = new Stack<>(5,6,3,2,100);

          System.out.println(st);
          st.pop();
          st.pop();
          st.push(1000);
          System.out.println(st + " , " + st.size());
          st.min().ifPresent(System.out::println);

          while(true){
              int selectedMenu = showAndGetSelectedMenu();
              switch(selectedMenu){
                  case 0:
                      System.out.println(st+"\n");
                      break;
                  case 1:
                      System.out.println("IS Empty? : " + st.isEmpty());
                      break;
                  case 2:
                      System.out.print("Enter Value : ");
                      st.push(in.nextInt());
                      break;
                  case 3:
                      st.pop().ifPresent(e -> System.out.println("Pop Value : " + e));
                      break;
                  case 4:
                      st.min().ifPresent(e -> System.out.println("Min Value : " + e));
                      break;
                  default:
                      System.exit(0);
              }
          }

      }

      public static int showAndGetSelectedMenu(){
          System.out.print(
             "0. Show\n"+
             "1. Check of Empty/Full\n"+
             "2. Push\n"+
             "3. Pop\n"+
             "4. Min\n"+
             "5. Reverse stack using extra space\n"+
             "6. Reverse stack without using extra space\n"+
             "7. Sort the stack with using extra space\n"+
             "8. Sort the stack without using extra space\n"+
             "9. Exit\n\n" +
             "Enter: "
          );
          return in.nextInt();
      }

}
