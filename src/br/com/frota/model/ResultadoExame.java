package br.com.frota.model;

import java.util.Date;

public class ResultadoExame extends GenericModel{
    private Date dtExame;
    private String valor;
    private Composicao composicaoId;
    private Laudo laudoId;




    public ResultadoExame(Integer id, Date dtExame, String valor, Composicao composicaoId, Laudo laudoId){
        this.dtExame = dtExame;
        this.valor = valor;
        this.composicaoId = composicaoId;
        this.laudoId = laudoId;
        super.setId(id);
    }

    public ResultadoExame(Date dtExame, String valor, Composicao composicaoId, Laudo laudoId) {
        this.dtExame = dtExame;
        this.valor = valor;
        this.composicaoId = composicaoId;
        this.laudoId = laudoId;
    }

    public void setDtExame(Date dtExame) {
        this.dtExame = dtExame;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Date getDtExame() {
        return dtExame;
    }

    public String getValor() {
        return valor;
    }

    public int getComposicaoId() {
        return composicaoId.getId();
    }

    public int getLaudoId() {
        return laudoId.getId();
    }

    @Override
    public String toString() {
        return "Resultado_exame {" +
                "id ='" + this.getId() + "\'" +
                "dt_exame ='" + dtExame + "\'" +
                "valor ='" + valor + "\'" +
                "composicao_id ='" + composicaoId + "\'" +
                "laudo_id ='" + laudoId + "\'" +
                '}';
    }

    public void setComposicaoId(Composicao composicaoId) {
        this.composicaoId = composicaoId;
    }

    public void setLaudoId(Laudo laudoId) {
        this.laudoId = laudoId;
    }
}