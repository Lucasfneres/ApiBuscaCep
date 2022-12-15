package com.busca.cep.apibuscacep.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoDto implements Serializable {

    @NotNull @NotEmpty @Length(min = 8, max = 8)
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private Integer ibge;
    private Integer gia;
    private Integer ddd;
    private Integer siafi;


}
