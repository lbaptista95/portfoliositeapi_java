package com.lb.portfolio.api.repository;

import com.lb.portfolio.api.model.dto.response.UserResponseDto;
import com.lb.portfolio.api.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("""
            select new com.lb.portfolio.api.model.dto.response.UserResponseDto(
            u.name, u.company, u.email, u.contact, u.socialUrl)
            from User u
            """)
    List<UserResponseDto> findAllUsers();

    @Query("""
            select new com.lb.portfolio.api.model.dto.response.UserResponseDto(
            u.name, u.company, u.email, u.contact, u.socialUrl)
            from User u
            where u.id = :id
            """)
    Optional<UserResponseDto> findTopById(Integer id);
}
