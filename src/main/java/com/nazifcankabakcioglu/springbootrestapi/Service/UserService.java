package com.nazifcankabakcioglu.springbootrestapi.Service;

import com.nazifcankabakcioglu.springbootrestapi.Dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    UserDto createUser(UserDto userDto);

    List<UserDto> getAll();

    UserDto getUserById(long id);

    UserDto updateUser(long id, UserDto userDto);

    Boolean deleteUser(long id);
}
