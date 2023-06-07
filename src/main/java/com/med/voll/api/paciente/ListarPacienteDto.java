package com.med.voll.api.paciente;

public record ListarPacienteDto(String nome, String email, String telefone, String cpf) {

    public ListarPacienteDto(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf());
    }
}
