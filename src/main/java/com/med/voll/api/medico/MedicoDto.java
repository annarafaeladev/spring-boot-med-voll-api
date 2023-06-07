package com.med.voll.api.medico;

import com.med.voll.api.endereco.Endereco;

public record MedicoDto(Long Id, String nome, String email, String crm, Especialidade especialidade) {
    public MedicoDto(Medico medico) {
       this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }



}
