package ar.fiuba.tdd.template;

public abstract class AbstractNodeBuilder<T> {

    public abstract  AbstractNodeBuilder<T> withData(T data);

    public abstract AbstractNodeBuilder<T> withPreviousNode( Node<T> previousNode);

    public abstract Node<T> build();
}
