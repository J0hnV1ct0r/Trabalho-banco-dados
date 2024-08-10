package br.com.frota.util;

import br.com.frota.model.Especialidade;
import br.com.frota.model.Medico;
import br.com.frota.servico.ServiceEspecialidade;
import br.com.frota.servico.ServiceMedico;

import java.sql.SQLException;
import java.text.ParseException;

public class testeMHE {
    public static void main(String[] args) throws SQLException, ParseException{
        Medico medMHE = new ServiceMedico().selectMedico(3);
        Especialidade espMHE = new ServiceEspecialidade().selectEspecialidade(2);
        //INSERT:
        //MedicoHasEspecialidade mhe = new MedicoHasEspecialidade(espMHE, medMHE);
        //new ServiceMedicoHasEspecialidade().InsertMedicoHasEspecialidade(mhe);
        //SELECT BY ALL:
          //MedicoHasEspecialidade selMHE = new ServiceMedicoHasEspecialidade().SelectMedicoHasEspecialidade(espMHE);
          //System.out.println(selMHE);
        //SELECT ALL:
        //List<MedicoHasEspecialidade> allMHE = new ServiceMedicoHasEspecialidade().SelectAllMedicoHasEspecialidade();
        //for(MedicoHasEspecialidade sai : allMHE){
          //System.out.println(sai);
         //}
        //UPDATE:
        //MedicoHasEspecialidade updtMHE = new MedicoHasEspecialidade(3,espMHE,medMHE);
        //new ServiceMedicoHasEspecialidade().UpdateMedicoHasEspecialidade(updtMHE);
        //DELETE:
        //new ServiceMedicoHasEspecialidade().DeleteMedicoHasEspecialidade(medMHE);
    }
}
