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

    private Object element;
    private Edge next;
    private Vertex vertex;

    public Vertex getVertex() {
        return vertex;
    }

    public void setVertex(Vertex vertex) {
        this.vertex = vertex;
    }

    public Edge(Object ele) {
        this.element = ele;
        this.next = null;
    }

    public Edge(Object ele, Edge n) {
        this.element = ele;
        this.next = n;  
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Edge getNext() {
        return next;
    }

    public void setNext(Edge next) {
        this.next = next;
    }
}
