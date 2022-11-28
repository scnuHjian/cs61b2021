package deque;


import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;


public class MaxArrayDequeTest {

    @Test
    public void testMax(){
        MaxArrayDeque<Integer> maxArrayDeque = new MaxArrayDeque<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer - t1;
            }
        });
        for (int i = 0; i < 100; i++) {
            maxArrayDeque.addLast(i);
        }
        assertEquals((Integer) 0,(Integer) maxArrayDeque.max(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1 - integer;
            }
        }));
    }
}
