package co.edu.uniandes.csw.habitaciones.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class MultaEntity {
    
    private String codigoReserva;

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }
    
    @Temporal(TemporalType.TIMESTAMP) 
    private Date fechaCancelacion;
    
    @Temporal(TemporalType.TIMESTAMP) 
    private Date fechaPago;

    public Date getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(Date fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
    
    @Override
    public int hashCode() {
        if (this.getCodigoReserva()!= null) {
            return this.getCodigoReserva().hashCode();
        }
        return super.hashCode();
    }
}