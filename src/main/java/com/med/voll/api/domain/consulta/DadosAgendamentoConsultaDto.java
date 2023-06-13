package com.med.voll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoConsultaDto(
        Long id,
        @NotNull
        Long idPaciente,
        @NotNull
        @Future
        LocalDateTime data) {
}
