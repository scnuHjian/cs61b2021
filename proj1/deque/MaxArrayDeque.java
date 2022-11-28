package deque;


import java.util.Comparator;

public class MaxArrayDeque<T> implements Deque<T>{
    private Comparator<T> comparator;
    private ArrayDeque<T> arrayDeque;
    public MaxArrayDeque(Comparator<T> comparator) {
        this.comparator = comparator;
        arrayDeque = new ArrayDeque<>();
    }
    public T max(){
        if(arrayDeque.isEmpty()){
            return null;
        }
        T max = arrayDeque.get(0);
        for (int i = 0; i < arrayDeque.size(); i++) {
            int compare = comparator.compare(max, arrayDeque.get(i));
            if (compare < 0){
                max = arrayDeque.get(i);
            }
        }
        return max;
    }

    public T max(Comparator<T> c){
        if(arrayDeque.isEmpty()){
            return null;
        }
        T max = arrayDeque.get(0);
        for (int i = 0; i < arrayDeque.size(); i++) {
            int compare = c.compare(max, arrayDeque.get(i));
            if (compare < 0){
                max = arrayDeque.get(i);
            }
        }
        return max;
    }

    @Override
    public void addFirst(T item) {
        arrayDeque.addFirst(item);
    }

    @Override
    public void addLast(T item) {
        arrayDeque.addLast(item);
    }

    @Override
    public boolean isEmpty() {
        return arrayDeque.isEmpty();
    }

    @Override
    public int size() {
        return arrayDeque.size();
    }

    @Override
    public void printDeque() {
        arrayDeque.printDeque();
    }

    @Override
    public T removeFirst() {
        return arrayDeque.removeFirst();
    }

    @Override
    public T removeLast() {
        return arrayDeque.removeLast();
    }

    @Override
    public T get(int index) {
        return arrayDeque.get(index);
    }
}
