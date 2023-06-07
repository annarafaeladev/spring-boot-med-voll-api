package com.med.voll.api.paciente;

import com.med.voll.api.endereco.DadosEndereco;

public record DadosUpdatePacienteDto(String nome, String telefone, DadosEndereco endereco) {
}
