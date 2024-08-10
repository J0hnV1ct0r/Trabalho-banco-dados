package br.com.frota.model;

public class ValorReferenciaComposicaoExame extends GenericModel{
    private String valorMinimo;
    private String valorMaximo;
    private String limitadorMinimo;
    private String limitadorMaximo;
    private UnidadeMedida unidadeMedidaId;


    public ValorReferenciaComposicaoExame(String valorMinimo, String valorMaximo, String limitadorMinimo, String limitadorMaximo,UnidadeMedida unidadeMedidaId){
        this.valorMinimo = valorMinimo;
        this.limitadorMaximo = limitadorMaximo;
        this.valorMaximo = valorMaximo;
        this.limitadorMinimo = limitadorMinimo;
        this.unidadeMedidaId = unidadeMedidaId;

    }

    public ValorReferenciaComposicaoExame(Integer id, String valorMinimo, String valorMaximo, String limitadorMinimo, String limitadorMaximo, UnidadeMedida unidadeMedidaId){
        this.valorMinimo = valorMinimo;
        this.limitadorMaximo = limitadorMaximo;
        this.valorMaximo = valorMaximo;
        this.limitadorMinimo = limitadorMinimo;
        this.unidadeMedidaId = unidadeMedidaId;
        super.setId(id);
    }

    public void setLimitadorMaximo(String limitadorMaximo) {
        this.limitadorMaximo = limitadorMaximo;
    }

    public void setLimitadorMinimo(String limitadorMinimo) {
        this.limitadorMinimo = limitadorMinimo;
    }

    public void setValorMaximo(String valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public void setValorMinimo(String valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public String getLimitadorMaximo() {
        return limitadorMaximo;
    }

    public String getValorMaximo() {
        return valorMaximo;
    }

    public String getValorMinimo() {
        return valorMinimo;
    }

    public String getLimitadorMinimo() {
        return limitadorMinimo;
    }

    public int getUnidadeMedidaId() {
        return unidadeMedidaId.getId();
    }

    @Override
    public String toString() {
        return "Valor_referencia_composicao_exame {" +
                "id ='" + this.getId() + "\'" +
                "valor_minimo ='" + valorMinimo + "\'" +
                "valor_maximo ='" + valorMaximo + "\'" +
                "limitador_minimo ='" + limitadorMinimo + "\'" +
                "limitador_maximo ='" + limitadorMaximo + "\'" +
                "unidade_medida_id ='" + unidadeMedidaId + "\'" +
                '}';
    }

    public void setUnidadeMedidaId(UnidadeMedida unidadeMedidaId) {
        this.unidadeMedidaId = unidadeMedidaId;
    }
}