package br.com.frota.model;

import java.util.Date;

public class ConsultaMedica extends GenericModel{
    private Date dtConsulta;
    private String nmAtendimento;
    private Paciente pacienteId;
    private Medico medicoId;

    public ConsultaMedica(Date dtConsulta, String nmAtendimento, Paciente pacienteId,Medico medicoId){
        this.dtConsulta = dtConsulta;
        this.nmAtendimento = nmAtendimento;
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
    }

    public ConsultaMedica(Integer id, Date dtConsulta, String nmAtendimento, Paciente pacienteId,Medico medicoId){
        this.dtConsulta = dtConsulta;
        this.nmAtendimento = nmAtendimento;
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
        super.setId(id);
    }

    public void setDtConsulta(Date dtConsulta) {
        this.dtConsulta = dtConsulta;
    }

    public void setNmAtendimento(String nmAtendimento) {
        this.nmAtendimento = nmAtendimento;
    }

    public Date getDtConsulta() {
        return dtConsulta;
    }

    public String getNmAtendimento() {
        return nmAtendimento;
    }

    public int getPacienteId() {
        return pacienteId.getId();
    }

    public void setPacienteId(Paciente pacienteId) {
        this.pacienteId = pacienteId;
    }
    @Override
    public String toString() {
        return "Paceiente {" +
                "id ='" + this.getId() + "\'" +
                "dt_consulta ='" + dtConsulta + "\'" +
                "nm_atendimento =" + nmAtendimento + "\'" +
                "paciente_id =" + pacienteId.getId() + "\'" +
                '}';
    }


    public int getMedicoId() {
        return medicoId.getId();
    }

    public void setMedicoId(Medico medicoId) {
        this.medicoId = medicoId;
    }
}