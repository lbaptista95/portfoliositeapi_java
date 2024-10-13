package com.lb.portfolio.api.model.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private String name;
    private String company;
    private String email;
    private String contact;
    private String socialUrl;
}
