package br.com.zup.consomeviacep.controller;

import br.com.zup.consomeviacep.dto.CepDto;
import br.com.zup.consomeviacep.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
@RequiredArgsConstructor
public class ConsultaCepController {

    final EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Void> consultaCep(@RequestBody CepDto cepDto) {
        try {
            enderecoService.consultarEPublicarEndereco(cepDto.getCep());
            return ResponseEntity.ok().build();
        } catch (RuntimeException runtimeException) {
            runtimeException.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
