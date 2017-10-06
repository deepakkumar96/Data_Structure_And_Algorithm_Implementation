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

      @Override
      public boolean add(E data){
          root = __add(root, data);
          size++;
          return true;
      }

      @Override
      public int size(){
          return size;
      }

      @Override
      public Iterator<E> iterator(){
          return new PreOrderIterator(root);
      }

      // Bst insert operation
      private Node<E> __add(Node<E> node, E key){
          if(node == null)
              return new Node<E>(null, key, null);
          if(key.compareTo(node.data) <  0)
              node.left = __add(node.left, key);
          if(key.compareTo(node.data) >  0)
              node.right = __add(node.right, key);
          return node;
      }

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

      @Override
      public String toString(){
          return "[ " + inOrder(root, new StringBuilder()) + "]";
      }


      /* Utility Classes */
      private static class Node<E>{
          Node<E> left;
          E data;
          Node<E> right;

          public Node(Node<E> left, E data, Node<E> right){
              this.data = data;
              this.left = left;
              this.right = right;
          }
      }

      public static class PreOrderIterator<E> implements Iterator<E>{

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
