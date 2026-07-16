package com.abhishek.ecommerce_api.service;

import com.abhishek.ecommerce_api.dto.request.LoginRequest;
import com.abhishek.ecommerce_api.dto.request.RegisterRequest;
import com.abhishek.ecommerce_api.dto.response.LoginResponse;
import com.abhishek.ecommerce_api.dto.response.RegisterResponse;

public interface AuthService {

    RegisterResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

}
