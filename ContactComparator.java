/**
 * Imports Java Utility
 */
import java.util.Comparator;


/**
 * Contact Comparator Class implements Comparator
 * @author Michael Mangrobang
 *
 */
public class ContactComparator implements Comparator<Contact> {

  
  /**
   * compares last name, if last names are same compare first names
   * @param o1
   * @param o2
   * @return
   * 
   */
  @Override
  public int compare(Contact o1, Contact o2) {

    if(o1.getLast().compareToIgnoreCase(o2.getLast()) == 0) {
      
      return o1.getFirst().compareToIgnoreCase(o2.getFirst());
      
    } else {
      
      return o1.getLast().compareToIgnoreCase(o2.getLast());
      
    }
    
  } // end compare
  
  
} // end class