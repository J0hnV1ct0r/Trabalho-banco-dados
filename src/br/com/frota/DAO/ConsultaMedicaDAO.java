package br.com.frota.DAO;

import br.com.frota.model.ConsultaMedica;
import br.com.frota.model.Medico;
import br.com.frota.model.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsultaMedicaDAO extends ConexaoDB {

    private static final String INSER_CONSULTA_MEDICA_SQL = "INSERT INTO consulta_medica (dt_consulta, nm_atendimento, paciente_id, medico_id) VALUES (?, ?, ?,?);";
    private static final String SELECT_CONSULTA_MEDICA_BY_ID = "SELECT id, dt_consulta, nm_atendimento, paciente_id, medico_id  FROM consulta_medica WHERE id = ?;";
    private static final String SELECT_ALL_CONSULTA_MEDICA = "SELECT * FROM consulta_medica;";
    private static final String DELETE_CONSULTA_MEDICA_SQL = "DELETE FROM consulta_medica WHERE id = ?;";
    private static final String UPDATE_CONSULTA_MEDICA_SQL = "UPDATE consulta_medica SET dt_consulta = ?, nm_atendimento = ?, paciente_id = ?, medico_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM consulta_medica;";

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

    public ConsultaMedica insertConsultaMedica(ConsultaMedica entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSER_CONSULTA_MEDICA_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setTimestamp(1,new Timestamp(entidade.getDtConsulta().getTime()));
            preparedStatement.setString(2, entidade.getNmAtendimento());
            preparedStatement.setInt(3, entidade.getPacienteId());
            preparedStatement.setInt(4, entidade.getMedicoId());
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

    public ConsultaMedica selectConsultaMedica(int id) {
        ConsultaMedica entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_CONSULTA_MEDICA_BY_ID, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                PacienteDAO pacienteDAO = new PacienteDAO();
                MedicoDAO medicoDAO = new MedicoDAO();
                Date dt_consulta  = new Date(rs.getTimestamp("dt_consulta").getTime());
                int paciente_id = rs.getInt("paciente_id");
                Paciente pac = pacienteDAO.selectPaciente(paciente_id);
                String nm_atendimento = rs.getString("nm_atendimento");
                int medico_id = rs.getInt("medico_id");
                Medico med = medicoDAO.selectMedico(medico_id);

                entidade = new ConsultaMedica(id, dt_consulta, nm_atendimento, pac,med);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<ConsultaMedica> selectAllConsultaMedica() {
        List<ConsultaMedica> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_CONSULTA_MEDICA, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                PacienteDAO pacienteDAO = new PacienteDAO();
                MedicoDAO medicoDAO = new MedicoDAO();
                int id = rs.getInt("id");
                Date dt_consulta  = new Date(rs.getTimestamp("dt_consulta").getTime());
                int paciente_id = rs.getInt("paciente_id");
                Paciente pac = pacienteDAO.selectPaciente(paciente_id);
                String nm_atendimento = rs.getString("nm_atendimento");
                int medico_id = rs.getInt("medico_id");
                Medico med = medicoDAO.selectMedico(medico_id);
                entidades.add(new ConsultaMedica(id, dt_consulta, nm_atendimento, pac,med));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteConsultaMedica(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_CONSULTA_MEDICA_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateConsultaMedica(ConsultaMedica entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_CONSULTA_MEDICA_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setTimestamp(1,new Timestamp(entidade.getDtConsulta().getTime()));
            statement.setString(2, entidade.getNmAtendimento());
            statement.setInt(3, entidade.getPacienteId());
            statement.setInt(4, entidade.getMedicoId());
            statement.setInt(5, entidade.getId());
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}