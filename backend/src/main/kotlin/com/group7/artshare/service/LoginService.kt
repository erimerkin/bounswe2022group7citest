package com.group7.artshare.service

import com.group7.artshare.request.LoginRequest
import com.group7.artshare.utils.JwtUtil.generateToken
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.lang.Exception


@Service
class LoginService(private val authenticationManager: AuthenticationManager, private val jwtService: JwtService) {

    fun login(loginRequest: LoginRequest): TokenResponse {
        val token = UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        try {
            val authenticatedToken = authenticationManager.authenticate(token)
            return TokenResponse(generateToken(authenticatedToken, jwtService.getSecretKey()))
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid email or password")
        }
    }
}

data class TokenResponse(val token: String)