package br.com.frota.servico;

import br.com.frota.DAO.SolicitacaoExameDAO;
import br.com.frota.model.SolicitacaoExame;

import java.sql.SQLException;
import java.util.List;

public class ServiceSolicitacaoExame {
    private SolicitacaoExameDAO solicitacaoExameDAO = new SolicitacaoExameDAO();

    public SolicitacaoExame Insert(SolicitacaoExame solicitacaoExame) {
        return solicitacaoExameDAO.insert(solicitacaoExame);
    }

    public SolicitacaoExame Selcet(int id) {
        return solicitacaoExameDAO.select(id);
    }

    public List<SolicitacaoExame> SelectAll() {
        return solicitacaoExameDAO.selectAll();
    }

    public void Update(SolicitacaoExame solicitacaoExame) throws SQLException {
        solicitacaoExameDAO.update(solicitacaoExame);
    }

    public void Delete(int id) throws SQLException {
        solicitacaoExameDAO.delete(id);
    }
}
