package Leet.November;

public class ReverseLinkedListII {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int data){
            this.val = data;
        }
    }

    static class LL{
       static ListNode head;

        public static void insert(int data){
            ListNode node = new ListNode(data);

            node.next = head;
            head = node;
        }

        public static void display(){
            ListNode temp = head;

            while (temp != null){
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            }
            System.out.println("END");
        }

        public static boolean isPalindrome(){
            ListNode head1 = head;
            ListNode node = findHead();
            ListNode head2 = revLL(node);

            while (head1 != null && head2 != null){
                if (head1.val == head2.val){
                    head1 = head1.next;
                    head2 = head2. next;
                }else {
                    return false;
                }
            }
            return true;
        }
        public static ListNode findHead(){
            ListNode slow = head;
            ListNode fast = head;

            while (fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow.next;
        }
        public static ListNode revLL(ListNode node){
            ListNode prev = node;
            ListNode curr = node.next;

            while (curr != null){
                ListNode nextCurr = curr.next;
                curr.next = prev;

                prev = curr;
                curr = nextCurr;
            }

            node.next = null;
            head = prev;

            return prev;
        }


        public static void reverseLL(int left, int right){
            ListNode leftNode=head;
            ListNode rightNode=head;

            int i=1;
            while (i != left){
                leftNode = leftNode.next;
                i++;
            }
            while (i != right + left-1){
                rightNode = rightNode.next;
                i++;
            }
            reverse(leftNode, rightNode);
        }
        public static void reverse(ListNode left, ListNode right){
            if (left.val == right.val){
                return;
            }
            ListNode prevLeft = null;
            if (left != head) {
                ListNode temp = head;
                while (temp.next != left){
                    temp = temp.next;
                }
                prevLeft = temp;
            }

            ListNode prev = left;
            ListNode curr = prev.next;
            ListNode temp = right.next;

            while (prev.val != right.val){
                ListNode nxt = curr.next;
                curr.next = prev;

                prev = curr;
                curr = nxt;
            }

            // Reconnect previous part
            if (prevLeft != null){
                prevLeft.next = right;
            }else {
                head = right;
            }
            left.next = temp;
        }
    }


    public static void main(String[] args) {
        LL.insert(5);
        LL.insert(4);
        LL.insert(3);
        LL.insert(2);
        LL.insert(1);
        LL.display();

//        System.out.println(LL.isPalindrome());

        LL.reverseLL(3,4);
        LL.display();
    }
}


/*
class Solution {
    ListNode head;
    public ListNode reverseBetween(ListNode head, int left, int right) {
             this.head = head;

        if (head == null || left == right) return head;

        reverseLL(left, right);
        return this.head;
    }
    public void reverseLL(int left, int right){
        ListNode leftNode = head;
        ListNode rightNode = head;

        // Find leftNode (at 'left')
        int i = 1;
        while (i < left) {
            leftNode = leftNode.next;
            i++;
        }

        // Find rightNode (at 'right')
        rightNode = leftNode;
        while (i < right) {
            rightNode = rightNode.next;
            i++;
        }
        reverse(leftNode, rightNode);
    }
    public void reverse(ListNode left, ListNode right){

        // Need prevLeft (node before left)
        ListNode prevLeft = null;
        if (left != head) {
            ListNode temp = head;
            while (temp.next != left) temp = temp.next;
            prevLeft = temp;
        }

        ListNode prev = null;
        ListNode curr = left;
        ListNode stop = right.next;

        // Reverse from left → right
        while (curr != stop) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        // Reconnect previous part
        if (prevLeft != null) {
            prevLeft.next = right;     // right is new start
        } else {
            head = right;              // update head if left == 1
        }

        // Reconnect end part
        left.next = stop;
        }
}
 */
