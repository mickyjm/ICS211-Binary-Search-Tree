/**
 * Class to test Assignment 08
 * @author Michael Mangrobang
 *
 */
public class TestContacts {

  
  /**
   * main method runs all other test methods
   * @param args
   */
  public static void main(String[] args) {

    /* declare new ContactComparator */
    ContactComparator cc = new ContactComparator();
    
    /* declare new BinarySearchTree */
    BinarySearchTree<Contact> ctree = new BinarySearchTree<Contact>(cc);
    
    /* declare new contacts */
    Contact[] c = new Contact[15];
    createContacts(c);
    
    /* tree is empty, so it should print nothing out */
    testtoString(ctree);
    
    /* test add and contains */
    testAdd(ctree, c); // method calls for and tests contains to see if the contact was added
    
    /* prints out in inOrder */
    testtoString(ctree); // prints out all contacts
    
    /* test remove, delete and find */
    testRemove(ctree, c); // method calls for and tests find to see if contact was deleted
    
    /* prints out in inOrder */
    testtoString(ctree); // prints out leftover contacts that were not removed or deleted.

  } // end main
  
  
  /**
   * Creates contacts
   * @param c
   */
  public static void createContacts(Contact[] c) {
    
    c[0] = new Contact("Crystal", "Cruz", 1234567);
    c[1] = new Contact("Alfred", "Chan", 1234568);
    c[2] = new Contact("Reno", "Redaja", 1234569);
    c[3] = new Contact("Michael", "Mangrobang", 1234570);
    c[4] = new Contact("Andrew", "Guagliardo", 1234571);
    c[5] = new Contact("Eric", "Wu", 1234572);
    c[6] = new Contact("Cam", "Moore", 1234573);
    c[7] = new Contact("Peter", "Parker", 1234574);
    c[8] = new Contact("Clark", "Kent", 1234575);
    c[9] = new Contact("Bruce", "Wayne", 1234576);
    c[10] = new Contact("Tony", "Stark", 1234577);
    c[11] = new Contact("Kanye", "West", 1234578);
    c[12] = new Contact("Taylor", "Swift", 1234579);
    c[13] = new Contact("Bart", "Simpson", 1234580);
    c[14] = new Contact("Yippy", "Yipperson", 1234581);
    
  } // end createContacts
  
  
  /**
   * tests binary search tree add method
   * @param ctree
   * @param c
   */
  private static void testAdd(BinarySearchTree<Contact> ctree, Contact[] c) {
    
    ctree.add(c[0]); // adds first contact
    
    if (!ctree.add(c[0])) { // first contact already added, so it should return a false
      
      if (!testContains(ctree, c[0])) { // contains should return true
        
        System.err.println("Problem with add method! Contact was not added!"); //  else if false, problem with add
        
      }
      
    }
    
    for (int i = 1; i < 15; i++) { // adds the rest of the contacts
      
      ctree.add(c[i]);
      
      if (!testContains(ctree, c[i])) { // contains should return true
        
        System.err.println("Problem with add method! Contact was not added!"); // else if false, problem with add
        
      }
      
    }
    
  } // end testAdd
  
  
  /**
   * test contains method. should return a true or false, if not there is a problem with method
   * @param ctree
   * @param c
   * @return true/false
   */
  private static boolean testContains(BinarySearchTree<Contact> ctree, Contact c) {
    
    if (ctree.contains(c) || !ctree.contains(c)) { // contain should return either a true or false
      
    } else {
      
      System.err.println("Problem with contains method! Does not return true or false!"); // else there is a problem with contains
      
    }
    
    return ctree.contains(c);
    
  } // end testContains
  
  
  /**
   * tests inorderString method. method should return contact list or empty, if not problem with method
   * @param ctree
   */
  private static void testtoString(BinarySearchTree<Contact> ctree) {
    
    if (ctree.inorderString() == null) { // inorderString is not set to return a null
      
      System.err.println("Problem with inorderString method!");
      
    } else {
      
      System.out.println(ctree.inorderString());
      
    }
    
  } // end testtoString
  
  
  /**
   * test remove, delete and find methods.
   * @param ctree
   * @param c
   */
  private static void testRemove(BinarySearchTree<Contact> ctree, Contact[] c) {
    
    if (ctree.find(c[11]) == c[11]) { // finds if contact is in tree, should return target contact if found
     
      if (ctree.delete(c[11]) != c[11]) { // delete should remove given contact and return said contact
      
        System.err.println("Problem with delete! Contact removed did not return!"); // if contact was not returned, problem with delete
      
      }
      
    } else {
      
      System.err.println("Problem with add! Contact was not added!"); // contact should be added at this point
      
    }

    if (ctree.find(c[11]) == null) { // contact was removed, so it should return null since contact was not found
    
      if (ctree.delete(c[11]) != null) { // contact already removed, so it should return null
      
        System.err.println("Problem with delete! Contact already removed should return a null!"); // if null was not returned, problem with delete
      
      }
    
    } else {
      
      System.err.println("Problem with add! Contact was not added!"); // contact should be added at this point
      
    }
    
    if (ctree.find(c[13]) == c[13]) { // finds if contact is in tree, should return target contact if found
      
      if (!ctree.remove(c[13])) { // remove should remove contact and return true
      
        System.err.println("Problem with remove! Method did not return true so contact was not removed!"); // if false is returned, problem with remove
      
      }
      
    } else {
      
      System.err.println("Problem with add! Contact was not added!"); // contact should be added at this point
      
    }
    
    if (ctree.find(c[13]) == null) { // contact was removed, so it should return null since contact was not found
      
      if (ctree.remove(c[13])) { // contact already removed, so it should return false
      
        System.err.println("Problem with remove! Contact removed did not return!"); // if true is returned, problem with remove
      
      }
      
    } else {
      
      System.err.println("Problem with add! Contact was not added!"); // contact should be added at this point
      
    } 
    
  } // end testRemove
    

} // end class