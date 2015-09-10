import java.util.*;

public class LinkedList<T> {

	private static Node head;
	private static Node tail;
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int userChoice = -1;
		head = null;
		tail = null;
		while(true){
		
			System.out.println("1. Insert node in the beginning ");
			System.out.println("2. Insert node at the end ");
			System.out.println("3. View list");
			System.out.println("4. View head");
			System.out.println("5. View tail");
			System.out.println("6. Search");
			System.out.println("7. Exit Program");
			System.out.print("Enter your choice (number) : ");
			userChoice = in.nextInt();
			System.out.println("");
			switch(userChoice){
				case 1 :
						System.out.print("Enter the data : ");
						addNodeBeginning(in.nextInt());
						break;
				case 2 :
						System.out.print("Enter the data : ");
						addNodeEnd(in.nextInt());
						break;
				case 3 :
						viewList();
						break;
				case 4 :
						System.out.println(head == null?"Head is null!":"Head --> "+head.data);
						System.out.println("");
						break;
				case 5 :
						System.out.println(tail == null?"Tail is null!":"Tail --> "+tail.data);
						System.out.println("");
						break;
				case 6 :
						System.out.print("Enter the item to search : ");
						int x = in.nextInt();
						int searchIndex = search(x);
						System.out.println((searchIndex < 0) ? x + " not found in the List!":x+" found at index "+searchIndex);
						System.out.println("");						
						break;
				case 7 :
						System.exit(0);
				default :
						System.out.println("Please enter a valid option!");
			}
			try{
				Runtime.getRuntime().exec("clear");
			} catch(Exception e){
				System.err.println("Clear not working");
			};
		}
	}
	
	public static void addNodeBeginning(int data){
		Node node = new Node(data);
		if(head == null){
			head = node;
			tail = node;
		} else {
			node.next = head;
			head = node;
		}
	}
	
	public static void addNodeEnd(int data){
		Node node = new Node(data);
		if(head == null){
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}
	
	public static void viewList(){
		if(head == null){
			System.out.println("List is empty!");
		} else {
			Node root = head;
			while(root != null){
				System.out.print(" --> " + root.data);
				root = root.next;			
			}
		}
		System.out.println("");
		System.out.println("");
	}
	
	public static int search(int x){
		Node root = head;
		int i=0;
		while(root != null){
			if((Integer)root.data == x){
				return i;
			}
			i++;
			root = root.next;
		}
		return -1;
	}
	
	public static Node getHead(){
		return head;
	}
	
	public static class Node<T>{
		
		private T data;
		private Node next;
		
		public Node(T data){
			this.data = data;
		}
		
		public T getData(){
			return data;
		}
		
		public Node getNext(){
			return next;
		}
		
		public void setNext(Node next){
			this.next = next;
		}
		
		public void setData(T data){
			this.data = data;
		}
	}

}