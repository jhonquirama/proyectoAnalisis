/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.math.BigDecimal;
import java.util.List;
import modelo.Cancion;
import modelo.Operaciones;

/**
 *
 * @author sebastian
 */
public class controladorOperaciones extends CtlAbstracto<Operaciones> {

    public controladorOperaciones(Class<Operaciones> entityClass) {
        super(Operaciones.class);
    }

    public void CrearOperacion(Operaciones entity) {
        super.create(entity);
    }

    public Operaciones BuscarOperacion(BigDecimal id) {
        return super.find(id);
    }

    public void EditarOperacion(Operaciones entity) {
        super.edit(entity);
    }

    public void EliminarOperaciones(BigDecimal id) {
        super.remove(super.find(id));
    }

    public List<Operaciones> ListarOperaciones(String tabla) {
        return super.findAll(tabla);
    }

}
