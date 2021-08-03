package br.com.zup.consomeviacep.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * {
 * "cep": "01001-000",
 * "logradouro": "Praça da Sé",
 * "complemento": "lado ímpar",
 * "bairro": "Sé",
 * "localidade": "São Paulo",
 * "uf": "SP",
 * "ibge": "3550308",
 * "gia": "1004",
 * "ddd": "11",
 * "siafi": "7107"
 * }
 */

@Setter
@Getter
@ToString
public class Endereco implements Serializable {

    private static final long serialVersionUID = -3130973034459839283L;

    private String cep;

    private String logradouro;

    @ToString.Exclude
    private String complemento;

    private String bairro;

    private String cidade;

    private String estado;

    @ToString.Exclude
    private String codigoIbge;

    @ToString.Exclude
    private String codigoDeArea;

}
