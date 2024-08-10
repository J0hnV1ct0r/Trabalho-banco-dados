package br.com.frota.DAO;

import br.com.frota.model.Contato;
import br.com.frota.model.Laboratorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO extends ConexaoDB {

    private static final String INSER_CONTATO_SQL = "INSERT INTO contato (telefone, id_laboratorio) VALUES (?, ?);";
    private static final String SELECT_CONTATO_BY_ID = "SELECT id, telefone, id_laboratorio  FROM contato WHERE id = ?;";
    private static final String SELECT_CONTATO_BY_LABORATORIO = "SELECT id, telefone, id_laboratorio  FROM contato WHERE id_laboratorio = ?;";
    private static final String SELECT_ALL_CONTATO_EXAME = "SELECT * FROM contato;";
    private static final String DELETE_CONTATO_EXAME_SQL = "DELETE FROM contato WHERE id = ?;";
    private static final String UPDATE_CONTATO_SQL = "UPDATE contato SET telefone = ?, id_laboratorio = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM contato;";

    public Integer count() {
        Integer count = 0;
        try (PreparedStatement preparedStatement = prapararSQL(TOTAL, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public Contato insertContato(Contato entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSER_CONTATO_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entidade.getTelefone());
            preparedStatement.setInt(2, entidade.getLaboratorioId());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
                entidade.setId(resultSet.getInt(1));
            }
            preparedStatement.getConnection().close();
            return entidade;
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public Contato selectContato(int id) {
        Contato entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_CONTATO_BY_ID, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String telefone  = rs.getString("telefone");
                int id_laboratorio = rs.getInt("id_laboratorio");
                Laboratorio lab = new LaboratorioDAO().selectLaboratorio(id_laboratorio);
                entidade = new Contato(id, telefone, lab);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Contato> selectAllContato() {
        List<Contato> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_CONTATO_EXAME, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String telefone  = rs.getString("telefone");
                int id_laboratorio = rs.getInt("id_laboratorio");
                Laboratorio lab = new LaboratorioDAO().selectLaboratorio(id_laboratorio);
                entidades.add(new Contato(id, telefone, lab));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }
    public List<Contato> selectContatoByLab(Laboratorio labEnt) {
        List<Contato> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_CONTATO_BY_LABORATORIO, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, labEnt.getId());
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String telefone  = rs.getString("telefone");
                int id_laboratorio = rs.getInt("id_laboratorio");
                Laboratorio lab = new LaboratorioDAO().selectLaboratorio(id_laboratorio);
                entidades.add(new Contato(id, telefone, lab));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }
    public void deleteContato(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_CONTATO_EXAME_SQL, Statement.RETURN_GENERATED_KEYS)) {
             statement.setInt(1, id);
             statement.executeUpdate();
             statement.getConnection().close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateContato(Contato entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_CONTATO_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, entidade.getTelefone());
            statement.setInt(2, entidade.getLaboratorioId());
            statement.setInt(3, entidade.getId());
            statement.executeUpdate();
            statement.getConnection().close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}