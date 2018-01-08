package aakgul13Project2;

public class HashTable {

	public int table_size;
	public int size=0;
	public LinkedList[] hashtable;

	public HashTable(int tablesize){
		hashtable=new LinkedList[tablesize];
		table_size=tablesize;
	}

	public int hash(String key){

		int hash = 0; 
		int p=23;
		for (int i = 0; i <key.length(); i++){
			hash = (p * hash +key.charAt(i)) % table_size;
		}
		return hash;
	}

	public int size(){
		return size;
	}

	public void put(String key,String value){
		int hash=this.hash(key);
		Node hashNode=new Node(key,value);
		if(hashtable[hash]==null){
			LinkedList hashList=new LinkedList();
			hashList.addLast(hashNode);
			hashtable[hash]=hashList;
			size++;
		}else if(this.containsKey(key)){
			hashtable[hash].changeValue(key,value);
		}else{
			hashtable[hash].addLast(hashNode);
			size++;
		}
	}

	public String remove(String key){
		String result = "";
		int hash=this.hash(key);
		if(hashtable[hash]!=null){
			while(hashtable[hash].numofNodes!=0){
				result+=hashtable[hash].removeLast()+" ";
				size--;
			}
		}
		return result;
	}

	public boolean containsKey(String key){
		int hash=this.hash(key);
		boolean result=false;
		if(hashtable[hash]==null){
			return false;
		}else{
			LinkedList keys=this.keySet();
			while(keys.isthereNext()){
				String currentKey=keys.Next();
				if(currentKey.equals(key)){
					result=true;
				}
			}
		}
		return result;
	}


	public LinkedList keySet(){
		LinkedList keyList=new LinkedList();
		for(int i=0; i<table_size; i++){
			if(hashtable[i]!=null){
				Node current=hashtable[i].head;
				while(current!=null){
					String key=current.getKey();
					current=current.getNext();
					Node newNode=new Node(key,"0");
					keyList.addLast(newNode);
				}
			}
		}
		return keyList;
	}

	public void Empty(){
		LinkedList[] newTable=new LinkedList[table_size];
		hashtable=newTable;
		size=0;
	}
}