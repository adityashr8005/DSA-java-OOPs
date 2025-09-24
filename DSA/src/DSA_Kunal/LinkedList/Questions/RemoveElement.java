package DSA_Kunal.LinkedList.Questions;

public class RemoveElement {
    public static void main(String[] args) {
        RemoveDuplicates.LL list = new RemoveDuplicates.LL();
        list.insertLast(2);
        list.insertLast(2);
        list.insertLast(2);
//        list.insertLast(3);
//        list.insertLast(2);
//        list.insertLast(2);
        list.display();
        list.removeElem(2);
        list.display();
    }

    public static class LL {
        private RemoveDuplicates.Node head;
        private RemoveDuplicates.Node tail;
        private int size;

        public LL() {
            this.size = 0;
        }

        public void insertFirst(int value) {
            RemoveDuplicates.Node node = new RemoveDuplicates.Node(value);
            node.next = head;
            head = node;

            if (tail == null) {
                tail = head;
            }
            size++;
        }

        public void insertLast(int value) {
            if (tail == null) {
                insertFirst(value);
                return;
            }
            RemoveDuplicates.Node node = new RemoveDuplicates.Node(value);
            tail.next = node;
            tail = node;
            size++;
        }

        public void removeElem(int val){
            RemoveDuplicates.Node node = head;

            while (node.next.value == val){
                node = node.next;
            }
            if (node.next.next != null){
                node.next = node.next.next;
            }else {
                node.next = null;
            }

        }

        public void display(){
            RemoveDuplicates.Node temp = head;
            while (temp!=null){
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }
            System.out.println("END");
        }

        public static class Node {
            int value;
            RemoveDuplicates.Node next;

            public Node(int value) {
                this.value = value;
            }

            public Node(int value, RemoveDuplicates.Node next) {
                this.value = value;
                this.next = next;
            }
        }
    }
}
