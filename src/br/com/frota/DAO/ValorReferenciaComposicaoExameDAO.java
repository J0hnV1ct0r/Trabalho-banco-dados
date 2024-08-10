package br.com.frota.DAO;


import br.com.frota.model.UnidadeMedida;
import br.com.frota.model.ValorReferenciaComposicaoExame;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ValorReferenciaComposicaoExameDAO extends ConexaoDB {

    private static final String INSER_VALOR_REFERENCIA_COMPOSICAO_EXAME_SQL = "INSERT INTO valor_referencia_composicao_exame (valor_minimo, valor_maximo, limitador_minimo, limitador_maximo, unidade_medida_id) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_VALOR_REFERENCIA_COMPOSICAO_EXAME_BY_ID = "SELECT id,valor_minimo, valor_maximo, limitador_minimo, limitador_maximo, unidade_medida_id FROM valor_referencia_composicao_exame WHERE id = ?;";
    private static final String SELECT_ALL_VALOR_REFERENCIA_COMPOSICAO_EXAME = "SELECT * FROM valor_referencia_composicao_exame;";
    private static final String DELETE_VALOR_REFERENCIA_COMPOSICAO_EXAME_SQL = "DELETE FROM valor_referencia_composicao_exame WHERE id = ?;";
    private static final String UPDATE_VALOR_REFERENCIA_COMPOSICAO_EXAME_SQL = "UPDATE valor_referencia_composicao_exame SET valor_minimo = ?, valor_maximo = ?, limitador_minimo = ?, limitador_maximo = ?, unidade_medida_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM valor_referencia_composicao_exame;";

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

    public ValorReferenciaComposicaoExame insert(ValorReferenciaComposicaoExame entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSER_VALOR_REFERENCIA_COMPOSICAO_EXAME_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entidade.getValorMinimo());
            preparedStatement.setString(2, entidade.getValorMaximo());
            preparedStatement.setString(3, entidade.getLimitadorMinimo());
            preparedStatement.setString(4, entidade.getLimitadorMaximo());
            preparedStatement.setInt(5, entidade.getUnidadeMedidaId());
            preparedStatement.executeUpdate();
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

    public ValorReferenciaComposicaoExame select(int id) {
        ValorReferenciaComposicaoExame entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_VALOR_REFERENCIA_COMPOSICAO_EXAME_BY_ID, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String valorMinimo  = rs.getString("valor_minimo");
                String valorMaximo = rs.getString("valor_maximo");
                String limitadorMinimo  = rs.getString("limitador_minimo");
                String limitadorMaximo = rs.getString("limitador_maximo");
                int unidadeMedidaId  = rs.getInt("unidade_medida_id");
                UnidadeMedidaDAO unimed = new UnidadeMedidaDAO();
                UnidadeMedida uni = unimed.select(unidadeMedidaId);
                entidade = new ValorReferenciaComposicaoExame(id,valorMinimo, valorMaximo, limitadorMinimo, limitadorMaximo, uni);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<ValorReferenciaComposicaoExame> selectAll() {
        List<ValorReferenciaComposicaoExame> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_VALOR_REFERENCIA_COMPOSICAO_EXAME, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String valorMinimo  = rs.getString("valor_minimo");
                String valorMaximo = rs.getString("valor_maximo");
                String limitadorMinimo  = rs.getString("limitador_minimo");
                String limitadorMaximo = rs.getString("limitador_maximo");
                int unidadeMedidaId  = rs.getInt("unidade_medida_id");
                UnidadeMedidaDAO unimed = new UnidadeMedidaDAO();
                UnidadeMedida uni = unimed.select(unidadeMedidaId);
                entidades.add(new ValorReferenciaComposicaoExame(id,valorMinimo, valorMaximo, limitadorMinimo, limitadorMaximo, uni));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean delete(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_VALOR_REFERENCIA_COMPOSICAO_EXAME_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(ValorReferenciaComposicaoExame entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_VALOR_REFERENCIA_COMPOSICAO_EXAME_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, entidade.getValorMinimo());
            statement.setString(2, entidade.getValorMaximo());
            statement.setString(3, entidade.getLimitadorMinimo());
            statement.setString(4, entidade.getLimitadorMaximo());
            statement.setInt(5, entidade.getUnidadeMedidaId());
            statement.setInt(6, entidade.getId());
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}