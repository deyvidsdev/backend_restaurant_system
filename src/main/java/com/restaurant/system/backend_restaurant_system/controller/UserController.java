package com.restaurant.system.backend_restaurant_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.system.backend_restaurant_system.dto.UserPaginationDTO;
import com.restaurant.system.backend_restaurant_system.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping(path = "/User")
@Tag(name = "User")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping(path = "/List")
    @Operation(summary = "Obtener lista de usuarios")
    public ResponseEntity<UserPaginationDTO> getAllUser(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        
        UserPaginationDTO userPage = userService.getAllUser(page, size);

        return ResponseEntity.ok().body(userPage);
    }
    

}
