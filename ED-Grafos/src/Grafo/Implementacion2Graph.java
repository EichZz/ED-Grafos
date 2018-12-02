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

        Vertex aux = vertice0;

        while (aux != null) {
            Edge edge = aux.getEdge();
            while (edge != null) {
                if (edge == e) {
                    vectorVertices[0] = aux;
                    vectorVertices[1] = edge.getVertex();
                }
                edge = edge.getNext();
            }
            aux = aux.getNext();
        }

        return vectorVertices;
    }

    @Override
    public Vertex opposite(Vertex v, Edge e) {
        Vertex[] aux = endVertices(e);
        Vertex resul = null;
        if (aux[0] == v) {
            resul = aux[1];
        } else if (aux[1] == v) {
            resul = aux[0];
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
            ampliarMatriz();
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
            int index = getIndex(v);
            reducirMatriz(index);
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
        int max = matrizAdyaciencia[0].length;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                if (matrizAdyaciencia[i][j] != null) {
                    aux.add(matrizAdyaciencia[i][j]);
                }
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

    private void reducirMatriz(int index) {
        int max = matrizAdyaciencia[0].length;
        Edge[][] matrizaux = new Edge[max - 1][max - 1];

        int posi = 0;
        int i = 0;

        while (i < max) {

            int j = 0;
            int posj = 0;

            if (i != index) {

                while (j < max) {

                    if (j != index) {
                        matrizaux[i - posi][j - posj] = matrizAdyaciencia[i][j];
                    } else {
                        posj++;
                    }
                    j++;
                }

            } else {
                posi++;
            }
            i++;
        }
        matrizAdyaciencia = matrizaux;
    }

    private void ampliarMatriz() {
        int max = matrizAdyaciencia[0].length;
        Edge[][] matrizaux = new Edge[max + 1][max + 1];

        int i = 0;
        while (i < max) {
            int j = 0;
            while (j < max) {
                matrizaux[i][j] = matrizAdyaciencia[i][j];
                j++;
            }
            i++;
        }
        matrizAdyaciencia = matrizaux;
    }

}
