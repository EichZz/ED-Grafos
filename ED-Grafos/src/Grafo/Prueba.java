/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.util.*;

/**
 *
 * @author Héctor y Juan
 */
public class Prueba {

    public static void main(String[] args) {
        System.out.println("Para 5 colores, nrep: 100000, t: " + test5colores(100000) + " ns");
        System.out.println("Para 8 colores, nrep: 100000, t: " + test8colores(100000) + " ns");
        System.out.println("Para 10 colores, nrep: 100000, t: " + test10colores(100000) + " ns");
        
        /*
        Datos de las pruebas
            Implementación 1
                Para 5 colores, nrep: 100000, t: 11360 ns
                Para 8 colores, nrep: 100000, t: 26464 ns
                Para 10 colores, nrep: 100000, t: 35949 ns
            Implementación 2
                Para 5 colores, nrep: 100000, t: 11580 ns
                Para 8 colores, nrep: 100000, t: 31687 ns
                Para 10 colores, nrep: 100000, t: 46832 ns
        */
    }

    public static String prueba5colores() {
        FabricaColores fabrica = new FabricaColores("Blanco");
        fabrica.colores.insertVertex("Amarillo");
        fabrica.colores.insertVertex("Naranja");
        fabrica.colores.insertVertex("Rojo");
        fabrica.colores.insertVertex("Negro");

        Iterator it = fabrica.colores.vertices();
        Vertex blanco = (Vertex) it.next();
        Vertex amarillo = (Vertex) it.next();
        Vertex naranja = (Vertex) it.next();
        Vertex rojo = (Vertex) it.next();
        Vertex negro = (Vertex) it.next();

        fabrica.colores.insertEdge(blanco, amarillo, 150);
        fabrica.colores.insertEdge(blanco, naranja, 120);
        fabrica.colores.insertEdge(blanco, rojo, 100);
        fabrica.colores.insertEdge(blanco, negro, 110);

        fabrica.colores.insertEdge(amarillo, blanco, 170);
        fabrica.colores.insertEdge(amarillo, naranja, 110);
        fabrica.colores.insertEdge(amarillo, rojo, 90);
        fabrica.colores.insertEdge(amarillo, negro, 100);

        fabrica.colores.insertEdge(naranja, blanco, 200);
        fabrica.colores.insertEdge(naranja, amarillo, 170);
        fabrica.colores.insertEdge(naranja, rojo, 80);
        fabrica.colores.insertEdge(naranja, negro, 100);

        fabrica.colores.insertEdge(rojo, blanco, 220);
        fabrica.colores.insertEdge(rojo, amarillo, 190);
        fabrica.colores.insertEdge(rojo, naranja, 100);
        fabrica.colores.insertEdge(rojo, negro, 90);

        fabrica.colores.insertEdge(negro, blanco, 300);
        fabrica.colores.insertEdge(negro, amarillo, 210);
        fabrica.colores.insertEdge(negro, naranja, 180);
        fabrica.colores.insertEdge(negro, rojo, 130);

        return fabrica.resolver();
    }
    
