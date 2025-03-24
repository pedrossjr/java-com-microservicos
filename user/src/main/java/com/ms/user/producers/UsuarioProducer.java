package com.ms.user.producers;

import com.ms.user.dtos.EmailDto;
import com.ms.user.models.UsuarioModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UsuarioProducer {

    final RabbitTemplate rabbitTemplate;

    public UsuarioProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UsuarioModel usuarioModel) {
        var emailDto = new EmailDto();

        emailDto.setUsuarioId(usuarioModel.getUsuarioId());
        emailDto.setEmailTo(usuarioModel.getEmail());
        emailDto.setSubject("Cadastro realizado com sucesso!");
        emailDto.setText(usuarioModel.getNome() + ", seja bem vindo(a)! \nAgradecemos o seu cadastro,  aproveite todos os recursos da nossa plataforma");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }

}
