package com.jacobo.atdd;

import org.junit.Test;
import static org.junit.Assert.assertEquals;



/**
 * Unit test for simple App.
 */
public class AppTest{

    /**
     * Primero verificamos se debe crear un método
     * para insertar.
     * Para ello, insertamos varios elementos y probamos
     * que al seguir cierto camino, un elemento este ahí.
     */
    @Test
    public void insertionCorrect(){
        int[] n = {5,6,3,1,2,4};
        App app = new App(n);
        assertEquals(
                "Mala inserción de datos",
                5,
                app.bst.getRoot().getData());
        assertEquals(
                "Mala inserción de datos",
                6,
                app.bst.getRoot().getRight().getData());
        assertEquals(
                "Mala inserción de datos",
                3,
                app.bst.getRoot().getLeft().getData());
        assertEquals(
                "Mala inserción de datos",
                1,
                app.bst.getRoot().getLeft().getLeft().getData());
    }

    /**
     * Creamos un método que verifique que
     * un elemento este en el árbol
     * pues de esto depende de que se pueda encontrar
     * la distancia entre dos nodos.
     */
    @Test
    public void containsElement(){
        int[] n = {5,6,3,1,2,4};
        App app = new App(n);
        assertEquals(
                "Verifica la busqueda",
                true,
                app.bst.contains(1));
        assertEquals(
                "Verifica la busqueda",
                false,
                app.bst.contains(100));
    }

    /**
     * Creamos un método que busque el común antescesor de
     * dos nodos, esto con el fin de conseguir calcular la
     * distancia
     */
    @Test
    public void correctAntescesor(){
        int[] n = {5,6,3,1,2,4};
        App app = new App(n);
        assertEquals(
                "Verifica el algoritmo",
                5,
                app.bst.lowestCommonAntescesor(1,6));
        assertEquals(
                "Verifica el algoritmo",
                3,
                app.bst.lowestCommonAntescesor(1,4));
    }


    /**
     * Método para verificar si se estan calculando
     * bien las distancias entre un nodo y el root
     */
    @Test
    public void correctDistanceRootNode(){
        int[] n = {5,6,3,1,2,4};
        App app = new App(n);
        assertEquals(
                "Verifica el algoritmo",
                0,
                app.bst.distanceOfNode(5));
        assertEquals(
                "Verifica el algoritmo",
                2,
                app.bst.distanceOfNode(1));
    }

    /**
     * Método para verificar si se estan calculando
     * bien las distancias entre dos nodos
     * ATDD, el usuario pide que se cuente el nodo inicial
     * como 1!
     */
    @Test
    public void correctDistanceOfTwoNodes(){
        int[] n = {5,6,3,1,2,4};
        App app = new App();
        assertEquals(
                "Verifica el algoritmo",
                3,
                app.distanceOfTwoNodes(n,1,4));
        assertEquals(
                "Verifica el algoritmo",
                -1,
                app.distanceOfTwoNodes(n,1,100));
    }


}
