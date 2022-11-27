package deque;

public class ArrayDeque<T> implements Deque<T>{

    private int size;
    private int capacity;
    private T[] item;
    private int head;
    private int tail;

    public ArrayDeque() {
        this.size = 0;
        this.capacity = 8;
        this.head = 0;
        this.tail = 0;
        this.item = (T[]) new Object[capacity];
    }

    @Override
    public void addFirst(T item) {
        if(size == capacity){
            resize(capacity * 2);
        }
        head--;
        size++;
        head = (head + capacity) % capacity;
        this.item[head] = item;
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = item[head++];
            head %= capacity;
        }
        head = 0;
        tail = size;
        this.capacity = capacity;
        item = temp;
    }

    @Override
    public void addLast(T item) {
        if(size == capacity){
            resize(capacity*2);
        }
        size++;
        this.item[tail] = item;
        tail++;
        tail %= capacity;
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
        for (int i = head; i < tail; i = (i + 1) % capacity) {
            System.out.println(item[i]+" ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()){
            return null;
        }
        if (size < capacity / 4){
            resize(capacity / 2);
        }
        T res = item[head];
        size--;
        item[head++] = null;
        head %= capacity;
        return res;
    }

    @Override
    public T removeLast() {
        if (isEmpty()){
            return null;
        }
        if (size < capacity / 4){
            resize(capacity / 2);
        }
        tail--;
        size--;
        tail = (tail + capacity) % capacity;
        T res = item[tail];
        item[tail] = null;
        return res;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index > size){
            return null;
        }
        int cur = (head + index + capacity) % capacity;
        return item[cur];
    }
}
