/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

/**
 *
 * @author EPS
 */
public class Edge {

    Object element;
    Edge next;

    public Edge(Object ele) {
        this.element = ele;
        this.next = null;
    }

    public Edge(Object ele, Edge n) {
        this.element = ele;
        this.next = n;
    }
}
