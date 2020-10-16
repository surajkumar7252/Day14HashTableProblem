package Day14HashTable.Day14HashTableProblem;

import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HashTable<I,M> 
{
	private static final Logger log=LogManager.getLogger(HashTable.class);
	private LinkedList<I> listOfValues;
	private final Integer numTimes;
	private ArrayList<LinkedList<I>>array;
	
	public HashTable() {
		this. numTimes=20;
		this.array=new ArrayList<LinkedList<I>>();
		for(int i=0;i<numTimes;i++) {
			this.array=null;
		}
	}
	public Integer getLength() {
		int length=0;
		for(LinkedList<I> listOfValues:array) {
			if(listOfValues!=null) {
				length=length+listOfValues.size();
			}
		}return length;
	}
	public boolean isEmpty() {
		return getLength()==0;
	}
	public M get(I key) {
		Integer indexOfValue=findIndex(key);
		LinkedList<I> listOfValues=array.get(indexOfValue);
		if(listOfValues==null)
			return null;
		MapNode<I, M> nodeInMap=(MapNode<I, M>) listOfValues.searchingNode(key);
		return (nodeInMap==null)?null:nodeInMap.getValue();
	}
	public Integer findIndex(I key) {
		Integer hashKey=Math.abs(key.hashCode());
		Integer indexOfValue=hashKey% numTimes;
		return indexOfValue;
		
	}
	
	
	public void addToList(I key, M value) {
		Integer indexOfValue=findIndex(key);
		LinkedList<I>listOfValues=array.get(indexOfValue);
		if(listOfValues==null) {
			listOfValues = new LinkedList<I>();
			array.set(indexOfValue, listOfValues);
		}
		MapNode<I, M> nodeInMap=(MapNode<I, M>) (listOfValues.searchingNode(key));
		if(nodeInMap==null) {
			listOfValues.addToList(new MapNode<I, M>(key,value));
		}else {
			nodeInMap.setValue(value);
		}
	}
	public void deletingValue(I key) {
		Integer indexOfValue=findIndex(key);
		LinkedList<I>listOfValues=array.get(indexOfValue);
		if(listOfValues!=null) {
		   listOfValues.deletingValue(key);
		}	
	}
    public static void main( String[] args )
    {
    	HashTable<String, Integer> hashTable= new HashTable<String, Integer>();
		String line="Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations.";
		for(String word: line.split(" ")) {
			if(hashTable.get(word)==null) {
				hashTable.addToList(word, 1);
			}else {
				hashTable.addToList(word, hashTable.get(word)+1);;
			}
		}
		log.debug(hashTable); 
		hashTable.deletingValue("avoidable");
		log.debug("\nhashTable");
		}
}
