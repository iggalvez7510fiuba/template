package ar.fiuba.tdd.template;
import org.junit.Test;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class ConcreteQueueTest {
    private static int EMPTY = 0;
    private static String MESSAGE = "the queue is empty";
    private static String EXCEPTION_NON_THROWN = "removing from an empty queue should throw AssertionError";
    @Test
    public void  testCreateAnEmptyQueueSizeMustBeZero() {
        ConcreteQueue<Integer> queue = new ConcreteQueue<>();
        assertEquals(EMPTY,queue.size());
    }

    @Test
    public void testRemovingFromAnEmptyQueueShouldThrowAssertionError() {
        ConcreteQueue<Integer> queue = new ConcreteQueue<>();
        try {
            queue.remove();
            fail(EXCEPTION_NON_THROWN);
        } catch (AssertionError e) {
            assertEquals(MESSAGE,e.getMessage());
        }
    }

    @Test
    public void testCallingTopFromEmptyQueueShouldThrowAssertionError() {
        ConcreteQueue<Integer> queue = new ConcreteQueue<>();
        try {
            queue.top();
            fail(EXCEPTION_NON_THROWN);
        } catch (AssertionError e) {
            assertEquals(MESSAGE,e.getMessage());
        }
    }

    @Test
    public void testAddingAndRemovingItemsShouldModifyQueueSize() {
        ConcreteQueue<Integer> queue = new ConcreteQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        assertEquals(4,queue.size());
        assertEquals(1, queue.top().intValue());
        queue.remove();
        assertEquals(3, queue.size());
        assertEquals(2, queue.top().intValue());
        queue.remove();
        queue.remove();
        assertEquals(4,queue.top().intValue());
        assertEquals(1,queue.size());
        queue.remove();
        assertEquals(EMPTY,queue.size());
    }

    @Test
    public void testRemovingMoreElementsThanQueueSizeShouldThrowAssertionError() {
        ConcreteQueue<Integer> queue = new ConcreteQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        try {
            queue.remove();
            fail(EXCEPTION_NON_THROWN);
        } catch (AssertionError e) {
            assertEquals(MESSAGE,e.getMessage());
        }
    }


    @Test
    public void testTopAfterRemovingAllElementsShouldThrowAssertionError() {
        ConcreteQueue<Integer> queue = new ConcreteQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        try {
            queue.top();
            fail(EXCEPTION_NON_THROWN);
        } catch (AssertionError e) {
            assertEquals(MESSAGE,e.getMessage());
        }
    }
}
