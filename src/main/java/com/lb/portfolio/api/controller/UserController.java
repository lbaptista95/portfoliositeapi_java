package com.lb.portfolio.api.controller;

import com.lb.portfolio.api.model.dto.response.UserResponseDto;
import com.lb.portfolio.api.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@Tag(name = "User Controller")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController extends BaseController {

    private final UserService userService;

    @Operation(summary = "Fetch all Users")
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return response(userService.findAllUsers());
    }

    @Operation(summary = "Fetch User by ID")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<UserResponseDto> getAllUsers(@RequestParam Integer id) {
        return response(userService.findTopById(id));
    }
}
