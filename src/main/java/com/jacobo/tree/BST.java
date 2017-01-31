package com.jacobo.tree;

/**
 * Created by jacobotapia on 30/01/17.
 */
public class BST<T extends Comparable<T>> {

    private Node<T> root;

    public BST(){
        root = null;
    }

    public void insert(T data){
        addNode(this.root,data);
    }

    private Node<T> addNode(Node n,T data){
        if(n == null){
            n = new Node<T>(data);
            if(this.root == null){
                this.root = n;
            }
            return n;
        }else{
            //root data less than argument
            if(n.getData().compareTo(data)>0){
                n.setLeft(addNode(n.getLeft(),data));
            }else if(n.getData().compareTo(data)<0) {
                n.setRight(addNode(n.getRight(),data));
            }
        }
        return n;
    }

    public boolean containsTwoValues(T one,T two){
        return contains(one) && contains(two);
    }

    public boolean contains(T data){
        return contains(this.root,data);
    }

    private boolean contains(Node n,T data){
        if(n == null){
            return false;
        }else{
            if(n.getData().compareTo(data)>0){
                return contains(n.getLeft(),data);
            }else if(n.getData().compareTo(data)<0){
                return contains(n.getRight(),data);
            }else{
                return true;
            }
        }
    }

    public Comparable<T> lowestCommonAntescesor(T one,T two){
        return lowestCommonAntescesor(this.root,one,two);
    }

    private Comparable<T> lowestCommonAntescesor(Node n,T one,T two){
        if(n.getData().compareTo(one)>0 && n.getData().compareTo(two)>0){
            return lowestCommonAntescesor(n.getLeft(),one,two);
        }else if(n.getData().compareTo(one)<0 && n.getData().compareTo(two)<0){
            return lowestCommonAntescesor(n.getRight(),one,two);
        }else{
            return n.getData();
        }
    }

    public int distanceOfNode(int value){
        return distanceOfNode(this.root,value,0);
    }

    private int distanceOfNode(Node n, int value,int distance){
        if(n.getData().compareTo(value)>0){
            return distanceOfNode(n.getLeft(),value,++distance);
        }else if(n.getData().compareTo(value)<0){
            return distanceOfNode(n.getRight(),value,++distance);
        }else{
            return distance;
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
