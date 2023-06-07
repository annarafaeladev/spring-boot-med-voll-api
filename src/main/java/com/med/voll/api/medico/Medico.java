package com.med.voll.api.medico;

import com.med.voll.api.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    @NotBlank
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Medico(DadosCadastroMedico data) {
        this.ativo = true;
        this.nome = data.nome();
        this.email = data.email();
        this.telefone = data.telefone();
        this.crm = data.crm();
        this.especialidade = data.especialidade();
        this.endereco = new Endereco(data.endereco());
    }

    public void update(DadosUpdateMedicoDto updateMedico){
        if (updateMedico.nome() != null)
            this.nome = updateMedico.nome();

        if (updateMedico.telefone() != null)
            this.telefone = updateMedico.telefone();

        if (updateMedico.endereco() != null)
            this.endereco.update(updateMedico.endereco());

    }

    public void destroyLogic(Long id) {
        this.ativo=false;
    }
}