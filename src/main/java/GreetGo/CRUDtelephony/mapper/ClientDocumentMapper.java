package GreetGo.CRUDtelephony.mapper;

import GreetGo.CRUDtelephony.dto.ClientDocumentDto;
import GreetGo.CRUDtelephony.entity.ClientDocument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientDocumentMapper {
    ClientDocumentMapper INSTANCE = Mappers.getMapper(ClientDocumentMapper.class);
    ClientDocumentDto toDto(ClientDocument clientDocument);
    ClientDocument toDocument(ClientDocumentDto clientDocumentDto);
}
