package DSA_Kunal.LinkedList.Questions;

public class RemoveDuplicates {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertLast(1);
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(3);
        list.display();
        list.removeDuplicate();
        list.display();
    }

    public static class LL{
        private Node head;
        private Node tail;
        private int size;

        public LL(){
            this.size = 0;
        }

        public void insertFirst(int value){
            Node node = new Node(value);
            node.next = head;
            head = node;

            if (tail == null){
                tail = head;
            }
            size++;
        }

        public void insertLast(int value){
            if (tail==null){
                insertFirst(value);
                return;
            }
            Node node = new Node(value);
            tail.next = node;
            tail = node;
            size++;
        }

        public void removeDuplicate(){
            Node node = head;

            while (node.next!=null){
                if (node.value == node.next.value){
                    node.next = node.next.next;
                    size--;
                }else {
                    node = node.next;
                }
            }
            tail = node;
            tail.next = null;
        }

        public void display(){
            Node temp = head;
            while (temp!=null){
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }
            System.out.println("END");
        }
    }

    public static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}



