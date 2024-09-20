package com.lb.portfolio.api.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColumnInfoDto {

    private String name;
    private String type;
}
