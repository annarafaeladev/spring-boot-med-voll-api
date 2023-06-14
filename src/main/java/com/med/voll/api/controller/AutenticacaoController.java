package com.med.voll.api.controller;

import com.med.voll.api.domain.usuario.LoginDto;
import com.med.voll.api.domain.usuario.Usuario;
import com.med.voll.api.domain.usuario.UsuarioRepository;
import com.med.voll.api.infra.security.TokenJwtDto;
import com.med.voll.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid LoginDto body){
        var authenticationToken  = new UsernamePasswordAuthenticationToken(body.login(), body.senha());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        var tokenJwt = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenJwtDto(tokenJwt, "Bearer"));

    }
}
