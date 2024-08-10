package br.com.frota.DAO;

import br.com.frota.model.HabilitacaoExame;
import br.com.frota.model.Laboratorio;
import br.com.frota.model.TipoExame;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HabilitacaoExameDAO extends ConexaoDB {

    private static final String INSER_HABILITACAO_EXAME_SQL = "INSERT INTO habilitacao_exame (observacao, custo, laboratorio_id, tipo_exame_id) VALUES (?, ?, ?, ?);";
    private static final String SELECT_HABILITACAO_EXAME_BY_ID = "SELECT id, observacao, custo, laboratorio_id, tipo_exame_id  FROM habilitacao_exame WHERE id = ?;";
    private static final String SELECT_ALL_HABILITACAO_EXAME = "SELECT * FROM habilitacao_exame;";
    private static final String DELETE_HABILITACAO_EXAME_SQL = "DELETE FROM habilitacao_exame WHERE id = ?;";
    private static final String UPDATE_HABILITACAO_EXAME_SQL = "UPDATE habilitacao_exame SET observacao = ?, custo = ?, laboratorio_id = ?, tipo_exame_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM habilitacao_exame;";

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

    public HabilitacaoExame insert(HabilitacaoExame entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSER_HABILITACAO_EXAME_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entidade.getObservacao());
            preparedStatement.setInt(2, entidade.getCusto());
            preparedStatement.setInt(3, entidade.getLaboratorioId());
            preparedStatement.setInt(4, entidade.getTipoExameId());
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

    public HabilitacaoExame select(int id) {
        HabilitacaoExame entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_HABILITACAO_EXAME_BY_ID, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String observacao  = rs.getString("observacao");
                int custo = rs.getInt("custo");
                int laboratorio_id  = rs.getInt("laboratorio_id");
                LaboratorioDAO laboratorioDAO = new LaboratorioDAO();
                Laboratorio lab = laboratorioDAO.selectLaboratorio(laboratorio_id);
                int tipo_exame_id = rs.getInt("tipo_exame_id");
                TipoExameDAO tipoExameDAO = new TipoExameDAO();
                TipoExame tipoExame = tipoExameDAO.selectTipoExame(tipo_exame_id);
                entidade = new HabilitacaoExame(id, observacao, custo, lab, tipoExame);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<HabilitacaoExame> selectAll() {
        List<HabilitacaoExame> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_HABILITACAO_EXAME, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String observacao  = rs.getString("observacao");
                int custo = rs.getInt("custo");
                int laboratorio_id  = rs.getInt("laboratorio_id");
                LaboratorioDAO laboratorioDAO = new LaboratorioDAO();
                Laboratorio lab = laboratorioDAO.selectLaboratorio(laboratorio_id);
                int tipo_exame_id = rs.getInt("tipo_exame_id");
                TipoExameDAO tipoExameDAO = new TipoExameDAO();
                TipoExame tipoExame = tipoExameDAO.selectTipoExame(tipo_exame_id);
                entidades.add(new HabilitacaoExame(id, observacao, custo, lab, tipoExame));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean delete(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_HABILITACAO_EXAME_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean update(HabilitacaoExame entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_HABILITACAO_EXAME_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, entidade.getObservacao());
            statement.setInt(2, entidade.getCusto());
            statement.setInt(3, entidade.getLaboratorioId());
            statement.setInt(4, entidade.getTipoExameId());
            statement.setInt(5, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}