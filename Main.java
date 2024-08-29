public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyList = new DoublyLinkedList<>();

        try {
            doublyList.add(10);
            doublyList.add(20);
            doublyList.add(30);
            doublyList.add(40);
            doublyList.add(50);

            doublyList.remove(0);
            doublyList.remove(2);

            System.out.println("Elemento na posição 1: " + doublyList.get(1));
            System.out.println("Elemento na posição 2: " + doublyList.get(2)); 
            doublyList.set(2, 80);

            System.out.println("------------------------------------------------------------------------");

            System.out.println("Tamanho da lista: " + doublyList.getSize());

            System.out.println("------------------------------------------------------------------------");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Lista está cheia? " + doublyList.isFull());
        System.out.println("Lista está vazia? " + doublyList.isEmpty());

        System.out.println("------------------------------------------------------------------------");
    }
}