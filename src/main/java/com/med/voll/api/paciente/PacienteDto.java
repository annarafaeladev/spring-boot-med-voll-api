package com.med.voll.api.paciente;

import com.med.voll.api.endereco.Endereco;

public record PacienteDto(Long id, String nome, String email, String telefone, String cpf, Endereco endereco) {

    public PacienteDto(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }
}
