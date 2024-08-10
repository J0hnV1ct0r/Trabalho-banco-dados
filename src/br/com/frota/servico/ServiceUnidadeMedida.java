package br.com.frota.servico;

import br.com.frota.DAO.UnidadeMedidaDAO;
import br.com.frota.model.UnidadeMedida;

import java.sql.SQLException;
import java.util.List;

public class ServiceUnidadeMedida {
    private UnidadeMedidaDAO unidadeMedidaDAO = new UnidadeMedidaDAO();

    public UnidadeMedida Insert(UnidadeMedida unidadeMedida) {
        return unidadeMedidaDAO.insert(unidadeMedida);
    }

    public UnidadeMedida Selcet(int id) {
        return unidadeMedidaDAO.select(id);
    }

    public List<UnidadeMedida> SelectAll() {
        return unidadeMedidaDAO.selectAll();
    }

    public void Update(UnidadeMedida unidadeMedida) throws SQLException {
        unidadeMedidaDAO.update(unidadeMedida);
    }

    public void Delete(int id) throws SQLException {
        unidadeMedidaDAO.delete(id);
    }
}
