package com.med.voll.api.controller;

import com.med.voll.api.medico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid DadosCadastroMedico data){
        Medico medico = new Medico(data);
        medicoRepository.save(medico);
    }

    @GetMapping
    public Page<MedicoDto> index(@PageableDefault(size = 2, sort = {"nome"}) Pageable pagination){
        return medicoRepository.findAll(pagination).map(MedicoDto::new);
    }
    @PutMapping("/{id}")
    @Transactional
    public void update(@PathVariable Long id, @RequestBody @Valid DadosUpdateMedicoDto data){
        Medico medico = medicoRepository.getReferenceById(id);
        medico.update(data);
    }


}