    public static String prueba10colores() {
        FabricaColores fabrica = new FabricaColores("Blanco");
        fabrica.colores.insertVertex("Amarillo");
        fabrica.colores.insertVertex("Naranja");
        fabrica.colores.insertVertex("Rojo");
        fabrica.colores.insertVertex("Negro");
        fabrica.colores.insertVertex("Morado");
        fabrica.colores.insertVertex("Azul");
        fabrica.colores.insertVertex("Magenta");
        fabrica.colores.insertVertex("Verde");
        fabrica.colores.insertVertex("Pistacho");

        Iterator it = fabrica.colores.vertices();
        Vertex blanco = (Vertex) it.next();
        Vertex amarillo = (Vertex) it.next();
        Vertex naranja = (Vertex) it.next();
        Vertex rojo = (Vertex) it.next();
        Vertex negro = (Vertex) it.next();
        Vertex morado = (Vertex) it.next();
        Vertex azul = (Vertex) it.next();
        Vertex magenta = (Vertex) it.next();
        Vertex verde = (Vertex) it.next();
        Vertex pistacho = (Vertex) it.next();

        fabrica.colores.insertEdge(blanco, amarillo, 150);
        fabrica.colores.insertEdge(blanco, naranja, 120);
        fabrica.colores.insertEdge(blanco, rojo, 100);
        fabrica.colores.insertEdge(blanco, negro, 110);
        fabrica.colores.insertEdge(blanco, morado, 90);
        fabrica.colores.insertEdge(blanco, azul, 100);
        fabrica.colores.insertEdge(blanco, magenta, 100);
        fabrica.colores.insertEdge(blanco, verde, 120);
        fabrica.colores.insertEdge(blanco, pistacho, 140);

        fabrica.colores.insertEdge(amarillo, blanco, 150);
        fabrica.colores.insertEdge(amarillo, naranja, 110);
        fabrica.colores.insertEdge(amarillo, rojo, 100);
        fabrica.colores.insertEdge(amarillo, negro, 110);
        fabrica.colores.insertEdge(amarillo, morado, 150);
        fabrica.colores.insertEdge(amarillo, azul, 120);
        fabrica.colores.insertEdge(amarillo, magenta, 100);
        fabrica.colores.insertEdge(amarillo, verde, 110);
        fabrica.colores.insertEdge(amarillo, pistacho, 110);

        fabrica.colores.insertEdge(naranja, blanco, 150);
        fabrica.colores.insertEdge(naranja, amarillo, 120);
        fabrica.colores.insertEdge(naranja, rojo, 100);
        fabrica.colores.insertEdge(naranja, negro, 110);
        fabrica.colores.insertEdge(naranja, morado, 150);
        fabrica.colores.insertEdge(naranja, azul, 120);
        fabrica.colores.insertEdge(naranja, magenta, 100);
        fabrica.colores.insertEdge(naranja, verde, 110);
        fabrica.colores.insertEdge(naranja, pistacho, 110);

        fabrica.colores.insertEdge(rojo, blanco, 150);
        fabrica.colores.insertEdge(rojo, amarillo, 120);
        fabrica.colores.insertEdge(rojo, naranja, 100);
        fabrica.colores.insertEdge(rojo, negro, 110);
        fabrica.colores.insertEdge(rojo, morado, 150);
        fabrica.colores.insertEdge(rojo, azul, 120);
        fabrica.colores.insertEdge(rojo, magenta, 100);
        fabrica.colores.insertEdge(rojo, verde, 110);
        fabrica.colores.insertEdge(rojo, pistacho, 110);

        fabrica.colores.insertEdge(negro, blanco, 150);
        fabrica.colores.insertEdge(negro, amarillo, 120);
        fabrica.colores.insertEdge(negro, naranja, 100);
        fabrica.colores.insertEdge(negro, rojo, 110);
        fabrica.colores.insertEdge(negro, morado, 150);
        fabrica.colores.insertEdge(negro, azul, 120);
        fabrica.colores.insertEdge(negro, magenta, 100);
        fabrica.colores.insertEdge(negro, verde, 110);
        fabrica.colores.insertEdge(negro, pistacho, 110);

        fabrica.colores.insertEdge(morado, blanco, 150);
        fabrica.colores.insertEdge(morado, amarillo, 120);
        fabrica.colores.insertEdge(morado, naranja, 100);
        fabrica.colores.insertEdge(morado, rojo, 110);
        fabrica.colores.insertEdge(morado, negro, 150);
        fabrica.colores.insertEdge(morado, azul, 120);
        fabrica.colores.insertEdge(morado, magenta, 100);
        fabrica.colores.insertEdge(morado, verde, 110);
        fabrica.colores.insertEdge(morado, pistacho, 110);

        fabrica.colores.insertEdge(azul, blanco, 150);
        fabrica.colores.insertEdge(azul, amarillo, 120);
        fabrica.colores.insertEdge(azul, naranja, 100);
        fabrica.colores.insertEdge(azul, rojo, 110);
        fabrica.colores.insertEdge(azul, negro, 150);
        fabrica.colores.insertEdge(azul, morado, 120);
        fabrica.colores.insertEdge(azul, magenta, 100);
        fabrica.colores.insertEdge(azul, verde, 110);
        fabrica.colores.insertEdge(azul, pistacho, 110);

        fabrica.colores.insertEdge(magenta, blanco, 150);
        fabrica.colores.insertEdge(magenta, amarillo, 120);
        fabrica.colores.insertEdge(magenta, naranja, 100);
        fabrica.colores.insertEdge(magenta, rojo, 110);
        fabrica.colores.insertEdge(magenta, negro, 150);
        fabrica.colores.insertEdge(magenta, morado, 120);
        fabrica.colores.insertEdge(magenta, azul, 100);
        fabrica.colores.insertEdge(magenta, verde, 110);
        fabrica.colores.insertEdge(magenta, pistacho, 110);

        fabrica.colores.insertEdge(verde, blanco, 150);
        fabrica.colores.insertEdge(verde, amarillo, 120);
        fabrica.colores.insertEdge(verde, naranja, 100);
        fabrica.colores.insertEdge(verde, rojo, 110);
        fabrica.colores.insertEdge(verde, negro, 150);
        fabrica.colores.insertEdge(verde, morado, 120);
        fabrica.colores.insertEdge(verde, azul, 100);
        fabrica.colores.insertEdge(verde, morado, 110);
        fabrica.colores.insertEdge(verde, pistacho, 110);

        fabrica.colores.insertEdge(pistacho, blanco, 150);
        fabrica.colores.insertEdge(pistacho, amarillo, 120);
        fabrica.colores.insertEdge(pistacho, naranja, 100);
        fabrica.colores.insertEdge(pistacho, rojo, 110);
        fabrica.colores.insertEdge(pistacho, negro, 150);
        fabrica.colores.insertEdge(pistacho, morado, 120);
        fabrica.colores.insertEdge(pistacho, azul, 100);
        fabrica.colores.insertEdge(pistacho, morado, 110);
        fabrica.colores.insertEdge(pistacho, verde, 110);

        return fabrica.resolver();
    }

