/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author hecto
 */
public class Implementacion2Graph implements Graph {

    Vertex vertice0;

    public Implementacion2Graph(Vertex v) {
        vertice0 = v;
    }

    @Override
    public Vertex[] endVertices(Edge e) {
        Vertex[] vectorVertices = null;
        boolean enc = false;
        Vertex aux = vertice0;

        while (aux != null && !enc) {
            Edge edge = aux.getEdge();
            while (edge != null && !enc) {
                if (edge == e) {
                    vectorVertices[0] = aux;
                    vectorVertices[1] = edge.getVertex();
                    enc = true;
                }
                edge = edge.getNext();
            }
            aux = aux.getNext();
        }

        return vectorVertices;
    }

    @Override
    public Vertex opposite(Vertex v, Edge e) {
        boolean enc = false;
        Vertex aux = vertice0;
        Vertex resul = null;
        
        while (aux != null && !enc) {
            Edge edge = aux.getEdge();
            while (edge != null && !enc) {
                if (edge == e) {
                    resul = edge.getVertex();
                    enc = true;
                }
                edge = edge.getNext();
            }
            aux = aux.getNext();
        }
        return resul;
    }

    @Override
    public boolean areAdjacent(Vertex v, Vertex w) {
        boolean enc = false;
        Edge aux = v.getEdge();
        while (!enc && aux.getNext() != null) {
            if (aux.getVertex() == w) {
                enc = true;
            }
        }
        if (!enc) {
            aux = w.getEdge();
            while (!enc && aux.getNext() != null) {
                if (aux.getVertex() == v) {
                    enc = true;
                }
            }
        }

        return enc;
    }

    @Override
    public boolean replace(Vertex v, Object x) {
        boolean resul = false;
        if (v != null) {
            v.setId(x);
            resul = true;
        }
        return resul;
    }

    @Override
    public boolean replace(Edge e, Object x) {
        boolean resul = false;
        if (e != null) {
            e.setElement(x);
            resul = true;
        }
        return resul;
    }

    @Override
    public boolean insertVertex(Object o) {

        boolean contains = contains(o);
        if (contains) {
            Vertex nuevo = new Vertex(o);
            Iterator<Vertex> it = vertices();
            Vertex aux = vertice0;
            while (it.hasNext()) {
                aux = (Vertex) it.next();
            }
            aux.setNext(nuevo);
        }
        return contains;
    }

    @Override
    public boolean insertEdge(Vertex v, Vertex w, Object o) {
        int i = getIndex(v);
        int j = getIndex(w);
        boolean resul = false;
        if (matrizAdyaciencia[i][j] != null) {
            matrizAdyaciencia[i][j] = new Edge(o);
            resul = true;
        }
        return resul;
    }

    @Override
    public boolean removeVertex(Vertex v) {

        boolean contains = contains(v.getId());
        if (contains) {
            disengageVertex(v);
        }
        return contains;
    }

    @Override
    public boolean removeEdge(Edge e) {
        boolean contains = contains(e);
        if (contains) {
            e = null;
        }
        return contains;
    }

    @Override
    public Iterator vertices() {
        List aux = new ArrayList();
        Vertex next = vertice0;
        while (next != null) {
            aux.add(next);
        }
        return aux.iterator();
    }

    @Override
    public Iterator edges() {
        List aux = new ArrayList();
        Iterator <Vertex>it = vertices();
        while(it.hasNext()){
            Edge edge = it.next().getEdge();
            while(edge != null){
                aux.add(edge);
                edge = edge.getNext();
            }
        }
        return aux.iterator();
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

    private Vertex getVertex(int index) {
        Vertex aux = vertice0;
        int i = 0;
        while (i != index) {
            aux = aux.getNext();
            i++;
        }
        return aux;
    }

    private boolean contains(Edge e) {
        Iterator it = edges();
        boolean contains = false;
        while (!contains && it.hasNext()) {
            if (it.next() == e) {
                contains = true;
            }
        }
        return contains;
    }

    private boolean contains(Object o) {
        Iterator<Vertex> it = vertices();
        boolean contains = false;
        while (!contains && it.hasNext()) {
            if (it.next().getId() == o) {
                contains = true;
            }
        }
        return contains;
    }

    private void disengageVertex(Vertex v) {
        if (v == vertice0) {
            vertice0 = vertice0.getNext();
        } else {
            getVertex(getIndex(v) - 1).setNext(v.getNext());
        }
    }
}
