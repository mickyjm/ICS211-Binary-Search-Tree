/**
 * Contact Class
 * @author Michael Mangrobang
 *
 */
public class Contact {


  private String first, last;
  private long phone;
  
  
  /**
   * default constructor
   * @param f
   * @param l
   * @param p
   */
  public Contact(String f, String l, long p) {
    
    this.first = f;
    this.last = l;
    this.phone = p;
    
  } // end default constructor


  /**
   * to string method
   * @return
   */
  @Override
  public String toString() {
    
    return "Contact [ " + last + ", " + first + ", Phone: " + phone + " ]";
  
  } // end toString


  /**
   * gets first name
   * @return first
   */
  public String getFirst() {
    
    return first;
    
  } // end getFirst


  /**
   * sets first name
   * @param first
   */
  public void setFirst(String first) {
    
    this.first = first;
    
  } // end setFirst


  /**
   * gets last name
   * @return last
   */
  public String getLast() {
    
    return last;
    
  } // end getLast


  /**
   * sets last name
   * @param last
   */
  public void setLast(String last) {
    
    this.last = last;
    
  } // end setLast


  /**
   * gets phone number
   * @return
   */
  public long getPhone() {
    
    return phone;
    
  } // end getPhone


  /**
   * sets phone number
   * @param phone
   */
  public void setPhone(long phone) {
    
    this.phone = phone;
    
  } // end setPhone
  

} // end class