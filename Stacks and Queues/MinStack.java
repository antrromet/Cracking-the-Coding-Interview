/**
*	How would you design a stack which, in addition to push and pop, also has a function 
*	min which returns the minimum element? Push, pop and min should all operate in
*	O(1) time.
**/

import java.util.Stack;

public class MinStack extends Stack<Integer>{

	private Stack<Integer> minStack;
	
	public MinStack(){
		minStack = new Stack<Integer>();
	}

	public void push(int value){
		if(value <= min()){
			minStack.push(value);
		}
		super.push(value);
	}
	
	public Integer pop(){
		int value = super.pop();
		if(value == min()){
			minStack.pop();
		}
		return value;
	}
	
	public Integer min(){
		if(minStack.isEmpty()){
			return Integer.MAX_VALUE;
		} else {
			return minStack.peek();
		}
	}

}