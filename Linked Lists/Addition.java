/**
*	You have two numbers represented by a linked list, where each node contains a single
*	digit. The digits are stored in reverse order. such that the 1's digit is at the head
*	of the list. Write a function that adds the two numbers and returns the sum as a
*	linked list.
*
*	FOLLOW UP
*	Suppose the digits are stored in forward order. Repeat the above problem.
**/

public class Addition {

	public static void main(String[] args){
		JustLinkedList num1 = new JustLinkedList();
		num1.add(6);
		num1.add(1);
		System.out.println("Number 1 : ");
		num1.view();
		
		JustLinkedList num2 = new JustLinkedList();
		num2.add(2);
		num2.add(9);
		num2.add(5);
		System.out.println("Number 2 : ");
		num2.view();
		
		System.out.println("Head 1 = "+num1.getHead().getData());
		System.out.println("Head 2 = "+num2.getHead().getData());
		
		JustLinkedList sumList = new JustLinkedList();
		JustLinkedList addedLinkedList = add(num1.getHead(), num2.getHead(), 0, sumList);
		addedLinkedList.view();
	}
	
	private static JustLinkedList add(Node node1, Node node2, int carry, JustLinkedList sumList){
		if(node1 == null && node2==null){
			if(carry > 0){
				sumList.add(carry);
			}
			return sumList;
		}
		int value = 0;
		if(node1!=null){
			value += (Integer)node1.getData();
			System.out.println(node1.getData());
		}
		
		if(node2!=null){
			value += (Integer)node2.getData();
			System.out.println(node2.getData());
		}
		
		value+=carry;
		sumList.add(value%10);
		return add(node1==null?null:node1.getNext(),node2==null?null:node2.getNext(),value/10, sumList);
	}

}