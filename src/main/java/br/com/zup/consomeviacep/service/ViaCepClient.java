package br.com.zup.consomeviacep.service;

import br.com.zup.consomeviacep.dto.EnderecoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepClient {

    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json", produces = "application/json")
    EnderecoDto getEndereco(@PathVariable("cep") final String cep);

}
