package com.med.voll.api.medico;

import com.med.voll.api.endereco.Endereco;

public record MedicoDto(Long Id, String nome, String email,String telefone, String crm, Especialidade especialidade, Endereco endereco) {
    public MedicoDto(Medico medico) {
       this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }



}
