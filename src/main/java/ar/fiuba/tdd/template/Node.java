package ar.fiuba.tdd.template;

public interface Node<T> {

    T getData() throws  RuntimeException;

    Node<T> getNextNode();

    void setNextNode(Node<T> node);
}