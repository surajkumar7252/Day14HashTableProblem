package Day14HashTable.Day14HashTableProblem;



import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

interface InterfaceNode<I>{
	I getKey();
	public void setKey(I key);
	InterfaceNode<I> getNext();
	public void setNext(InterfaceNode<I> next);
}

class MapNode<I,M> implements InterfaceNode<I>{
	public I key;
	public M value;
	public MapNode<I,M> next;
	public MapNode(I key,M value) {
		this.value=value;
		this.key = key;
		this.next = null;
	}
	public I getKey() {
		return key;
	}
	public void setKey(I key) {
		this.key = key;
	}
	public M getValue() {
		return value;
	}
	public void setValue(M value) {
		this.value = value;
	}
	
	public MapNode<I, M> getNext() {
		return next;
	}
	public void setNext(InterfaceNode<I> next) {
		this.next = (MapNode<I, M>) next;
	}
	
}

public class LinkedList<I> 
{   private static final Logger log=LogManager.getLogger(LinkedList.class);
    static Scanner inputFeed=new Scanner(System.in);
    public static Integer counter=0;
    public InterfaceNode<I> headPart=null;
    public InterfaceNode<I> tailPart=null;
  
    
    public void addToList(InterfaceNode<I> tempNode) {
    	if(this.headPart==null) {
    		this.headPart=tempNode;
    	}
    	if(this.tailPart==null) {
    		this.tailPart=tempNode;
    	}else {
    		InterfaceNode<I> temp=this.headPart;
    		this.headPart=tempNode;
    		this.headPart.setNext(temp);
    	}
    	
    }
    public void printingList() {
		InterfaceNode<I> tempNode=this.headPart;
		
		if(tempNode!=null) {
			log.debug("This is the Linked List : ");
			do {
				System.out.print(tempNode.getKey()+"->");
			}while((tempNode=tempNode.getNext())!=null);
			
			
		}
		
	}
    public void appendingToList(InterfaceNode<I> tempNode) {
		if (this.headPart == null) {
			this.headPart = tempNode;
		}
		if (this.tailPart == null) {
			this.tailPart = tempNode;
		} else {
			this.tailPart.setNext(tempNode);
			this.tailPart = this.tailPart.getNext();
		}
		
	}
    public void insertionInBetween(InterfaceNode<I> node1, InterfaceNode<I> node2) {
    	InterfaceNode<I> tempNode=node1.getNext();
		node1.setNext(node2);
		node1.getNext().setNext(tempNode);
		
	}
    public InterfaceNode<I> pop() {
    	InterfaceNode<I> tempNode = this.headPart;
		this.headPart = this.headPart.getNext();
		return tempNode;
	}
    public InterfaceNode<I> popLast() {
    	InterfaceNode<I> tempNode = this.headPart;
	    while(!tempNode.getNext().equals(this.tailPart)) 
		tempNode = tempNode.getNext();
	    this.tailPart = tempNode;
	    tempNode = tempNode.getNext();
	    this.tailPart.setNext(null);
	    return tempNode;
	}
    
    public InterfaceNode searchingNode(I valueToBeSearched) {
    	InterfaceNode<I> tempNode=this.headPart;
		while(tempNode!=null) {
			if(tempNode.getKey().equals(valueToBeSearched)) 
				return tempNode;
			tempNode=tempNode.getNext();
		}
		return null;
	}
    

    public InterfaceNode<I> deletingValue(I valueToBeDeleted) {
    	
    	InterfaceNode<I> temp = null;
    	InterfaceNode<I> presentNode =this.headPart, previousNode = null; 
		if (presentNode != null && presentNode.getKey() == valueToBeDeleted) { 
			this.headPart = presentNode.getNext();
			counter++;
			temp = presentNode;
		} 
		while (presentNode != null && presentNode.getKey() != valueToBeDeleted) { 
			previousNode = presentNode; 
			presentNode = presentNode.getNext(); 
			
		}  
		if (presentNode != null) { 
			previousNode.setNext(presentNode.getNext());  
			temp = presentNode;
		} 
		return temp;
	} 
    
  
    
}
