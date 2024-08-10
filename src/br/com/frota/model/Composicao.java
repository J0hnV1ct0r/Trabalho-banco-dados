package br.com.frota.model;

public class Composicao extends GenericModel{
    private Exame exameId;
    private ComposicaoExame composicaoExameId;
    private ValorReferenciaComposicaoExame valorReferenciaComposicaoExameId;

    public Composicao(int id, Exame exameId, ComposicaoExame composicaoExameId, ValorReferenciaComposicaoExame valorReferenciaComposicaoExameId){
        this.exameId = exameId;
        this.composicaoExameId = composicaoExameId;
        this.valorReferenciaComposicaoExameId = valorReferenciaComposicaoExameId;
        super.setId(id);
    }

    public Composicao(Exame exameId, ComposicaoExame composicaoExameId, ValorReferenciaComposicaoExame valorReferenciaComposicaoExameId) {
        this.exameId = exameId;
        this.composicaoExameId = composicaoExameId;
        this.valorReferenciaComposicaoExameId = valorReferenciaComposicaoExameId;
    }

    public void setExameId(Exame exameId) {
        this.exameId = exameId;
    }

    public void setComposicaoExameId(ComposicaoExame composicaoExameId) {
        this.composicaoExameId = composicaoExameId;
    }

    public void setValorReferenciaComposicaoExameId(ValorReferenciaComposicaoExame valorReferenciaComposicaoExameId) {
        this.valorReferenciaComposicaoExameId = valorReferenciaComposicaoExameId;
    }
    public int getExameId() {
        return exameId.getId();
    }

    public int getComposicaoExameId() {
        return composicaoExameId.getId();
    }

    public int getValorReferenciaComposicaoExameId() {
        return valorReferenciaComposicaoExameId.getId();
    }

    @Override
    public String toString() {
        return "Composicao {" +
                "id ='" + this.getId() + "\'" +
                "exame_id ='" + exameId + "\'" +
                "composicao_exame_id ='" + composicaoExameId + "\'" +
                "valor_referencia_composicao_exame_id ='" + valorReferenciaComposicaoExameId + "\'" +
                '}';
    }

}