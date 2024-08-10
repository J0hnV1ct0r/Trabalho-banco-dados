package br.com.frota.servico;

import br.com.frota.DAO.ValorReferenciaComposicaoExameDAO;
import br.com.frota.model.ValorReferenciaComposicaoExame;

import java.sql.SQLException;
import java.util.List;

public class ServicoValorReferenciaComposicaoExame {
    private ValorReferenciaComposicaoExameDAO valorReferenciaComposicaoExameDAO = new ValorReferenciaComposicaoExameDAO();

    public ValorReferenciaComposicaoExame Insert(ValorReferenciaComposicaoExame valorReferenciaComposicaoExame) {
        return valorReferenciaComposicaoExameDAO.insert(valorReferenciaComposicaoExame);
    }

    public ValorReferenciaComposicaoExame Selcet(int id) {
        return valorReferenciaComposicaoExameDAO.select(id);
    }

    public List<ValorReferenciaComposicaoExame> SelectAll() {
        return valorReferenciaComposicaoExameDAO.selectAll();
    }

    public void Update(ValorReferenciaComposicaoExame valorReferenciaComposicaoExame) throws SQLException {
        valorReferenciaComposicaoExameDAO.update(valorReferenciaComposicaoExame);
    }

    public void Delete(int id) throws SQLException {
        valorReferenciaComposicaoExameDAO.delete(id);
    }
}
