/**
 * Stack class that contains a list.
 * 
 * @author Gerda Ugne Pupelyte
 * @version 1.0
 */
public class Stack {

	private List myList;
	
	public Stack() {
		// TODO Auto-generated constructor stub
		myList = new List();
	}
	
	
	/**
	 * Checks if the stack is empty
	 * @return true if empty, false if not
	 */
	public boolean isStackEmpty()
	{
		return myList.isListEmpty();
	}
	
	/**
	 * Adds an element onto the top of the stack
	 * @param number - number that is pushed on the stack
	 * 
	 */
	public void push(String itemName, int itemValue)
	{
		myList.addToList(itemName, itemValue);
	}
	
	/**
	 * Removes an element from the top of the stack and returns it
	 * @return popped element
	 * @throws EmptyStackException - an empty stack exception if an empty list is popped
	 */
	public String pop() throws EmptyStackException
	{
			ListNode poppedNode;
			
			poppedNode = myList.deleteFromStart();
			
			if(poppedNode == null)
			{
				throw new EmptyStackException();
			}
			
			return poppedNode.getData();
						
	}
	
	/**
	 * Prints the contents of stack
	 */
	
	public void printStack()
	{	

        myList.printList();
	
	}
	
	/**
	 * Calculates total elements currently held in stack.
	 * @return amount of elements in stack
	 */
	
	public int calculateStackElements()
	{
		return myList.calculateNodesOnList();
	}
}
