/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Cancion;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebastian
 */
public class controladorCancion extends CtlAbstracto<Cancion>{

    public controladorCancion() {
        super(Cancion.class);
    }
    
     public void CrearCancion(Cancion entity) {
        super.create(entity);
    }

    public Cancion BuscarCancion(BigDecimal id) {
        return super.find(id);
    }

    public void EditarCancion(Cancion entity) {
        super.edit(entity);
    }

    public void EliminarCancion(BigDecimal id) {
        super.remove(super.find(id));
    }

    public List<Cancion> ListarCancion(String tabla) {
        return super.findAll(tabla);
    }
}
