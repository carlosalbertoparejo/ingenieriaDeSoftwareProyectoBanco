package DbManager.DAOs;

import java.sql.Connection;

public abstract class DAO <T> {

    protected Connection conexion;

    // Métodos
    public abstract void insertar (T dato_insertar);
    public abstract void actualizar (T dato_actualizar);
    public abstract void eliminar (int id);
    public abstract void listarUno ( int id);
    public abstract void listarTodos ();

}
