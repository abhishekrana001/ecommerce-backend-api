package com.abhishek.ecommerce_api.service.impl;

import com.abhishek.ecommerce_api.dto.request.LoginRequest;
import com.abhishek.ecommerce_api.dto.response.LoginResponse;
import com.abhishek.ecommerce_api.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    @Override
    public LoginResponse login(LoginRequest request) {
        return null;
    }
}
