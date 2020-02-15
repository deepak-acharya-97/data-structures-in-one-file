public class Solution {
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedList {
        public Node head;

        public LinkedList() {
            this.head = null;
        }

        public void add(int data) {
            if (head == null)
                head = new Node(data);
            else {
                Node temp = head;
                while (temp.next != null)
                    temp = temp.next;
                temp.next = new Node(data);
            }
        }

        public void addFront(int data) {
            if (head == null)
                head = new Node(data);
            else {
                Node newNode = new Node(data);
                newNode.next = head;
                head = newNode;
            }
        }

        public int deleteFront() {
            if (head == null)
                return -1;
            if (head.next == null) {
                int data = head.data;
                head = null;
                return data;
            }
            int data = head.data;
            head = head.next;
            return data;
        }

    }

    public static class Queue {
        public Node front;
        public Node rear;

        public Queue() {
            front = rear = null;
        }

        public void enQueue(int data) {
            Node newNode = new Node(data);
            if (rear == null) {
                front = rear = newNode;
                return;
            }
            rear.next = newNode;
            rear = newNode;
        }

        public int deQueue() {
            if (front == null)
                return -1;
            int data = front.data;
            front = front.next;
            if (front == null)
                rear = null;
            return data;
        }
    }

    public static class Graph {
        private LinkedList[] adjacencyList;
        public int vertices;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices];
            this.initialiseAdjacencyList();
        }

        private void initialiseAdjacencyList() {
            for (int i = 0; i < this.vertices; i++)
                this.adjacencyList[i] = new LinkedList();
        }

        public void addEdge(int src, int dest) {
            this.adjacencyList[src].add(dest);
            // this.adjacencyList[dest].add(src); // in case of undirected graph
        }

        public void dfs(int src) {
            boolean[] visited = new boolean[vertices];
            dfsUtil(src, visited);
        }

        private void dfsUtil(int src, boolean[] visited) {
            visited[src] = true;
            System.out.println(src);
            LinkedList adjacents = adjacencyList[src];
            Node currentNodeHead = adjacents.head;
            while (currentNodeHead != null) {
                int current = currentNodeHead.data;
                if (visited[current] == false)
                    dfsUtil(current, visited);
                currentNodeHead = currentNodeHead.next;
            }
        }

    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(2, 0);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.dfs(2);
    }
}