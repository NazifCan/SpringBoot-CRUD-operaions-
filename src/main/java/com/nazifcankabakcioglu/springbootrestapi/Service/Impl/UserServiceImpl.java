package com.nazifcankabakcioglu.springbootrestapi.Service.Impl;

import com.nazifcankabakcioglu.springbootrestapi.Dto.UserDto;
import com.nazifcankabakcioglu.springbootrestapi.Entity.User;
import com.nazifcankabakcioglu.springbootrestapi.Repository.UserRepository;
import com.nazifcankabakcioglu.springbootrestapi.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public UserDto createUser(UserDto userDto) {

        User user = new User();

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setCreatedAt(new Date());
        user.setCreatedBy("Admin");

        return modelMapper.map(userRepository.save(user),UserDto.class);
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(long id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()) {
            return modelMapper.map(user,UserDto.class);
        }
        return null;
    }

    @Override
    public UserDto updateUser(long id, UserDto userDto) {

        Optional<User> user = userRepository.findById(id);

        user.ifPresent(value -> value.setFirstName(userDto.getFirstName()));

        user.ifPresent(value -> value.setLastName(userDto.getLastName()));

        user.ifPresent(value -> value.setUpdatedAt(new Date()));

        user.ifPresent(value -> value.setUpdatedBy("Admin"));

        return modelMapper.map(userRepository.save(user.get()), UserDto.class);
    }

    @Override
    public Boolean deleteUser(long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()){
            userRepository.deleteById(id);
            return true;
        }

        return false;
    }


}
