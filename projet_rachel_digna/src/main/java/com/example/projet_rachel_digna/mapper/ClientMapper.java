package com.example.projet_rachel_digna.mapper;

import com.example.projet_rachel_digna.dto.ClientDto;
import com.example.projet_rachel_digna.entity.Client;
import org.mapstruct.*;


@Mapper(componentModel = "spring" , unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ClientMapper {

    ClientDto toDto(Client entity);

    @Mapping(target = "id", ignore = true)
    Client toEntity(ClientDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Client entity, ClientDto dto);
//    public static ClientDTO toDTO(Client entity) {
//        if (entity == null) return null;
//
//        ClientDTO dto = new ClientDTO();
//        dto.setId(entity.getId());
//        dto.setNom(entity.getNom());
//        dto.setPrenom(entity.getPrenom());
//        dto.setAdresse(entity.getAdresse());
//        dto.setCodePostal(entity.getCodePostal());
//        dto.setVille(entity.getVille());
//        dto.setTelephone(entity.getTelephone());
//
//        return dto;
//    }
//
//    public static Client toEntity(ClientDTO dto) {
//        if (dto == null) return null;
//
//        Client entity = new Client(
//                dto.getNom(),
//                dto.getPrenom(),
//                dto.getAdresse(),
//                dto.getCodePostal(),
//                dto.getVille(),
//                dto.getTelephone()
//        );
//
//        if (dto.getId() != null) {
//            entity.setId(dto.getId());
//        }
//
//        return entity;
//    }
}
