package com.nazifcankabakcioglu.springbootrestapi.Controller;


import com.nazifcankabakcioglu.springbootrestapi.Dto.UserDto;
import com.nazifcankabakcioglu.springbootrestapi.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto resultUser = userService.createUser(userDto);
        return ResponseEntity.ok(resultUser);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> userDtos =userService.getAll();
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable ("id") long id){
        UserDto userDto= userService.getUserById(id);

        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") long id, @RequestBody UserDto userDto){
        UserDto updatedUser = userService.updateUser(id,userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") long id){
        Boolean status = userService.deleteUser(id);

        return ResponseEntity.ok(status);
    }
}
