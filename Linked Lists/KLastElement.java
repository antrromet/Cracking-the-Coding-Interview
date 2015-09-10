/**
*	Implement an algorithm to find the kth to last element of a singly linked list.
**/

public class KLastElement {

	private static LinkedList linkedList;

	public static void main(String[] args){
		int k = Integer.valueOf(args[0]);
		linkedList = new LinkedList();
		linkedList.addNodeEnd(5);
		linkedList.addNodeEnd(3);
		linkedList.addNodeEnd(4);
		linkedList.addNodeEnd(5);
		linkedList.addNodeEnd(7);
		linkedList.addNodeEnd(8);
		linkedList.addNodeEnd(3);
		linkedList.addNodeEnd(0);
		linkedList.addNodeEnd(10);
		linkedList.addNodeEnd(25);
		linkedList.addNodeEnd(25);
		linkedList.addNodeEnd(54);
		linkedList.addNodeEnd(565);
		linkedList.addNodeEnd(57);
		linkedList.viewList();
		
		System.out.println(k +"th element from last is "+findElement(k, linkedList.getHead()));
	}
	
	private static int findElement(int k, LinkedList.Node head){
		LinkedList.Node runner = head;
		while(k!=0){
			if(runner == null){
				System.out.println("Underflow!!!");
				System.exit(0);
			}
			runner = runner.getNext();
			k--;
		}
		
		while(runner!=null){
			runner = runner.getNext();
			head = head.getNext();
		}
		return (Integer)head.getData();
	}

}