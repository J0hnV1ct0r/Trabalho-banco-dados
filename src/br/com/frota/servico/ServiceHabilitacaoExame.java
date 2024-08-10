package br.com.frota.servico;

import br.com.frota.DAO.HabilitacaoExameDAO;
import br.com.frota.model.HabilitacaoExame;

import java.sql.SQLException;
import java.util.List;

public class ServiceHabilitacaoExame {
    private HabilitacaoExameDAO habilitacaoExameDAO = new HabilitacaoExameDAO();

    public HabilitacaoExame Insert(HabilitacaoExame habilitacaoExame){
        return habilitacaoExameDAO.insert(habilitacaoExame);
    }
    public HabilitacaoExame Selcet(int id){
        return habilitacaoExameDAO.select(id);
    }
    public List<HabilitacaoExame> SelectAll(){
        return habilitacaoExameDAO.selectAll();
    }
    public void Update(HabilitacaoExame habilitacaoExame) throws SQLException {
        habilitacaoExameDAO.update(habilitacaoExame);
    }
    public void Delete(int id) throws SQLException {
        habilitacaoExameDAO.delete(id);
    }
}
