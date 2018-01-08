package aakgul13Project2;

public class LinkedList {

	public Node head=null;
	public Node tail=null;
	public int numofNodes=0;

	public LinkedList(){
	}

	public int size(){
		return numofNodes;
	}

	public void changeValue(String key, String value){
		Node currentNode=head;
		String currentKey=head.getKey();
		while(!currentKey.equalsIgnoreCase(key)){
			currentNode=head.getNext();
			currentKey=currentNode.getKey();
		}
		currentNode.setValue(value);
	}

	public void addLast(Node newNode){
		if (head==null){
			head=newNode;
			tail=newNode;
		}else{
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail=newNode;
		}
		numofNodes++;
	}

	public String removeLast(){
		String value=tail.getValue();
		String key=tail.getKey();
		if(head.getNext()==null){
			head=null;
			tail=null;
		}else if(tail.getPrev()==head){
			head.setNext(null);
			tail=head;
		}else{
			tail.getPrev().setNext(null);
			tail=tail.getPrev();
		}
		numofNodes--;
		return key+" "+value;
	}

	public String remove(Node oldNode){
		if(numofNodes==0){
			return null;
		}else{
			if(oldNode.getNext()!=null){
				oldNode.getNext().setPrev(oldNode.getPrev());
			}
			if(oldNode.getPrev()!=null){
				oldNode.getPrev().setNext(oldNode.getNext());
			}
			oldNode.setNext(null);
			oldNode.setPrev(null);
			numofNodes--;
			return oldNode.getKey();
		}
	}
	
	public String removeFirst(){
		String key=head.getKey();
		if(head.getNext()==null){
			head=null;
			tail=null;
		}else if(head.getNext()==tail){
			tail.setPrev(null);
			head=tail;
		}else{
			head.getNext().setPrev(null);
			head=head.getNext();
		}
		numofNodes--;
		return key;
	}
	
	public String Next(){
		return removeFirst();
	}

	public boolean isthereNext(){
		if(head.getNext()==null){
			return false;
		}else{
			return true;
		}
	}

}

