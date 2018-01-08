package aakgul13Project2;

public class Node {

	String key;
	String value;
	Node next=null;
	Node prev=null;

	public Node(String nodeKey, String nodeValue){
		key=nodeKey;
		value=nodeValue;
	}

	public Node getNext(){
		return next;
	}

	public Node getPrev(){
		return prev;
	}

	public void setNext(Node sNext){
		next=sNext;
	}

	public void setPrev(Node sPrev){
		prev=sPrev;
	}
	
	public String getKey(){
		return key;
	}
	public String getValue(){
		return value;
	}
	
	public void setKey(String newkey){
		key=newkey;
	}
	
	public void setValue(String newvalue){
		value=newvalue;
	}
	
	public boolean hasNext(){
		if (next==null){
			return false;
		}else{
			return true;
		}
	}

}
