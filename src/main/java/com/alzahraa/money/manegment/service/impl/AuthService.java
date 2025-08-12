package com.alzahraa.money.manegment.service.impl;


 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.alzahraa.money.manegment.dto.LoginRequest;
import com.alzahraa.money.manegment.dto.RegisterRequest;
import com.alzahraa.money.manegment.entity.UserEntity;
import com.alzahraa.money.manegment.enums.UserRoleEnum;
import com.alzahraa.money.manegment.repository.UserRepository;
import com.alzahraa.money.manegment.security.JwtUtil;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtUtil jwtUtil;


    public String login(LoginRequest request) {
        UserEntity user = userRepo.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return jwtUtil.generateToken(user.getUsername(), user.getRole().name());
    }

    public void register(RegisterRequest request) {
        if (userRepo.existsByUsernameCustom(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        UserEntity user = new UserEntity();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(UserRoleEnum.valueOf(request.getRole()));
        userRepo.save(user);
    }
}

