package com.med.voll.api.controller;

import com.med.voll.api.medico.Medico;
import com.med.voll.api.paciente.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
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
        return pacienteRepository.findByAtivoTrue(pagination).map(PacienteDto::new);
    }

    @PutMapping("/{id}")
    @Transactional
    public void update(@PathVariable Long id, @RequestBody @Valid DadosUpdatePacienteDto data){
        System.out.println("" +id + data);
        Paciente paciente = pacienteRepository.getReferenceById(id);
        paciente.update(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        Paciente paciente  = pacienteRepository.getReferenceById(id);
        paciente.destroyLogic(id);

    }



}