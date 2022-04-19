/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_03.Enumeraciones;

/**
 *
 * @author Walter
 */
public enum Palo {
    ESPADAS("Espadas"),BASTOS("Bastos"),OROS("Oros"),COPAS("Copas");
    
    String nombre;
    
    Palo(){
    }
    
    Palo(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
