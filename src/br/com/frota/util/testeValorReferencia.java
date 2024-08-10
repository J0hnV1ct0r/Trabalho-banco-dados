package br.com.frota.util;

import br.com.frota.model.UnidadeMedida;
import br.com.frota.model.ValorReferenciaComposicaoExame;
import br.com.frota.servico.ServicoValorReferenciaComposicaoExame;

import java.sql.SQLException;

public class testeValorReferencia {
    public static void main(String[] args) throws SQLException {
        ServicoValorReferenciaComposicaoExame servicoValorReferenciaComposicaoExame = new ServicoValorReferenciaComposicaoExame();
        UnidadeMedida un = new UnidadeMedida(2,"muito grande");
        ValorReferenciaComposicaoExame valorReferenciaComposicaoExame = new ValorReferenciaComposicaoExame("76342","742356234","2345672","873456",un);
        servicoValorReferenciaComposicaoExame.Insert(valorReferenciaComposicaoExame);
        System.out.println(servicoValorReferenciaComposicaoExame.Selcet(1));
        ValorReferenciaComposicaoExame valorReferenciaComposicaoExam = new ValorReferenciaComposicaoExame(1,"76342","742356234","2345672","873456",un);
        servicoValorReferenciaComposicaoExame.Update(valorReferenciaComposicaoExam);
        servicoValorReferenciaComposicaoExame.Delete(1);
    }
}
