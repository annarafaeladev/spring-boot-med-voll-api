package com.med.voll.api.domain.paciente;

import com.med.voll.api.domain.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Entity(name = "Paciente")
@Table(name = "pacientes")
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cpf;

    @Embedded
    private  Endereco endereco;

    private Boolean ativo;

    public Paciente(DadosCadastroPaciente paciente) {
        this.ativo = true;
        this.nome = paciente.nome();
        this.email = paciente.email();
        this.telefone = paciente.telefone();
        this.cpf = paciente.cpf();
        this.endereco = new Endereco(paciente.endereco());
    }

    public void update(DadosUpdatePacienteDto updatePaciente){
        if (updatePaciente.nome() != null)
            this.nome = updatePaciente.nome();

        if (updatePaciente.telefone() != null)
            this.telefone = updatePaciente.telefone();

        if (updatePaciente.endereco() != null)
            this.endereco.update(updatePaciente.endereco());

    }

    public void destroyLogic(Long id) {
        this.ativo=false;
    }
}
