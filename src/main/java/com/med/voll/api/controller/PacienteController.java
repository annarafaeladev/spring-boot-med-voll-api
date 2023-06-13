package com.med.voll.api.controller;

import com.med.voll.api.medico.Medico;
import com.med.voll.api.medico.MedicoDto;
import com.med.voll.api.paciente.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<PacienteDto> create(@RequestBody @Valid DadosCadastroPaciente data, UriComponentsBuilder uriComponentsBuilder){
        Paciente paciente = new Paciente(data);
        URI uri = uriComponentsBuilder.path("pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        pacienteRepository.save(paciente);

        return ResponseEntity.created(uri).body(new PacienteDto(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<PacienteDto>> index(@PageableDefault(size = 2, sort = {"nome"}) Pageable pagination){
        Page page = pacienteRepository.findByAtivoTrue(pagination).map(PacienteDto::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PacienteDto> update(@PathVariable Long id, @RequestBody @Valid DadosUpdatePacienteDto data){
        Paciente paciente = pacienteRepository.getReferenceById(id);
        paciente.update(data);

        return ResponseEntity.ok(new PacienteDto(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity delete(@PathVariable Long id){
        Paciente paciente  = pacienteRepository.getReferenceById(id);
        paciente.destroyLogic(id);

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity show(@PathVariable Long id){
        Paciente paciente  = pacienteRepository.getReferenceById(id);

        return ResponseEntity.ok(new PacienteDto(paciente));
    }



}