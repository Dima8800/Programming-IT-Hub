package fifth.Task0;

import fifth.BaseTask.Order.MyQuene;

import java.util.ArrayList;
import java.util.List;

public class LinkedList<T> implements MyQuene {
    private Node<T> head;
    private Node<T> tail;

    @Override
    public void putInBack(Object item) {
        Node newNode = new Node(item);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    @Override
    public Object takeOffHead() {
        if (isEmpty()) {
            return null;
        }
        Object data = head.data;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        return data;
    }

    @Override
    public int getTotalTimeToCook() {
        if (isEmpty()){
            return 0;
        }
        int sum = takeAll();
        return sum;
    }

    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private int takeAll() {
        int sum = 0;
        List<Object> elements = new ArrayList<>();

        Node current = head;
        while (current != null) {
            sum += Integer.parseInt( current.data.toString().split(" ")[1]);
            current = current.next;
        }

        return sum;
    }

    private boolean isEmpty() {
        return head == null;
    }
}

