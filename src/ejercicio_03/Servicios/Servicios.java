/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_03.Servicios;

import ejercicio_03.Entidades.Baraja;
import ejercicio_03.Entidades.Carta;
import ejercicio_03.Enumeraciones.Palo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Walter
 */
public class Servicios {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private Baraja Mazo = new Baraja();
    private Baraja CartasDadas = new Baraja();
    
    public void CrearBaraja(){
        ArrayList<Carta> CartasNuevas = new ArrayList();
        ArrayList<Carta> CartasSalidas = new ArrayList();
        System.out.println("Abriendo una baraja de cartas.");
        for(Palo aux:Palo.values()){
            for(int i=0;i<12;i++){
                if(i==8||i==9){
                    //NADA
                }else{
                    Carta c = new Carta(i+1,aux);
                    CartasNuevas.add(c);
                }
            }
        }
        System.out.println("\nBaraja Lista.");
        CartasDadas.setCartas(CartasSalidas);
        Mazo.setCartas(CartasNuevas);
    }
    
    public void Barajar(){
        Collections.shuffle(Mazo.getCartas());
    }
    
    public void SiguienteCarta(){
        Carta c = new Carta();
        if(Mazo.getCartas().isEmpty()){
            System.out.println("Ya no hay más cartas.");
        }else if(Mazo.getCartas().size()==1){
            c=Mazo.getCartas().get(0);
            System.out.print("Esta es la última carta: "+c.toString());
        }else{
            c=Mazo.getCartas().get(0);
            System.out.print("La siguiente carta es: "+c.toString());
        }
    }
    
    public void CartasDisponibles(){
        if(Mazo.getCartas().isEmpty()){
            System.out.println("Ya no hay más cartas.");
        }else if(Mazo.getCartas().size()==1){
            System.out.println("Queda 1 carta todavía.");
        }else{
            System.out.println("Quedan "+Mazo.getCartas().size()+" cartas todavía.");
        }
    }
    
    public void DarCartas(){
        System.out.print("\nIngrese la cantidad de cartas que desea: ");
        int cantCartas = leer.nextInt();
        
        if(cantCartas<=Mazo.getCartas().size()){
            for (int i = 0; i < cantCartas; i++) {
                System.out.println("Se entrega el " + Mazo.getCartas().get(i).toString() + " al jugador");
            }
            for (int i = 0; i < cantCartas; i++) {
                CartasDadas.getCartas().add(Mazo.getCartas().get(0));
                Mazo.getCartas().remove(0);
            }
        }else{
            System.out.println("No quedan suficientes cartas.");
            CartasDisponibles();
        }
    }
    
    public void CartasMonton(){
        if(Car){
        }else{
        }
    }
    
    
    
    
    
    
    
    
}
