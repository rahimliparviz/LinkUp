package org.rahimliparviz.linkup.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.rahimliparviz.linkup.model.dto.RegisterDto;
import org.rahimliparviz.linkup.service.AuthServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthServiceImpl authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterDto> Register(@Valid @RequestBody RegisterDto registerDto)
    {

        authService.register(registerDto);
        return  ResponseEntity.ok(registerDto);
    }


}
