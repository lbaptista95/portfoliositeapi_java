package com.lb.portfolio.api.model.entity.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SkillProjectId implements Serializable {

    @Column(name = "skill_id", nullable = false)
    private Integer skillId;
    @Column(name = "project_id", nullable = false)
    private Integer projectId;
    // project - skill
}
