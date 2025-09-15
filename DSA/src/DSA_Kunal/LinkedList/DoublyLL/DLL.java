package DSA_Kunal.LinkedList.DoublyLL;

public class DLL {
    private Node head;
    private int size;

    public DLL() {
        this.size = 0;
    }

    //Insertion of a list from first.
    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        if (head != null){
            head.prev = node;
        }
        head = node;
        size++;
    }
    //Insert at last
    public void insertLast(int value){
        Node node = new Node(value);
        Node temp = head;

        if (head==null){
            node.prev=null;
            head=node;
            return;
        }

        while (temp.next!=null){
            temp=temp.next;
        }
        node.next=null;
        temp.next=node;
        node.prev=temp;
    }
    //Insert at index
    public void insert(int value, int index){
        if (index==0){
            insertFirst(value);
            return;
        }
        if (index==size){
            insertLast(value);
            return;
        }
        Node temp = head;
        for (int i=1; i<index; i++){
            temp = temp.next;
        }
        Node node = new Node(value);
        node.next = temp.next;
        temp.next.prev = node;
        temp.next = node;
        node.prev = temp;
    }
    //Insert after given node value
    public void insertAfter(int after, int value){
        Node p = find(after);

        if (p == null){
            System.out.println("Doesn't exist.");
        }
        Node node = new Node(value);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if (node.next !=null){
            node.next.prev = node;
        }
    }
    public Node find(int val){
        Node node = head;
        while (node != null){
            if (node.value == val ){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    //Display function
    public void display(){
        Node temp = head;
        Node last = null;//used for display list reverse.
        while (temp!=null){
            System.out.print(temp.value + " -> ");
            last=temp;
            temp=temp.next;
        }
        System.out.println("End");

        //Displaying the list in reverse.
        System.out.println("Display Reverse");
        while (last!=null){
            System.out.print(last.value + " -> ");
            last = last.prev;
        }
        System.out.println("Start");
    }
    public static class Node{
        private final int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

    }
}
