package Models;

import java.util.HashMap;
import java.util.Map;

public class Usuario {

        private String dni;
        private String password;

        //Getters y setters
        public String getDni() {
            return dni;
        }

        public void setDni(String dni) {
            this.dni = dni;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        //Constructor

        public Usuario(String dni, String password) {
            this.dni = dni;
            this.password = password;
        }

        //Public map

        public Map<String, Usuario>
        mapaUsuario = new HashMap<>();
}
