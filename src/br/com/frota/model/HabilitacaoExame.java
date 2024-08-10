package br.com.frota.model;

public class HabilitacaoExame extends GenericModel{
    private String observacao;
    private int custo;
    private Laboratorio laboratorioId;
    private TipoExame tipoExameId;

    public HabilitacaoExame(String observacao, int custo, Laboratorio laboratorioId, TipoExame tipoExameId){
        this.custo = custo;
        this.observacao = observacao;
        this.laboratorioId = laboratorioId;
        this.tipoExameId = tipoExameId;
    }

    public HabilitacaoExame(Integer id, String observacao, int custo, Laboratorio laboratorioId, TipoExame tipoExameId){
        this.custo = custo;
        this.observacao = observacao;
        this.laboratorioId = laboratorioId;
        this.tipoExameId = tipoExameId;
        super.setId(id);
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public void setLaboratorioId(Laboratorio laboratorioId) {
        this.laboratorioId = laboratorioId;
    }

    public void setTipoExameId(TipoExame tipoExameId) {
        this.tipoExameId = tipoExameId;
    }

    public String getObservacao() {
        return observacao;
    }

    public int getCusto() {
        return custo;
    }

    public int getLaboratorioId() {
        return laboratorioId.getId();
    }

    public int getTipoExameId() {
        return tipoExameId.getId();
    }


    @Override
    public String toString() {
        return "Habilitacao_exame {" +
                "id ='" + this.getId() + "\'" +
                "observacao ='" + observacao + "\'" +
                "custo =" + custo + "\'" +
                "laboratorio_id =" + laboratorioId + "\'" +
                "tipo_exame_id =" + tipoExameId + "\'" +
                '}';
    }

}
