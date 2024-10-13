package com.lb.portfolio.api.model.dto.response;

import com.lb.portfolio.api.model.dto.request.MediaRequestDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponseDto {

    private Integer id;
    private String name;
    private String description;
    private List<MediaRequestDto> media;
    private List<String> skillNames;
}
