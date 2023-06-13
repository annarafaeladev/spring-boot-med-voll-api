package com.med.voll.api.domain.paciente;

import com.med.voll.api.domain.endereco.DadosEndereco;

public record DadosUpdatePacienteDto(String nome, String telefone, DadosEndereco endereco) {
}
