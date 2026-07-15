package com.abhishek.ecommerce_api.service.impl;

import com.abhishek.ecommerce_api.dto.request.RegisterRequest;
import com.abhishek.ecommerce_api.dto.response.RegisterResponse;
import com.abhishek.ecommerce_api.entity.Role;
import com.abhishek.ecommerce_api.entity.User;
import com.abhishek.ecommerce_api.exception.ResourceAlreadyExistsException;
import com.abhishek.ecommerce_api.repository.UserRepository;
import com.abhishek.ecommerce_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponse register(RegisterRequest request) {
        if(userRepository.existsByEmail(request.getEmail())) {
            throw new ResourceAlreadyExistsException("Email already exists");
        }
        if(userRepository.existsByPhone(request.getPhone())) {
            throw new ResourceAlreadyExistsException("Phone already exists");
        }
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone(request.getPhone())
                .role(Role.USER)
                .enabled(true)
                .deleted(false)
                .build();

        User savedUser = userRepository.save(user);

        return RegisterResponse.builder()
                .id(savedUser.getId())
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .email(savedUser.getEmail())
                .phone(savedUser.getPhone())
                .message("User registered successfully.")
                .build();
    }
}
