package br.com.frota.util;

import br.com.frota.model.Paciente;
import br.com.frota.servico.ServicePaciente;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestePaciente {
    public static void main(String[] args) throws SQLException, ParseException{
        String dateSTR = "28-05-2001";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date data = formatter.parse(dateSTR);
        //INSERT:
            Paciente pac = new Paciente("Maria",data);
            new ServicePaciente().insertPaciente(pac);
        //SELECT:
            Paciente selPac = new ServicePaciente().selectPaciente(1);
            System.out.println(selPac);
            Paciente pac2 = new Paciente(1,"Diana",data);
            new br.com.frota.util.ServicePaciente().Update(pac2);
            new br.com.frota.util.ServicePaciente().Delete(1);
    }
}
