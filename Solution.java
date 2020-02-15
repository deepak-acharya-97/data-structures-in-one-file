public class Solution {
    public static class Node<T> {
        public T data;
        public Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedList<T> {
        public Node<T> head;

        public LinkedList() {
            this.head = null;
        }

        public void add(T data) {
            if (head == null)
                head = new Node(data);
            else {
                Node temp = head;
                while (temp.next != null)
                    temp = temp.next;
                temp.next = new Node(data);
            }
        }

        public void addFront(T data) {
            if (head == null)
                head = new Node(data);
            else {
                Node newNode = new Node(data);
                newNode.next = head;
                head = newNode;
            }
        }

        public T deleteFront() {
            if (head == null)
                return new T();
            if (head.next == null) {
                T data = head.data;
                head = null;
                return data;
            }
            T data = head.data;
            head = head.next;
            return data;
        }

    }

    public static void main(String[] args) {

    }
}