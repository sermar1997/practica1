/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author Sergio
 */
public class Excepcion extends Exception{
    public Excepcion(String mensaje){
        super("Selecciona una fila");
    }
}
