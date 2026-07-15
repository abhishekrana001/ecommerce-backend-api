package com.abhishek.ecommerce_api.service;

import com.abhishek.ecommerce_api.dto.request.RegisterRequest;
import com.abhishek.ecommerce_api.dto.response.RegisterResponse;

public interface UserService {
    RegisterResponse register(RegisterRequest request);
}
