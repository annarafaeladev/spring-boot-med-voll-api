package com.med.voll.api.paciente;

public record PacienteDto(Long id, String nome, String email, String telefone, String cpf) {

    public PacienteDto(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf());
    }
}
