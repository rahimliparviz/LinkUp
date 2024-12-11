package org.rahimliparviz.linkup.service;

import lombok.RequiredArgsConstructor;
import org.rahimliparviz.linkup.config.JwtService;
import org.rahimliparviz.linkup.entity.User;
import org.rahimliparviz.linkup.model.Role;
import org.rahimliparviz.linkup.model.dto.LoginDto;
import org.rahimliparviz.linkup.model.dto.RegisterDto;
import org.rahimliparviz.linkup.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService implements IAuthService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public String login(LoginDto loginDto) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));
        return "";
    }

    @Override
    public String register(RegisterDto registerDto) {
        var user = User.builder()
                .firstname(registerDto.getFirstname())
                .lastname(registerDto.getLastname())
                .email(registerDto.getEmail())
                .password(passwordEncoder.encode(registerDto.getPassword()))
                .role(Role.User)
                .build();

        userRepository.save(user);

        return jwtService.generateToken(null,user);
    }
}
