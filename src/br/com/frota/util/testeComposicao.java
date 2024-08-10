package br.com.frota.util;

import br.com.frota.model.*;
import br.com.frota.servico.ServiceComposicao;

import java.sql.SQLException;

public class testeComposicao {
    public static void main(String[] args) throws SQLException {
        UnidadeMedida un = new UnidadeMedida(2,"muito grande");
        ComposicaoExame composicaoExame = new ComposicaoExame(2,"uma descricao aqui",un);
        MaterialExame materialExame = new MaterialExame(2,"Sangue","contaminado");
        ValorReferenciaComposicaoExame valorReferenciaComposicaoExame = new ValorReferenciaComposicaoExame(3,"76342","742356234","2345672","873456",un);
        TipoExame tipoExame = new TipoExame(2,"sonda louca", "meia-noite te conto");
        Exame exame = new Exame(1,"abrir ao meio","no bisturi",materialExame,tipoExame);
        ServiceComposicao serviceComposicao = new ServiceComposicao();
        Composicao composicao = new Composicao(exame,composicaoExame,valorReferenciaComposicaoExame);
        serviceComposicao.Insert(composicao);
        System.out.println(serviceComposicao.Selcet(1));
        Composicao composicao2 = new Composicao(1,exame,composicaoExame,valorReferenciaComposicaoExame);
        serviceComposicao.Update(composicao2);
        serviceComposicao.Delete(1);
    }
}
