package Models;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Movimiento {

    private Date fechaMovimiento;
    private String iban;
    private double cantidad;

    //Getters y  setters
    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    // COnstructor


    public Movimiento(Date fechaMovimiento, String iban, double cantidad) {
        this.fechaMovimiento = fechaMovimiento;
        this.iban = iban;
        this.cantidad = cantidad;
    }

    //Public map

    public Map<String, List<Movimiento>>
    mapaMovimientos = new HashMap<>();
}


