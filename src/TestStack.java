public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());  // 3
        stack.print();  // 3 2 1
        System.out.println(stack.pop());  // 3
        stack.push(4);
        stack.print();  // 4 2 1
    }
}
