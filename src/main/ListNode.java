package main;

/**
 * A class that contains List Nodes contained in List class
 * 
 * @author Gerda Ugne Pupelyte
 * @version 1.0
 */
public class ListNode    
{
    // fields to store the data being held in this list node
	private String itemName;
	private int itemValue;
	
    private ListNode next;

    /**
     * Default constructor. Initialise fields to default values
     */
    public ListNode()
    {
        
    	itemName = " ";
    	itemValue = 0;
    	
        // set next node to null 
        next = null;
    }
    
    public ListNode(String itemName, int itemValue)
    {
    	this.itemName = itemName;
    	this.itemValue = itemValue;
    }

    /**
     * Get the next node in the list after this one
     * 
     * @return A reference to the next node (or null if
     *         there is no next node)
     */
    public ListNode getNext()
    {
      return next;
    }

    /**
     * Set the next node in the list after this one
     * 
     * @param next A reference to a ListNode object which 
     *             represents the next node in the list after
     *             this one.
     */
    public void setNext(ListNode next)
    {
    	this.next = next;
    }
    
    public String getItemName()
    {
    	return itemName;
    }
    
    public int getItemValue()
    {
    	return itemValue;
    }
    
    /**
     * Returns item data
     * @return information about items
     */
    public String getData()
    {
    	String data;
    	
    	data = getItemName() + getItemValue();
    	return data;
    }

}
