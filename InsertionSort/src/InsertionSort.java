// ============================================================================
// CECS 328 Lab Assignment 1
// ============================================================================
// Team Members:
// Kevin Vu
// Osman Khan
// ============================================================================

// ==== DLL ==================================================================
// DoublyLinkedList that contains a node variable head and a function called
// InsertionSort
// ============================================================================
class DLL { 
    Node head; //Main 'head' node that will be used in the entire program
    DLL() //Default constructor
    {
    	head = null; //head will be initialized to null if the default
    	 			 //constructor is used
    }
    
    //InsertionSort function that will take in a parameter of a DoublyLinkedList which is called list
    void InsertionSort(DLL list)
    {
    	
    	Node key = list.head.next; //temp node which in this case is known as the "key"
    	while(key != null) //while loop that loops until it reaches null
    	{
    		
    		String name = key.data; //String variable, name, is initialized to the current key's name. This variable will act as a placeholder
    		Node temp = key.prev; // Temp node variable which will point to the key's previous node
    		while(temp != null && (temp.data.compareTo(name) > 0)) //if the temp node is not null and the temp's name is bigger than the placeholder's name then it will enter this loop
    		{
    			Node temp2 = temp.next; //temp2 will be initialized to the next node of temp
    			temp2.data = temp.data; // temp2's name will be initialized to temp's name
    			temp.data = name; //temp's name will now be initialized to the placeholder 'name'. 
    			temp = temp.prev; //temp  will continue to loop until it sorts the name in alphabetical order
    		}
    		
    		key = key.next; // key is initialized to the next node.
    	}
    }
} 

//==== Node ==================================================================
// Node class that contains a string called Data and two nodes: prev, next.
//============================================================================
class Node { 
String data; 
Node prev; 
Node next; 

Node(String d) { data = d; } 
} 

//==== InsertionSort =========================================================
// InsertionSort class that contains the main
//============================================================================
public class InsertionSort {
	public static void main(String []args) //Main function
	{
		DLL dll = new DLL(); //Creates an object of dll

		
		for(int index = 0; index < args.length; ++index) //for loop that loops until it goes through every argument that is typed in from the user
		{
			Node temp = new Node(args[index]); //stores the argument aka the string into a node
			temp.next = null; //initializes next to null
			temp.prev = null; //initializes prev to null
			
			//If there is no head, then it will enter this loop and initialize the head to the node that was just created.
			if(dll.head == null)
			{
				dll.head = temp;
			}
			//else it stores the new node to the front of the doubly linked list. It will then set temp as the new head
			else
			{
				temp.next = dll.head;
				dll.head.prev = temp;
				dll.head = temp;
			}
		}
		
		//Uses the dll object to call InsertionSort function that will take in a parameter of dll. It will then sort the names in alphabetical order
		dll.InsertionSort(dll);
		
		//A placeholder node that is initialize to the head of the doubly linked list
		Node traversal = dll.head;
		
		//Traverses through the doubly linked list until it reaches null and displays the name while it is looping.
		while(traversal != null)
		{
			System.out.print(traversal.data + " ");
			traversal = traversal.next;
		}
		
		
	}
}
