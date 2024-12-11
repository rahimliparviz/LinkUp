package org.rahimliparviz.linkup.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.rahimliparviz.linkup.model.dto.RegisterDto;
import org.rahimliparviz.linkup.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/Register")
    public ResponseEntity<RegisterDto> Register(@Valid @RequestBody RegisterDto registerDto)
    {

        authService.register(registerDto);
        return  ResponseEntity.ok(registerDto);
    }

    @GetMapping("/h/{id}")
    public String Register2(@PathVariable String id)
    {

        return id;
        //return  ResponseEntity.ok().build();
    }

}
