package com.game.towerofhanoi;

public class LinkedStack<T> {

    private Node<T> head, tail;

    private int numNodes = 0;

    public void push(T data){
        Node<T> node = new Node<T>(data);
        if(head == null){
            head = node;
        }else{
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail = node;
        numNodes++;
    }

    public T pop(){
        if (head == null){
            return (T) "Stack is Empty";
        }

        T POPPED_OBJECT = tail.getData();

        if (tail == head){
            head.setNext(null);
            head = null;
        }else {
            tail = tail.getPrevious();
            tail.setNext(null);
        }
        numNodes--;
        return POPPED_OBJECT;
    }

    public T peek(){
        if (head == null){
            return (T) "Stack is Empty";
        }

        return tail.getData();

    }

    public int length(){
        return numNodes;
    }

    public boolean isEmpty(){
        return head == null;
    }

    @Override
    public String toString(){
        if (head == null){
            return "[]";
        }

        String STACK_STRING = "";

        Node<T> current = head;

        while (current != null){

            if (current == head){
                STACK_STRING = current.data.toString() + STACK_STRING;
            }else {
                STACK_STRING = current.data.toString() + ", " + STACK_STRING;
            }

            current = current.getNext();

        }
        return "[" + STACK_STRING + "]";
    }


    private static class Node<T>{
        private T data;
        private Node<T> next;
        private Node<T> previous;

        private Node(T d) {
            data = d;
        }
        private T getData() {
            return data;
        }
        private void setData(T d) {
            this.data = d;
        }
        private Node<T> getNext() {
            return next;
        }
        private Node<T> getPrevious() {
            return previous;
        }
        private void setNext(Node<T> n) {
            this.next = n;
        }
        private void setPrevious(Node<T> p) {
            this.previous = p;
        }

    }
}
