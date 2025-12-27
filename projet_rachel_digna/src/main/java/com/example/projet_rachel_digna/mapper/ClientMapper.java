package com.example.projet_rachel_digna.mapper;

import com.example.projet_rachel_digna.dto.ClientDto;
import com.example.projet_rachel_digna.entity.Client;
import org.mapstruct.*;

@Mapper(componentModel = "spring" , unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ClientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accounts", ignore = true)
    Client toEntity(ClientDto dto);

    @Mapping(target = "accounts")
    ClientDto toDto(Client entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accounts", ignore = true)
    void updateEntity(@MappingTarget Client entity, ClientDto dto);

}
