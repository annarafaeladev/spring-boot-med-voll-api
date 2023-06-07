package com.med.voll.api.medico;

import com.med.voll.api.endereco.DadosEndereco;
import com.med.voll.api.endereco.Endereco;

public record DadosUpdateMedicoDto(String nome, String telefone, DadosEndereco endereco) {
}
