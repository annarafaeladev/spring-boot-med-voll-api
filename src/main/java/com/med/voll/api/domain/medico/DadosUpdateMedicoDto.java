package com.med.voll.api.domain.medico;

import com.med.voll.api.domain.endereco.DadosEndereco;

public record DadosUpdateMedicoDto(String nome, String telefone, DadosEndereco endereco) {
}
