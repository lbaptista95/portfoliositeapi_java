package com.lb.portfolio.api.service;

import com.lb.portfolio.api.configuration.logging.LogExecutionTime;
import com.lb.portfolio.api.model.dto.response.UserResponseDto;
import com.lb.portfolio.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @LogExecutionTime
    public List<UserResponseDto> findAllUsers() {
        return userRepository.findAllUsers();
    }

    @LogExecutionTime
    public UserResponseDto findTopById(Integer id) {
        return userRepository.findTopById(id).orElse(null);
    }
}
