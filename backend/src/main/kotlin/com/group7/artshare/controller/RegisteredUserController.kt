package com.group7.artshare.controller

import com.group7.artshare.request.LoginRequest
import com.group7.artshare.request.SignupRequest
import com.group7.artshare.service.LoginService
import com.group7.artshare.service.RegisteredUserService
import com.group7.artshare.service.SignupService
import com.group7.artshare.service.TokenResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
class RegisteredUserController(
    private val loginService: LoginService,
    private val signupService: SignupService,
    private val registeredUserService: RegisteredUserService
){
    @PostMapping("/login")
    fun login(@RequestBody loginRequest: @Valid LoginRequest): TokenResponse {
        return loginService.login(loginRequest)
    }

    @PostMapping("/signup")
    fun signup(@RequestBody signupRequest: SignupRequest) {
        return signupService.signup(signupRequest)
    }
}