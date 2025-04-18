package com.finance.tracker.services;

import com.finance.tracker.dto.UserDTO;
import com.finance.tracker.entities.User;

import java.util.List;

public interface UserService {
    List<UserDTO> getAll();
    UserDTO getById(Long id);
    UserDTO createUser(User user);
    void deleteUser(Long id);
}
