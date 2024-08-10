package br.com.frota.DAO;



import br.com.frota.model.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PacienteDAO extends ConexaoDB {

    private static final String INSERT_PACIENTE_SQL = "INSERT INTO paciente (nome, dt_nascimento) VALUES (?,?);";
    private static final String SELECT_PACIENTE_BY_ID = "SELECT id,nome,dt_nascimento FROM paciente WHERE id = ?";
    private static final String SELECT_ALL_PACIENTE = "SELECT * FROM paciente;";
    private static final String DELETE_PACIENTE_SQL = "DELETE FROM paciente WHERE id = ? ;";
    private static final String UPDATE_PACIENTE_SQL = "UPDATE paciente SET nome = ?, dt_nascimento = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM paciente;";

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

    public Paciente insertPaciente(Paciente entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_PACIENTE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entidade.getNome());
            preparedStatement.setTimestamp(2, new Timestamp(entidade.getDtNascimento().getTime()));
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

    public Paciente selectPaciente(int id) {
        Paciente entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_PACIENTE_BY_ID, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                Date dt_nascimento = new Date(rs.getTimestamp("dt_nascimento").getTime());
                entidade = new Paciente(id, nome, dt_nascimento);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Paciente> selectAllPaciente() {
        List<Paciente> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_PACIENTE, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                Date dt_nascimento = new Date(rs.getTimestamp("dt_nascimento").getTime());
                entidades.add(new Paciente(id, nome, dt_nascimento));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deletePaciente(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_PACIENTE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updatePaciente(Paciente entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_PACIENTE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, entidade.getNome());
            statement.setTimestamp(2, new Timestamp(entidade.getDtNascimento().getTime()));
            statement.setInt(3, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}