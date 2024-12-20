public class Stack <T>{
	private LinkedList<T> list;
    public Stack() {
        list = new LinkedList<>();
    }
    public void push(T item) {
        list.add(item);  
    }
    public int size() {
        return list.size();
    }
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }
        return list.pop();
    }
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }
        T topItem = list.pop();  
        list.add(topItem);       
        return topItem;
    }
    public boolean isEmpty() {
        return list.size() == 0;
    }
    @Override
    public String toString() {
        return list.toString();
    }
}
