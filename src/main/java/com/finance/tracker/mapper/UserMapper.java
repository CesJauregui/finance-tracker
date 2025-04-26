package com.finance.tracker.mapper;

import com.finance.tracker.dto.UserDTO;
import com.finance.tracker.entities.User;

public class UserMapper {
    public static UserDTO toDto(User user){
        return new UserDTO(user.getId(), user.getName(), user.getSurname(), user.getUsername());
    }

    public static User toEntity(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setUsername(userDTO.getUsername());

        return user;
    }
}
