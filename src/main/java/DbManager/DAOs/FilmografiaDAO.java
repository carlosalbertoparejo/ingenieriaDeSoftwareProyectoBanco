package DbManager.DAOs;

import DbManager.Models.Filmografia;

import java.sql.Connection;

public class FilmografiaDao {

    private static final String LISTALL = "SELECT * FROM Filmografia";

    try (Connection conexion = conexion.getConnection();
    PreparedStatement stmt = conexion.prepareStatement(sql);
    ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Filmografia film = new Filmografia();
            film.setId(rs.getInt("id"));
            film.setTitulo(rs.getString("titulo"));
            film.setFecha_estreno(rs.getString("fecha"));
            film.setSinopsis(rs.getString("sinopsis"));
            film.setPais_id(rs.getInt("pais_id"));
            film.setClasificacion_id(rs.getInt("clasificacion"));

            lista.addFirst(film);
        }
    } catch (Exception e) {
        System.out.println("Error al listar filmografía " + e.getMessage());

    }

    private static final String LISTONE = "SELECT * FROM Filmografia WHERE id =? ";

        public Filmografia listone(int id) {

            stmt.setInt(1, id);

            try (Connection conexion = conexion.getConnection();
                 if(rs.next()) {
                     Filmografia film = new Filmografia();

                     film.setId(rs.getInt("id"));
                     film.setTitulo(rs.getString("titulo"));
                     film.setFecha_estreno(rs.getString("fecha"));
                     film.setSinopsis(rs.setString("sinopsis"));
                     film.setPais_id(rs.setString("id pais"));
                     film.setClasificacion_id(rs.setString("clasificacion"));
            }
        }


}


