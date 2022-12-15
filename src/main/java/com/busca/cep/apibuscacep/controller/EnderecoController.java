package com.busca.cep.apibuscacep.controller;

import com.busca.cep.apibuscacep.dto.EnderecoDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;


@RequestMapping("/endereco")
@RestController
public class EnderecoController {

    @Value("${url.viacep}")
    public String urlViaCep;


    @GetMapping("/busca-endereco-cep/{cep}")
    public ResponseEntity<EnderecoDto> buscarEnderecoByCep(@PathVariable @Valid String cep) {
        EnderecoDto enderecoDto;

        if (cep.length() == 8) {
            RestTemplate restTemplate = new RestTemplate();
            EnderecoDto enderecoDtoResponse = restTemplate.getForObject(urlViaCep + cep + "/json", EnderecoDto.class);
            enderecoDto = enderecoDtoResponse;

        } else {
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok().body(enderecoDto);
    }

}