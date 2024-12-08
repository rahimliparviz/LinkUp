package org.rahimliparviz.linkup.controller;

import jakarta.validation.Valid;
import org.rahimliparviz.linkup.model.dto.RegisterDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Auth")
public class AuthController {

    @PostMapping("/Register")
    public ResponseEntity<RegisterDto> Register(

         @Valid    @RequestBody RegisterDto registerDto)
    {


        return  ResponseEntity.ok(registerDto);
    }

    @GetMapping("/h/{id}")
    public String Register2(@PathVariable String id)
    {

        return id;
        //return  ResponseEntity.ok().build();
    }

}
