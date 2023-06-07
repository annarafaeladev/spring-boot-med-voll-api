package com.med.voll.api.paciente;

public record PacienteDto(String nome, String email, String telefone, String cpf) {

    public PacienteDto(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf());
    }
}
