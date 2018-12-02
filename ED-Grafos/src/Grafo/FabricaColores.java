/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.util.*;

/**
 *
 * @author hecto
 */
public class FabricaColores {

    Graph colores;

    public FabricaColores(Object o) {
        colores = new Implementacion2Graph(o);
    }

    public void resolver() {
        Iterator aristas = colores.edges();

        Edge min = ((Edge) aristas.next()), next;
        while (aristas.hasNext()) {
            next = ((Edge) aristas.next());
            if ((int) next.getElement() < (int) min.getElement()) {
                min = next;
            }
        }
        int tiempo = (int) min.getElement();
        Vertex[] aux = colores.endVertices(min);
        Vertex actual = aux[1];
        colores.removeVertex(aux[0]);
        List<Vertex> elementos = new ArrayList();
        elementos.add(aux[0]);
        elementos.add(aux[1]);

        Iterator vertices = colores.vertices();
        boolean enc;
        int minimoActual = -1;
        Vertex siguiente = null;
        while (vertices.hasNext()) {

            aristas = colores.edges();//actualizamos la lista de aristas
            enc = false;
            while (aristas.hasNext() && !enc) {
                next = ((Edge) aristas.next());
                Vertex[] verticesActuales = colores.endVertices(next);
                if (verticesActuales[0] == actual) {
                    minimoActual = (int) next.getElement();
                    siguiente = verticesActuales[1];
                    enc = true;
                }
            }
            while (aristas.hasNext()) {
                next = ((Edge) aristas.next());
                Vertex[] verticesActuales = colores.endVertices(next);
                if (verticesActuales[0] == actual) {
                    int minimoPosible = (int) next.getElement();
                    if (minimoPosible < minimoActual) {
                        minimoActual = minimoPosible;
                        siguiente = verticesActuales[1];
                    }
                }
            }
            tiempo += minimoActual;
            elementos.add(siguiente);
            colores.removeVertex(actual);
            actual = siguiente;
            vertices = colores.vertices(); //actualizamos la lista de vertices
            vertices.next();
        }
        int produccion = 1200 - tiempo;
        System.out.println("El tiempo de producción semanal de pintura es:"
                + " " + produccion / 60 + " horas y " + produccion % 60 + " minutos");
        System.out.println("El tiempo de disposición es:"
                + " " + tiempo / 60 + " horas y " + tiempo % 60 + " minutos");
        String s = "La secuencia de producción: ";
        for (int i = 0; i < elementos.size(); i++) {
            s += elementos.get(i).getId();
            if (i < elementos.size() - 1) {
                s += " - ";
            }
        }
        System.out.println(s);
    }
}
