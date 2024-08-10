package br.com.frota.model;

public class MedicoHasEspecialidade extends GenericModel{
    private Medico medicoId;
    private Especialidade especialidadeId;


    public MedicoHasEspecialidade(Integer id, Especialidade especialidadeId, Medico medicoId){
        this.especialidadeId = especialidadeId;
        this.medicoId = medicoId;
        super.setId(id);
    }

    public MedicoHasEspecialidade(Especialidade especialidadeId, Medico medicoId) {
        this.medicoId = medicoId;
        this.especialidadeId = especialidadeId;
    }

    public int getMedicoId() {
        return medicoId.getId();
    }

    public int getEspecialidadeId() {
        return especialidadeId.getId();
    }
    @Override
    public String toString() {
        return "Medico_has_especialidade {" +
                " medico_id = '" + medicoId.getId() + "\'" +
                ", especalidade_id = '" + especialidadeId.getId() + "\'" +
                '}';
    }

    public void setMedicoId(Medico medicoId) {
        this.medicoId = medicoId;
    }

    public void setEspecialidadeId(Especialidade especialidadeId) {
        this.especialidadeId = especialidadeId;
    }
}