package com.abhishek.ecommerce_api.service;

import com.abhishek.ecommerce_api.dto.request.LoginRequest;
import com.abhishek.ecommerce_api.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);
}
