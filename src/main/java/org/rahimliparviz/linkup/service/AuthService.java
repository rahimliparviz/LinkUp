package org.rahimliparviz.linkup.service;

import org.rahimliparviz.linkup.model.dto.LoginDto;
import org.rahimliparviz.linkup.model.dto.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
}
