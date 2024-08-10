package br.com.frota.util;


import br.com.frota.model.Especialidade;
import br.com.frota.model.Medico;
import br.com.frota.servico.ServiceMedico;

import java.sql.SQLException;
import java.text.ParseException;

public class Teste {

    public static void main(String[] args) throws SQLException, ParseException {
        //TESTE DE LAORATORIO:
        //INSERT:
            //Laboratorio laboratorio1 = new Laboratorio("melhor medicanico de Nitgh City","Clinica do Viktor","23144","836442846","83746357365");
            //new ServiceLaboratorio().insertLaboratorio(laboratorio1);
            //Laboratorio laboratorio2 = new Laboratorio("Laboratorio central da Umbrella","R.U.L","8575485","993472281252411","778654562463514");
            //new ServiceLaboratorio().insertLaboratorio(laboratorio2);

        //DELETE:
            //new ServiceLaboratorio().deleteLaboratorio(5);
            //new ServiceLaboratorio().deleteLaboratorio(6);

        //SELECT BY ID:
            //Laboratorio retorno = new ServiceLaboratorio().selectLaboratorio(4);
            //System.out.println(retorno.toString());

        //UPDATE:
            //Laboratorio laboratorio3 = new Laboratorio(3,"Melhor medicanico de Nitgh City","Clinica do Viktor","2314499645","836442846","83746357365");
            //new ServiceLaboratorio().updateLaboratorio(laboratorio3);

        //SELECT ALL:
            //List<Laboratorio> entidades = new ServiceLaboratorio().selectAllLaboratorio();
            //for(Laboratorio sai : entidades){
                //System.out.println(sai.toString());
            //}


        //TESTE DE CONTATO:
            //Laboratorio lab = new ServiceLaboratorio().selectLaboratorio(4);

        //INSERT:
            //Contato con1 = new Contato("(85) 925-762-935",lab.getId());
        //new ServiceContato().insertContato(con1);

        //UPDATE:
            //Contato updt = new Contato(1,"(85) 882-152-908",lab.getId());
            //new ServiceContato().updateContato(updt);

        //DELETE:
            //new ServiceContato().deleteContato(3);
            //new ServiceContato().deleteContato(4);

        //SELECT BY ID:
            //Contato sel =  new ServiceContato().selectContato(1);
            //System.out.println(sel.toString());

        ///SELECT ALL:
            //List<Contato> entCon =  new ServiceContato().selectAllContato();
            //for(Contato sai : entCon){
                //System.out.println(sai.toString());
           //}


        //TESTE DE ENDEREÇO:

            //Laboratorio labEnd = new ServiceLaboratorio().selectLaboratorio(4);
            //INSERT:
                //Endereco end = new Endereco("Spencerd","Grande lab","Arkley","56474-9","Raccon City",labEnd.getId(),"666");
                //new ServiceEndereco().insertEndereco(end);
            //UPDATE:
                //Endereco updtEnd = new Endereco(8,"Spencer","Grande lab","Arkley","56474-9","Raccon City",labEnd.getId(),"666");
                //new ServiceEndereco().updateEndereco(updtEnd);
            //DELETE:
                //new ServiceEndereco().deleteEndereco(7);
            //SELECT BY ID:
                //Endereco selEnd = new ServiceEndereco().selectEndereco(8);
                //System.out.println(selEnd);
            //SELECT ALL:
                //List<Endereco>entEnd = new ServiceEndereco().selectAllEndereco();
                //for(Endereco sai : entEnd){
                   // System.out.println(sai.toString());
                //}


        //TESTE DE RESPONSAVEL TECNICO:

            //INSERT:
                //ResponsavelTecnico resp = new ResponsavelTecnico("Misty", "medicina por amor","medicina alternativa","MA");
                //new ServiceResponsavelTecnico().insertResponsavelTecnico(resp);
            //DELETE:
                //new ServiceResponsavelTecnico().deleteResponsavelTecnico(2);
            //UPDATE:
                //ResponsavelTecnico updResp = new ResponsavelTecnico(4,"Misty", "implante ocular","medicina alternativa","MA");
                //new ServiceResponsavelTecnico().updateResponsavelTecnico(updResp);
            //SELECET BY ID:
                //ResponsavelTecnico selResp = new ServiceResponsavelTecnico().selectResponsavelTecnico(3);
                //System.out.println(selResp);
            //SELECT ALL:
                //List<ResponsavelTecnico> allResp = new ServiceResponsavelTecnico().selectAllResponsavelTecnico();
                //for(ResponsavelTecnico sai : allResp){
                    //System.out.println(sai);
                //}


        //TESTE DE RESPONSAVEL HAS LABORATORIO:
            //Laboratorio labRHL = new ServiceLaboratorio().selectLaboratorio(3);
            //ResponsavelTecnico respRHL = new ServiceResponsavelTecnico().selectResponsavelTecnico(4);
            //INSERT:
                //ResponsavelTecnicoHasLaboratorio rhl = new ResponsavelTecnicoHasLaboratorio(labRHL.getId(), respRHL.getId());
                //new ServiceResponsavelTecnicoHasLaboratorio().insertResponsavelTecnicoHasLaboratorio(rhl);
            //SELECT BY ID:
                //ResponsavelTecnicoHasLaboratorio selRHL = new ServiceResponsavelTecnicoHasLaboratorio().selectResponsavelTecnicoHasLaboratorio(2);
                //System.out.println(selRHL);
            //SELECT ALL:
                //List<ResponsavelTecnicoHasLaboratorio> allRHL = new ServiceResponsavelTecnicoHasLaboratorio().selectAllResponsavelTecnicoHasLaboratorio();
                //for(ResponsavelTecnicoHasLaboratorio  sai : allRHL){
                    //System.out.println(sai);
                //}
            //DELETE:
                //new ServiceResponsavelTecnicoHasLaboratorio().deleteResponsavelTecnicoHasLaboratorio(5);
            //UPDATE:
                //ResponsavelTecnicoHasLaboratorio updtRHL = new ResponsavelTecnicoHasLaboratorio(5, labRHL.getId(),respRHL.getId());
                //new ServiceResponsavelTecnicoHasLaboratorio().updateResponsavelTecnicoHasLaboratorio(updtRHL);

        //TESTE DE MEDICO:

            //INSERT:
                Medico med = new Medico("William Birkin","54551");
                med.setEsp(new Especialidade("virologia","o melhor"));
                med.setEsp(new Especialidade("Anatomia","o melhor"));
                new ServiceMedico().insertMedico(med);
            //SELECT BY ALL:
                //Medico selMed = new ServiceMedico().selectMedico(1);
                //System.out.println(selMed);
            //SELECT ALL:
                //List<Medico> allMed = new ServiceMedico().selectAllMedico();
                //for(Medico sai : allMed){
                    //System.out.println(sai);
                //}
            //UPDATE:
                //Medico updtMed = new Medico(2,"Annette Birkin","635584112");
                //new ServiceMedico().updateMedico(updtMed);
            //DELETE:
                //new ServiceMedico().deleteMedico(4);


        //TESTE DE ESPECIALIDADE:
            //INSERT:
                //Especialidade esp = new Especialidade("mdecanio","Mestrado");
                //new ServiceEspecialidade().insertEspecialidade(esp);
            //SELECT BY ALL:
                //Especialidade selEsp = new ServiceEspecialidade().selectEspecialidade(1);
                //System.out.println(selEsp);
            //SELECT ALL:
                //List<Especialidade> allEsp = new ServiceEspecialidade().selectAllEspecialidade();
                //for(Especialidade sai : allEsp){
                    //System.out.println(sai);
                //}
            //UPDATE:
                //Especialidade updtEsp = new Especialidade(3,"medicanico","Mestrado");
                //new ServiceEspecialidade().updateEspecialidade(updtEsp);
            //DELETE:
                //new ServiceEspecialidade().deleteEspecialidade(3);

        //TESTE DE MEDICO HAS ESPECIALIDADE:
            //Medico medMHE = new ServiceMedico().selectMedico(3);
            //Especialidade espMHE = new ServiceEspecialidade().selectEspecialidade(1);
            //INSERT:
                //MedicoHasEspecialidade mhe = new MedicoHasEspecialidade(espMHE.getId(), medMHE.getId());
                //new ServiceMedicoHasEspecialidade().insertMedicoHasEspecialidade(mhe);
            //SELECT BY ALL:
                 //MedicoHasEspecialidade selMHE = new ServiceMedicoHasEspecialidade().selectMedicoHasEspecialidade(2);
                 //System.out.println(selMHE);
            //SELECT ALL:
                 //List<MedicoHasEspecialidade> allMHE = new ServiceMedicoHasEspecialidade().selectAllMedicoHasEspecialidade();
                 //for(MedicoHasEspecialidade sai : allMHE){
                    //System.out.println(sai);
                 //}
            //UPDATE:
                //MedicoHasEspecialidade updtMHE = new MedicoHasEspecialidade(3,espMHE.getId(), medMHE.getId());
                //new ServiceMedicoHasEspecialidade().updateMedicoHasEspecialidade(updtMHE);
            //DELETE:
                //new ServiceMedicoHasEspecialidade().deleteMedicoHasEspecialidade(4);


    }


}
