package com.ms.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRecordDto(@NotBlank String nome,
                               @NotBlank @Email String email) {

}
