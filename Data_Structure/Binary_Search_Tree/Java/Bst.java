import java.util.*;
import java.io.*;

class Bst<E extends Comparable<E>> extends AbstractSet<E>
            implements Set<E>, Serializable{

      private Node<E> root;
      private int size;
      public Bst(){ }

      public Bst(Collection<? extends E> c){
          this();
          addAll(c);
      }

      /* Main BST operations */

      // Bst insert operation
      private Node<E> bstInsert(Node<E> node, E key){
          if(node == null)
              return new Node<E>(null, key, null);
          if(key.compareTo(node.data) <  0)
              node.left = bstInsert(node.left, key);
          if(key.compareTo(node.data) >  0)
              node.right = bstInsert(node.right, key);
          return node;
      }


      @Override
      public boolean add(E data){
          root = bstInsert(root, data);
          size++;
          return true;
      }

      @Override
      public int size(){
          return size;
      }


      // Traversal
      public String preOrder(Node<E> node, StringBuilder sb){
          if(node != null){
              sb.append(node.data).append(" ");
              preOrder(node.left, sb);
              preOrder(node.right, sb);
          }
          return sb.toString();
      }

      public String inOrder(Node<E> node, StringBuilder sb){
          if(node != null){
              inOrder(node.left, sb);
              sb.append(node.data).append(" ");
              inOrder(node.right, sb);
          }
          return sb.toString();
      }

      public <T extends Number> int addGreaterToAll(Node<T> node, int sum, Adder<T> adder){
          if(node == null)
              return sum;
          sum += addGreaterToAll(node.right, sum, adder);
          sum += node.data.intValue();
          node.data = (T)adder.add((T)new Integer(sum), (T)new Integer(node.data.intValue()));
          sum += addGreaterToAll(node.left, sum, adder);
          System.out.println("--"+node.data +" - "+sum);
          return sum;
      }

      public <T extends Number> int addGreaterToAll(Adder<T> adder){
            return addGreaterToAll((Node<T>)root, 0, adder);
      }

      @Override
      public Iterator<E> iterator(){
          return new PreOrderIterator(root);
      }

      @Override
      public String toString(){
          return "[ " + inOrder(root, new StringBuilder()) + "]";
      }


      /* Utility Classes */
      private static class Node<E>{
          Node<E> left;
          E data;
          Node<E> right;

          public Node(){}

          public Node(Node<E> left, E data, Node<E> right){
              this.data = data;
              this.left = left;
              this.right = right;
          }
      }

      private static class HashNode extends Node{}

      public static interface Adder<T extends Number>{
          T add(T v1, T v2);
      }

      private static class PreOrderIterator<E> implements Iterator<E>{

          Node<E> root;
          Stack<Node<E>> stk = new Stack<>();
          public PreOrderIterator(Node<E> root){
              this.root = root;
              stk.push(root);
          }

          @Override
          public boolean hasNext(){
              return !stk.isEmpty();
          }

          @Override
          public E next(){
              Node<E> cur = stk.peek();
              if(cur.left != null)
                  stk.push(cur.left);
              else{
                  Node<E> tmp = stk.pop();
                  while(tmp.right == null){
                      if (stk.isEmpty())
                          return cur.data;
                      tmp = stk.pop();
                  }
                  stk.push(tmp.right);
              }
              return cur.data;
          }
      }

}
