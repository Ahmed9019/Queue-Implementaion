import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface IQueue {
    /*** Inserts an item at the queue front.*/
    public void enqueue(Object item);
    /*** Removes the object at the queue rear and returnsit.*/
    public Object dequeue();
    /*** Tests if this queue is empty.*/
    public boolean isEmpty();
    /*** Returns the number of elements in the queue*/
    public int size();
}

public class ArrayQueue implements IQueue {

    public Object[] Q = new Object[10000];
    public int f = 0, r = 0;

    public void enqueue(Object item) {
        Q[r] = item;
        r++;
    }

    public Object dequeue() {
        if (isEmpty()) {
            return "Error";
        }
        Object e = Q[f];
        f++;
        return e;
    }

    public boolean isEmpty() {
        return (r == f);
    }

    public int size() {
        return (r - f);
    }

    public void display() {

        System.out.print("[");
        for (int i = r - 1; i >= f; i--) {
            if (i == f) {
                System.out.print(Q[i]);
            } else {
                System.out.print(Q[i] + ", ");
            }

        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] arrIn = in.split(", ");
        ArrayQueue list = new ArrayQueue();
        for (int i = arrIn.length - 1; i >= 0 && !(arrIn[arrIn.length - 1].equals("")); i--) {
            list.enqueue(Integer.parseInt(arrIn[i]));
        }

        String command = sc.nextLine();

        if (command.equals("enqueue")) {
            int element = sc.nextInt();
            list.enqueue(element);
            list.display();
        } else if (command.equals("dequeue")) {
            if (list.dequeue() == "Error") {
                System.out.println("Error");
            } else {
                list.display();
            }

        } else if (command.equals("isEmpty")) {
            if (list.isEmpty()) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        } else if (command.equals("size")) {
            System.out.println(list.size());
        } else {
            System.out.println("Error");
        }
    }

}