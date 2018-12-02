/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.util.*;

/**
 *
 * @author EPS
 */
public class Implementacion1Graph implements Graph {

    Edge[][] matrizAdyaciencia;
    Vertex vertice0;

    public Implementacion1Graph(Vertex v) {
        vertice0 = v;
        matrizAdyaciencia = new Edge[1][1];
    }

    @Override
    public Vertex[] endVertices(Edge e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vertex opposite(Vertex v, Edge e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean areAdjacent(Vertex v, Vertex w) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean replace(Vertex v, Object x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean replace(Edge e, Object x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertVertex(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertEdge(Vertex v, Vertex w, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeVertex(Vertex v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeEdge(Edge e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator vertices() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator edges() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int getIndex(Vertex v) {
        Vertex aux = vertice0;
        int i = 0;
        while (aux != v) {
            aux = aux.getNext();
            i++;
        }
        return i;
    }
    
    private Vertex getVertex(int index){
    Vertex aux = vertice0;
        int i = 0;
        while (i != index) {
            aux = aux.getNext();
            i++;
        }
        return aux;
    }
}
