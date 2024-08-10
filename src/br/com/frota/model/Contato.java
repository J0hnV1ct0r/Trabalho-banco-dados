package br.com.frota.model;

public class Contato extends GenericModel{
    private String telefone;
    private Laboratorio laboratorioId;

    public Contato(Integer id, String telefone, Laboratorio laboratorioId){
        this.telefone = telefone;
        this.laboratorioId = laboratorioId;

        super.setId(id);
    }

    public Contato(String telefone, Laboratorio laboratorioId) {
        this.telefone = telefone;
        this.laboratorioId = laboratorioId;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getTelefone() {

        return telefone;
    }



    public int getLaboratorioId() {
        return laboratorioId.getId();
    }

    @Override
    public String toString() {
        return "Contato {" +
                ", id = ' " + this.getId() + "\'" +
                ", telefone =' " + telefone  + "\'" +
                ", id_laboratorio = '" + laboratorioId.getId() + "\'" +
                '}';
    }

    public void setLaboratorioId(Laboratorio laboratorioId) {
        this.laboratorioId = laboratorioId;
    }
}
