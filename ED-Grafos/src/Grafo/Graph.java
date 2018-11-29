/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.util.Iterator;

/**
 *
 * @author EPS
 */
public interface Graph {

    Vertex[] endVertices(Edge e);

    Edge opposite(Vertex v, Edge e);

    boolean areAdjacent(Vertex v, Vertex w);

    boolean replace(Vertex v, Object x);

    boolean replace(Edge e, Object x);

    boolean insertVertex(Object o);

    boolean insertEdge(Vertex v, Vertex w, Object o);

    boolean removeVertex(Vertex v);

    boolean removeEdge(Edge e);

    Iterator vertices();

    Iterator edges();
}
