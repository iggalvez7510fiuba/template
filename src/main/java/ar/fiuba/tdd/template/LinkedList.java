package ar.fiuba.tdd.template;

public class LinkedList<T> {
    private  static int EMPTY = 0;
	private static String EMPTY_LIST_ERROR_MESSAGE = "the list is empty";
    private Node<T> firstNode;
	private Node<T> lastNode;
    private int size;
	private AbstractNodeBuilder<T> nodeBuilder;
	public LinkedList(AbstractNodeBuilder<T> nodeBuilder) {
		this.nodeBuilder = nodeBuilder;
        firstNode = null;
        lastNode = null;
        size = EMPTY;
	}
	
	public void addData(T data) {
		if (checkNull()){
			firstNode = nodeBuilder.withData(data).build();
			lastNode = firstNode;
		}
		else {
			Node<T> node = nodeBuilder.withPreviousNode(lastNode).
					withData(data).build();
            lastNode.setNextNode(node);
			lastNode = node;
		}
        increaseSize();
	}

    private void increaseSize() {
        size++;
    }

    private  boolean checkNull(){
		// if firstNode is null lastNode is also null
		return firstNode == null;
	}
	private void checkNullAndThrow() {
		// if firstNode is null lastNode is also null
		if (firstNode == null) throw  new RuntimeException(EMPTY_LIST_ERROR_MESSAGE);
	}


    public  T front(){
        checkNullAndThrow();
        return firstNode.getData();
    }
	public  void removeFront(){
        checkNullAndThrow();
		arrangeFirstAndLast();
        decreaseSize();
	}

    private void decreaseSize() {
        size--;
    }

    private void arrangeFirstAndLast() {
		if (firstNode == lastNode) {
			firstNode = null;
			lastNode = null;
		}
		else {
			firstNode = firstNode.getNextNode();
		}
	}

    public int getSize(){
        return size;
    }
}