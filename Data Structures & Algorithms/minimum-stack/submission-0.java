class MinStack {
class Record{
    int val;
    int minVal;
    public Record(int val, int minVal){
        this.val = val;
        this.minVal = minVal;
    }
}

    Stack<Record> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        int minVal = stack.isEmpty() ? val : Math.min(val, getMin());
        stack.push(new Record(val, minVal));
    }
    
    public void pop() {
        if(!stack.isEmpty()) stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().minVal;
    }
}
