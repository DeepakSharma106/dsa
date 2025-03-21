package datastructure;


class Node<T> {
    private T data;
    private Node next;

    public Node(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String toString(){
        return this.data.toString();
    }

}


class LinkedList {
    private Node head;

    public LinkedList(){
        this.head = null;
    }

    public Node insertion(Node nodeToBeInserted, int position) {
        // first entry
        if(head == null) {
            head = nodeToBeInserted;
            return head;
        }
        // if position is greater than +1 size of array
        int size = size(head);
        if(position > size + 1) {
            System.out.println("invalid position ");
            return this.head;
        }

        // perform insertion at any valid position
        // insert at the beginning
        if(position == 1) {
            nodeToBeInserted.setNext(this.head);
            this.head = nodeToBeInserted;
            return this.head;
        }

        // insert at anyother valid position
        Node current = head;
        int counter = 1;
        while(counter < position - 1) {
            counter = counter+ 1;
            current = current.getNext();
        }
        nodeToBeInserted.setNext(current.getNext());
        current.setNext(nodeToBeInserted);
        return head;
    }

    public int size(Node head) {
        int counter = 0;
        Node temp = head;
        while(temp != null) {
            counter = counter + 1;
            temp = temp.getNext();
        }

        return counter;
    }

    public Node deletion(int position) {
        int size = size(head);
        if(size <= 0) {
            System.out.println("there is nothing to delete");
            return head;
        }
        if(position > size) {
            System.out.println("invalid position for deletion");
            return head;
        }
        // go for the deletion at the first position
        if(position == 1){
            head = head.getNext();
            return head;
        }

        // delete at any other position
        Node current = head;
        int counter = 1;
        while(counter < position - 1) {
            current = current.getNext();
            counter = counter + 1;
        }
        Node toDelete = current.getNext();
        current.setNext(toDelete.getNext());
        return head;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        Node current = head;
        while(current != null) {
            sb.append(current.getData()+" --> ");
            current = current.getNext();
        }
        if(sb.length() > 5)
            sb.replace(sb.length()-5, sb.length(), "");
        return sb.toString();
    }



}

public class LinkedListTesting {
    public static void main(String[] args) {
        Node n1 = new Node(11);
        LinkedList ll = new LinkedList();
        ll.insertion(n1, 1);
        Node n2 = new Node(12);
        ll.insertion(n2, 1);
        Node n3 = new Node(13);
        ll.insertion(n3, 1);
        Node n4 = new Node(14);
        ll.insertion(n4, 1);

        Node n5 = new Node(22);
        ll.insertion(n5, 3);

        Node n6 = new Node(32);
        ll.insertion(n6, 6);

        Node n7 = new Node(42);
        ll.insertion(n7, 2);

        System.out.println(ll);

        ll.deletion(7);
        System.out.println(ll);

        ll.deletion(3);
        System.out.println(ll);

        ll.deletion(1);
        System.out.println(ll);

        ll.deletion(1);
        System.out.println(ll);
        ll.deletion(1);
        System.out.println(ll);
        ll.deletion(1);
        System.out.println(ll);

        ll.deletion(1);
        System.out.println(ll);

        ll.deletion(1);
        System.out.println(ll);

        Node n11 = new Node(121);
        ll.insertion(n11, 1);
        System.out.println(ll);

        Node n12 = new Node(122);
        ll.insertion(n12, 1);
        System.out.println(ll);

        Node n13 = new Node(123);
        ll.insertion(n13, 3);
        System.out.println(ll);

    }
}
