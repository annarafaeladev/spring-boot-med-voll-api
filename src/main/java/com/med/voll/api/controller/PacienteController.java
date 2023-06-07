package com.med.voll.api.controller;

import com.med.voll.api.medico.Medico;
import com.med.voll.api.paciente.DadosCadastroPaciente;
import com.med.voll.api.paciente.Paciente;
import com.med.voll.api.paciente.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid DadosCadastroPaciente data){
        Paciente medico = new Paciente(data);
        pacienteRepository.save(medico);
    }

}