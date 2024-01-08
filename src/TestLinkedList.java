public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(7);
        list.append(5);
        list.append(9);
        System.out.println(list);  // [7, 5, 9]
        list.prepend(3);
        System.out.println(list);  // [3, 7, 5, 9]
        list.insertAt(4, 2);
        list.insertAt(1, 0);
        System.out.println(list);  // [1, 3, 7, 4, 5, 9]
        var removed = list.remove(7);
        System.out.println("Removed: " + removed);  // 7
        System.out.println(list);  // [1, 3, 4, 5, 9]
        var removed2 = list.removeAt(2);
        System.out.println("Removed: " + removed2);  // 4
        System.out.println(list);  // [1, 3, 5, 9]
        var getElement = list.get(2);
        System.out.println("Get: " + getElement);  // 5
    }
}
