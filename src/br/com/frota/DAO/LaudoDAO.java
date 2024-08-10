package br.com.frota.DAO;

import br.com.frota.model.Laudo;
import br.com.frota.model.SolicitacaoExame;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LaudoDAO extends ConexaoDB {

    private static final String INSERT_LAUDO_SQL = "INSERT INTO laudo (assinatura_digital, dt_resultado, codigo, solicitacao_exame_id) VALUES (?, ?, ?, ?);";
    private static final String SELECT_LAUDO_BY_ID = "SELECT id, assinatura_digital, dt_resultado, codigo, solicitacao_exame_id FROM laudo WHERE id = ?";
    private static final String SELECT_ALL_LAUDO = "SELECT * FROM laudo;";
    private static final String DELETE_LAUDO_SQL = "DELETE FROM laudo WHERE id = ?;";
    private static final String UPDATE_LAUDOSQL = "UPDATE laudo SET assinatura_digital = ?, dt_resultado = ?, codigo = ?, solicitacao_exame_id = ?  WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM laudo;";

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

    public Laudo insert(Laudo entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_LAUDO_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entidade.getAssinaturaDigital());
            preparedStatement.setString(2, entidade.getDtResultado());
            preparedStatement.setString(3, entidade.getCodigo());
            preparedStatement.setInt(4, entidade.getSolicitacaoExameId());
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

    public Laudo select(int id) {
        Laudo entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_LAUDO_BY_ID, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String assinaturaDigital = rs.getString("assinatura_digital");
                String dt_resultado = rs.getString("dt_resultado");
                String codigo = rs.getString("codigo");
                int solicitacao_exame_id = rs.getInt("solicitacao_exame_id");
                SolicitacaoExameDAO solicitacaoExameDAO = new SolicitacaoExameDAO();
                SolicitacaoExame solicitacaoExame = solicitacaoExameDAO.select(solicitacao_exame_id);
                entidade = new Laudo(id,assinaturaDigital, dt_resultado, codigo, solicitacaoExame);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Laudo> selectAll() {
        List<Laudo> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_LAUDO, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String assinaturaDigital = rs.getString("assinatura_digital");
                String dt_resultado = rs.getString("dt_resultado");
                String codigo = rs.getString("codigo");
                int solicitacao_exame_id = rs.getInt("solicitacao_exame_id");
                SolicitacaoExameDAO solicitacaoExameDAO = new SolicitacaoExameDAO();
                SolicitacaoExame solicitacaoExame = solicitacaoExameDAO.select(solicitacao_exame_id);
                entidades.add(new Laudo(id,assinaturaDigital, dt_resultado, codigo, solicitacaoExame));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean delete(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_LAUDO_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(Laudo entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_LAUDOSQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, entidade.getAssinaturaDigital());
            statement.setString(2, entidade.getDtResultado());
            statement.setString(3, entidade.getCodigo());
            statement.setInt(4, entidade.getSolicitacaoExameId());
            statement.setInt(5, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}