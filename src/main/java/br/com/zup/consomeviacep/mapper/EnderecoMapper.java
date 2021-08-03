package br.com.zup.consomeviacep.mapper;

import br.com.zup.consomeviacep.domain.Endereco;
import br.com.zup.consomeviacep.dto.EnderecoDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnderecoMapper {

    EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

    Endereco mapFrom(final EnderecoDto enderecoDto);

}
