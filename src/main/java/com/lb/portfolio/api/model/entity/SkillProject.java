package com.lb.portfolio.api.model.entity;

import com.lb.portfolio.api.model.entity.id.SkillProjectId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "skill_project")
public class SkillProject implements Serializable {

    @EmbeddedId
    private SkillProjectId id;
}
