package com.med.voll.api.medico;

public record ListarMedicoDto(String nome, String email, String crm, Especialidade especialidade) {
    public ListarMedicoDto(Medico medico) {
       this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
