package com.algaworks.cadufood.api.exceptionhandler;

import lombok.Getter;

// Ajustar: URI_PADRAO
@Getter
public enum ProblemType {

    ERRO_DE_SISTEMA("/erro-sistema", "Erro de sistema"),
    ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio"),
    ENTIDADE_NAO_ENCONTRADA("/entidade-nao-encontrada", "Entidade não encontrada"),
    RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
    ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
    PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro inválido"),
    MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensível"),
    DADOS_INVALIDOS("/dados-invalidos", "Dados inválidos"),
    SENHA_INCORRETA("/senha-incorreta", "Senha incorreta");

    public static final String URI_PADRAO = "https://cadufood.com.br";
    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = URI_PADRAO + path;
        this.title = title;
    }
}
