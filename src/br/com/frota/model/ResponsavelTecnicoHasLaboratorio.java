package br.com.frota.model;

public class ResponsavelTecnicoHasLaboratorio extends GenericModel{
    private Laboratorio laboratorioId;
    private ResponsavelTecnico responsavelTecnico;


    public ResponsavelTecnicoHasLaboratorio(Integer id, Laboratorio laboratorioId, ResponsavelTecnico responsavelTecnico){
        this.laboratorioId = laboratorioId;
        this.responsavelTecnico = responsavelTecnico;
        super.setId(id);
    }

    public ResponsavelTecnicoHasLaboratorio(Laboratorio laboratorioId, ResponsavelTecnico responsavelTecnico) {
        this.laboratorioId = laboratorioId;
        this.responsavelTecnico = responsavelTecnico;
    }

    public int getResponsavelTecnico() {
        return responsavelTecnico.getId();
    }

    public int getLaboratorioId() {
        return laboratorioId.getId();
    }

    @Override
    public String toString() {
        return "Responsavel_tecnico_has_laboratorio {" +
                "id ='" + this.getId() + "\'" +
                "laboratorio_id ='" + laboratorioId + "\'" +
                "responsavel_tecnico =" + responsavelTecnico + "\'" +
                '}';
    }

    public void setLaboratorioId(Laboratorio laboratorioId) {
        this.laboratorioId = laboratorioId;
    }

    public void setResponsavelTecnico(ResponsavelTecnico responsavelTecnico) {
        this.responsavelTecnico = responsavelTecnico;
    }
}
