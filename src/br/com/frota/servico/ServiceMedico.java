package br.com.frota.servico;

import br.com.frota.DAO.EspecialidadeDAO;
import br.com.frota.DAO.MedicoDAO;
import br.com.frota.DAO.MedicoHasEspecialidadeDAO;
import br.com.frota.model.Especialidade;
import br.com.frota.model.Medico;
import br.com.frota.model.MedicoHasEspecialidade;

import java.sql.SQLException;
import java.util.List;

public class ServiceMedico extends MedicoDAO {
    private MedicoDAO medicoDAO = new MedicoDAO();
    private EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
    private MedicoHasEspecialidadeDAO medicoHasEspecialidadeDAO = new MedicoHasEspecialidadeDAO();



    public Medico insertMedico(Medico medNovo) {
       medicoDAO.insertMedico(medNovo);
       for(Especialidade r : medNovo.getEsp()){
           especialidadeDAO.insertEspecialidade(r);
       }
       for(Especialidade r : medNovo.getEsp()){
           medicoHasEspecialidadeDAO.insertMedicoHasEspecialidade(new MedicoHasEspecialidade(r,medNovo));
       }
        return medNovo;
    }


    public Medico selectMedico(Medico med) {
       return medicoDAO.selectMedico(med.getId());
    }


    public List<Medico> selectAllMedico() {
        return medicoDAO.selectAllMedico();
    }


    public void deleteMedico(Medico med) throws SQLException {
        for(Especialidade e : med.getEsp()){
            especialidadeDAO.deleteEspecialidade(e.getId());
        }
         medicoHasEspecialidadeDAO.deleteMedicoHasEspecialidade(med);
         medicoDAO.deleteMedico(med.getId());
    }


    public void updateMedico(Medico med) throws SQLException {
       medicoDAO.updateMedico(med);
    }
    public void updateEspecialidade(Medico med){


    }
}
