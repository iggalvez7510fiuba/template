package ar.fiuba.tdd.template;
import org.junit.Test;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class LinkedListTest {
    private static int EMPTY = 0;
    private static NodeBuilder<Integer> integerNodeBuilder
            = new NodeBuilder<>();



    @Test
    public void testCreateEmptyList() {
        LinkedList<Integer> list = new LinkedList<>(integerNodeBuilder);
        assertEquals(list.getSize(),EMPTY);
    }
    @Test
    public void testRemoveItemFromEmptyListThrowsRuntimeException(){
        LinkedList<Integer> list = new LinkedList<>(integerNodeBuilder);
        try {
            list.removeFront();
            fail("Runtime exception expected on empty list data removal");
        }catch (RuntimeException e){
            assertEquals("the list is empty",e.getMessage());
        }
    }

    @Test
    public void testFrontMethodFromEmptyListThrowsRuntimeException(){
        LinkedList<Integer> list = new LinkedList<>(integerNodeBuilder);
        try {
            list.front();
            fail("Runtime exception expected on empty list data removal");
        }catch (RuntimeException e){
            assertEquals("the list is empty",e.getMessage());
        }
    }

    @Test
    public void testAddingOrRemovingItemsChangeListSize() {

        LinkedList<Integer> list = new LinkedList<>(integerNodeBuilder);
        list.addData(1);
        list.addData(2);
        list.addData(3);
        list.addData(4);
        assertEquals(1,list.front().intValue());
        assertEquals(4, list.getSize());
        list.removeFront();
        assertEquals(2,list.front().intValue());
        assertEquals(3,list.getSize());
        list.removeFront();
        list.removeFront();
        list.removeFront();
        assertEquals(EMPTY,list.getSize());
    }

    @Test
    public void testRemovingFrontAfterClearingList() {
        LinkedList<Integer> list = new LinkedList<>(integerNodeBuilder);
        list.addData(1);
        list.addData(2);
        list.addData(3);
        list.removeFront();
        list.removeFront();
        list.removeFront();
        try {
            list.removeFront();
            fail("it should throw a RuntimeException when removeFront is called" +
                    "after clearing the list");
        }catch (RuntimeException e) {
            assertEquals("the list is empty",e.getMessage());
        }
    }

    @Test
    public void testCallingFrontAfterClearingList() {
        LinkedList<Integer> list = new LinkedList<>(integerNodeBuilder);
        list.addData(1);
        list.addData(2);
        list.addData(3);
        list.removeFront();
        list.removeFront();
        list.removeFront();
        try {
            list.front();
            fail("it should throw a RuntimeException when removeFront is called" +
                    "after clearing the list");
        }catch (RuntimeException e) {
            assertEquals("the list is empty",e.getMessage());
        }
    }
}
