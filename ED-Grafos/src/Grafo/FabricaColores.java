/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

/**
 *
 * @author hecto
 */
public class FabricaColores {

    private Graph colores;

    public FabricaColores(Object o) {
        colores = new Implementacion1Graph(o);
    }

}
