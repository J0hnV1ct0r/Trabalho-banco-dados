package br.com.frota.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static br.com.frota.DAO.ConexaoDB.prapararSQL;

public class limpa {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String[] tabelas = {"contato","resultado_exame","laudo"," solicitacao_exame","consulta_medica","paciente","medico_has_especialidade","especialidade","medico","composicao","composicao_exame","valor_referencia_composicao_exame","unidade_medida","exame","habilitacao_exame","material_exame","tipo_exame","responsavel_tecnico_has_laboratorio","responsavel_tecnico","endereco","laboratorio"};
         for(String tabela : tabelas){
             String delete = "DELETE FROM " + tabela +";";
             String reseteq = "ALTER SEQUENCE " + tabela + "_id_seq RESTART;";
             try(PreparedStatement statement = prapararSQL(delete, Statement.RETURN_GENERATED_KEYS)){
                 statement.executeUpdate();
                 statement.getConnection().close();
             }catch (SQLException e) {
                 printSQLException(e);
             } catch (ClassNotFoundException e) {
                 throw new RuntimeException(e);
             }
             try(PreparedStatement statement = prapararSQL(reseteq, Statement.RETURN_GENERATED_KEYS)){
                 statement.executeUpdate();
                 statement.getConnection().close();
             }catch (SQLException e) {
                 printSQLException(e);
             } catch (ClassNotFoundException e) {
                 throw new RuntimeException(e);
             }
         }


    }


    private static void printSQLException(SQLException e) {
    }
}


