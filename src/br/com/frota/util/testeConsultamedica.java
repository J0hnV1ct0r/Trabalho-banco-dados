package br.com.frota.util;

import br.com.frota.model.ConsultaMedica;
import br.com.frota.model.Especialidade;
import br.com.frota.model.Medico;
import br.com.frota.model.Paciente;
import br.com.frota.servico.ServiceConsultaMedica;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testeConsultamedica {
    public static void main(String[] args) throws ParseException, SQLException {
        String dateSTR = "28-05-2001";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date data = formatter.parse(dateSTR);
        Paciente pac = new Paciente(1,"Maria",data);
        Medico med = new Medico(1,"William Birkin","54551");
        med.setEsp(new Especialidade("virologia","o melhor"));
        med.setEsp(new Especialidade("Anatomia","o melhor"));
        ConsultaMedica consultaMedica =  new ConsultaMedica(data,"88776",pac,med);
        new ServiceConsultaMedica().Insert(consultaMedica);
        System.out.println(new ServiceConsultaMedica().Selcet(1));
        new ServiceConsultaMedica().Update(new ConsultaMedica(1,data,"2653256",pac,med));
        //new ServiceConsultaMedica().Delete(1);
    }
}
