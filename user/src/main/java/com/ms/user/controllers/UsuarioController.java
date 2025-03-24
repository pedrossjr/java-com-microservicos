package com.ms.user.controllers;

import com.ms.user.dtos.UsuarioRecordDto;
import com.ms.user.models.UsuarioModel;
import com.ms.user.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UsuarioController {

    final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("usuarios")
    public ResponseEntity<UsuarioModel> salvarUsuario(@RequestBody @Valid UsuarioRecordDto usuarioRecordDto) {

        var usuarioModel = new  UsuarioModel();

        BeanUtils.copyProperties(usuarioRecordDto, usuarioModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salve(usuarioModel));

    }
}
