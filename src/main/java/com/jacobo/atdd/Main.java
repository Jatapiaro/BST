package com.jacobo.atdd;

import com.jacobo.tree.BST;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.JOptionPane;

/**
 * Created by jacobotapia on 30/01/17.
 */
public class Main {
    public static void main(String[] args){

        BST<Integer> tree = new BST<Integer>();
        int[] theNumbers = {5,6,3,1,2,4};

        for(int i : theNumbers){
            tree.insert(i);
        }

        int exit = -1;
        int option = -1;

        while(exit != 2){
            option = Integer.parseInt(JOptionPane.showInputDialog("1.Obtener distancia\n2.Salir"));
            if(option == 1){
                String[] values = JOptionPane.showInputDialog(
                        "Ingresa ambos números separados por una ',' ejemplo -> 1,5").split(",");
                int a = Integer.parseInt(values[0]);
                int b = Integer.parseInt(values[1]);
                int r = distanceOfTwoNodes(a,b,tree);
                JOptionPane.showMessageDialog(null,"Resultado: "+r);
            }else if(option == 2){
                break;
            }
        }

    }

    public static int distanceOfTwoNodes(int a,int b,BST<Integer> tree){
        if(tree.containsTwoValues(a,b)){
            int distanceA = tree.distanceOfNode(a);
            int distanceB = tree.distanceOfNode(b);
            int ant = (Integer)tree.lowestCommonAntescesor(a,b);
            int distanceC = tree.distanceOfNode(ant);
            return (distanceA+distanceB)-(2*distanceC)+1;
        }else{
            return -1;
        }
    }
}
