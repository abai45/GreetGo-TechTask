package GreetGo.CRUDtelephony.mapper;

import GreetGo.CRUDtelephony.dto.BaseClientDto;
import GreetGo.CRUDtelephony.dto.ClientEntityDto;
import GreetGo.CRUDtelephony.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientEntityMapper {
    ClientEntityMapper INSTANCE = Mappers.getMapper(ClientEntityMapper.class);
    BaseClientDto toDto(ClientEntity clientEntity);
    ClientEntity toEntity(ClientEntityDto clientEntityDto);
}
