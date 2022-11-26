package deque;

public class LinkedListDeque<T> implements Deque<T>{

    private Node sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new Node(null,null,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        sentinel.next = new Node(item,sentinel,sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    @Override
    public void addLast(T item) {
        sentinel.prev = new Node(item,sentinel.prev,sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node head = sentinel.next;
        for (int i = 0; i < size; i++) {
            while(head != sentinel){
                System.out.print(head.item+" ");
                head = head.next;
            }
            System.out.println();
        }
    }

    @Override
    public T removeFirst() {
        if(isEmpty()) {
            return null;
        }
        T temp = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return temp;
    }

    @Override
    public T removeLast() {
        if(isEmpty()) {
            return null;
        }
        T temp = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return temp;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index > size){
            return null;
        }
        Node head = sentinel.next;
        for (int i = 0; i < index; i++) {
            head = head.next;
        }
        return head.item;
    }


    public boolean equals(LinkedListDeque list) {
        if(list.size() != this.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if(list.get(i) != get(i)){
                return false;
            }
        }
        return true;
    }

    public T getRecursive(int index){
        if(index < 0 || index > size){
            return null;
        }
        return getRecursive(0,index,sentinel.next);
    }

    public T getRecursive(int pos,int index,Node node){
        if(pos == index){
            return node.item;
        }
        return getRecursive(pos+1,index,node.next);
    }

    private class Node {
        T item;
        Node prev;
        Node next;

        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

}
