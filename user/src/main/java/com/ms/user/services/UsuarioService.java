package com.ms.user.services;

import com.ms.user.models.UsuarioModel;
import com.ms.user.producers.UsuarioProducer;
import com.ms.user.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    final UsuarioRepository usuarioRepository;
    final UsuarioProducer usuarioProducer;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioProducer usuarioProducer) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioProducer = usuarioProducer;
    }

    @Transactional
    public UsuarioModel salve(UsuarioModel usuarioModel) {
        usuarioModel = usuarioRepository.save(usuarioModel);
        usuarioProducer.publishMessageEmail(usuarioModel);
        return usuarioModel;
    }

}
