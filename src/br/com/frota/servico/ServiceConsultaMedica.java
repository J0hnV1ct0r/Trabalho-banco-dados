package br.com.frota.servico;

import br.com.frota.DAO.ConsultaMedicaDAO;
import br.com.frota.model.ConsultaMedica;

import java.sql.SQLException;
import java.util.List;

public class ServiceConsultaMedica {
    private ConsultaMedicaDAO consultaMedicaDAO = new ConsultaMedicaDAO();

    public ConsultaMedica Insert(ConsultaMedica consultaMedica){
        return consultaMedicaDAO.insertConsultaMedica(consultaMedica);
    }
    public ConsultaMedica Selcet(int id){
        return consultaMedicaDAO.selectConsultaMedica(id);
    }
    public List<ConsultaMedica> SelectAll(){
        return consultaMedicaDAO.selectAllConsultaMedica();
    }
    public void Update(ConsultaMedica consultaMedica) throws SQLException {
        consultaMedicaDAO.updateConsultaMedica(consultaMedica);
    }
    public void Delete(int id) throws SQLException {
        consultaMedicaDAO.deleteConsultaMedica(id);
    }
}
