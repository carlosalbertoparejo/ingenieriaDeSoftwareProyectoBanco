package DbManager.DAOs;

import DbManager.Models.Filmografia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmografiaDao2 {

    private static final String LISTALL = "SELECT * FROM Filmografia;";
    private static final String LISTONE = "SELECT * FROM Filmografia where id = ?";
    private static final String INSERT = "INSERT INTO Filmografia (id, titulo, fecha_estreno, sinopsis, pais_id, clasificacion_id) VALUES (?,?,?,?,?,?);";
    private static final String DELETE = "DELETE FROM Filmografia where id = ?";
    private static final String UPDATE = "UPDATE Filmografia SET titulo = ?, fecha_estreno = ?, sinopsis = ?, pais_id = ?, clasificacion_id = ? WHERE id = ?";




    public void eliminar (int id) throws SQLException {

        PreparedStatement stmt = null;
        try {
            stmt = database_connection.preparedStatement(BORRAR);
            stmt.setInt(1, is);
            stmt.executeUpdate();
            database_connection.commit();
        catch (SQLException e){
            hacerRollback(database_connection);
            throw new SQLException("ERROR");
            }finally {
            cerrarEstados(stmt, null);
            }
        }

    }



    // Mapeo de resultset a filmografía

    private mapToFilmografia(ResultSet rs) throws SQLException {

        return new Filmografia(
                rs.getInt("id");
        rs.getString("titulo");
        rs.getString("fecha_estreno");
        rs.getString("sinopsis");
        rs.getInt("pais_id");
        rs.getInt("clasificacion");

        );

    }

    // Mapeo para cerrar estados

    private void cerrarEstados(PreparedStatement stmt, ResultSet rs) {

        try {

            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }


        } catch (SQLException e) {
            System.out.println("Error al cerrar recursos: " + e.getMessage());
        }

    }
}
