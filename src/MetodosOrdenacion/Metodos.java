/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetodosOrdenacion;

import controlador.controladorCancion;
import controlador.controladorOrdenacion;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import modelo.Cancion;
import modelo.Ordenacion;

/**
 *
 * @author sebastian
 */
public class Metodos {

    static controladorOrdenacion ctlordenacion = new controladorOrdenacion(Ordenacion.class);
    static long totalTiempo;

    //Metodo de ordenacion Burbuja
    public static Cancion[] OrdenarBurbujaInt(Cancion[] arregloDesorden) {
        long tiempoInicio = System.nanoTime();
        Cancion temp;
        int t = arregloDesorden.length;
        for (int i = 1; i < t; i++) {
            for (int k = t - 1; k >= i; k--) {
                if (arregloDesorden[k].getDuracion().intValue() < arregloDesorden[k - 1].getDuracion().intValue()) {
                    temp = arregloDesorden[k];
                    arregloDesorden[k] = arregloDesorden[k - 1];
                    arregloDesorden[k - 1] = temp;
                }
            }
        }
        totalTiempo = System.nanoTime() - tiempoInicio;
        System.out.println("Tiempo demorado:\t" + totalTiempo + " nanosegundos.");
        return arregloDesorden;
    }

    public static Cancion[] OrdenarBurbujaDate(Cancion[] arregloDesorden) {
        Cancion temp;
        int t = arregloDesorden.length;
        for (int i = 1; i < t; i++) {
            for (int k = t - 1; k >= i; k--) {
                if (arregloDesorden[k].getFechaNacimiento().getTime() < arregloDesorden[k - 1].getFechaNacimiento().getTime()) {
                    temp = arregloDesorden[k];
                    arregloDesorden[k] = arregloDesorden[k - 1];
                    arregloDesorden[k - 1] = temp;
                }
            }
        }
        return arregloDesorden;
    }

    //String
    public static Cancion[] OrdenarBurbujaString(Cancion[] arregloDesorden) {
        Cancion temp;
        int t = arregloDesorden.length;
        for (int i = 1; i < t; i++) {
            for (int k = t - 1; k >= i; k--) {
                if (arregloDesorden[k].getNombre().compareTo(arregloDesorden[k - 1].getNombre()) < 0) {
                    temp = arregloDesorden[k];
                    arregloDesorden[k] = arregloDesorden[k - 1];
                    arregloDesorden[k - 1] = temp;
                }
            }
        }
        return arregloDesorden;
    }

// Fin metodo de ordenacion burbuja
// metodo de rdenacion burbuja bidimencional
    public static Cancion[] OrdenarBurbujaBidireccionalInt(Cancion[] arregloDesorden) {

        int izquierda = 1, derecha = arregloDesorden.length - 1, ultimo = arregloDesorden.length - 1;

        do {
            for (int i = arregloDesorden.length - 1; i > 0; i--) {
                //Burbuja hacia la izquierda
                //Los valores menores van a la izquierda 
                if (arregloDesorden[i - 1].getDuracion().intValue() > arregloDesorden[i].getDuracion().intValue()) {
                    Cancion aux = arregloDesorden[i]; // variable auxiliar para poder hacer intercambio de
                    arregloDesorden[i] = arregloDesorden[i - 1];  // posicion
                    arregloDesorden[i - 1] = aux;
                    ultimo = i;
                }
            }
            izquierda = ultimo + 1;
            for (int j = 1; j < arregloDesorden.length; j++) {
                //Burbuja hacia la derecha
                //Los valores mayores van a la derecha 
                if (arregloDesorden[j - 1].getDuracion().intValue() > arregloDesorden[j].getDuracion().intValue()) {
                    Cancion aux = arregloDesorden[j];
                    arregloDesorden[j] = arregloDesorden[j - 1];
                    arregloDesorden[j - 1] = aux;
                    ultimo = j;
                }
            }
            derecha = ultimo - 1;
        } while (derecha >= izquierda);

        return arregloDesorden;

    }

