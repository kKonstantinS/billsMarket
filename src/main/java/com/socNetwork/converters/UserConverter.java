package com.socNetwork.converters;

import com.socNetwork.domain.UserDto;
import com.socNetwork.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConverter {

    UserDto toDto(UserEntity entity);

    UserEntity toEntity(UserDto dto);
}
