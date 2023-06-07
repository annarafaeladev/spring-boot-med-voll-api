package com.med.voll.api.medico;

import com.med.voll.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.validation.annotation.Validated;

public record DadosCadastroMedico(
        @NotNull
        @NotEmpty
        String nome,
        @NotNull
        @NotEmpty
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid
        DadosEndereco endereco) {
}
