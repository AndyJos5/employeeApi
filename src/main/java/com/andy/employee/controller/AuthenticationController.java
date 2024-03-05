package com.andy.employee.controller;

import com.andy.employee.model.AuthenticationResponse;
import com.andy.employee.model.Role;
import com.andy.employee.model.User;
import com.andy.employee.service.AuthenticationService;
import com.andy.employee.service.JwtService;
import com.andy.employee.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AuthenticationController {
    private final AuthenticationService authService;
    private final UserService userService;
    private final JwtService jwtService;

    public AuthenticationController(AuthenticationService authService, UserService userService, JwtService jwtService) {
        this.authService = authService;
        this.userService = userService;

        this.jwtService = jwtService;
    }


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody User request
    ) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody User request
    ) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @GetMapping("isTokenValid/{token}")
    public ResponseEntity<Boolean> isTokenValid(@PathVariable String token){
        var user = userService.loadUserByUsername(jwtService.extractUsername(token));
        var isValid = jwtService.isValid(token,user);
        return new ResponseEntity<>(isValid, HttpStatus.GONE);
    }

    @GetMapping("getRoles")
    public List<Role> getRole(){
        return List.of(Role.values());
    }
}
