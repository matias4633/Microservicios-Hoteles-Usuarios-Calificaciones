package com.mscv.usuario.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
    private String mensaje;
    private boolean exito;
    private HttpStatus status;
}
