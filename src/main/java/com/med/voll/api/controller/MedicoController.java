package com.med.voll.api.controller;

import com.med.voll.api.medico.DadosCadastroMedico;
import com.med.voll.api.medico.Medico;
import com.med.voll.api.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

}
