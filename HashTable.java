package Day14HashTable.Day14HashTableProblem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HashTable<I,M> 
{
	private static final Logger log=LogManager.getLogger(HashTable.class);
	private LinkedList<I> listOfValues;
	
	public HashTable() {
		listOfValues=new LinkedList<I>();
	}
	public M get(I key) {
		MapNode<I, M> nodeInMap=(MapNode<I, M>) listOfValues.searchingNode(key);
		return (nodeInMap==null)?null:nodeInMap.getValue();
	}
	
	public void addToList(I key, M value) {
		MapNode<I, M> nodeInMap=(MapNode<I, M>) (listOfValues.searchingNode(key));
		if(nodeInMap==null) {
			listOfValues.addToList(new MapNode<I, M>(key,value));
		}else {
			nodeInMap.setValue(value);
		}
	}
    public static void main( String[] args )
    {
    	HashTable<String, Integer> hashTable= new HashTable<String, Integer>();
		String line="to be or not to be";
		for(String word: line.split(" ")) {
			if(hashTable.get(word)==null) {
				hashTable.addToList(word, 1);
			}else {
				hashTable.addToList(word, hashTable.get(word)+1);;
			}
		}
		log.debug(hashTable);    }
}
