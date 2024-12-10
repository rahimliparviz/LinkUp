package org.rahimliparviz.linkup.service;

import org.rahimliparviz.linkup.model.dto.LoginDto;
import org.rahimliparviz.linkup.model.dto.RegisterDto;

public interface IAuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
}
