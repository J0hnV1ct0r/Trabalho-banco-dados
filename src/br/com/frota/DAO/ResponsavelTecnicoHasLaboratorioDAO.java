package br.com.frota.DAO;


import br.com.frota.model.Laboratorio;
import br.com.frota.model.ResponsavelTecnico;
import br.com.frota.model.ResponsavelTecnicoHasLaboratorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ResponsavelTecnicoHasLaboratorioDAO extends ConexaoDB {

    private static final String INSERT_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL = "INSERT INTO responsavel_tecnico_has_laboratorio (laboratorio_id,responsavel_tecnico_id) VALUES (?, ?);";
    private static final String SELECT_RESPONSAVEL_TECNICO_HAS_LABORATORIO_BY_ID = "SELECT laboratorio_id, responsavel_tecnico_id FROM responsavel_tecnico_has_laboratorio WHERE laboratorio_id = ?";
    private static final String SELECT_ALL_RESPONSAVEL_TECNICO_HAS_LABORATORIO = "SELECT * FROM responsavel_tecnico_has_laboratorio;";
    private static final String DELETE_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL = "DELETE FROM responsavel_tecnico_has_laboratorio WHERE laboratorio_id = ?;";
    private static final String UPDATE_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL = "UPDATE responsavel_tecnico_has_laboratorio SET laboratorio_id = ?, responsavel_tecnico_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM responsavel_tecnico_has_laboratorio;";

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

    public ResponsavelTecnicoHasLaboratorio insertResponsavelTecnicoHasLaboratorio(ResponsavelTecnicoHasLaboratorio entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, entidade.getLaboratorioId());
            preparedStatement.setInt(2, entidade.getResponsavelTecnico());
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

    public List<ResponsavelTecnicoHasLaboratorio> selectResponsavelTecnicoHasLaboratorio(Laboratorio lab) {
        List<ResponsavelTecnicoHasLaboratorio> entidade = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_RESPONSAVEL_TECNICO_HAS_LABORATORIO_BY_ID, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, lab.getId());
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                ResponsavelTecnicoDAO responsavelTecnicoDAO = new ResponsavelTecnicoDAO();

                int responsavel_tecnico = rs.getInt("responsavel_tecnico_id");
                ResponsavelTecnico resp = responsavelTecnicoDAO.selectResponsavelTecnico(responsavel_tecnico);
                entidade.add(new ResponsavelTecnicoHasLaboratorio(lab, resp));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<ResponsavelTecnicoHasLaboratorio> selectAllResponsavelTecnicoHasLaboratorio() {
        List<ResponsavelTecnicoHasLaboratorio> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_RESPONSAVEL_TECNICO_HAS_LABORATORIO, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                LaboratorioDAO laboratorioDAO = new LaboratorioDAO();
                ResponsavelTecnicoDAO responsavelTecnicoDAO = new ResponsavelTecnicoDAO();
                int laboratorio_id = rs.getInt("laboratorio_id");
                Laboratorio lab = laboratorioDAO.selectLaboratorio(laboratorio_id);
                int responsavel_tecnico = rs.getInt("responsavel_tecnico_id");
                ResponsavelTecnico resp = responsavelTecnicoDAO.selectResponsavelTecnico(responsavel_tecnico);
                entidades.add(new ResponsavelTecnicoHasLaboratorio(lab, resp));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public void deleteResponsavelTecnicoHasLaboratorio(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.getConnection().close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateResponsavelTecnicoHasLaboratorio(ResponsavelTecnicoHasLaboratorio entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, entidade.getLaboratorioId());
            statement.setInt(2, entidade.getResponsavelTecnico());
            statement.setInt(3, entidade.getId());
            statement.executeUpdate();
            statement.getConnection().close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}