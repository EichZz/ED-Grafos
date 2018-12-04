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
 * @author Héctor y Juan
 */
public class Implementacion2Graph implements Graph {

    Vertex vertice0;

    public Implementacion2Graph(Object o) {
        Vertex v = new Vertex(o);
        vertice0 = v;
    }

    @Override
    public Vertex[] endVertices(Edge e) {
        Vertex[] vectorVertices = new Vertex[2];
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
        Vertex resul = null;

        Edge edge = v.getEdge();
        while (edge != null && !enc) {
            if (edge == e) {
                resul = edge.getVertex();
                enc = true;
            }
            edge = edge.getNext();
        }
        return resul;
    }

    @Override
    public boolean areAdjacent(Vertex v, Vertex w) {
        boolean enc = false;
        Edge aux = v.getEdge();
        while (!enc && aux != null) {
            if (aux.getVertex() == w) {
                enc = true;
            }
            aux = aux.getNext();
        }
        if (!enc) {
            aux = w.getEdge();
            while (!enc && aux != null) {
                if (aux.getVertex() == v) {
                    enc = true;
                }
                aux = aux.getNext();
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
        if (!contains) {
            Vertex nuevo = new Vertex(o);
            Vertex aux = vertice0;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(nuevo);
        }
        return !contains;
    }

    @Override
    public boolean insertEdge(Vertex v, Vertex w, Object o) {
        boolean enc = false;
        Edge next = v.getEdge();
        Edge previo = null;
        while (next != null && !enc) {
            if (next.getVertex() == w) {
                enc = true;
            }
            previo = next;
            next = next.getNext();
        }
        if (!enc) {
            next = new Edge(o);
            next.setVertex(w);
            if (v.getEdge() == null) {
                v.setEdge(next);
            }else{
            previo.setNext(next);
            }
        }
        return !enc;
    }

    @Override
    public boolean removeVertex(Vertex v) {

        boolean contains = contains(v.getId());
        if (contains) {
            disengageVertex(v);
            Iterator it = edges();
            while (it.hasNext()) {
                Edge next = (Edge) it.next();
                if (next.getVertex() == v) {
                    removeEdge(next);
                }
            }
        }
        return contains;
    }

    @Override
    public boolean removeEdge(Edge e) {
        boolean contains = contains(e);
        if (contains) {
            disengageEdge(e);
        }
        return contains;
    }

    @Override
    public Iterator vertices() {
        List aux = new ArrayList();
        Vertex next = vertice0;
        while (next != null) {
            aux.add(next);
            next = next.getNext();
        }
        return aux.iterator();
    }

    @Override
    public Iterator edges() {
        List aux = new ArrayList();
        Iterator<Vertex> it = vertices();
        while (it.hasNext()) {
            Edge edge = it.next().getEdge();
            while (edge != null) {
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

    private void disengageEdge(Edge e) {
        boolean enc = false;
        Vertex aux = vertice0;

        while (aux != null && !enc) {
            Edge edge = aux.getEdge();
            if (edge.getNext() != null) {
                Edge next = edge.getNext();
                if (edge == e) {
                    aux.setEdge(next);
                    enc = true;
                }
                while (next != null && !enc) {
                    if (next == e) {
                        edge.setNext(next.getNext());
                        enc = true;
                    }
                    edge = next;
                    next = edge.getNext();
                }
            } else {
                aux.setEdge(null);
            }
            aux = aux.getNext();
        }
    }
}
