package DbManager;

public class Main {
    public static void main(String[] args) {

        DbManager db = new DbManager(); // ahora sin parámetros

        db.conectar();
        db.desconectar();
    }
}
