package br.com.frota.model;

public class Laudo extends GenericModel{
    private String assinaturaDigital;
    private String dtResultado;
    private String codigo;
    private SolicitacaoExame solicitacaoExameId;

    public Laudo(String assinaturaDigital, String dtResultado, String codigo, SolicitacaoExame solicitacaoExameId){
        this.assinaturaDigital = assinaturaDigital;
        this.codigo = codigo;
        this.solicitacaoExameId = solicitacaoExameId;
        this.dtResultado = dtResultado;
    }

    public Laudo(Integer id, String assinaturaDigital, String dtResultado, String codigo, SolicitacaoExame solicitacaoExameId){
        this.assinaturaDigital = assinaturaDigital;
        this.codigo = codigo;
        this.dtResultado = dtResultado;
        this.solicitacaoExameId = solicitacaoExameId;
        super.setId(id);
    }

    public void setAssinaturaDigital(String assinatura_digital) {
        this.assinaturaDigital = assinatura_digital;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDtResultado(String dt_resultado) {
        this.dtResultado = dt_resultado;
    }

    public String getAssinaturaDigital() {
        return assinaturaDigital;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDtResultado() {
        return dtResultado;
    }

    public int getSolicitacaoExameId() {
        return solicitacaoExameId.getId();
    }

    public void setSolicitacaoExameId(SolicitacaoExame solicitacaoExameId) {
        this.solicitacaoExameId = solicitacaoExameId;
    }
    @Override
    public String toString() {
        return "Laudo {" +
                "id ='" + this.getId() + "\'" +
                "assinatura_digital ='" + assinaturaDigital + "\'" +
                "codigo =" + codigo + "\'" +
                "dt_resultado =" + dtResultado + "\'" +
                "solicitacao_exame_id =" + solicitacaoExameId + "\'" +
                '}';
    }


}
