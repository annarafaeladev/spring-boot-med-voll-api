package com.med.voll.api.controller;

import com.med.voll.api.domain.medico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/medicos")
@SecurityRequirement(name = "bearer-key")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<MedicoDto> create(@RequestBody @Valid DadosCadastroMedico data, UriComponentsBuilder uriComponentsBuilder){
        Medico medico = new Medico(data);
        medicoRepository.save(medico);
        URI uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new MedicoDto(medico));
    }

    @GetMapping
    public ResponseEntity<Page<MedicoDto>> index(@PageableDefault(size = 2, sort = {"nome"}) Pageable pagination){
        Page page = medicoRepository.findAllByAtivoTrue(pagination).map(MedicoDto::new);

        return ResponseEntity.ok(page);
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<MedicoDto> update(@PathVariable Long id, @RequestBody @Valid DadosUpdateMedicoDto data){
        Medico medico = medicoRepository.getReferenceById(id);
        medico.update(data);

        return ResponseEntity.ok(new MedicoDto(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        Medico medico  = medicoRepository.getReferenceById(id);
        medico.destroyLogic(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity show(@PathVariable Long id){
        Medico medico  = medicoRepository.getReferenceById(id);

        return ResponseEntity.ok(new MedicoDto(medico));
    }


}