    public static String prueba8colores() {
        FabricaColores fabrica = new FabricaColores("Blanco");
        fabrica.colores.insertVertex("Amarillo");
        fabrica.colores.insertVertex("Naranja");
        fabrica.colores.insertVertex("Rojo");
        fabrica.colores.insertVertex("Negro");
        fabrica.colores.insertVertex("Morado");
        fabrica.colores.insertVertex("Azul");
        fabrica.colores.insertVertex("Magenta");

        Iterator it = fabrica.colores.vertices();
        Vertex blanco = (Vertex) it.next();
        Vertex amarillo = (Vertex) it.next();
        Vertex naranja = (Vertex) it.next();
        Vertex rojo = (Vertex) it.next();
        Vertex negro = (Vertex) it.next();
        Vertex morado = (Vertex) it.next();
        Vertex azul = (Vertex) it.next();
        Vertex magenta = (Vertex) it.next();

        fabrica.colores.insertEdge(blanco, amarillo, 150);
        fabrica.colores.insertEdge(blanco, naranja, 120);
        fabrica.colores.insertEdge(blanco, rojo, 100);
        fabrica.colores.insertEdge(blanco, negro, 110);
        fabrica.colores.insertEdge(blanco, morado, 90);
        fabrica.colores.insertEdge(blanco, azul, 100);
        fabrica.colores.insertEdge(blanco, magenta, 100);

        fabrica.colores.insertEdge(amarillo, blanco, 150);
        fabrica.colores.insertEdge(amarillo, naranja, 110);
        fabrica.colores.insertEdge(amarillo, rojo, 100);
        fabrica.colores.insertEdge(amarillo, negro, 110);
        fabrica.colores.insertEdge(amarillo, morado, 150);
        fabrica.colores.insertEdge(amarillo, azul, 120);
        fabrica.colores.insertEdge(amarillo, magenta, 100);

        fabrica.colores.insertEdge(naranja, blanco, 150);
        fabrica.colores.insertEdge(naranja, amarillo, 120);
        fabrica.colores.insertEdge(naranja, rojo, 100);
        fabrica.colores.insertEdge(naranja, negro, 110);
        fabrica.colores.insertEdge(naranja, morado, 150);
        fabrica.colores.insertEdge(naranja, azul, 120);
        fabrica.colores.insertEdge(naranja, magenta, 100);

        fabrica.colores.insertEdge(rojo, blanco, 150);
        fabrica.colores.insertEdge(rojo, amarillo, 120);
        fabrica.colores.insertEdge(rojo, naranja, 100);
        fabrica.colores.insertEdge(rojo, negro, 110);
        fabrica.colores.insertEdge(rojo, morado, 150);
        fabrica.colores.insertEdge(rojo, azul, 120);
        fabrica.colores.insertEdge(rojo, magenta, 100);

        fabrica.colores.insertEdge(negro, blanco, 150);
        fabrica.colores.insertEdge(negro, amarillo, 120);
        fabrica.colores.insertEdge(negro, naranja, 100);
        fabrica.colores.insertEdge(negro, rojo, 110);
        fabrica.colores.insertEdge(negro, morado, 150);
        fabrica.colores.insertEdge(negro, azul, 120);
        fabrica.colores.insertEdge(negro, magenta, 100);

        fabrica.colores.insertEdge(morado, blanco, 150);
        fabrica.colores.insertEdge(morado, amarillo, 120);
        fabrica.colores.insertEdge(morado, naranja, 100);
        fabrica.colores.insertEdge(morado, rojo, 110);
        fabrica.colores.insertEdge(morado, negro, 150);
        fabrica.colores.insertEdge(morado, azul, 120);
        fabrica.colores.insertEdge(morado, magenta, 100);

        fabrica.colores.insertEdge(azul, blanco, 150);
        fabrica.colores.insertEdge(azul, amarillo, 120);
        fabrica.colores.insertEdge(azul, naranja, 100);
        fabrica.colores.insertEdge(azul, rojo, 110);
        fabrica.colores.insertEdge(azul, negro, 150);
        fabrica.colores.insertEdge(azul, morado, 120);
        fabrica.colores.insertEdge(azul, magenta, 100);

        fabrica.colores.insertEdge(magenta, blanco, 150);
        fabrica.colores.insertEdge(magenta, amarillo, 120);
        fabrica.colores.insertEdge(magenta, naranja, 100);
        fabrica.colores.insertEdge(magenta, rojo, 110);
        fabrica.colores.insertEdge(magenta, negro, 150);
        fabrica.colores.insertEdge(magenta, morado, 120);
        fabrica.colores.insertEdge(magenta, azul, 100);

        return fabrica.resolver();
    }

    public static long test5colores(int nrep) {
        long start = System.nanoTime();
        for (int i = 0; i < nrep; i++) {
            prueba5colores();
        }
        long stop = System.nanoTime();
        return (stop - start) / nrep;
    }
    
    public static long test8colores(int nrep) {
        long start = System.nanoTime();
        for (int i = 0; i < nrep; i++) {
            prueba8colores();
        }
        long stop = System.nanoTime();
        return (stop - start) / nrep;
    }
    
    public static long test10colores(int nrep) {
        long start = System.nanoTime();
        for (int i = 0; i < nrep; i++) {
            prueba10colores();
        }
        long stop = System.nanoTime();
        return (stop - start) / nrep;
    }
}
