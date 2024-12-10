package org.rahimliparviz.linkup.service;

import org.rahimliparviz.linkup.model.dto.LoginDto;
import org.rahimliparviz.linkup.model.dto.RegisterDto;
import org.rahimliparviz.linkup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public String login(LoginDto loginDto) {
        return "";
    }

    @Override
    public String register(RegisterDto registerDto) {
        return "";
    }
}
