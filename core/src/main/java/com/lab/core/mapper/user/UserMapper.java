package com.lab.core.mapper.user;

import com.lab.core.domain.User;
import com.lab.core.dto.user.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);
}