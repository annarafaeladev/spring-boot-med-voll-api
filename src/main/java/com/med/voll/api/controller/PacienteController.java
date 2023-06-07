package com.med.voll.api.controller;

import com.med.voll.api.paciente.DadosCadastroPaciente;
import com.med.voll.api.paciente.PacienteDto;
import com.med.voll.api.paciente.Paciente;
import com.med.voll.api.paciente.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public Page<PacienteDto> index(@PageableDefault(size = 2, sort = {"nome"}) Pageable pagination){
        return pacienteRepository.findAll(pagination).map(PacienteDto::new);
    }

}