package com.med.voll.api.controller;

import com.med.voll.api.medico.DadosCadastroMedico;
import com.med.voll.api.medico.ListarMedicoDto;
import com.med.voll.api.medico.Medico;
import com.med.voll.api.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public Page<ListarMedicoDto> index(Pageable pagination){
        return medicoRepository.findAll(pagination).map(ListarMedicoDto::new);
    }
}
