package com.example.foodcollector.web.mapprs;

import com.example.foodcollector.domain.user.User;
import com.example.foodcollector.web.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    User toEntity(UserDto dto);
}
