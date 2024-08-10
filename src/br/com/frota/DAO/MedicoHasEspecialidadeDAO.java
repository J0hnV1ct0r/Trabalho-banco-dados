package br.com.frota.DAO;

import br.com.frota.model.Especialidade;
import br.com.frota.model.Medico;
import br.com.frota.model.MedicoHasEspecialidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedicoHasEspecialidadeDAO extends ConexaoDB {
    private static final String INSER_MEDICO_HAS_ESPECIALIDADE_SQL = "INSERT INTO medico_has_especialidade (medico_id, especialidade_id) VALUES (?, ?);";
    private static final String SELECT_MEDICO_HAS_ESPECIALIDADE_BY_ID = "SELECT especialidade_id, medico_id  FROM medico_has_especialidade WHERE especialidade_id = ?;";
    private static final String SELECT_ALL_MEDICO_HAS_ESPECIALIDADE = "SELECT * FROM medico_has_especialidade;";
    private static final String DELETE_MEDICO_HAS_ESPECIALIDADE_SQL = "DELETE FROM medico_has_especialidade WHERE medico_id = ?;";
    private static final String UPDATE_MEDICO_HAS_ESPECIALIDADE_SQL = "UPDATE medico_has_especialidade SET  especialidade_id = ? WHERE medico_id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM medico_has_especialidade;";

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

    public MedicoHasEspecialidade insertMedicoHasEspecialidade(MedicoHasEspecialidade entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSER_MEDICO_HAS_ESPECIALIDADE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, entidade.getMedicoId());
            preparedStatement.setInt(2, entidade.getEspecialidadeId());
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

    public MedicoHasEspecialidade selectMedicoHasEspecialidade(Especialidade especialidade_id) {
        MedicoHasEspecialidade entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_MEDICO_HAS_ESPECIALIDADE_BY_ID, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, especialidade_id.getId());
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                MedicoDAO med = new MedicoDAO();
                Medico medico_id =  med.selectMedico(rs.getInt("medico_id"));
                entidade = new MedicoHasEspecialidade (especialidade_id,medico_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<MedicoHasEspecialidade> selectAllMedicoHasEspecialidade() {
        List<MedicoHasEspecialidade> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_MEDICO_HAS_ESPECIALIDADE, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                MedicoDAO med = new MedicoDAO();
                Medico medico_id =  med.selectMedico(rs.getInt("medico_id"));
                EspecialidadeDAO esp = new EspecialidadeDAO();
                Especialidade especialidade_id = esp.selectEspecialidade(rs.getInt("especialidade_id"));
                entidades.add(new MedicoHasEspecialidade( especialidade_id,medico_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteMedicoHasEspecialidade(Medico medico) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_MEDICO_HAS_ESPECIALIDADE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, medico.getId());
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateMedicoHasEspecialidade(MedicoHasEspecialidade entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_MEDICO_HAS_ESPECIALIDADE_SQL, Statement.RETURN_GENERATED_KEYS)) {


            statement.setInt(1, entidade.getEspecialidadeId());
            statement.setInt(2, entidade.getMedicoId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
