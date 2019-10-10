package com.bad.applications.controllers.mappers;

import com.bad.applications.controllers.dtos.UserDTO;
import com.bad.applications.models.User;
import org.springframework.beans.BeanUtils;

public class UserMapper {

    public static User toUser(UserDTO userDTO){
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return user;
    }

    public static UserDTO toDto(User user){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        userDTO.setRoles(user.getRoles());
        return userDTO;
    }
}
