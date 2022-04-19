/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_03.Entidades;

import ejercicio_03.Enumeraciones.Palo;

/**
 *
 * @author Walter
 */
public class Carta {
    private Integer valor;
    private Palo palo;

    public Carta() {
    }

    public Carta(Integer valor, Palo palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Palo getPalo() {
        return palo;
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        return valor +" de "+palo.getNombre();
    }
    
}
