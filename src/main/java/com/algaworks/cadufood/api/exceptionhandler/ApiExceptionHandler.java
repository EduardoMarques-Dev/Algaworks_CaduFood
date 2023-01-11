package com.algaworks.cadufood.api.exceptionhandler;

import com.algaworks.cadufood.domain.exception.*;
import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import com.fasterxml.jackson.databind.exc.IgnoredPropertyException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.PropertyBindingException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatusCode statusCode, WebRequest request) {

        // Pattern RFC 7809
        if (body == null){
            body = Problem.builder()
                    .status(statusCode.value())
                    .title(HttpStatus.valueOf(statusCode.value()).getReasonPhrase())
                    .detail(HttpStatus.valueOf(statusCode.value()).getReasonPhrase())
                    .timestamp(LocalDateTime.now())
                    .build();
        } else if (body instanceof String){
            body = Problem.builder()
                    .status(statusCode.value())
                    .title(HttpStatus.valueOf(statusCode.value()).getReasonPhrase())
                    .detail((String) body)
                    .timestamp(LocalDateTime.now())
                    .build();
        }

        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }

    // EXCEPTIONS DE NEGÓCIO

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<?> handleNegocioException(NegocioException ex, WebRequest request){
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        ProblemType problemType = ProblemType.ERRO_NEGOCIO;
        String detail = ex.getMessage();

        Problem problem = createProblemBuilder(statusCode, problemType, detail).build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), statusCode, request);
    }

    @ExceptionHandler({
            EntidadeNaoEncontradaException.class,
            CidadeNaoEncontradaException.class,
            RestauranteNaoEncontradoException.class,
            EstadoNaoEncontradoException.class,
            CozinhaNaoEncontradaException.class})
    public ResponseEntity<?> handleEntidadeNaoEncontradaException(EntidadeNaoEncontradaException ex, WebRequest request){

        HttpStatus statusCode = HttpStatus.NOT_FOUND;
        ProblemType problemType = ProblemType.ENTIDADE_NAO_ENCONTRADA;
        String detail = ex.getMessage();

        Problem problem = createProblemBuilder(statusCode, problemType, detail).build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), statusCode, request);
    }

    @ExceptionHandler(EntidadeEmUsoException.class)
    public ResponseEntity<?> handleEntidadeEmUsoException(EntidadeNaoEncontradaException ex, WebRequest request){

        HttpStatus statusCode = HttpStatus.CONFLICT;
        ProblemType problemType = ProblemType.ENTIDADE_EM_USO;
        String detail = ex.getMessage();

        Problem problem = createProblemBuilder(statusCode, problemType, detail).build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), statusCode, request);
    }

    // DESSERIALIZAÇÃO EXCEPTION

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Throwable rootCause = ExceptionUtils.getRootCause(ex);

        ProblemType problemType = ProblemType.MENSAGEM_INCOMPREENSIVEL;
        String detail = "O corpo da requisição está inválido. Verifique o erro de sintaxe.";

        if (rootCause instanceof InvalidFormatException invalidEx){
            String path = JoinPath(invalidEx.getPath());

            detail = String.format("A propriedade '%s' recebeu o valor '%s', "
                            + "que é de um tipo inválido. Corrija e informe um valor compatível com o tipo %s.",
                    path, invalidEx.getValue(), invalidEx.getTargetType().getSimpleName());

        } if (rootCause instanceof PropertyBindingException ignoredEx){
            String path = JoinPath(ignoredEx.getPath());

            detail = String.format("A propriedade '%s' não existe. "
                    + "Corrija ou remova essa propriedade e tente novamente.", path);
        }

        Problem problem = createProblemBuilder(status, problemType, detail).build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    // PATH VARIABLE EXCEPTION

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ProblemType problemType = ProblemType.PARAMETRO_INVALIDO;
        String detail = String.format("O parâmetro de URL '%s' recebeu o valor '%s'," +
                "que é um tipo inválido. Corrija e informe um valor compatível com o tipo '%s'",
                ((MethodArgumentTypeMismatchException) ex).getName(), ex.getValue(), ex.getRequiredType().getSimpleName());

        Problem problem = createProblemBuilder(status, problemType, detail).build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    // METHOD NOT ALLOWED EXCEPTION

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ProblemType problemType = ProblemType.RECURSO_NAO_ENCONTRADO;
        String detail = String.format("O recurso '%s' que você tentou acessar não existe.",
                ex.getRequestURL());

        Problem problem = createProblemBuilder(status, problemType, detail).build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    // UTILITÁRIOS

    private static String JoinPath(List<Reference> path) {
        return path
                .stream().map(Reference::getFieldName)
                .collect(Collectors.joining("."));
    }

    private Problem.ProblemBuilder createProblemBuilder(HttpStatusCode statusCode, ProblemType problemType, String detail){
        return Problem.builder()
                .status(statusCode.value())
                .type(problemType.getUri())
                .title(problemType.getTitle())
                .detail(detail)
                .timestamp(LocalDateTime.now());
    }


}
