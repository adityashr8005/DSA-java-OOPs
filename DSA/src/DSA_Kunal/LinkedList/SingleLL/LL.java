package DSA_Kunal.LinkedList.SingleLL;

public class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL(){
        this.size=0;
    }
    //Insert the value from head side.
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null){
            tail = head;
        }
        size++;
    }
    //Inserting the value at last.
    public void insertLast(int val){
        if (tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }
    //Inserting at given index.
    public void insert(int val, int index){
        if (index==0){
            insertFirst(val);
            return;
        }
        if (index==size){
            insertLast(val);
            return;
        }
        Node temp=head;
        for (int i=1; i<index; i++){
            temp=temp.next;
        }
        temp.next = new Node(val,temp.next);
        size++;
    }

    //Delete First node
    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if (head==null){
            tail=null;
        }
        size--;
        return val;
    }
    //Delete it from Last
    public int deleteLast(){
        int val = tail.value;
        tail = get(size-2);
        tail.next = null;
        size--;
        return val;
    }
    //Delete given index node
    public int delete(int index){
        if (index==0){
            return deleteFirst();
        }
        if (index==size-1){
            return deleteLast();
        }
        Node prev = get(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        return val;
    }
    private Node get(int index){
        Node temp = head;
        for (int i=0; i<index; i++){
            temp=temp.next;
        }
        return temp;
    }

    //Function to display the List.
    public void display(){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.value + " -> ");
            temp=temp.next;
        }
        System.out.println("End");
    }

    //Node class
    private static class Node{
        private final int value;
        private Node next;

        //Constructor for value;
        public Node(int value) {
            this.value = value;
        }

        //Constructor for adding node at middle indexes.
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
