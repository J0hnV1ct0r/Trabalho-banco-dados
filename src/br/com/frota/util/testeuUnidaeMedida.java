package br.com.frota.util;

import br.com.frota.model.UnidadeMedida;
import br.com.frota.servico.ServiceUnidadeMedida;

import java.sql.SQLException;

public class testeuUnidaeMedida {


    public static void main(String[] args) throws SQLException {
        UnidadeMedida uni = new UnidadeMedida("grande");
        ServiceUnidadeMedida serviceUnidadeMedida = new ServiceUnidadeMedida();
        serviceUnidadeMedida.Insert(uni);
        System.out.println(serviceUnidadeMedida.Selcet(1));
        serviceUnidadeMedida.Delete(1);
        UnidadeMedida un = new UnidadeMedida(2,"muito grande");
        serviceUnidadeMedida.Update(un);
    }
}
