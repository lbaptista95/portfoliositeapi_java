package com.lb.portfolio.api.model.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {

    private String email;
    private String password;
}
