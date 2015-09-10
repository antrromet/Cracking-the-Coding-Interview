public class JustLinkedList<T> {

	private Node head;
	
	public void add(T data){
		Node node = new Node();
		node.setData(data);
		if(head == null){
			head = node;
		} else {
			Node runner = head;
			while(runner.getNext()!=null){
				runner = runner.getNext();
			}
			runner.setNext(node);
		}
	}
	
	public void view(){
		Node runner = head;
		while(runner!=null){
			System.out.print(" --> " + runner.getData());
			runner = runner.getNext();
		}
		System.out.println("");
	}
	
	public Node getHead(){
		return head;
	}

}