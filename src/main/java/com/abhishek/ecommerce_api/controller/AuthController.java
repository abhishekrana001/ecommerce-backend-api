package com.abhishek.ecommerce_api.controller;


import com.abhishek.ecommerce_api.dto.request.RegisterRequest;
import com.abhishek.ecommerce_api.dto.response.ApiResponse;
import com.abhishek.ecommerce_api.dto.response.RegisterResponse;
import com.abhishek.ecommerce_api.exception.ResourceAlreadyExistsException;
import com.abhishek.ecommerce_api.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<RegisterResponse>> register(
            @Valid @RequestBody RegisterRequest request){
        RegisterResponse response = userService.register(request);

        ApiResponse<RegisterResponse> apiResponse = ApiResponse.<RegisterResponse>builder()
                .success(true)
                .message("User register successfully")
                .data(response).build();
        return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }
}
