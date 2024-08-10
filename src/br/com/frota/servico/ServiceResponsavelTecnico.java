package br.com.frota.servico;

import br.com.frota.DAO.ResponsavelTecnicoDAO;
import br.com.frota.model.ResponsavelTecnico;

import java.sql.SQLException;
import java.util.List;

public class ServiceResponsavelTecnico extends ResponsavelTecnicoDAO {

    //public void insertResponsavelTecnico(ResponsavelTecnico entidade) {
        //super.insertResponsavelTecnico(entidade);
   // }

    @Override
    public ResponsavelTecnico selectResponsavelTecnico(int id) {
        return super.selectResponsavelTecnico(id);
    }

    @Override
    public List<ResponsavelTecnico> selectAllResponsavelTecnico() {
        return super.selectAllResponsavelTecnico();
    }

    @Override
    public boolean deleteResponsavelTecnico(int id) throws SQLException {
        return super.deleteResponsavelTecnico(id);
    }

    @Override
    public boolean updateResponsavelTecnico(ResponsavelTecnico entidade) throws SQLException {
        return super.updateResponsavelTecnico(entidade);
    }
}
