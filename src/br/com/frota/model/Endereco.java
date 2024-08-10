package br.com.frota.model;

public class Endereco extends GenericModel{

    private String rua;
    private String complemento;
    private String bairo;
    private String cep;
    private String cidade;

    private Laboratorio laboratorioId;
    private String numero;


    public Endereco(String rua, String complemento, String bairo, String cep, String cidade, Laboratorio laboratorioId,String numero){
        super();
        this.rua = rua;
        this.complemento = complemento;
        this.bairo =  bairo;
        this.cep = cep;
        this.cidade =  cidade;
        this.laboratorioId = laboratorioId;
        this.numero = numero;

    }

    public Endereco(Integer id, String rua, String complemento, String bairo, String cep, String cidade, Laboratorio laboratorioId,String numero){
        this.rua = rua;
        this.complemento = complemento;
        this.bairo =  bairo;
        this.cep = cep;
        this.cidade =  cidade;
        this.laboratorioId = laboratorioId;
        this.numero = numero;
        super.setId(id);
    }

    public void setRua(String rua){
        this.rua = rua;
    }

    public void setComplemento(String complemento){
        this.complemento = complemento;
    }

    public void setBairo(String bairo){
        this.bairo = bairo;
    }

    public void setCep(String cep){
        this.cep = cep;
    }

    public void setCidade(String cidade){
        this.cidade = cidade;
    }

    public void setLaboratorioId(Laboratorio laboratorioId) {
        this.laboratorioId = laboratorioId;
    }

    //
    public String getBairo() {
        return bairo;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getRua() {
        return rua;
    }

    public Integer getLaboratorioId() {
        return laboratorioId.getId();
    }
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String toString() {
        return "Endereco {" +
                "id = '" + this.getId() + "\'" +
                ", rua = '" + rua  + "\'" +
                ", complemento = '" + complemento  + "\'" +
                ", bairo = '" + bairo  + "\'" +
                ", cep =' " + cep  + "\'" +
                ", cidade = '" + cidade  + "\'" +
                ", id_laboratorio = '" + laboratorioId + "\'" +
                '}';
    }



}
