package br.com.frota.util;

import br.com.frota.model.TipoExame;
import br.com.frota.servico.ServiceTipoExama;

import java.sql.SQLException;

public class testeTipoExame {
    public static void main(String[] args) throws SQLException {
        ServiceTipoExama serviceTipoExama = new ServiceTipoExama();
        TipoExame tipoExame = new TipoExame("sonda louca", "meia-noite te conto");
        serviceTipoExama.Insert(tipoExame);
        //System.out.println(serviceTipoExama.Selcet(1));
        //TipoExame tipoExame2 = new TipoExame(1,"sonda louca", "meia-noite te conto");
        //serviceTipoExama.Update(tipoExame2);
        //serviceTipoExama.Delete(1);
    }
}