    //Date
    public static Cancion[] OrdenarBurbujaBidireccionalDate(Cancion[] arregloDesorden) {

        int izquierda = 1, derecha = arregloDesorden.length - 1, ultimo = arregloDesorden.length - 1;

        do {
            for (int i = arregloDesorden.length - 1; i > 0; i--) {
                //Burbuja hacia la izquierda
                //Los valores menores van a la izquierda 
                if (arregloDesorden[i - 1].getFechaNacimiento().getTime() > arregloDesorden[i].getFechaNacimiento().getTime()) {
                    Cancion aux = arregloDesorden[i]; // variable auxiliar para poder hacer intercambio de
                    arregloDesorden[i] = arregloDesorden[i - 1];  // posicion
                    arregloDesorden[i - 1] = aux;
                    ultimo = i;
                }
            }
            izquierda = ultimo + 1;
            for (int j = 1; j < arregloDesorden.length; j++) {
                //Burbuja hacia la derecha
                //Los valores mayores van a la derecha 
                if (arregloDesorden[j - 1].getFechaNacimiento().getTime() > arregloDesorden[j].getFechaNacimiento().getTime()) {
                    Cancion aux = arregloDesorden[j];
                    arregloDesorden[j] = arregloDesorden[j - 1];
                    arregloDesorden[j - 1] = aux;
                    ultimo = j;
                }
            }
            derecha = ultimo - 1;
        } while (derecha >= izquierda);

        return arregloDesorden;

    }

    //String
    public static Cancion[] OrdenarBurbujaBidireccionalString(Cancion[] arregloDesorden) {

        int izquierda = 1, derecha = arregloDesorden.length - 1, ultimo = arregloDesorden.length - 1;

        do {
            for (int i = arregloDesorden.length - 1; i > 0; i--) {
                //Burbuja hacia la izquierda
                //Los valores menores van a la izquierda 
                if (arregloDesorden[i - 1].getNombre().compareTo(arregloDesorden[i].getNombre()) > 0) {
                    Cancion aux = arregloDesorden[i]; // variable auxiliar para poder hacer intercambio de
                    arregloDesorden[i] = arregloDesorden[i - 1];  // posicion
                    arregloDesorden[i - 1] = aux;
                    ultimo = i;
                }
            }
            izquierda = ultimo + 1;
            for (int j = 1; j < arregloDesorden.length; j++) {
                //Burbuja hacia la derecha
                //Los valores mayores van a la derecha 
                if (arregloDesorden[j - 1].getNombre().compareTo(arregloDesorden[j].getNombre()) > 0) {
                    Cancion aux = arregloDesorden[j];
                    arregloDesorden[j] = arregloDesorden[j - 1];
                    arregloDesorden[j - 1] = aux;
                    ultimo = j;
                }
            }
            derecha = ultimo - 1;
        } while (derecha >= izquierda);

        return arregloDesorden;

    }

    //Fin metodo de ordenacion burbuja bidimencional
    //Metodo de ordenacion insertShort
    public static Cancion[] insertSortInt(Cancion[] arregloDesorden) {
        for (int i = 1; i < arregloDesorden.length; i++) {
            Cancion aux = arregloDesorden[i];
            int j;
            for (j = i - 1; j >= 0 && arregloDesorden[j].getDuracion().intValue() > aux.getDuracion().intValue(); j--) {
                arregloDesorden[j + 1] = arregloDesorden[j];
            }
            arregloDesorden[j + 1] = aux;
        }

        return arregloDesorden;
    }

    //Date
    public static Cancion[] insertSortDate(Cancion[] arregloDesorden) {
        for (int i = 1; i < arregloDesorden.length; i++) {
            Cancion aux = arregloDesorden[i];
            int j;
            for (j = i - 1; j >= 0 && arregloDesorden[j].getFechaNacimiento().getTime() > aux.getFechaNacimiento().getTime(); j--) {
                arregloDesorden[j + 1] = arregloDesorden[j];
            }
            arregloDesorden[j + 1] = aux;
        }

        return arregloDesorden;
    }

