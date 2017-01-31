package com.jacobo.tree;

/**
 * Created by jacobotapia on 30/01/17.
 */
public class Node<T extends Comparable<T>> {

    private T data;
    private Node left;
    private Node right;

    public Node(T data){
        this.data = data;
        this.left = this.right = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString(){
        return "{Value: "+this.data+"[Left: "+this.left+"],[Right: "+this.right+"]}";
    }
}
