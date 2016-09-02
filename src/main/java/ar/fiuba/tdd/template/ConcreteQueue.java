package ar.fiuba.tdd.template;

public class ConcreteQueue<T> implements Queue<T> {
    private static String EMPTY_QUEUE_ERROR_MESSAGE = "the queue is empty";
    private  static int EMPTY_QUEUE = 0;
    private LinkedList<T> list;
    private NodeBuilder<T> nodeBuilder;

    public ConcreteQueue(){
        nodeBuilder = new NodeBuilder<>();
        list = new LinkedList<>(nodeBuilder);
    }

    public boolean isEmpty(){
        return list.getSize() == EMPTY_QUEUE;
    }
    public int size() {
        return  list.getSize();
    }
    public void add(T item) {
        list.addData(item);
    }
    public T top() {
       try {
           return list.front();
       }catch (RuntimeException e){
           throw new AssertionError(EMPTY_QUEUE_ERROR_MESSAGE);
       }
    }
   public void remove() {
       try {
           list.removeFront();
       } catch (RuntimeException e) {
           throw new AssertionError(EMPTY_QUEUE_ERROR_MESSAGE);
       }
   }
}
