package com.ms.email.dtos;

import java.util.UUID;

public record EmailRecordDto(UUID usuarioId,
                             String emailTo,
                             String subject,
                             String text) {
}
