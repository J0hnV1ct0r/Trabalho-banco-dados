package br.com.frota.DAO;

import br.com.frota.model.Endereco;
import br.com.frota.model.Laboratorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO extends ConexaoDB {

    private static final String INSERT_ENDERECO_SQL = "INSERT INTO endereco (rua,complemento,bairo,cep,cidade,id_laboratorio,numero) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ENDERECO_BY_ID = "SELECT id, rua, complemento, bairo, cep, cidade, id_laboratorio, numero FROM endereco WHERE id = ?";
    private static final String SELECT_ALL_ENDERECO = "SELECT * FROM endereco;";
    private static final String DELETE_ENDERECO_SQL = "DELETE FROM endereco WHERE id = ?;";
    private static final String UPDATE_ENDERECOSQL = "UPDATE endereco SET rua = ?, complemento = ?, bairo = ?, cep = ?, cidade = ?, id_laboratorio = ?, numero = ? WHERE id_laboratorio = ?;";
    private static final String TOTAL = "SELECT count(1) FROM endereco;";

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

    public Endereco insertEndereco(Endereco entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_ENDERECO_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entidade.getRua());
            preparedStatement.setString(2, entidade.getComplemento());
            preparedStatement.setString(3, entidade.getBairo());
            preparedStatement.setString(4, entidade.getCep());
            preparedStatement.setString(5, entidade.getCidade());
            preparedStatement.setInt(6, entidade.getLaboratorioId());
            preparedStatement.setString(7, entidade.getNumero());
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

    public Endereco selectEndereco(Laboratorio lab) {
        Endereco entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ENDERECO_BY_ID, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, lab.getId());
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String rua = rs.getString("rua");
                String complemento = rs.getString("complemento");
                String bairo = rs.getString("bairo");
                String cep = rs.getString("cep");
                String cidade = rs.getString("cidade");
                String numero = rs.getString("numero");
                entidade = new Endereco(id, rua, complemento, bairo, cep, cidade, lab, numero);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Endereco> selectAllEndereco() {
        List<Endereco> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_ENDERECO, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String rua = rs.getString("rua");
                String complemento = rs.getString("complemento");
                String bairo = rs.getString("bairo");
                String cep = rs.getString("cep");
                String cidade = rs.getString("cidade");
                int id_laboratorio = rs.getInt("id_laboratorio");
                Laboratorio lab = new LaboratorioDAO().selectLaboratorio(id_laboratorio);
                String numero = rs.getString("numero");
                entidades.add(new Endereco(id, rua, complemento, bairo, cep, cidade, lab,numero));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public void deleteEndereco(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_ENDERECO_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.getConnection().close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateEndereco(Endereco entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_ENDERECOSQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, entidade.getRua());
            statement.setString(2, entidade.getComplemento());
            statement.setString(3, entidade.getBairo());
            statement.setString(4, entidade.getCep());
            statement.setString(5, entidade.getCidade());
            statement.setInt(6, entidade.getLaboratorioId());
            statement.setString(7, entidade.getNumero());
            statement.setInt(8, entidade.getId());
            statement.executeUpdate();
            statement.getConnection().close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}