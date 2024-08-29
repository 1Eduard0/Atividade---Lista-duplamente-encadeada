public class DoublyLinkedList<T> {
    private Node base;
    private Node top;
    private int size;

    private class Node {
        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public DoublyLinkedList() {
        this.base = null;
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return false; 
    }

    public int getSize() {
        return size;
    }

    public void add(T value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            base = top = newNode;
        } else {
            top.next = newNode;
            newNode.prev = top;
            top = newNode;
        }
        size++;
        printList(); 
    }

    public T remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("Posição inválida!");
        }

        Node nodeToRemove = getNode(pos);
        T removedData = remove(nodeToRemove);
        printList(); 
        return removedData;
    }

    public T remove(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("Nó inválido!");
        }

        if (node == base && node == top) {
            base = top = null;
        } else if (node == base) {
            base = base.next;
            if (base != null) {
                base.prev = null;
            }
        } else if (node == top) {
            top = top.prev;
            if (top != null) {
                top.next = null;
            }
        } else {
            node.prev.next = node.next;
            if (node.next != null) {
                node.next.prev = node.prev;
            }
        }

        size--;
        return node.data;
    }

    public Node getNode(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("Posição inválida!");
        }

        Node currentNode = base;
        for (int i = 0; i < pos; i++) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }

    public T get(int pos) {
        Node node = getNode(pos);
        return node.data;
    }

    public void set(int pos, T value) {
        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("Posição inválida!");
        }
        Node node = getNode(pos);
        node.data = value;
        printList(); 
    }

    public void printList() {
        System.out.print("Lista atual: ");
        if (isEmpty()) {
            System.out.println("[]");
        } else {
            Node current = base;
            System.out.print("[");
            while (current != null) {
                System.out.print(current.data);
                current = current.next;
                if (current != null) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}