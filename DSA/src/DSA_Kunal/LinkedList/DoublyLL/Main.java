package DSA_Kunal.LinkedList.DoublyLL;

public class Main {
    public static void main(String[] args) {
        DLL list = new DLL();

        list.insertFirst(1);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(4);
        list.insertLast(0);
        list.insert(99,2);
        list.insertAfter(99,100);
        list.display();
    }
}
