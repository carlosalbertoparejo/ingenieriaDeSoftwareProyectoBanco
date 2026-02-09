package DbManager.Models;

public class Cuenta {
    private int id_cuenta;
    private String tipo_cuenta;
    private String nombre;
    private String passwordHash;

    public Cuenta (int id_cuenta, String tipo_cuenta, String nombre, String passwordHash) {
        this.id_cuenta = id_cuenta;
        this.tipo_cuenta = tipo_cuenta;
        this.nombre = nombre;
        this.passwordHash= passwordHash;
        
    }
}
