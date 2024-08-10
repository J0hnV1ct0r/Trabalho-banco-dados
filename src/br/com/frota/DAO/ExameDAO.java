package br.com.frota.DAO;

import br.com.frota.model.Exame;
import br.com.frota.model.MaterialExame;
import br.com.frota.model.TipoExame;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExameDAO extends ConexaoDB{
    private static final String INSERT_EXAME_SQL = "INSERT INTO exame (descricao,  metodo, tipo_exame_id, material_exame_id) VALUES (?, ?, ?, ?);";
    private static final String SELECT_EXAME_BY_ID = "SELECT id, descricao,  metodo, tipo_exame_id, material_exame_id  FROM exame WHERE id = ?;";
    private static final String SELECT_ALL_EXAME = "SELECT * FROM exame;";
    private static final String DELETE_EXAME_SQL = "DELETE FROM exame WHERE id = ?;";
    private static final String UPDATE_EXAME_SQL = "UPDATE exame SET descricao = ?,  metodo = ?, tipo_exame_id = ?, material_exame_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM exame;";
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
    public Exame insert(Exame entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_EXAME_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setString(2, entidade.getMetodo());
            preparedStatement.setInt(3, entidade.getTipoExameId());
            preparedStatement.setInt(4, entidade.getMaterialExameId());
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
    public Exame select(int id) {
        Exame entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_EXAME_BY_ID, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao  = rs.getString("descricao");
                String metodo = rs.getString("metodo");
                int material_exame_id  = rs.getInt("material_exame_id");
                MaterialExameDAO materialExameDAO = new MaterialExameDAO();
                MaterialExame materialExame = materialExameDAO.select(material_exame_id);
                int tipo_exame_id = rs.getInt("tipo_exame_id");
                TipoExameDAO tipoExameDAO = new TipoExameDAO();
                TipoExame tipoExame = tipoExameDAO.selectTipoExame(tipo_exame_id);
                entidade = new Exame(id, descricao, metodo, materialExame, tipoExame);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }
    public List<Exame> selectAll() {
        List<Exame> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_EXAME, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao  = rs.getString("descricao");
                String metodo = rs.getString("metodo");
                int material_exame_id  = rs.getInt("material_exame_id");
                MaterialExameDAO materialExameDAO = new MaterialExameDAO();
                MaterialExame materialExame = materialExameDAO.select(material_exame_id);
                int tipo_exame_id = rs.getInt("tipo_exame_id");
                TipoExameDAO tipoExameDAO = new TipoExameDAO();
                TipoExame tipoExame = tipoExameDAO.selectTipoExame(tipo_exame_id);
                entidades.add(new Exame(id, descricao, metodo, materialExame, tipoExame));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }
    public boolean delete(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_EXAME_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean update(Exame entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_EXAME_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, entidade.getDescricao());
            statement.setString(2, entidade.getMetodo());
            statement.setInt(3, entidade.getTipoExameId());
            statement.setInt(4, entidade.getMaterialExameId());
            statement.setInt(5, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
