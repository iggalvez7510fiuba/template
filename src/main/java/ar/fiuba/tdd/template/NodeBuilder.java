package ar.fiuba.tdd.template;

public class NodeBuilder<T> extends AbstractNodeBuilder<T> {

    private T data;
    private Node<T> previousNode;
    private Node<T> nextNode;

    public NodeBuilder(){
        data = null;
        previousNode = null;
        nextNode = null;
    }
    public AbstractNodeBuilder<T> withData(T data){
        this.data =  data;
        return this;
    }
    public AbstractNodeBuilder<T> withPreviousNode( Node<T> previousNode){
        this.previousNode = previousNode;
        return this;
    }

    public AbstractNodeBuilder<T> withNextNode( Node<T> nextNode){
        this.nextNode = nextNode;
        return this;
    }

    public Node<T> build() {
        Node<T> node = new ConcreteNode<>(data,previousNode,nextNode);
        clear();
        return node;
    }

    private  void clear() {
        previousNode = null;
        nextNode = null;
        data = null;
    }
}

