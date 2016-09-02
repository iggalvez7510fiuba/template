package ar.fiuba.tdd.template;

public class ConcreteNode<T> implements Node<T> {
	
	private T data;
	private Node<T> nextNode;
	private Node<T> previousNode;
	
	public ConcreteNode(T data, Node<T> previousNode, Node<T> nextNode){
		this.data = data;
		this.previousNode = previousNode;
		this.nextNode = nextNode;
	}
	
	public ConcreteNode(T data) {
		this(data,null,null);
	}
	
	public T getData() {
		if (data == null) {
			throw new RuntimeException("the node does no have any data");
		}
		else {
			return data;
		}
	}

	public Node<T> getNextNode(){ return nextNode;}

	public Node<T> getPreviousNode(){return previousNode;}
	
	public void setPreviousNode(Node<T> previousNode) {
		this.nextNode = previousNode;
	}
	
	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}


}