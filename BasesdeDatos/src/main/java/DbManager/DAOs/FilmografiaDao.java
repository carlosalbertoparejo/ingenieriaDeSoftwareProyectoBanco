package DbManager.DAOs;

import DbManager.Models.Filmografia;
import java.sql.*;

public class FilmografiaDao {

    private static final String LISTALL = "SELECT * FROM Filmografia";
    private static final String LISTONE = "SELECT * FROM Filmografia WHERE id = ?";
    private static final String INSERT = "INSERT INTO Filmografia(id, titulo, fecha_estreno, sinopsis, pais_id, clasificacion_id) VALUES (?,?,?,?,?,?)";
    private static final String DELETE = "DELETE FROM Filmografia WHERE id = ?";
    private static final String UPDATE = "UPDATE Filmografia SET titulo = ?, fecha_estreno = ?, sinopsis = ?, pais_id = ?, clasificacion_id = ? WHERE id = ?";

    private Connection dataBase;

    public FilmografiaDao(Connection dataBase) {
        this.dataBase = dataBase;
    }

    // ---------------------------------------------------------
    // LISTAR TODOS
    // ---------------------------------------------------------
    public void listAll() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = dataBase.prepareStatement(LISTALL);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Filmografia f = mapToFilmografia(rs);
                System.out.println(f.getTitulo());
            }

        } catch (SQLException e) {
            System.out.println("Error al listar todos: " + e.getMessage());

        } finally {
            cerrarEstados(stmt, rs);
        }
    }

    // ---------------------------------------------------------
    // LISTAR UNO POR ID
    // ---------------------------------------------------------
    public Filmografia listOne(int id) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = dataBase.prepareStatement(LISTONE);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                return mapToFilmografia(rs);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar uno: " + e.getMessage());

        } finally {
            cerrarEstados(stmt, rs);
        }

        return null;
    }

    // ---------------------------------------------------------
    // INSERTAR (tu estilo)
    // ---------------------------------------------------------
    public boolean insert(Filmografia f) {

        PreparedStatement stmt = null;

        try {
            stmt = dataBase.prepareStatement(INSERT);

            stmt.setInt(1, f.getId());
            stmt.setString(2, f.getTitulo());
            stmt.setString(3, f.getFecha_estreno());
            stmt.setString(4, f.getSinopsis());
            stmt.setInt(5, f.getPais_id());
            stmt.setInt(6, f.getClasificacion_id());

            int filas = stmt.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
            return false;

        } finally {
            cerrarEstados(stmt, null);
        }
    }

    // ACTUALIZAR
    public boolean update(Filmografia f) {

        PreparedStatement stmt = null;

        try {
            stmt = dataBase.prepareStatement(UPDATE);

            stmt.setString(1, f.getTitulo());
            stmt.setString(2, f.getFecha_estreno());
            stmt.setString(3, f.getSinopsis());
            stmt.setInt(4, f.getPais_id());
            stmt.setInt(5, f.getClasificacion_id());
            stmt.setInt(6, f.getId());

            int filas = stmt.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
            return false;

        } finally {
            cerrarEstados(stmt, null);
        }
    }

    // BORRAR
    public boolean delete(int id) {

        PreparedStatement stmt = null;
        boolean borrado = false;

        try {
            stmt = dataBase.prepareStatement(DELETE);
            stmt.setInt(1, id);

            int filas = stmt.executeUpdate();
            borrado = filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al borrar: " + e.getMessage());
            borrado = false;

        } finally {
            cerrarEstados(stmt, null);
        }

        return borrado;
    }


    // ---------------------------------------------------------
    // MAPEO RESULTSET → OBJETO
    // ---------------------------------------------------------
    private Filmografia mapToFilmografia(ResultSet rs) throws SQLException {
        return new Filmografia(
                rs.getInt("id"),
                rs.getString("titulo"),
                rs.getString("fecha_estreno"),
                rs.getString("sinopsis"),
                rs.getInt("pais_id"),
                rs.getInt("clasificacion_id")
        );
    }

    // ---------------------------------------------------------
    // CERRAR ESTADOS
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
