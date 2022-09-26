import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface IQueue {
    /*** Inserts an item at the queue front.*/
    public void enqueue(Object item);
    /*** Removes the object at the queue rear and returns it.*/
    public Object dequeue();
    /*** Tests if this queue is empty.*/
    public boolean isEmpty();
    /*** Returns the number of elements in the queue*/
    public int size();
}

public class LinkedListQueue implements IQueue {

    doubleLinkedList dll = new doubleLinkedList();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListQueue llq = new LinkedListQueue();
        String[] in = sc.nextLine().replaceAll("\\[|\\]| ", "").split(",");
        if (in.length == 0) {
            System.out.println("Error");
            System.exit(0);
        }
        if (!in [0].equals("")) {
            for (int i = in.length - 1; i >= 0; i--) {
                if (!in [i].matches("[-0123456789]+")) {
                    System.out.println("Error");
                    System.exit(0);
                }
                if (in [i] != "") llq.enqueue(in [i]);
            }
        }
        String command = sc.nextLine();
        if (command.equals("enqueue")) {
            llq.enqueue(sc.nextInt());
            llq.printQueue();
        } else if (command.equals("dequeue")) {
            if (llq.dequeue() != null) llq.printQueue();
        } else if (command.equals("size")) System.out.println(llq.size());
        else if (command.equals("isEmpty")) {
            if (llq.isEmpty()) System.out.println("True");
            else System.out.println("False");
        } else System.out.println("Error");
        sc.close();
    }

    @Override
    public void enqueue(Object item) {
        dll.addToStart(item);
    }

    @Override
    public Object dequeue() {
        return dll.removeFromEnd();
    }

    @Override
    public boolean isEmpty() {
        return dll.isEmpty();
    }

    @Override
    public int size() {
        return dll.size();
    }

    public void printQueue() {
        dll.display();
    }

    class doubleLinkedList {
        Node head;
        Node tail;
        int size;

        public doubleLinkedList() {
            size = 0;
            head = new Node();
            tail = new Node(null, null, head);
            head.setNext(tail);
        }

        public void addToStart(Object element) {
            Node p = head.getNext();
            Node n = new Node(element, p, head);
            head.setNext(n);
            p.setPrev(n);
            size++;
        }

        public Object removeFromEnd() {
            Node n = tail.getPrev();
            if (n == head) {
                System.out.print("Error");
                return null;
            }
            Node p = n.getPrev();
            n.setNext(null);
            n.setPrev(null);
            p.setNext(tail);
            tail.setPrev(p);
            return n.getElement();
        }

        public Boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void display() {
            Node n = head;
            System.out.print("[");
            if (n.getNext() != tail) {
                n = n.getNext();
                System.out.print(n.getElement());
            }
            while (n.getNext() != tail) {
                n = n.getNext();
                System.out.print(", ");
                System.out.print(n.getElement());
            }
            System.out.print("]");
        }

        class Node {
            //instance variables
            private Object element;
            private Node next;
            private Node prev;
            //getters
            public Object getElement() {
                return element;
            }
            public Node getNext() {
                return next;
            }
            public Node getPrev() {
                return prev;
            }
            //setters
            public void setElement(Object element) {
                this.element = element;
            }
            public void setNext(Node next) {
                this.next = next;
            }
            public void setPrev(Node prev) {
                this.prev = prev;
            }

            public Node(Object element, Node next, Node prev) {
                this.element = element;
                this.next = next;
                this.prev = prev;
            }
            public Node() {
                this.element = null;
                this.next = null;
                this.prev = null;
            }
        }
    }
}