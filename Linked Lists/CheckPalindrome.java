/**
*	Implement a function to check if a linked list is a palindrome
**/

import java.util.Stack;

public class CheckPalindrome{

	public static void main(String[] args){
		LinkedList linkedList = new LinkedList();
		linkedList.addNodeEnd(5);
		linkedList.addNodeEnd(3);
		linkedList.addNodeEnd(4);
		linkedList.addNodeEnd(3);
		linkedList.addNodeEnd(5);
		
		System.out.println("Checking palindrome");
		linkedList.viewList();

		System.out.println((checkPalindrome(linkedList.getHead())?"":"Not a ")+"Palindrome");
	}
	
	private static boolean checkPalindrome(LinkedList.Node head){
		LinkedList.Node runner = head;
		Stack<Integer> stack = new Stack<Integer>();
		while(runner!=null && runner.getNext()!=null){
			runner = runner.getNext().getNext();
			stack.push((Integer)head.getData());
			head = head.getNext();
		}
		
		if(runner != null){
			head = head.getNext();
		}
		
		while(head!=null){
			if((Integer)head.getData() != stack.pop()){
				return false;
			}
			head = head.getNext();
		}
		return true;
	}

}