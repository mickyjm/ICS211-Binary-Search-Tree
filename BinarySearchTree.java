/**
 * Import Java Utility
 */
import java.util.Comparator;


/**
 * Binary Search Tree class implements Search Tree Interface
 * @author Michael Mangrobang
 * @coauthor ICS 211 Book
 *
 */
public class BinarySearchTree<E> implements SearchTree<E> {
  

  private Comparator<E> comp;
  private BinaryNode<E> root;
  private boolean added;
  private E deleted;
  
  
  /**
   * Binary Node Class for Binary Search Tree
   * Ends at line 48
   */
  private class BinaryNode<E> {
    
    private E data;
    private BinaryNode<E> left, right;
    
    
    /**
     * default constructor
     * @param data
     */
    public BinaryNode(E data) {
      
      this.data = data;
      left = null;
      right = null;
      
    }
    
    
    /**
     * toString method
     * @return toString()
     */
    public String toString() {
      
      return data.toString();
      
    }
    
  
  } // end inner binary node class
 
  
  /* start search tree interface starter and recursive methods. end at line 268 */
  
  /**
   * Add starter method. Inserts item into where it belongs in the tree.
   * @return true if item is inserted, false if item is already in tree.
   */
  @Override
  public boolean add(E item) {
    
    root = add(root, item);
    return added;
    
  } // end add
  
  
  /**
   * Add recursive method.
   * @param n
   * @param e
   * @return
   */
  private BinaryNode<E> add(BinaryNode<E> n, E e) {
    
    if (n == null) {
      
      added = true;
      return new BinaryNode<E>(e);
      
    } else if (comp.compare(e, n.data) == 0) {
      
      added = false;
      return n;
      
    } else if (comp.compare(e, n.data) < 0) {
      
      n.left = add(n.left, e);
      return n;
      
    } else {
      
      n.right = add(n.right, e);
      return n;
      
    }
    
  } // end recursive add


  /**
   * @return true if item is in the tree, false otherwise.
   */
  @Override
  public boolean contains(E item) {

    return find(root, item) != null;
    
  } // end contains


  /**
   * Find starter method. Finds the given target in the tree
   * @return a reference to the target if found, null if target isn't in the tree.
   */
  @Override
  public E find(E target) {
    
    return find(root, target);
    
  } // end find
  
  
  /**
   * Recursive find method.
   * @param n
   * @param e
   * @return null / n.data
   */
  private E find(BinaryNode<E> n, E e) {
    
    if (n == null) {
      
      return null;
      
    }
    
    if (comp.compare(e, n.data) == 0) {
      
      return n.data;
      
    } else if (comp.compare(e, n.data) < 0) {
      
      return find(n.left, e);
      
    } else {
      
      return find(n.right, e);
      
    }
    
  } // end recursive find


  /**
   * Starter delete method. Removes target from the tree.
   * @return a reference to the target if found, null if target isn't in the tree.
   */
  @Override
  public E delete(E target) {
    
    root = delete(root, target);
    return deleted;
    
  } // end delete

  
  /**
   * Delete recursive method.
   * @param n
   * @param e
   * @return
   */
  private BinaryNode<E> delete(BinaryNode<E> n, E e) {
    
    if (n == null) {
      
      deleted = null;
      return n;
      
    }
    
    if (comp.compare(e, n.data) < 0) {
      
      n.left = delete(n.left, e);
      return n;
      
    } else if (comp.compare(e, n.data) > 0) {
      
      n.right = delete(n.right, e);
      return n;
      
    } else {
      
      deleted = n.data;
      
      if (n.left == null) {
        
        return n.right;
        
      } else if (n.right == null) {
        
        return n.left;
        
      } else {
        
        if (n.left.right == null) {
          
          n.data = n.left.data;
          n.left = n.left.left;
          return n;
          
        } else {
          
          n.data = nextHeir(n.left);
          return n;
          
        }
        
      }
      
    }
    
  } // end recursive delete;
  
  
  /**
   * Next heir method. Finds next largest node
   * @param n
   * @return
   */
  private E nextHeir(BinaryNode<E> n) {
    
    if (n.right.right == null) {
      
      E val = n.right.data;
      n.right = n.right.left;
      return val;
      
    } else {
      
      return nextHeir(n.right);
      
    }
    
  } // end recursive nextHeir

  
  /**
   * Removes target from the tree.
   * @return true if target was in the tree, false otherwise.
   */
  @Override
  public boolean remove(E target) {
    
    root = delete(root, target);
    return deleted != null;
    
  } // end remove
  
  
  /* end search tree interface starter and recursive methods. starts at line 59 */
  
  
  /**
   * Creates a new BinarySearchTree.
   * @param c the comparator to use for determining order.
   */
  public BinarySearchTree(Comparator<E> c) {
    
    this.comp = c;
    this.root = null;
    
  } // end binary Search Tree

  
  /**
   * inorderString starter method
   * @return the contacts in order as a string.
   */
  public String inorderString() {
    
    return inorderString(root);
    
  } // end inorderString
  
  
  /**
   * inorderString recursive method
   * @coauthor Cam Moore
   * @return s
   */
  private String inorderString(BinaryNode<E> n) {
    
    String s = "";
    
    if (n != null) {
      
      s += inorderString(n.left);
      s += n.data.toString() + "\n";
      s += inorderString(n.right);
      
    }
    
    return s;
    
  } // end recursive inorderString
  

} // end class