class MinStack {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public MinStack() {
        //Stack<Integer> Stack = new Stack<>();
    }
    
    public void push(int value) {
        st.push(value);

        if(minStack.isEmpty() || value <=  minStack.peek()) {
            minStack.push(value);
        }
    }
    
    public void pop() {
        if(st.peek().equals(minStack.peek())){
            minStack.pop();
        }
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        //int min = stack.peek();
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */