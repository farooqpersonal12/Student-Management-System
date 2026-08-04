package com.umar.studentmanagementsystem.Controller;

import com.umar.studentmanagementsystem.DTOS.LoginRequestDTO;
import com.umar.studentmanagementsystem.DTOS.LoginResponseDTO;
import com.umar.studentmanagementsystem.Security.Jwt.JwtService;
import com.umar.studentmanagementsystem.Service.CustomUserDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final CustomUserDetailsService customUserDetailsService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @RequestBody @Valid LoginRequestDTO requestDTO
            ){
        authenticationManager.authenticate(

                new UsernamePasswordAuthenticationToken(
                        requestDTO.getUsername(),
                        requestDTO.getPassword()
                )
        );
        UserDetails userDetails = customUserDetailsService
                        .loadUserByUsername(requestDTO.getUsername());

        String token = jwtService.generateToken(userDetails);

        return ResponseEntity.ok(
                new LoginResponseDTO(token)
        );
    }
}
