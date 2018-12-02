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
public class Vertex {

    Object id;
    Vertex next;
    Edge edge;

    public Vertex(Object ele) {
        this.id = ele;
        this.next = null;
        this.edge = null;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Vertex getNext() {
        return next;
    }

    public void setNext(Vertex next) {
        this.next = next;
    }

    public Edge getEdge() {
        return edge;
    }

    public void setEdge(Edge edge) {
        this.edge = edge;
    }
    
    
}
