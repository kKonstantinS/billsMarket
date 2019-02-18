package com.socnetwork.converters;

import com.socnetwork.domain.UserDto;
import com.socnetwork.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConverter {

    UserDto toDto(UserEntity entity);

    UserEntity toEntity(UserDto dto);
}
