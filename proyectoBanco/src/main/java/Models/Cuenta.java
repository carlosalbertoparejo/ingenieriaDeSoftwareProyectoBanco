package Models;

import java.util.HashMap;
import java.util.Map;

public class Cuenta {
    private String iban;
    private double saldo;

    //Getters setters

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // constructor

    public Cuenta(String iban, double saldo) {
        this.iban = iban;
        this.saldo = saldo;
    }

    //Public map

    public Map <String, Map<String, Cuenta>>
    mapaCuentas = new HashMap<> ();
}