    //String
    public static Cancion[] insertSortString(Cancion[] arregloDesorden) {
        for (int i = 1; i < arregloDesorden.length; i++) {
            Cancion aux = arregloDesorden[i];
            int j;
            for (j = i - 1; j >= 0 && arregloDesorden[j].getNombre().compareTo(aux.getNombre()) > 0; j--) {
                arregloDesorden[j + 1] = arregloDesorden[j];
            }
            arregloDesorden[j + 1] = aux;
        }

        return arregloDesorden;
    }

    //Fin metodo de ordenacion insetShort
    //Metodo de ordenacion Seleccion
    public static Cancion[] selecccionInt(Cancion[] arregloDesorden) {
        for (int i = 0; i < arregloDesorden.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arregloDesorden.length; j++) {
                if (arregloDesorden[j].getDuracion().intValue() < arregloDesorden[min].getDuracion().intValue()) {
                    min = j;
                }
            }
            if (i != min) {
                Cancion aux = arregloDesorden[i];
                arregloDesorden[i] = arregloDesorden[min];
                arregloDesorden[min] = aux;
            }
        }
        return arregloDesorden;
    }

    //Date
    public static Cancion[] selecccionDate(Cancion[] arregloDesorden) {
        for (int i = 0; i < arregloDesorden.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arregloDesorden.length; j++) {
                if (arregloDesorden[j].getFechaNacimiento().getTime() < arregloDesorden[min].getFechaNacimiento().getTime()) {
                    min = j;
                }
            }
            if (i != min) {
                Cancion aux = arregloDesorden[i];
                arregloDesorden[i] = arregloDesorden[min];
                arregloDesorden[min] = aux;
            }
        }
        return arregloDesorden;
    }

    //String
    public static Cancion[] selecccionString(Cancion[] arregloDesorden) {
        for (int i = 0; i < arregloDesorden.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arregloDesorden.length; j++) {
                if (arregloDesorden[j].getNombre().compareTo(arregloDesorden[min].getNombre()) < 0) {
                    min = j;
                }
            }
            if (i != min) {
                Cancion aux = arregloDesorden[i];
                arregloDesorden[i] = arregloDesorden[min];
                arregloDesorden[min] = aux;
            }
        }
        return arregloDesorden;
    }

    //Fin de metodo de ordenacion de seleccion
    // Inicio metodo Quicksort
    public static Cancion[] ordenarQuicksortInt(Cancion[] arregloDesorden, int primero, int ultimo) {
        int i = primero, j = ultimo;
        int pivote = arregloDesorden[(primero + ultimo) / 2].getDuracion().intValue();
        Cancion auxiliar;

        do {
            while (arregloDesorden[i].getDuracion().intValue() < pivote) {
                i++;
            }
            while (arregloDesorden[j].getDuracion().intValue() > pivote) {
                j--;
            }

            if (i <= j) {
                auxiliar = arregloDesorden[j];
                arregloDesorden[j] = arregloDesorden[i];
                arregloDesorden[i] = auxiliar;
                i++;
                j--;
            }

        } while (i <= j);

        if (primero < j) {
            ordenarQuicksortInt(arregloDesorden, primero, j);
        }
        if (ultimo > i) {
            ordenarQuicksortInt(arregloDesorden, i, ultimo);
        }

        return arregloDesorden;
    }

    //Date
    public static Cancion[] ordenarQuicksortDate(Cancion[] arregloDesorden, int primero, int ultimo) {
        int i = primero, j = ultimo;
        Date pivote = arregloDesorden[(primero + ultimo) / 2].getFechaNacimiento();
        Cancion auxiliar;

        do {
            while (arregloDesorden[i].getFechaNacimiento().before(pivote)) {
                i++;
            }
            while (arregloDesorden[j].getFechaNacimiento().after(pivote)) {
                j--;
            }

            if (i <= j) {
                auxiliar = arregloDesorden[j];
                arregloDesorden[j] = arregloDesorden[i];
                arregloDesorden[i] = auxiliar;
                i++;
                j--;
            }

        } while (i <= j);

        if (primero < j) {
            ordenarQuicksortInt(arregloDesorden, primero, j);
        }
        if (ultimo > i) {
            ordenarQuicksortInt(arregloDesorden, i, ultimo);
        }

        return arregloDesorden;
    }

    //String
    public static Cancion[] ordenarQuicksortString(Cancion[] arregloDesorden, int primero, int ultimo) {
        int i = primero, j = ultimo;
        String pivote = arregloDesorden[(primero + ultimo) / 2].getNombre();
        Cancion auxiliar;

        do {
            while (arregloDesorden[i].getNombre().compareTo(pivote) < 0) {
                i++;
            }
            while (arregloDesorden[j].getNombre().compareTo(pivote) > 0) {
                j--;
            }

            if (i <= j) {
                auxiliar = arregloDesorden[j];
                arregloDesorden[j] = arregloDesorden[i];
                arregloDesorden[i] = auxiliar;
                i++;
                j--;
            }

        } while (i <= j);

        if (primero < j) {
            ordenarQuicksortInt(arregloDesorden, primero, j);
        }
        if (ultimo > i) {
            ordenarQuicksortInt(arregloDesorden, i, ultimo);
        }

        return arregloDesorden;
    }

    //Fin de metodo quicksort
    //Inicio de metodo Shell
    public static Cancion[] shellInt(Cancion A[]) {
        int salto, i;
        Cancion aux;
        boolean cambios;
        for (salto = A.length / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) { // Mientras se intercambie algún elemento
                cambios = false;
                for (i = salto; i < A.length; i++) // se da una pasada
                {
                    if (A[i - salto].getDuracion().intValue() > A[i].getDuracion().intValue()) { // y si están desordenados
                        aux = A[i]; // se reordenan
                        A[i] = A[i - salto];
                        A[i - salto] = aux;
                        cambios = true; // y se marca como cambio.
                    }
                }
            }
        }

        return A;
    }

    //Date
    public static Cancion[] shellDate(Cancion A[]) {
        int salto, i;
        Cancion aux;
        boolean cambios;
        for (salto = A.length / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) { // Mientras se intercambie algún elemento
                cambios = false;
                for (i = salto; i < A.length; i++) // se da una pasada
                {
                    if (A[i - salto].getFechaNacimiento().after(A[i].getFechaNacimiento())) { // y si están desordenados
                        aux = A[i]; // se reordenan
                        A[i] = A[i - salto];
                        A[i - salto] = aux;
                        cambios = true; // y se marca como cambio.
                    }
                }
            }
        }

        return A;
    }

    //String
    public static Cancion[] shellString(Cancion A[]) {
        int salto, i;
        Cancion aux;
        boolean cambios;
        for (salto = A.length / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) { // Mientras se intercambie algún elemento
                cambios = false;
                for (i = salto; i < A.length; i++) // se da una pasada
                {
                    if (A[i - salto].getNombre().compareTo(A[i].getNombre()) > 0) { // y si están desordenados
                        aux = A[i]; // se reordenan
                        A[i] = A[i - salto];
                        A[i - salto] = aux;
                        cambios = true; // y se marca como cambio.
                    }
                }
            }
        }

        return A;
    }
    // Fin metodo shell
    // Inicio metodo por mezcla

    public static Cancion[] mergesort(Cancion A[], int izq, int der) {
        if (izq < der) {
            int m = (izq + der) / 2;
            mergesort(A, izq, m);
            mergesort(A, m + 1, der);
            A = merge(A, izq, m, der);
        }

        return A;
    }

    public static Cancion[] merge(Cancion A[], int izq, int m, int der) {
        int i, j, k;
        Cancion[] B = new Cancion[A.length]; //array auxiliar
        for (i = izq; i <= der; i++) //copia ambas mitades en el array auxiliar
        {
            B[i] = A[i];
        }

        i = izq;
        j = m + 1;
        k = izq;
        while (i <= m && j <= der) //copia el siguiente elemento más grande
        {
            if (B[i].getDuracion().intValue() <= B[j].getDuracion().intValue()) {
                A[k++] = B[i++];
            } else {
                A[k++] = B[j++];
            }
        }
        while (i <= m) //copia los elementos que quedan de la
        {
            A[k++] = B[i++]; //primera mitad (si los hay)
        }

        return A;
    }

    //Date
    public static Cancion[] mergesortDate(Cancion A[], int izq, int der) {
        if (izq < der) {
            int m = (izq + der) / 2;
            mergesort(A, izq, m);
            mergesort(A, m + 1, der);
            A = merge(A, izq, m, der);
        }

        return A;
    }

    public static Cancion[] mergeDate(Cancion A[], int izq, int m, int der) {
        int i, j, k;
        Cancion[] B = new Cancion[A.length]; //array auxiliar
        for (i = izq; i <= der; i++) //copia ambas mitades en el array auxiliar
        {
            B[i] = A[i];
        }

        i = izq;
        j = m + 1;
        k = izq;
        while (i <= m && j <= der) //copia el siguiente elemento más grande
        {
            if (B[i].getFechaNacimiento().getTime() <= B[j].getFechaNacimiento().getTime()) {
                A[k++] = B[i++];
            } else {
                A[k++] = B[j++];
            }
        }
        while (i <= m) //copia los elementos que quedan de la
        {
            A[k++] = B[i++]; //primera mitad (si los hay)
        }

        return A;
    }

    //Fin metodo ordenacion merge
    //inicio metodo de ordemaniento por monticulos
    // Ordenacion por monticulos - HeapSort
    public static Cancion[] ordenacionMonticulos(Cancion[] v) {
        final int N = v.length;
        for (int nodo = N / 2; nodo >= 0; nodo--) {
            hacerMonticulo(v, nodo, N - 1);
        }
        for (int nodo = N - 1; nodo >= 0; nodo--) {
            Cancion tmp = v[0];
            v[0] = v[nodo];
            v[nodo] = tmp;
            hacerMonticulo(v, 0, nodo - 1);
        }

        return v;
    }

    public static void hacerMonticulo(Cancion[] v, int nodo, int fin) {
        int izq = 2 * nodo + 1;
        int der = izq + 1;
        int may;
        if (izq > fin) {
            return;
        }
        if (der > fin) {
            may = izq;
        } else {
            may = v[izq].getDuracion().intValue() > v[der].getDuracion().intValue() ? izq : der;
        }
        if (v[nodo].getDuracion().intValue() < v[may].getDuracion().intValue()) {
            Cancion tmp = v[nodo];
            v[nodo] = v[may];
            v[may] = tmp;
            hacerMonticulo(v, may, fin);
        }
    }

    //Date
    public static Cancion[] ordenacionMonticulosDate(Cancion[] v) {
        final int N = v.length;
        for (int nodo = N / 2; nodo >= 0; nodo--) {
            hacerMonticuloDate(v, nodo, N - 1);
        }
        for (int nodo = N - 1; nodo >= 0; nodo--) {
            Cancion tmp = v[0];
            v[0] = v[nodo];
            v[nodo] = tmp;
            hacerMonticuloDate(v, 0, nodo - 1);
        }

        return v;
    }

    //toca analisarlo mejor no esta funcionando
    public static void hacerMonticuloDate(Cancion[] v, int nodo, int fin) {
        int izq = 2 * nodo + 1;
        int der = izq + 1;
        int may;
        if (izq > fin) {
            return;
        }
        if (der > fin) {
            may = izq;
        } else {
            may = v[izq].getFechaNacimiento().after(v[der].getFechaNacimiento()) ? izq : der;
        }
        if (v[nodo].getFechaNacimiento().before(v[may].getFechaNacimiento())) {
            Cancion tmp = v[nodo];
            v[nodo].getFechaNacimiento();
            v[nodo] = v[may];
            v[may] = tmp;
            hacerMonticulo(v, may, fin);
        }

    }

    //String
    public static Cancion[] ordenacionMonticulosString(Cancion[] v) {
        final int N = v.length;
        for (int nodo = N / 2; nodo >= 0; nodo--) {
            hacerMonticuloString(v, nodo, N - 1);
        }
        for (int nodo = N - 1; nodo >= 0; nodo--) {
            Cancion tmp = v[0];
            v[0] = v[nodo];
            v[nodo] = tmp;
            hacerMonticuloString(v, 0, nodo - 1);
        }

        return v;
    }

    public static void hacerMonticuloString(Cancion[] v, int nodo, int fin) {
        int izq = 2 * nodo + 1;
        int der = izq + 1;
        int may;
        if (izq > fin) {
            return;
        }
        if (der > fin) {
            may = izq;
        } else {
            may = v[izq].getNombre().compareTo(v[der].getNombre()) > 0 ? izq : der;
        }
        if (v[nodo].getNombre().compareTo(v[may].getNombre()) < 0) {
            Cancion tmp = v[nodo];
            v[nodo] = v[may];
            v[may] = tmp;
            hacerMonticulo(v, may, fin);
        }
    }

    //Fin de metodo monticulos
    //Inicio metodo peine
    public static Cancion[] peineInt(Cancion[] v) {

        int swaps = 0;

        int grap = v.length - 1;

        while (swaps > 0 || grap > 1) {
            swaps = 0;

            for (int i = v.length - 1; i - grap >= 0; i--) {
                if (v[i].getDuracion().intValue() < v[i - grap].getDuracion().intValue()) {
                    Cancion aux = v[i];
                    v[i] = v[i - grap];
                    v[i - grap] = aux;
                    swaps++;
                }
                if (grap > 1) {
                    grap = (int) (grap / 1.3);
                }
                if (grap == 9 || grap == 10) {
                    grap = 11;
                }
            }

        }

        return v;
    }
    //Date

    public static Cancion[] peineDate(Cancion[] v) {

        int swaps = 0;

        int grap = v.length - 1;

        while (swaps > 0 || grap > 1) {
            swaps = 0;

            for (int i = v.length - 1; i - grap >= 0; i--) {
                if (v[i].getFechaNacimiento().before(v[i - grap].getFechaNacimiento())) {
                    Cancion aux = v[i];
                    v[i] = v[i - grap];
                    v[i - grap] = aux;
                    swaps++;
                }
                if (grap > 1) {
                    grap = (int) (grap / 1.3);
                }
                if (grap == 9 || grap == 10) {
                    grap = 11;
                }
            }

        }

        return v;
    }

    //String
    public static Cancion[] peineString(Cancion[] v) {

        int swaps = 0;

        int grap = v.length - 1;

        while (swaps > 0 || grap > 1) {
            swaps = 0;

            for (int i = v.length - 1; i - grap >= 0; i--) {
                if (v[i].getNombre().compareTo(v[i - grap].getNombre()) < 0) {
                    Cancion aux = v[i];
                    v[i] = v[i - grap];
                    v[i - grap] = aux;
                    swaps++;
                }
                if (grap > 1) {
                    grap = (int) (grap / 1.3);
                }
                if (grap == 9 || grap == 10) {
                    grap = 11;
                }
            }

        }

        return v;
    }

    public void GuardarTiempos(String metodo, String cantidad, String tipoDato) {
        Ordenacion ordenacion = new Ordenacion();
        ordenacion.setMetodo(metodo);
        ordenacion.setTiempo(new BigInteger(totalTiempo + ""));
        ordenacion.setCantidad(new BigInteger(cantidad));
        ordenacion.setTipoDato(tipoDato);
        ctlordenacion.CrearOrdenamiento(ordenacion);
    }
}
