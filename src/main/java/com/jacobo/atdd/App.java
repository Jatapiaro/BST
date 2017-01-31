package com.jacobo.atdd;

import com.jacobo.tree.BST;

public class App {

    public BST<Integer> bst;

    public App(){
        bst = new BST<Integer>();
    }

    public App(int[] theNumbers){
        bst = new BST<Integer>();
        for(int i : theNumbers){
            bst.insert(i);
        }
    }

    public int distanceOfTwoNodes(int[] numbers,int a,int b){
        for(int i : numbers){
            bst.insert(i);
        }

        if(bst.containsTwoValues(a,b)){
            int distanceA = bst.distanceOfNode(a);
            int distanceB = bst.distanceOfNode(b);
            int ant = (Integer)bst.lowestCommonAntescesor(a,b);
            int distanceC = bst.distanceOfNode(ant);
            return (distanceA+distanceB)-(2*distanceC)+1;
        }else{
            return -1;
        }
    }

}
