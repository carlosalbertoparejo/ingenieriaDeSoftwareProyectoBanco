package DAOs;

import DbManager.Models.Filmografia;
import java.sql.*;

public class FilmografiaDao {

    private static final String LISTALL = "Select * from Filmografia";
    private static final String LISTONE = "Select * from Filmografia where id = ?";
    private static final String INSERT = "insert into Filmografia(id, titulo, fecha_estreno, sinopsis, pais_id, clasificacion_id) values (?,?,?,?,?,?)";
    private static final String DELETE = "delete from Filmografia where id = ?";
    private static final String UPDATE = "update Filmografia set titulo = ?, fecha_estreno = ?, sinopsis = ?, pais_id = ?, clasificacion_id = ? where id = ?";

    private Connection dataBase;

    public FilmografiaDao(Connection dataBase) {
        this.dataBase = dataBase;
    }

/*
    // Listar todos
    public List<Filmografia> listAll() throws SQLException {
        List<Filmografia> lista = new ArrayList<>();

        try (PreparedStatement stmt = dataBase.prepareStatement(LISTALL);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(mapToFilmografia(rs));
            }
        }
        return lista;
    }
*/

    // Listar con cerrarEstados

    public void listAll() throws SQLException {

        ResultSet rs = null;
        PreparedStatement stmt = null;

        try {
            stmt = dataBase.prepareStatement(LISTALL);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Filmografia f = mapToFilmografia(rs);

                System.out.println(
                        "id: " + f.getId() +
                                "Título: " + f.getTitulo() +
                                "Fecha estreno: " + f.getFecha_estreno() +
                                "Sinopsis: " + f.getSinopsis() +
                                "ID País: " + f.getPais_id() +
                                "Categoría: " + f.getClasificacion_id()

                );
            }


        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());

        }finally {
            cerrarEstados(stmt, rs);
        }

    }

    // Listar uno por id
    public Filmografia listOne ( int id) throws SQLException {
        try (PreparedStatement stmt = dataBase.prepareStatement(LISTONE)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapToFilmografia(rs);
                }
            }
        }
        return null;
    }

    //Insertar

    public boolean insert (Filmografia f) throws SQLException {

        try (PreparedStatement stmt = dataBase.prepareStatement(INSERT)) {

            stmt.setInt(1, f.getId());
            stmt.setString(2, f.getTitulo());
            stmt.setString(3, f.getFecha_estreno());
            stmt.setString(4, f.getSinopsis());
            stmt.setInt(5, f.getPais_id());
            stmt.setInt(6, f.getClasificacion_id());

            return stmt.executeUpdate() > 0;

        }
    }

    // Actualizar

    public boolean update(Filmografia f) throws SQLException {

        try (PreparedStatement stmt = dataBase.prepareStatement(UPDATE)) {

            stmt.setString(1, f.getTitulo());
            stmt.setString(2, f.getFecha_estreno());
            stmt.setString(3, f.getSinopsis());
            stmt.setInt(4, f.getPais_id());
            stmt.setInt(5, f.getClasificacion_id());
            stmt.setInt(6, f.getId()); // este es el WHERE

            return stmt.executeUpdate() > 0;
        }
    }


    //BORRAR

    public boolean delete ( int id) throws SQLException {

        try (PreparedStatement stmt = dataBase.prepareStatement(DELETE)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        }

    }

    // Mapeo ResultSet → Objeto
    private Filmografia mapToFilmografia (ResultSet rs) throws SQLException {
        return new Filmografia(
                rs.getInt("id"),
                rs.getString("titulo"),
                rs.getString("fecha_estreno"),
                rs.getString("sinopsis"),
                rs.getInt("pais_id"),
                rs.getInt("clasificacion_id")
        );
    }

    //método para cerrar estados

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

