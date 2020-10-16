package Day14HashTable.Day14HashTableProblem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class HashTableTest {
	private static final Logger log = LogManager.getLogger(HashTable.class);
	@Test
	public void wordsAddedToHasmapShouldReturnItsFrequency() {
		HashTable<String, Integer> hashTable= new HashTable<String, Integer>();
		String line="to be or not to be";
		for(String string:line.split(" ")) {
			if(hashTable.get(string)==null) {
				hashTable.addToList(string, 1);
			}else {
				hashTable.addToList(string, hashTable.get(string)+1);;
			}
		}
		int frequency=hashTable.get("be");
		log.debug(hashTable);
		Assert.assertEquals(2, frequency);
	}
}