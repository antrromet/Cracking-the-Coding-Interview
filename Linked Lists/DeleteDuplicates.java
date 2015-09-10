/**
*	Write a code to remove duplicates from an unsorted linked list.
**/

import java.util.HashSet;

public class DeleteDuplicates {

	private static LinkedList linkedList;

	public static void main(String[] args){
		linkedList = new LinkedList();
		linkedList.addNodeEnd(5);
		linkedList.addNodeEnd(3);
		linkedList.addNodeEnd(4);
		linkedList.addNodeEnd(5);
		linkedList.addNodeEnd(5);
		linkedList.viewList();
		
		System.out.println("Removing duplicates");
		removeDuplicates(linkedList.getHead());
		
		System.out.println("Removing duplicates without any buffer");
		removeDuplicatesNoBuffer(linkedList.getHead());
	}
	
	private static void removeDuplicates(LinkedList.Node head){
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedList.Node prev = null;
		while(head!=null){
			if(set.contains(head.getData())){
				prev.setNext(head.getNext());
			} else {
				set.add((Integer)head.getData());
				prev = head;
			}
			head = head.getNext();
		}
		linkedList.viewList();
	}
	
	private static void removeDuplicatesNoBuffer(LinkedList.Node head){
		while(head!=null){
			LinkedList.Node runner = head;
			while(runner.getNext()!=null){
				if(runner.getNext().getData() == head.getData()){
					runner.setNext(runner.getNext().getNext());
				}else{
					runner = runner.getNext();
				}
			}
			head = head.getNext();
		}
		linkedList.viewList();
	}

}