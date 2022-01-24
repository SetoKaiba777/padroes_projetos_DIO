package com.kaibacorp.labpadroesprojetosspring.api.exceptionHandler;

import com.kaibacorp.labpadroesprojetosspring.domain.exception.DontFoundException;
import feign.FeignException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.time.OffsetDateTime;
import java.util.ArrayList;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(FeignException.class)
    public String handleFeignStatusException(FeignException ex, HttpServletResponse response) {
        response.setStatus(ex.status());
        return "Feign Error";
    }

    @ExceptionHandler(DontFoundException.class)
    public ResponseEntity<Object> handleDontFoundExcpetion(DontFoundException ex, WebRequest request) {
        var status = HttpStatus.NOT_FOUND;
        Problema problema = conjuntoDeProblemas(ex.getMessage(), status);
        return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request){

        var campos = new ArrayList<Problema.Campo>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()){
            String nome = ((FieldError) error).getField();
            String msg = error.getDefaultMessage();

            campos.add(new Problema.Campo(nome, msg));
        }
        Problema problema = conjuntoDeProblemas("Um ou mais campos não foram preenchidos corretamente",status);
        problema.setCampos(campos);
        return super.handleExceptionInternal(ex,problema, headers,status,request);
    }

    private Problema conjuntoDeProblemas(String msg, HttpStatus status){
        var problema = new Problema();
        problema.setStatus(status.value());
        problema.setTitulo(msg);
        problema.setDataHora(OffsetDateTime.now());
        return problema;
    }

}
