/* 
 * Copyright (C) 2017 c.penaloza.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package co.edu.uniandes.csw.habitaciones.dtos;

import co.edu.uniandes.csw.habitaciones.entities.ReservaEntity;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

 @XmlRootElement
public class ReservaDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Long codigoReserva;
    private Date fechaInicio;
    private Date fechaFin;
    private Double costo;
    private Character estado;
    private MultaDTO multa;
    private HabitacionDTO habitacion;
    private ViviendaDTO vivienda;
    
    
    public ReservaDTO(){
        super();
    }

    public ReservaDTO(ReservaEntity entity){
        if(entity!=null){
            this.codigoReserva =  entity.getCodigoReserva();
            this.costo = entity.getCosto();
            this.estado = entity.getEstado();
            this.fechaInicio = entity.getFechaInicio();
            this.fechaFin = entity.getFechaFin();
            this.vivienda = new ViviendaDTO(entity.getVivienda());
            this.multa = new MultaDTO(entity.getMulta());
            this.habitacion = new HabitacionDTO(entity.getHabitacion());
            }
    }
    
    public ReservaEntity toEntity() {
        ReservaEntity entity = new ReservaEntity();
        
        entity.setCodigoReserva(this.getCodigoReserva());
        entity.setEstado(this.getEstado());
        entity.setFechaInicio(this.getFechaInicio());
        entity.setFechaFin(this.getFechaFin());
        if( entity.getHabitacion() !=null)
        {
            entity.setHabitacion(this.getHabitacion().toEntity());
        }
        if( entity.getVivienda() != null)
        {
            entity.setVivienda(this.getVivienda().toEntity());
        }
        if( entity.getMulta() != null)
        {
            entity.setMulta(this.getMulta().toEntity());
        }
        
      return entity;  
    }

    public Long getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(Long codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public MultaDTO getMulta() {
        return multa;
    }

    public void setMulta(MultaDTO multa) {
        this.multa = multa;
    }

    public HabitacionDTO getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(HabitacionDTO habitacion) {
        this.habitacion = habitacion;
    }

    public ViviendaDTO getVivienda() {
        return vivienda;
    }

    public void setVivienda(ViviendaDTO vivienda) {
        this.vivienda = vivienda;
    }
    
    
}

