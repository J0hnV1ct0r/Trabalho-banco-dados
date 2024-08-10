package br.com.frota.DAO;

import br.com.frota.model.ComposicaoExame;
import br.com.frota.model.UnidadeMedida;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ComposicaoExameDAO extends ConexaoDB {

    private static final String INSERT_COMPOSICAO_EXAME_SQL = "INSERT INTO composicao_exame (descricao, uidade_medida_id) VALUES (?, ?);";
    private static final String SELECT_COMPOSICAO_EXAME_BY_ID = "SELECT id, descricao, uidade_medida_id  FROM composicao_exame WHERE id = ?;";
    private static final String SELECT_ALL_COMPOSICAO_EXAME = "SELECT * FROM composicao_exame;";
    private static final String DELETE_COMPOSICAO_EXAME_SQL = "DELETE FROM composicao_exame WHERE id = ?;";
    private static final String UPDATE_COMPOSICAO_EXAME_SQL = "UPDATE composicao_exame SET descricao = ?, uidade_medida_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM composicao_exame;";

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

    public ComposicaoExame insert(ComposicaoExame entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_COMPOSICAO_EXAME_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setInt(2, entidade.getUnidadeMedidaId());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
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

    public ComposicaoExame select(int id) {
        ComposicaoExame entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_COMPOSICAO_EXAME_BY_ID, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                int unidade_medida_id = rs.getInt("uidade_medida_id");
                UnidadeMedidaDAO unimed = new UnidadeMedidaDAO();
                UnidadeMedida uni = unimed.select(unidade_medida_id);
                entidade = new ComposicaoExame(id, descricao, uni);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<ComposicaoExame> selectAll() {
        List<ComposicaoExame> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_COMPOSICAO_EXAME, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                int unidade_medida_id = rs.getInt("uidade_medida_id");
                UnidadeMedidaDAO unimed = new UnidadeMedidaDAO();
                UnidadeMedida uni = unimed.select(unidade_medida_id);
                entidades.add(new ComposicaoExame(id, descricao, uni));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public void delete(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_COMPOSICAO_EXAME_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.getConnection().close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(ComposicaoExame entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_COMPOSICAO_EXAME_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, entidade.getDescricao());
            statement.setInt(2, entidade.getUnidadeMedidaId());
            statement.setInt(3, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}