/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Cancion;

/**
 *
 * @author sebastian
 */
public class ctlArray {

    Cancion array[];

    public ctlArray() {
    }

    public ctlArray(int cantidad) {
        array = new Cancion[cantidad];
    }

    public static controladorCancion ctlCancion = new controladorCancion();

    public Cancion[] insertarArray(List<Cancion> listaCanciones) {
        for (int i = 0; i < array.length; i++) {
            array[i] = listaCanciones.get(i);
        }
        return array;
    }

    public Cancion buscar(int idCancion, Cancion[] arrayLLeno) {
        Cancion can = new Cancion();
        for (int i = 0; i < arrayLLeno.length; i++) {
            if (arrayLLeno[i].getIdCancion().intValue() == idCancion) {
                System.out.println("encontrado");
                return arrayLLeno[i];
            }
        }
        return null;
    }

    public Cancion[] actualizar(Cancion cancion) {
        Cancion can = new Cancion();
        for (int i = 0; i < array.length; i++) {
            can = array[i];
            if (can.getIdCancion().intValue() == cancion.getIdCancion().intValue()) {
                array[i] = cancion;
                break;
            }
        }
        return array;
    }

    public Cancion[] eliminar(int idCancion) {
        int j = 0;
        Cancion[] canci = new Cancion[array.length - 1];
        for (int i = 0; i < array.length; i++) {
            if (array[i].getIdCancion().intValue() == idCancion) {
                i++;
            }
            canci[j] = array[i];
            j++;
        }
        return canci;
    }

}
