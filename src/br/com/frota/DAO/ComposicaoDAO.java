package br.com.frota.DAO;

import br.com.frota.model.Composicao;
import br.com.frota.model.ComposicaoExame;
import br.com.frota.model.Exame;
import br.com.frota.model.ValorReferenciaComposicaoExame;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ComposicaoDAO extends ConexaoDB {

    private static final String INSER_COMPOSICAO_MEDICA_SQL = "INSERT INTO composicao (exame_id, composicao_exame_id, valor_referencia_composicao_exame_id) VALUES (?, ?, ?);";
    private static final String SELECT_COMPOSICAO_BY_ID = "SELECT id, exame_id, composicao_exame_id, valor_referencia_composicao_exame_id  FROM composicao WHERE id = ?;";
    private static final String SELECT_ALL_COMPOSICAO = "SELECT * FROM composicao;";
    private static final String DELETE_COMPOSICAO_SQL = "DELETE FROM composicao WHERE id = ?;";
    private static final String UPDATE_COMPOSICAO_SQL = "UPDATE composicao SET exame_id = ?, composicao_exame_id =  ?, valor_referencia_composicao_exame_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM composicao;";

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

    public Composicao insert(Composicao entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSER_COMPOSICAO_MEDICA_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, entidade.getExameId());
            preparedStatement.setInt(2, entidade.getComposicaoExameId());
            preparedStatement.setInt(3, entidade.getValorReferenciaComposicaoExameId());
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

    public Composicao select(int id) {
        Composicao entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_COMPOSICAO_BY_ID, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int exameId = rs.getInt("exame_id");
                ExameDAO exameDAO = new ExameDAO();
                Exame exame =exameDAO.select(exameId);
                int composicaoExameId = rs.getInt("composicao_exame_id");
                ComposicaoExameDAO composicaoExameDAO = new ComposicaoExameDAO();
                ComposicaoExame composicaoExame = composicaoExameDAO.select(composicaoExameId);
                int valorReferenciaComposicaoExameId  = rs.getInt("valor_referencia_composicao_exame_id");
                ValorReferenciaComposicaoExameDAO valorReferenciaComposicaoExameDAO = new ValorReferenciaComposicaoExameDAO();
                ValorReferenciaComposicaoExame valorReferenciaComposicaoExame = valorReferenciaComposicaoExameDAO.select(valorReferenciaComposicaoExameId);

                entidade = new Composicao(id, exame, composicaoExame, valorReferenciaComposicaoExame);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Composicao> selectAll() {
        List<Composicao> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_COMPOSICAO, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int exameId = rs.getInt("exame_id");
                ExameDAO exameDAO = new ExameDAO();
                Exame exame =exameDAO.select(exameId);
                int composicaoExameId = rs.getInt("composicao_exame_id");
                ComposicaoExameDAO composicaoExameDAO = new ComposicaoExameDAO();
                ComposicaoExame composicaoExame = composicaoExameDAO.select(composicaoExameId);
                int valorReferenciaComposicaoExameId  = rs.getInt("valor_referencia_composicao_exame_id");
                ValorReferenciaComposicaoExameDAO valorReferenciaComposicaoExameDAO = new ValorReferenciaComposicaoExameDAO();
                ValorReferenciaComposicaoExame valorReferenciaComposicaoExame = valorReferenciaComposicaoExameDAO.select(valorReferenciaComposicaoExameId);
                entidades.add(new Composicao(id, exame, composicaoExame, valorReferenciaComposicaoExame));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public void delete(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_COMPOSICAO_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.getConnection().close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Composicao entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_COMPOSICAO_SQL, Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, entidade.getExameId());
            statement.setInt(2, entidade.getComposicaoExameId());
            statement.setInt(3, entidade.getValorReferenciaComposicaoExameId());
            statement.setInt(4, entidade.getId());
            statement.executeUpdate();
            statement.getConnection().close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}