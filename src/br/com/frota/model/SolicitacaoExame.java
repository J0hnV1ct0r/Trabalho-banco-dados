package br.com.frota.model;

import java.util.Date;

public class SolicitacaoExame extends GenericModel{
    private String nPrescrito;
    private Date dtSolocitac;
    private ConsultaMedica consultaMedicaId;
    private HabilitacaoExame habilitacaoExameId;
    private Exame exameId;

    public SolicitacaoExame(String nPrescrito, Date dtSolocitac, ConsultaMedica consultaMedicaId, HabilitacaoExame habilitacaoExameId, Exame exameId){
        this.dtSolocitac = dtSolocitac;
        this.nPrescrito = nPrescrito;
        this.consultaMedicaId = consultaMedicaId;
        this.habilitacaoExameId = habilitacaoExameId;
        this.exameId = exameId;
    }

    public SolicitacaoExame(Integer id, String nPrescrito, Date dtSolocitac, ConsultaMedica consultaMedicaId, HabilitacaoExame habilitacao_exame_id, Exame exameId){
        this.dtSolocitac = dtSolocitac;
        this.nPrescrito = nPrescrito;
        this.consultaMedicaId = consultaMedicaId;
        this.habilitacaoExameId = habilitacao_exame_id;
        this.exameId = exameId;
        super.setId(id);
    }

    public void setDtSolocitac(Date dtSolocitac) {
        this.dtSolocitac = dtSolocitac;
    }



    public void setnPrescrito(String nPrescrito) {
        this.nPrescrito = nPrescrito;
    }
    public void setConsultaMedicaId(ConsultaMedica consultaMedicaId) {
        this.consultaMedicaId = consultaMedicaId;
    }

    public void setHabilitacaoExameId(HabilitacaoExame habilitacaoExameId) {
        this.habilitacaoExameId = habilitacaoExameId;
    }

    public void setExameId(Exame exameId) {
        this.exameId = exameId;
    }

    public Date getDtSolocitac() {
        return dtSolocitac;
    }


    public String getnPrescrito() {
        return nPrescrito;
    }

    public int getConsultaMedicaId() {
        return consultaMedicaId.getId();
    }

    public int getExameId() {
        return exameId.getId();
    }


    public int gethabilitacaoExameId() {
        return habilitacaoExameId.getId();
    }

    @Override
    public String toString() {
        return "Solicitacao_exame {" +
                "id ='" + this.getId() + "\'" +
                "n_prescrito ='" + nPrescrito + "\'" +
                "dt_solocitac =" + dtSolocitac + "\'" +
                "consulta_medica_id =" + consultaMedicaId + "\'" +
                "habilitacao_exame_id =" + habilitacaoExameId + "\'" +
                "exame_id =" + exameId + "\'" +
                '}';
    }

}