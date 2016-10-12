import java.lang.reflect.Array;
import java.util.ArrayList;

// Implements the Map ADT using a hash table with separate chaining.
public class HashMap<KeyType, ValueType> {
   private class Node {
      public KeyType mKey;
      public ValueType mValue;
      public Node mNext;
   }
   private Node[] mTable;
   private int mCount;
   
   // Constructs a hashtable with the given size.
   public HashMap(int tableSize) {
      mTable = (Node[])Array.newInstance(Node.class, tableSize); 
      // mTable's entries are all null initially.
   }
   
   // Inserts the given key and value into the table, assuming no entry with 
   // an equal key is present. If such an entry is present, override the entry's
   // value.
   public void insert(KeyType key, ValueType value) {
	   int index = Math.abs(key.hashCode()% mTable.length);
	   Node newNode = new Node();
	   newNode.mKey=key;
	   newNode.mValue=value;
	   
	   Node cNode = mTable[index];
	   
	   if(mTable[index]==null){
		   mTable[index]=newNode;
		   mCount++;
		   return;
	   }
	   while(cNode!=null){
		   if(cNode.mKey.equals(key)){
			   cNode.mValue = value;
			   return;
		   }
		   if(cNode.mNext==null){
			   break;
		   }
		   cNode = cNode.mNext;
	   }
	   cNode.mNext = newNode;
	   mCount++;
	   return;
   }

   // Returns the value associated with the given key, if it is present.
   // Returns null if the value is not present.
   public ValueType find(KeyType key) {
	   int index = Math.abs(key.hashCode()% mTable.length);
	   Node cNode = mTable[index];

	   while(cNode!=null){
		   if(cNode.mKey.equals(key)){
			   return cNode.mValue;
		   }
		   cNode = cNode.mNext;
	   }
	   return null;
	   
   }
   
   // Removes the pair with the given key from the table.
   public void remove(KeyType key) {
	   int index = Math.abs(key.hashCode()% mTable.length);
	   
	   if(mTable[index].mKey.equals(key)){
		   mTable[index]= mTable[index].mNext;
	   }
	   
	   Node pNode = mTable[index]; //previousNode
	   Node cNode = mTable[index];
	   if(pNode!=null && pNode.mNext!=null){
		   cNode = mTable[index].mNext; //currentnode
	   }   
	   while (cNode!=null){
		   if(cNode.mKey.equals(key)){
			   pNode.mNext = cNode.mNext;
			   mCount--;
		   }
		   else{
			   pNode = pNode.mNext;
			   cNode = cNode.mNext;
		   }
	   }  
	   return;
   }
   
   //checks if a certain key is in the table
   public boolean containsKey(KeyType key){
	   if(find(key)!=null){
		   return true;
	   }
	   return false;
   }
   //returns the current number of elements in the hash map
   public int count(){
	   return mCount;
   }
   //Returns a list with all the keys of the hash map
   public ArrayList<KeyType> keySet(){
	   ArrayList<KeyType> set = new ArrayList<KeyType>();
	   for(int i=0;i<mTable.length;i++){
		   Node cNode = mTable[i];
		   while(cNode!=null){
			   set.add(cNode.mKey);
			   cNode = cNode.mNext;
		   }
	   }
	   return set;
   }
}