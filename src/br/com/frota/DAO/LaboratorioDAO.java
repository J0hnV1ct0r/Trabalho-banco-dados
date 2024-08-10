package br.com.frota.DAO;

import br.com.frota.model.Laboratorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LaboratorioDAO extends ConexaoDB {

    private static final String INSERT_LABORATORIO_SQL = "INSERT INTO laboratorio (descricao,nome_fantasia,cnes,cnpj,crbm) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_LABORATORIO_BY_ID = "SELECT id, descricao, nome_fantasia, cnes, cnpj, crbm FROM laboratorio WHERE id = ?";
    private static final String SELECT_ALL_LABORATORIO = "SELECT * FROM laboratorio;";
    private static final String DELETE_LABORATORIO_SQL = "DELETE FROM laboratorio WHERE id = ?;";
    private static final String UPDATE_LABORATORIOSQL = "UPDATE laboratorio SET descricao = ?, nome_fantasia = ?, cnes = ?, cnpj = ?, crbm = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM laboratorio;";

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

    public Laboratorio insertLaboratorio(Laboratorio entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_LABORATORIO_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setString(2, entidade.getNome_fantasia());
            preparedStatement.setString(3, entidade.getCnes());
            preparedStatement.setString(4, entidade.getCnpj());
            preparedStatement.setString(5, entidade.getCrbm());
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

    public Laboratorio selectLaboratorio(int id) {
        Laboratorio entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_LABORATORIO_BY_ID, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                String nome_fantasia = rs.getString("nome_fantasia");
                String cnes = rs.getString("cnes");
                String cnpj = rs.getString("cnpj");
                String crbm = rs.getString("crbm");
                entidade = new Laboratorio(id, descricao,nome_fantasia,cnes,cnpj,crbm);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Laboratorio> selectAllLaboratorio() {
        List<Laboratorio> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_LABORATORIO, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                String nome_fantasia = rs.getString("nome_fantasia");
                String cnes = rs.getString("cnes");
                String cnpj = rs.getString("cnpj");
                String crbm = rs.getString("crbm");
                entidades.add(new Laboratorio(id, descricao,nome_fantasia,cnes,cnpj,crbm));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public void deleteLaboratorio(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_LABORATORIO_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.getConnection().close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateLaboratorio(Laboratorio entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_LABORATORIOSQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, entidade.getDescricao());
            statement.setString(2, entidade.getNome_fantasia());
            statement.setString(3, entidade.getCnes());
            statement.setString(4, entidade.getCnpj());
            statement.setString(5, entidade.getCrbm());
            statement.setInt(6, entidade.getId());
            statement.executeUpdate();
            statement.getConnection().close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}