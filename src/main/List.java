package main;

/**
 * A list class that contains numbers from RPN.
 * 
 * @author Gerda Ugne Pupelyte
 * @version 1.0
 */
public class List 
{
    private ListNode head; // used to hold a reference to an instance of a ListNode object
    // which will be the first item in the list, i.e. at the 'head'
    // of the list

    /**
     * Default constructor. Initialise fields to default values.
     */
    public List()
    {
        // set the list to be empty, i.e. not referring to anything valid yet
        head = null;
    }

    /**
     * Get the list node which is at the 'head' of the list
     * 
     * @return A reference to a ListNode object which represents the node at the
     *         head of the list (or null if the list is empty, i.e. no 'head' has
     *         been set yet).    
     */
    public ListNode getHead()
    {
        return head;
    }

    /**
     * Set the 'head' of the list to the given node
     * 
     * @param  newHead A reference to a ListNode object which will be
     *                 the head of the list. 
     *                 
     * NOTE: if a list already exists, the existing listing will be 
     * lost since the head is being assigned to something new.
     */
    public void setHead(ListNode newHead)
    {
        head = newHead;
    }
    
    /**
     * Returns true if the list is empty
     * @return true if list is empty
     */
    public boolean isListEmpty()
    {
    	return (head == null);
    }


    /**
     * Add a new node to the start of the list which will contain
     * the data provided (a number).

     * @param number - the number read from user's input
     */
    public void addToList(String itemName, int itemValue)
    {
        ListNode newNode = new ListNode(itemName, itemValue);
        
        newNode.setNext(head);
        head = newNode;
    }
    
    
    /**
     * Print the list, starting at head
     */
     public void printList()
     {
        ListNode marker = head;

        if (isListEmpty())
        {
        	System.out.println("The list is empty.");  
        	return;
        }
 
        while (marker != null)
        {
        	System.out.println(marker.getItemName() + marker.getItemValue());  
	        marker=marker.getNext();
        }
    }

    /**
     * Deletes a node which is at the start of the list
     * and returns it
     * 
     * @return deleted element
     */
    public ListNode deleteFromStart()
    {
    	ListNode marker = head;
    	
    	if(isListEmpty())
    	{
    		return null;
    	}
    	else
    	{
    		head = marker.getNext();
    		return marker;
    	}

    }
    
    /**
     * Calculates the total number of nodes on the list
     * @return number of nodes contained in the list
     */
    public int calculateNodesOnList()
    {
        int sum = 0;
        for (ListNode n = head; n != null; n = n.getNext()) {
            sum++;
        }
        return sum;
    }

    
}
