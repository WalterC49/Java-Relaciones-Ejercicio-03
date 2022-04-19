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
        System.out.println("\nMazo barajado.");
    }
    
    public void SiguienteCarta(){
        Carta c = new Carta();
        if(Mazo.getCartas().isEmpty()){
            System.out.println("\nYa no hay más cartas.");
        }else if(Mazo.getCartas().size()==1){
            c=Mazo.getCartas().get(0);
            System.out.println("\nLa siguiente y última carta es el "+c.toString()+".");
        }else{
            c=Mazo.getCartas().get(0);
            System.out.println("\nLa siguiente carta es el "+c.toString()+".");
        }
    }
    
    public void CartasDisponibles(){
        if(Mazo.getCartas().isEmpty()){
            System.out.println("\nYa no hay más cartas.");
        }else if(Mazo.getCartas().size()==1){
            System.out.println("\nQueda 1 carta todavía.");
        }else{
            System.out.println("\nQuedan "+Mazo.getCartas().size()+" cartas todavía.");
        }
    }
    
    public void DarCartas(){
        System.out.print("\nIngrese la cantidad de cartas que desea: ");
        int cantCartas = leer.nextInt();
        System.out.println("");
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
        if(CartasDadas.getCartas().isEmpty()){
            System.out.println("\nTodavía no se han entregado cartas.");
        }else{
            System.out.println("\nCartas ya dadas:");
            for (Object i : CartasDadas.getCartas()) {
                System.out.println("- "+i);
            }
        }
    }
    
    
    public void MostrarBaraja(){
        if(Mazo.getCartas().isEmpty()){
            System.out.println("\nYa no quedan cartas en el mazo.");
        }else{
            System.out.println("\nCartas restantes en la baraja:");
            for (Object i : Mazo.getCartas()) {
                System.out.println("- "+i);
            }
        }
    }
    
    public void Menu() {
        System.out.println("");
        System.out.println("----- MENU -----");
        System.out.println("Seleccione una opción: ");
        System.out.println("1. Barajar el mazo");
        System.out.println("2. Ver siguiente carta");
        System.out.println("3. Ver cartas disponibles");
        System.out.println("4. Pedir cartas");
        System.out.println("5. Ver cartas ya dadas");
        System.out.println("6. Ver cartas aún en el mazo");
        System.out.println("7. Salir del programa");
        System.out.print("Opción: ");
        String opc = leer.next();
        switch (opc) {
            case "1":
                Barajar();
                Menu();
                break;
            case "2":
                SiguienteCarta();
                Menu();
                break;
            case "3":
                CartasDisponibles();
                Menu();
                break;
            case "4":
                DarCartas();
                Menu();
                break;
            case "5":
                CartasMonton();
                Menu();
                break;
            case "6":
                MostrarBaraja();
                Menu();
                break;
            case "7":
                System.out.println("Hasta luego.");
                break;
            default:
                System.out.println("\nOpción no válida");
                Menu();
        }
    }
}
