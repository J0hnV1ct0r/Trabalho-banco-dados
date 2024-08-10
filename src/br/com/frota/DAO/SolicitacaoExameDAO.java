package br.com.frota.DAO;

import br.com.frota.model.ConsultaMedica;
import br.com.frota.model.Exame;
import br.com.frota.model.HabilitacaoExame;
import br.com.frota.model.SolicitacaoExame;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SolicitacaoExameDAO extends ConexaoDB{
    private static final String INSERT_SOLICITACAO_EAXAME_SQL = "INSERT INTO solicitacao_exame (n_prescrito, dt_solocitacao, consulta_medica_id, habilitacao_exame_id, exame_id) VALUES (?, ?, ?, ? ,?);";
    private static final String SELECT_SOLICITACAO_EAXAME_BY_ID = "SELECT id, n_prescrito, dt_solocitacao, consulta_medica_id, habilitacao_exame_id, exame_id FROM solicitacao_exame WHERE id = ?";
    private static final String SELECT_ALL_SOLICITACAO_EAXAME = "SELECT * FROM solicitacao_exame;";
    private static final String DELETE_SOLICITACAO_EAXAME_SQL = "DELETE FROM solicitacao_exame WHERE id = ? ;";
    private static final String UPDATE_SOLICITACAO_EAXAME_SQL = "UPDATE solicitacao_exame SET n_prescrito = ?, dt_solocitacao = ?, consulta_medica_id = ?, habilitacao_exame_id = ?, exame_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM solicitacao_exame;";
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
    public SolicitacaoExame insert(SolicitacaoExame entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_SOLICITACAO_EAXAME_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entidade.getnPrescrito());
            preparedStatement.setTimestamp(2, new Timestamp(entidade.getDtSolocitac().getTime()));
            preparedStatement.setInt(3, entidade.getConsultaMedicaId());
            preparedStatement.setInt(4, entidade.gethabilitacaoExameId());
            preparedStatement.setInt(5, entidade.getExameId());
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
    public SolicitacaoExame select(int id) {
        SolicitacaoExame entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_SOLICITACAO_EAXAME_BY_ID, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nPrescrito = rs.getString("n_prescrito");
                Date dt_solocitacao = new Date(rs.getTimestamp("dt_solocitacao").getTime());
                int consultaMedicaId = rs.getInt("consulta_medica_id");
                ConsultaMedicaDAO consultaMedicaDAO = new ConsultaMedicaDAO();
                ConsultaMedica consultaMedica = consultaMedicaDAO.selectConsultaMedica(consultaMedicaId);
                int habilitacaoExameId = rs.getInt("habilitacao_exame_id");
                HabilitacaoExameDAO habilitacaoExameDAO = new HabilitacaoExameDAO();
                HabilitacaoExame habilitacaoExame = habilitacaoExameDAO.select(habilitacaoExameId);
                int exameId = rs.getInt("exame_id");
                ExameDAO exameDAO = new ExameDAO();
                Exame exame = exameDAO.select(exameId);
                entidade = new SolicitacaoExame(id, nPrescrito, dt_solocitacao,consultaMedica,habilitacaoExame,exame);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }
    public List<SolicitacaoExame> selectAll() {
        List<SolicitacaoExame> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_SOLICITACAO_EAXAME, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nPrescrito = rs.getString("n_prescrito");
                Date dt_solocitacao = new Date(rs.getTimestamp("dt_solocitacao").getTime());
                int consultaMedicaId = rs.getInt("consulta_medica_id");
                ConsultaMedicaDAO consultaMedicaDAO = new ConsultaMedicaDAO();
                ConsultaMedica consultaMedica = consultaMedicaDAO.selectConsultaMedica(consultaMedicaId);
                int habilitacaoExameId = rs.getInt("habilitacao_exame_id");
                HabilitacaoExameDAO habilitacaoExameDAO = new HabilitacaoExameDAO();
                HabilitacaoExame habilitacaoExame = habilitacaoExameDAO.select(habilitacaoExameId);
                int exameId = rs.getInt("exame_id");
                ExameDAO exameDAO = new ExameDAO();
                Exame exame = exameDAO.select(exameId);
                entidades.add(new SolicitacaoExame(id, nPrescrito, dt_solocitacao,consultaMedica,habilitacaoExame,exame));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }
    public boolean delete(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_SOLICITACAO_EAXAME_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean update(SolicitacaoExame entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_SOLICITACAO_EAXAME_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, entidade.getnPrescrito());
            statement.setTimestamp(2, new Timestamp(entidade.getDtSolocitac().getTime()));
            statement.setInt(3, entidade.getConsultaMedicaId());
            statement.setInt(4, entidade.gethabilitacaoExameId());
            statement.setInt(5, entidade.getExameId());
            statement.setInt(6, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
