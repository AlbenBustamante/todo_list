package com.alnicode.todolist.web.controller;

import com.alnicode.todolist.domain.dto.AuthenticationRequest;
import com.alnicode.todolist.domain.dto.AuthenticationResponse;
import com.alnicode.todolist.domain.dto.UserResponse;
import com.alnicode.todolist.domain.service.IUserService;
import com.alnicode.todolist.domain.service.impl.CustomUserDetailsService;
import com.alnicode.todolist.web.security.JwtUtil;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Validated
public class AuthController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> getToken(@NotNull @Valid @RequestBody AuthenticationRequest request) {
        try {
            manager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            final var userDetails = userDetailsService.loadUserByUsername(request.getUsername());
            final var jwt = jwtUtil.generateToken(userDetails);
            final var response = new AuthenticationResponse();
            response.setJwt(jwt);

            return ResponseEntity.ok(response);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<UserResponse> registerUser(@NotNull @Valid @RequestBody AuthenticationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(request));
    }
}
