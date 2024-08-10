package br.com.frota.DAO;


import br.com.frota.model.Composicao;
import br.com.frota.model.Laudo;
import br.com.frota.model.ResultadoExame;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResultadoExameDAO extends ConexaoDB{
    private static final String INSERT_RESULTADO_EXAME_SQL = "INSERT INTO resultado_exame (dt_exame, valor, composicao_id, laudo_id) VALUES (?,?,?,?);";
    private static final String SELECT_RESULTADO_EXAME_BY_ID = "SELECT id,dt_exame, valor, composicao_id, laudo_id FROM resultado_exame WHERE id = ?";
    private static final String SELECT_ALL_RESULTADO_EXAME = "SELECT * FROM resultado_exame;";
    private static final String DELETE_RESULTADO_EXAME_SQL = "DELETE FROM resultado_exame WHERE id = ?;";
    private static final String UPDATE_RESULTADO_EXAME_SQL = "UPDATE resultado_exame SET dt_exame = ?, valor = ?, composicao_id = ?, laudo_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM resultado_exame;";
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
    public ResultadoExame insert(ResultadoExame entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_RESULTADO_EXAME_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setTimestamp(1, new Timestamp(entidade.getDtExame().getTime()));
            preparedStatement.setString(2, entidade.getValor());
            preparedStatement.setInt(3, entidade.getComposicaoId());
            preparedStatement.setInt(4, entidade.getLaudoId());
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
    public ResultadoExame select(int id) {
        ResultadoExame entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_RESULTADO_EXAME_BY_ID, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Date dtExame = new Date(rs.getTimestamp("dt_exame").getTime());
                String valor = rs.getString("valor");
                ComposicaoDAO comp = new ComposicaoDAO();
                Composicao comps = comp.select(rs.getInt("composicao_id"));
                LaudoDAO laudo = new LaudoDAO();
                Laudo lau = laudo.select(rs.getInt("laudo_id"));
                entidade = new ResultadoExame(id, dtExame,valor, comps,lau);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }
    public List<ResultadoExame> selectAll() {
        List<ResultadoExame> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_RESULTADO_EXAME, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                Date dtExame = new Date(rs.getTimestamp("dt_exame").getTime());
                String valor = rs.getString("valor");
                ComposicaoDAO comp = new ComposicaoDAO();
                Composicao comps = comp.select(rs.getInt("composicao_id"));
                LaudoDAO laudo = new LaudoDAO();
                Laudo lau = laudo.select(rs.getInt("laudo_id"));
                entidades.add(new ResultadoExame(id, dtExame,valor, comps,lau));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }
    public boolean delete(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_RESULTADO_EXAME_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean update(ResultadoExame entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_RESULTADO_EXAME_SQL, Statement.RETURN_GENERATED_KEYS)) {

            statement.setTimestamp(1, new Timestamp(entidade.getDtExame().getTime()));
            statement.setString(2,entidade.getValor());
            statement.setInt(3,entidade.getComposicaoId());
            statement.setInt(4,entidade.getLaudoId());
            statement.setInt(5, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
