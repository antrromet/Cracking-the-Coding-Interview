/**
*	Implement an algorithm to delete a node in the middle  of a singly linked list,
*	given only access to that node.
**/

public class DeleteMiddleNode {

	private static LinkedList linkedList;
	
	public static void main(String[] args){
		linkedList = new LinkedList();
		linkedList.addNodeEnd(5);
		linkedList.addNodeEnd(3);
		linkedList.addNodeEnd(4);
		linkedList.addNodeEnd(7);
		linkedList.addNodeEnd(9);
		linkedList.viewList();
		
		deleteNode(getToBeDeletedNode(Integer.valueOf(args[0])));
		System.out.println("After deletion of node "+args[0]);
		linkedList.viewList();
	}
	
	private static void deleteNode(LinkedList.Node n){
		if(n == null){
			System.out.println("Sorry, Deletion not possible, element not found");
			System.exit(0);
		} else if(n.getNext() == null){
			System.out.println("Sorry, Deletion not possible, next element is null");
			System.exit(0);
		}
		
		n.setData(n.getNext().getData());
		n.setNext(n.getNext().getNext());
	}
	
	private static LinkedList.Node getToBeDeletedNode(int n){
		LinkedList.Node head = linkedList.getHead();
		
		while(head!=null){
			if((Integer)head.getData() == n){
				return head;
			}
			head = head.getNext();
		}	
		return null;
	}
	
}