package br.com.frota.servico;

import br.com.frota.DAO.ResultadoExameDAO;
import br.com.frota.model.ResultadoExame;

import java.sql.SQLException;
import java.util.List;

public class ServiceResultadoExame {
    private ResultadoExameDAO resultadoExameDAO = new ResultadoExameDAO();

    public ResultadoExame Insert(ResultadoExame resultadoExame){
        return resultadoExameDAO.insert(resultadoExame);
    }
    public ResultadoExame Selcet(int id){
        return resultadoExameDAO.select(id);
    }
    public List<ResultadoExame> SelectAll(){
        return resultadoExameDAO.selectAll();
    }
    public void Update(ResultadoExame resultadoExame) throws SQLException {
        resultadoExameDAO.update(resultadoExame);
    }
    public void Delete(int id) throws SQLException {
        resultadoExameDAO.delete(id);
    }
}
