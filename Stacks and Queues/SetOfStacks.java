import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SetOfStacks {

	private int threshhold;
	private List<Stack> stackSet;
	private int totalElements;

	public SetOfStacks(int threshhold){
		this.threshhold = threshhold;
		stackSet = new ArrayList<Stack>();
		totalElements = 0;
	}

	public static void main(String[] args){
		
	}
	
	public void push(int value){
		if(totalElements%threshhold == 0){
			Stack stack = new Stack<Integer>();
			stackSet.add(stack);
		}
		stackSet.get(stackSet.size() - 1).push(value);
		totalElements++;
	}
	
	public int pop(){
		if(totalElements == 0){
			System.out.println("Underflow!!!");
			System.exit(0);
		}
		totalElements--;
		int value = (int)stackSet.get(stackSet.size() - 1).pop();
		if(totalElements%threshhold == 0){
			stackSet.remove(stackSet.size()-1);
		}
		return value;
	}
	
	public int popAt(int stackIndex){
		
	}

}