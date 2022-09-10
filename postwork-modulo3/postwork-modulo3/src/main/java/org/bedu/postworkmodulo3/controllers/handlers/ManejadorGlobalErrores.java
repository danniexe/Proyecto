package org.bedu.postworkmodulo3.controllers.handlers;

import org.bedu.postworkmodulo3.model.RespuestaError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ManejadorGlobalErrores  {


    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ResponseEntity<?> handleStatusException(MethodArgumentNotValidException ex, WebRequest request){
        return RespuestaError.builder()
                .exception(ex)
                .ruta(request.getDescription(false).substring(4))
                .entidad();
    }


}
