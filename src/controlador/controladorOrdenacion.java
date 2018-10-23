/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.math.BigDecimal;
import java.util.List;
import modelo.Cancion;
import modelo.Ordenacion;

/**
 *
 * @author sebastian
 */
public class controladorOrdenacion extends CtlAbstracto<Ordenacion> {

   

    public controladorOrdenacion(Class<Ordenacion> entityClass) {
        super(Ordenacion.class);
    }

   
    public void CrearOrdenamiento(Ordenacion entity) {
        super.create(entity);
    }

    public Ordenacion BuscarOrdenamiento(BigDecimal id) {
        return super.find(id);
    }

    public void EditarOrdenamieno(Ordenacion entity) {
        super.edit(entity);
    }

    public void EliminarOrdenamieno(BigDecimal id) {
        super.remove(super.find(id));
    }

    public List<Ordenacion> ListarOrdenamieno(String tabla) {
        return super.findAll(tabla);
    }

}
