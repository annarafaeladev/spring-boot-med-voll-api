package com.med.voll.api.controller;

import com.med.voll.api.domain.consulta.DadosAgendamentoConsultaDto;
import com.med.voll.api.domain.consulta.DadosDetalhamentoConsulta;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @PostMapping
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsultaDto body){
        System.out.println(body);
        return ResponseEntity.ok(new DadosDetalhamentoConsulta(null, null, null, null));

    }
}
