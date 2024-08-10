package br.com.frota.servico;

import br.com.frota.DAO.ComposicaoExameDAO;
import br.com.frota.model.ComposicaoExame;

import java.sql.SQLException;
import java.util.List;

public class ServiceComposicaoExame {
    private ComposicaoExameDAO composicaoExameDAO = new ComposicaoExameDAO();

    public ComposicaoExame Insert(ComposicaoExame composicaoExame){
        return composicaoExameDAO.insert(composicaoExame);
    }
    public ComposicaoExame Selcet(int id){
        return composicaoExameDAO.select(id);
    }
    public List<ComposicaoExame> SelectAll(){
        return composicaoExameDAO.selectAll();
    }
    public void Update(ComposicaoExame composicaoExame) throws SQLException {
        composicaoExameDAO.update(composicaoExame);
    }
    public void Delete(int id) throws SQLException {
        composicaoExameDAO.delete(id);
    }
}
